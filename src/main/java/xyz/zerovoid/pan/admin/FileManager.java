package xyz.zerovoid.pan.admin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Map;

import AllFileTable.File;
import AllFileTable.FileManagement;
import xyz.zerovoid.pan.dao.DAOFactory;
import xyz.zerovoid.pan.util.AppPreferences;
import xyz.zerovoid.pan.util.Folder;
import xyz.zerovoid.pan.vo.User;

/**
 * @since 0.1.0
 * @author zerovoid
 */
public class FileManager {

    private FileManagement fileDao = null;
    private Folder folder = null;
    private String rootPath;

    public FileManager () throws SQLException, IOException {
        this.fileDao = DAOFactory.getFileDAO();
        folder = new Folder("/");
        rootPath = AppPreferences.getInstance().getRootPath();
    }

    /**
     * @author hp
     */
    public boolean upload(Map<String, String[]> map, User user) {
        File file = File.form2File(map);
        Path path = Paths.get(rootPath, folder.getName());
        file.setDir(path.relativize(Paths.get(rootPath)).toString())
            .setKind(getFileType(path.toString()))
            .setHash(path.hashCode())
            .setUploader_UID(User)

        return true;
    }

    private String getFileType(String filename) {
		String type = filename.substring(filename.lastIndexOf(".")+1,filename.length());
		return type;
    }

}
