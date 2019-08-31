package xyz.zerovoid.pan.install;

import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xyz.zerovoid.pan.dao.ColInfo;
import xyz.zerovoid.pan.dao.DAOFactory;
import xyz.zerovoid.pan.dao.DatabaseConnection;
import xyz.zerovoid.pan.dao.TableInfo;
import xyz.zerovoid.pan.dao.UserManager;

public class InitTable {
    
    private static final Logger logger = 
        LoggerFactory.getLogger(InitTable.class);

    private DatabaseConnection baseManager;

    public InitTable() throws SQLException {
        baseManager = new DatabaseConnection();
    }

    public InitTable(DatabaseConnection dbc) {
        baseManager = dbc;
    }

    public void CreateUserTable() throws SQLException {
        TableInfo table = new TableInfo("user");
        ColInfo col = new ColInfo("uid", "int", 5, true, true);
        col.setOther("auto_increment");
        table.addColInfo(col);
        table.addColInfo(new ColInfo("mail", "varchar", 255, false, true));
        table.addColInfo(new ColInfo("password", "varchar", 255, false, true));
        table.addColInfo(new ColInfo("name", "varchar", 255, false, false));
        col = new ColInfo("groupname", "varchar", 255, false, false);
        col.setDefaultValue("guest");
        table.addColInfo(col);
        Statement stat = baseManager.getConnection().createStatement();
        stat.execute(table.getCreateString());
        stat.close();
        logger.info("Created user table.");
    }

    public boolean init() {
        try {
			CreateUserTable();
		} catch (SQLException e) {
            logger.error("cannot create table correctedly.");
			e.printStackTrace();
            return false;
		}
        
        try {
			UserManager userManager = DAOFactory.getUserManager();
		} catch (SQLException e) {
            logger.error("cannot regesiter root manager.");
			e.printStackTrace();
		}
        return true;
    }
}
