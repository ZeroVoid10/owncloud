package AllUserTable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class UserManagement {

	public Connection mConnect;
    public UserManagement(Connection connection) {
        super();
        this.mConnect = connection;
    }
    public void add_user(String name, String password, String mail, String group) {
        try {
            Statement statement =mConnect.createStatement();
            String sql ="INSERT INTO test.allusers(name, password, mail, access) VALUES ('"+
                name+"','"+password+"','"+mail+"','" + group + "');";
                statement.executeUpdate(sql);//执行语句
            statement.close();
            System.out.println("user " + name + " created");
        } catch (SQLException e) {
            }
     }
    public User getUserInfos(int UID) {
        String sql ="SELECT * FROM test.allusers WHERE UID = " + UID + ";";
        String log;
        try {
            Statement statement =mConnect.createStatement();
            ResultSet result = statement.executeQuery(sql);
            if(result.first()) {
                if(result.getTimestamp("log_out") == null)
                	log = "null";
                else
                	log = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(result.getTimestamp("log_out"));
            	User userBean =new User(
                		result.getInt("UID"), 
                		result.getString("name"), 
                		result.getString("password"),
                		result.getString("mail"),
                		result.getString("access"),
                		log);
                return userBean;
            }
            statement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            
        }
        return null;
    }
    
    public void PrintUserInfos(User user) {
    	try{
    		if(user == null)
    			System.err.println("无此用户");
    		System.out.println("UID: " + user.getUID());
    		System.out.println("name: " + user.getName());
    		System.out.println("password: " + user.getPassword());
	    	System.out.println("mail: " + user.getMail());
	    	System.out.println("group: " + user.getGroup());
	    	System.out.println("log_out: " + user.getLog_out());
    	}catch(Exception ex) {
    		
    	}
    		
    }
    
    public int update_user_info(int UID, String password, String keyword, String new_info) {
    	int result =-1;
    	try {
            String sql="UPDATE test.allusers SET " + keyword + "= '"+new_info+ "' WHERE UID = '"+UID+"';";
            User user =getUserInfos(UID);
            if(user!=null) {
                /**
                 * 判断传递过来的老密码是否正确
                 */
                if(user.getPassword().equals(password)) {
                    Statement statement =mConnect.createStatement();
                    statement.executeUpdate(sql);
                    statement.close();
                    result= 0;
                }else {
                    result=1;
                    System.err.println("密码不正确,不允许更改");
                }
            }else {
                result=2;
                System.err.println("无此用户");
            }
        }catch(SQLException e) {}
    	return result;
    }
    
    public void delete_user(int UID, String password) {
    	try {
            String sql="DELETE FROM test.allusers WHERE UID = '"+UID+"';";
            User user =getUserInfos(UID);
            if(user!=null) {
                /**
                 * 判断传递过来的老密码是否正确
                 */
                if(user.getPassword().equals(password)) {
                    Statement statement =mConnect.createStatement();
                    statement.executeUpdate(sql);
                    statement.close();
                    System.out.println("user deleted");
                }else {
                    System.err.println("密码不正确,不允许删除");
                }
            }else {
                System.err.println("无此用户");
            }
        }catch(SQLException e) {}
    }
}
