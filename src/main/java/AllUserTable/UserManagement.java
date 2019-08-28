package AllUserTable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

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
                else {
                	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                	sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
                	log = sdf.format(result.getTimestamp("log_out"));
                }
            	User userBean =new User(
                		result.getInt("UID"), 
                		result.getString("name"), 
                		result.getString("password"),
                		result.getString("mail"),
                		result.getString("access"),
                		log);            
            	statement.close();
                return userBean;
            }

            else {
            	System.err.println("无此用户");
            	statement.close();
            	return null;
            }
            	
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
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
    
    public void update_log_out(int UID) {
    	User user = getUserInfos(UID);
    	try {
            if(user != null) {
            	if(user.log_out == "null") {
            		String sql = "UPDATE test.allusers SET log_out = now() WHERE UID = '"+UID+"';";
            		Statement statement =mConnect.createStatement();
                    statement.executeUpdate(sql);
                    statement.close();
            	}
            	else {
            		String sql = "UPDATE test.allusers SET log_out = null WHERE UID = '"+UID+"';";
            		Statement statement =mConnect.createStatement();
                    statement.executeUpdate(sql);
                    statement.close();
            	}
            }
            else
            	System.err.println("无此用户");
            	
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
