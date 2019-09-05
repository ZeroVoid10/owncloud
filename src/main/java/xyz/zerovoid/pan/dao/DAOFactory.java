package xyz.zerovoid.pan.dao;

import java.sql.SQLException;

import AllFileTable.FileManagement;

public class DAOFactory {

    public static UserDao getUserDAO() throws SQLException {
        return new UserDao();
    }

    public static FileManagement getFileDAO() throws SQLException {
        return new FileManagement();
    }

}
