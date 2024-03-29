package xyz.zerovoid.pan.admin;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
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
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import AllFileTable.File;
import AllFileTable.FileManagement;
import xyz.zerovoid.pan.dao.DAOFactory;
import xyz.zerovoid.pan.dao.UserDao;
import xyz.zerovoid.pan.util.AppPreferences;
import xyz.zerovoid.pan.util.Folder;
import xyz.zerovoid.pan.vo.User;

/**
 * @since 0.1.0
 * @author zerovoid
 */
public class FileManager {
    private static final Logger logger = 
        LoggerFactory.getLogger(FileManager.class);

    private UserDao userDao = null; 
    private FileManagement fileDao = null;
    private Folder folder = null;
    private String rootPath;
    private static final String salt = "JamesHpZeroVoid";

    public FileManager () throws SQLException, IOException {
        this.userDao = DAOFactory.getUserDAO();
        this.fileDao = DAOFactory.getFileDAO();
        folder = new Folder("/");
        rootPath = AppPreferences.getInstance().getRootPath();
    }

    public JSONObject getFileInfo() throws SQLException {
        ArrayList<File> list = folder.getFileList();
        JSONObject json = new JSONObject();
        ArrayList<JSONObject> info = new ArrayList<JSONObject>();
        for(File f : list) {
            JSONObject singleinfo = new JSONObject();
            singleinfo.put("fileinfoid", Paths.get(rootPath, f.getDir()+f.getName()+salt).hashCode());
            singleinfo.put("dir", f.getDir())
                .put("imgsrc", "img/" + f.getKind() + ".png")
                .put("filename", f.getName())
                .put("size", f.getSize())
                .put("a", f.getDir())
                .put("date", f.getUpload_time());
            logger.info("get name");
            logger.info(f.getDir());
            logger.info(f.getName());
            int hash = Paths.get(f.getDir(), f.getName()).hashCode();
            String strhash = Integer.toString(hash);
            List<File> templist = fileDao.mult_search_file(f.getName(), "", "", "");
            if (!templist.isEmpty()) {
                User user = userDao.findUser(templist.get(0).getUploader_UID());
                singleinfo.put("uploaduser", user.getUsername());
            } else {
                singleinfo.put("uploaduser", "system");
            }
            info.add(singleinfo);
        }
        json.put("fileinfo", info);
        return json;
    }

    public JSONObject orderFile(String method, int sc) throws SQLException {
        List<File> list = null;
        if (method.equals("filename")) {
            list = fileDao.order_by("name", sc>0);
        }
        JSONObject json = new JSONObject();
        ArrayList<JSONObject> info = new ArrayList<JSONObject>();
        for(File f : list) {
            JSONObject singleinfo = new JSONObject();
            singleinfo.put("fileinfoid", Paths.get(rootPath, f.getDir()+f.getName()+salt).hashCode());
            singleinfo.put("dir", f.getDir())
                .put("imgsrc", "img/" + f.getKind() + ".png")
                .put("filename", f.getName())
                .put("size", f.getSize())
                .put("a", f.getDir())
                .put("date", f.getUpload_time());
            logger.info("get name");
            logger.info(f.getDir());
            logger.info(f.getName());
            List<File> templist = fileDao.mult_search_file(f.getName(), "", "", "");
            if (!templist.isEmpty()) {
                User user = userDao.findUser(templist.get(0).getUploader_UID());
                singleinfo.put("uploaduser", user.getUsername());
            } else {
                singleinfo.put("uploaduser", "system");
            }
            info.add(singleinfo);
        }
        json.put("fileinfo", info);
        return json;
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
     * @throws SQLException
     */
    public void upload(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, SQLException{
        //Map<String, String[]> map = new HashMap<String, String[]>(request.getParameterMap());
        HttpSession session = request.getSession();
        //File file = File.form2File(map);
        Path path = Paths.get(rootPath, folder.getName());
        File file = File.getNewFile();
        file.setDir(path.relativize(Paths.get(rootPath)).toString());
            //.setUploader_UID(((User)session.getAttribute("user")).getUID());
        int uid ;
        if (session.getAttribute("uid") == null) {
            file.setUploader_UID(2);
        } else {
            file.setUploader_UID((int)session.getAttribute("uid"));
        }
        if (file.getDir().equals("")) {
        }

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
                String description = null;
                String fileTag = null;
                if(item.isFormField()) {
                    if(item.getFieldName().equals("description")) {
                        description = item.getString("UTF-8");
                    }else if(item.getFieldName().equals("tags")) {
                        fileTag = item.getString("UTF-8");
                        file.setTag(fileTag);
                    } else if (item.getFieldName().equals("filename")) {
                        file.setName(item.getString("UTF-8"));
                    } else if (item.getFieldName().equals("suffix")) {
                        file.setKind(item.getString("UTF-8"));
                    } else if (item.getFieldName().equals("filesize")) {
                        file.setSize(item.getString("UTF-8"));
                    } 
                }else if(item.getFieldName().equals("file")) {
                    /*
                    String fileName = item.getName();
                    fileName=fileName.substring(fileName.lastIndexOf("\\")+1);
                    file.setName(fileName); */
                    java.io.File newFile = new java.io.File(path.toString(),file.getName());
                    
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
        logger.info("upload name");
        logger.info(file.getDir());
        logger.info(file.getName());
        file.setHash(Paths.get(file.getDir(), file.getName()).hashCode());

        fileDao.add_file(file);
    }

    private String getFileType(String filename) {
		String type = filename.substring(filename.lastIndexOf(".")+1,filename.length());
		return type;
    }

}
