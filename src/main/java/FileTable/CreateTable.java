package FileTable;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	public Connection mConnect;
	public String table_name;
    
    public CreateTable(Connection connection, String table_name) {
        super();
        this.mConnect = connection;
        this.table_name = table_name;
    }
    public boolean create_table() {
    	String sql="CREATE TABLE IF NOT EXISTS " + table_name + "(" +
    			"Hesh int(8) PRIMARY KEY NOT NULL);";
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
