package xyz.zerovoid.pan.dao;

import java.sql.SQLException;

public class DAOFactory {

    public static UserDao getUserDAO() throws SQLException {
        return new UserDao();
    }

}
