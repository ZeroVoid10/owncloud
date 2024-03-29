package PublicFileAdministrator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import AllUserTable.UserManagement;

public class administratorManagement {

	public Connection mConnect;
    public administratorManagement(Connection connection) {
        super();
        this.mConnect = connection;
    }
    public void add_administrator(int UID) {
        try {
            if(new UserManagement(mConnect).getUserInfos(UID) !=null) {
	        	if(Isadministrator(UID))
	        		System.err.println("UID: " + UID + " is already a administrator");
	        	else {
            	Statement statement =mConnect.createStatement();
	            String sql ="INSERT INTO test.publicfileadministrator(UID) VALUES ("+
	                UID+");";
	            statement.executeUpdate(sql);
	            statement.close();
	            System.out.println("UID: " + UID + " added");
	        	}
            }
            else
            	System.err.println("User don't exist");
        } catch (SQLException e) {
        	e.printStackTrace();
            }
     }
    public boolean Isadministrator(int UID) {
        String sql ="SELECT * FROM test.publicfileadministrator WHERE UID = " + UID + ";";
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
            return false;
        }
    }
    
    public void delete_administrator(int UID) {
    	try {
            String sql="DELETE FROM test.publicfileadministrator WHERE UID = '"+UID+"';";
            if(Isadministrator(UID)) {
                    Statement statement =mConnect.createStatement();
                    statement.executeUpdate(sql);
                    statement.close();
                    System.out.println("UID: " + UID + " administrator deleted");
            }
            else {
                System.err.println("Administrator don't exist");
            }
        }catch(SQLException e) {}
    }
    
    public List<Integer> get_user_list() {
    	List<Integer> UIDs = new ArrayList<Integer>();
    	try {
    		String sql = "SELECT UID FROM test.publicfileadministrator;";
    		Statement statement =mConnect.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()) {
            	UIDs.add(result.getInt("UID"));
            }
            return UIDs;
    	}catch(SQLException e) {}
    	return UIDs;
    }
}
