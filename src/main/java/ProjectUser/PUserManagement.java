package ProjectUser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import AllUserTable.UserManagement;

public class PUserManagement {

	public Connection mConnect;
	String project_name;
    public PUserManagement(Connection connection, String project_name) {
        super();
        this.mConnect = connection;
        this.project_name = project_name;
    }
    public void add_PUser(int UID, String access) {
        try {
            if(new UserManagement(mConnect).getUserInfos(UID) !=null) {
	        	if(IsPUser(UID))
	        		System.err.println("UID: " + UID + " 已经是项目成员了");
	        	else {
            	Statement statement =mConnect.createStatement();
	            String sql ="INSERT INTO test." + project_name + "(UID, access) VALUES ("+
	                UID+",'" + access + "');";
	            statement.executeUpdate(sql);//执行语句
	            statement.close();
	            System.out.println("UID: " + UID + " added");
	        	}
            }
            else
            	System.err.println("无此用户");
        } catch (SQLException e) {
        	e.printStackTrace();
            }
    }
    public boolean IsPUser(int UID) {
        String sql ="SELECT * FROM test." + project_name +" WHERE UID = " + UID + ";";
        try {
            Statement statement =mConnect.createStatement();
            ResultSet result = statement.executeQuery(sql);
            if(result.first()) {
                statement.close();
                return true;
            }
            else {
            	statement.close();
            	return false;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            
        }
        return false;
    }
    
    public void delete_PUser(int UID) {
    	try {
            String sql="DELETE FROM test." + project_name + " WHERE UID = '"+UID+"';";
            if(IsPUser(UID)) {
                    Statement statement =mConnect.createStatement();
                    statement.executeUpdate(sql);
                    statement.close();
                    System.out.println("UID: " + UID + " PUser deleted");
            }
            else {
                System.err.println("无此项目成员");
            }
        }catch(SQLException e) {}
    }
    public void PUser_access_update(int UID, String new_access) {
    	try {
            String sql="UPDATE test." + project_name + " SET access = '" + new_access + "' WHERE UID = '"+UID+"';";
            if(IsPUser(UID)) {
                    Statement statement =mConnect.createStatement();
                    statement.executeUpdate(sql);
                    statement.close();
                    System.out.println("UID: " + UID + " PUser's access is now " + new_access);
            }
            else {
                System.err.println("无此项目成员");
            }
        }catch(SQLException e) {}
    }
    public String get_PUser_access(int UID) {
    	String PUser_access = null;
    	try {
    		String sql ="SELECT * FROM test." + project_name + " WHERE UID = " + UID + ";";
            Statement statement =mConnect.createStatement();
            ResultSet result = statement.executeQuery(sql);
            if(result.first()) {
            	PUser_access = result.getString("access");
            	statement.close();
            }
            else {
                System.err.println("无此项目成员");
            }
            return PUser_access;
        }catch(SQLException e) {return null;}
    }
}
