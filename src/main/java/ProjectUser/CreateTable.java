package ProjectUser;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	public Connection mConnect;
	String project_name;
    
    public CreateTable(Connection connection, String project_name) {
        super();
        this.mConnect = connection;
        this.project_name = project_name;
    }
    public boolean create_table() {
    	String sql="CREATE TABLE IF NOT EXISTS " + project_name + "(" +
    			"UID int(5) PRIMARY KEY NOT NULL ,"+
                "access varchar(255) NOT NULL);";
    	boolean result = false;
        try {
            Statement statement = mConnect.createStatement();
            statement.execute(sql);
            result = true;
            statement.close();
            System.out.println("table " + project_name + " created");
        } catch (SQLException e) {
            System.err.println("创建表异常:"+e.getMessage());
        }
        return result;
    }
}
