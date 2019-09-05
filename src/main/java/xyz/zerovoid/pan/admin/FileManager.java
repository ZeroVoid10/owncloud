package xyz.zerovoid.pan.admin;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

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

    public void initRoot(String path) throws IOException {
        if (AppPreferences.getInstance().getRootPath() == null) {
            java.io.File root = new java.io.File(path);
            if (!root.isDirectory()) {
                throw new IOException();
            }
        }
    }

    /**
     * @author hp
     * @throws UnsupportedEncodingException
     */
    public void upload(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
        //Map<String, String[]> map = new HashMap<String, String[]>(request.getParameterMap());
        HttpSession session = request.getSession();
        //File file = File.form2File(map);
        Path path = Paths.get(rootPath, folder.getName());
        File file = File.getNewFile();
        file.setDir(path.relativize(Paths.get(rootPath)).toString())
            //.setUploader_UID(((User)session.getAttribute("user")).getUID());
            .setUploader_UID(1);

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List<FileItem> items = upload.parseRequest(request);
            Iterator<FileItem> iter = items.iterator();
            while(iter.hasNext()) {
                FileItem item = iter.next();
                String upload_path = null;
                String fileTag = null;
                if(item.isFormField()) {
                    if(item.getFieldName().equals("upload-path")) {
                        upload_path = item.getString("UTF-8");
                    }else if(item.getFieldName().equals("tags")) {
                        fileTag = item.getString("UTF-8");
                        file.setTag(fileTag);
                    }
                }else if(item.getFieldName().equals("file")) {
                    String fileName = item.getName();
                    fileName=fileName.substring(fileName.lastIndexOf("\\")+1);
                    file.setName(fileName);
                    java.io.File newFile = new java.io.File(path.toString(),fileName);
                    
                    try {
                        item.write(newFile);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
		}
        file.setHash(Paths.get(file.getDir(), file.getName()).hashCode());
        file.setKind("pdf").setSize("2MB");

        fileDao.add_file(file);
    }

    private String getFileType(String filename) {
		String type = filename.substring(filename.lastIndexOf(".")+1,filename.length());
		return type;
    }

}
