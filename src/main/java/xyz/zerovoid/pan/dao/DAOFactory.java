package xyz.zerovoid.pan.dao;

import java.sql.SQLException;

public class DAOFactory {

    public static UserManager getUserManager() throws SQLException {
        return new UserManager();
    }

}
