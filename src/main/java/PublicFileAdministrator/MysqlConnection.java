package PublicFileAdministrator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
    private static Connection mConnect;
    static {
        try {
            System.out.println("init---");
            Class.forName("com.mysql.cj.jdbc.Driver");
            mConnect=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC", "root", "james990401");
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        return mConnect;
        
    }
    public static void  close() {
        try {
            mConnect.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}

