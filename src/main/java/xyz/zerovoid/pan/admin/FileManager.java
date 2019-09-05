package xyz.zerovoid.pan.admin;

import java.sql.SQLException;
import java.util.Map;

import AllFileTable.FileManagement;
import xyz.zerovoid.pan.dao.DAOFactory;

/**
 * @since 0.1.0
 * @author zerovoid
 */
public class FileManager {

    private FileManagement fileDao = null;

    public FileManager () throws SQLException {
        this.fileDao = DAOFactory.getFileDAO();
    }

    public boolean upload(Map<String, String[]> map) {

        return true;
    }

}
