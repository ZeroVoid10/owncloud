package xyz.zerovoid.pan.admin;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xyz.zerovoid.pan.dao.ColInfo;
import xyz.zerovoid.pan.dao.DatabaseConnection;
import xyz.zerovoid.pan.dao.TableInfo;
import xyz.zerovoid.pan.util.AppPreferences;
import xyz.zerovoid.pan.admin.UserManager;

/**
 * 系统管理
 * @since 0.1.0
 * @author James, ZeroVoid
 */
public class SystemManager {
    
    private static final Logger logger = 
        LoggerFactory.getLogger(SystemManager.class);

    private DatabaseConnection baseManager;
    private Map<String, String[]> infoMap;
    private AppPreferences pref;

    public SystemManager() throws SQLException {
        baseManager = new DatabaseConnection();
    }

    public SystemManager(DatabaseConnection dbc) {
        baseManager = dbc;
    }

    public SystemManager(Map<String, String[]> map) throws SQLException {
        // js已经检测过输入
        pref = AppPreferences.getInstance();
        infoMap = new HashMap<String, String[]>(map);
        addBaseInfo();
        baseManager = new DatabaseConnection();
    }

    public void install() throws SQLException {
	    UserManager userManager = null;
		try {
			CreateUserTable();
            userManager = new UserManager();
		} catch (SQLException e) {
            logger.error("Create table failed.");
			e.printStackTrace();
            pref.clear();
            throw e;
		}
        infoMap.put("group", new String[]{"root"});
        infoMap.put("name", new String[]{"root"});
        try {
			userManager.register(infoMap);
		} catch (SQLException e) {
            logger.error("Register failed.");
			e.printStackTrace();
            pref.clear();
            throw e;
		}
        pref.setInstalled();
        logger.info("pref installed: " + pref.getInstalled());
        logger.info("Install successed.");
    }

    public void CreateUserTable() throws SQLException {
        TableInfo table = new TableInfo("user");
        ColInfo col = new ColInfo("uid", "int", 5, true, true);
        col.setOther("auto_increment");
        table.addColInfo(col);
        table.addColInfo(new ColInfo("mail", "varchar", 255, false, true));
        table.addColInfo(new ColInfo("password", "varchar", 255, false, true));
        table.addColInfo(new ColInfo("username", "varchar", 255, false, false));
        col = new ColInfo("groupname", "varchar", 255, false, false);
        col.setDefaultValue("guest");
        table.addColInfo(col);
        /*
        Statement stat = baseManager.getConnection().createStatement();
        stat.execute(table.getCreateString());
        stat.close();
        */
        createTable(table.getCreateString());
        logger.info("Created user table.");
    }

    public void CreateFileInfoTable() throws SQLException {
    	String sql="CREATE TABLE IF NOT EXISTS allfiles(" +
    			"Hash int(8) PRIMARY KEY NOT NULL,"+
                "name varchar(255) NOT NULL," + 
                "kind varchar(255) NOT NULL," + 
                "dir varchar(255) NOT NULL," +
                "size varchar(255) NOT NULL," +
                "uploader_UID int(5) NOT NULL," +
                "upload_time datetime DEFAULT NULL," +
                "tag varchar(255) DEFAULT NULL);";
        createTable(sql);
        logger.info("Create fileinfo table");
    }

    public boolean CheckInstalled() {
        if (pref.getInstalled().compareTo("ok") == 0) {
            return true;
        } else {
            return false;
        }
    }

    private void addBaseInfo() {
        // get String 需要和install.jsp中表单name对应
        pref.setDBDriver(infoMap.get("db_type")[0]);
        pref.setHost(infoMap.get("db_host")[0]);
        pref.setPort(infoMap.get("db_port")[0]);
        pref.setDabaseName(infoMap.get("db_name")[0]);
        pref.setCredentials(infoMap.get("db_username")[0], 
                            infoMap.get("db_password")[0]);
    }

    private void createTable(String sql) throws SQLException {
        Statement stat = baseManager.getConnection().createStatement();
        stat.execute(sql);
        stat.close();
    }
}
