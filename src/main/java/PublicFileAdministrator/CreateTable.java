package PublicFileAdministrator;

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
    	String sql="CREATE TABLE IF NOT EXISTS publicfileadministrator(" +
    			"UID int(5) PRIMARY KEY NOT NULL);";
    	boolean result = false;
        try {
            Statement statement = mConnect.createStatement();
            statement.execute(sql);
            result = true;
            statement.close();
            System.out.println("table created");
        } catch (SQLException e) {
            System.err.println("�������쳣:"+e.getMessage());
        }
        return result;
    }
}
