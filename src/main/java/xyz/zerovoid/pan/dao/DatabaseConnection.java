package xyz.zerovoid.pan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xyz.zerovoid.pan.util.AppPreferences;

public class DatabaseConnection {

    private static final Logger logger = 
        LoggerFactory.getLogger(DatabaseConnection.class);
    
    private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    private static final String MARIADB_DRIVER = "org.mariadb.jdbc.Driver";
    private AppPreferences pref = AppPreferences.getInstance();


    private Connection conn;
    
    public DatabaseConnection() throws SQLException {
        String dbType = pref.getDBDriver();
        String dbUrl = "jdbc:" + dbType + "://" + pref.getHost() + ":" + 
                       pref.getPort() + "/" + pref.getDatabaseName() +
                       "?user=" + pref.getUsername() + "&password=" +
                       pref.getPassword();
        logger.info("Getting database connection...");
        try {
            if (dbType.compareTo("mariadb") == 0) {
                Class.forName(MARIADB_DRIVER);
            } else if (dbType.compareTo("mysql") == 0) {
                Class.forName(MYSQL_DRIVER);
            }
			conn = DriverManager.getConnection(dbUrl);
        } catch (ClassNotFoundException e) {
            logger.error("Cannot find porper database driver.");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.conn;
    }

    public static Connection getNewConnection() throws SQLException {
        DatabaseConnection dc = new DatabaseConnection();
        return dc.getConnection();
    }

    public void close() throws Exception {
        if (this.conn != null) {
            try {
                this.conn.close();
            } catch (Exception e) {
                logger.error("Cannot close database connection.");
                throw e;
            }
        }
    }
}
