package AllUserTable;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	public Connection mConnect;
    
    public CreateTable(Connection connection) {
        super();
        this.mConnect = connection;
    }
    public boolean create_table() {
    	String sql="CREATE TABLE IF NOT EXISTS allusers(" +
    			"UID int(5) PRIMARY KEY NOT NULL AUTO_INCREMENT,"+
                "name varchar(255) NOT NULL," + 
                "password varchar(255) NOT NULL," + 
                "mail varchar(255) NOT NULL," +
                "access varchar(255) NOT NULL," +
                "log_out datetime DEFAULT NULL);";
    	boolean result = false;
        try {
            Statement statement = mConnect.createStatement();
            statement.execute(sql);
            result = true;
            statement.close();
            System.out.println("Table created");
        } catch (SQLException e) {
            System.err.println("Failed to create table:"+e.getMessage());
        }
        return result;
    }
}
