package AllFileTable;

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
    	String sql="CREATE TABLE IF NOT EXISTS allfiles(" +
    			"Hesh int(8) PRIMARY KEY NOT NULL,"+
                "name varchar(255) NOT NULL," + 
                "kind varchar(255) NOT NULL," + 
                "dir varchar(255) NOT NULL," +
                "size varchar(255) NOT NULL," +
                "uploader_UID int(5) NOT NULL," +
                "upload_time datetime DEFAULT NULL);";
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
