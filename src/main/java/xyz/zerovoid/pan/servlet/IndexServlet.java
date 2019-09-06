package xyz.zerovoid.pan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xyz.zerovoid.pan.admin.FileManager;
import xyz.zerovoid.pan.admin.UserManager;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = 
        LoggerFactory.getLogger(InstallServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
        PrintWriter printer = response.getWriter();
		boolean isMutipart = ServletFileUpload.isMultipartContent(request);
        if (isMutipart) {
            logger.info("upload file");
            printer.print(doUpload(request, response));
        } else {
            Map<String, String[]> map = new HashMap(request.getParameterMap()); 
            if (map.get("request")[0].equals("fileinfo")) {
                logger.info("get file list");
                printer.print(getFileInfo(request, response));
            } 
        }
        printer.flush();
        printer.close();
	}

    private String doUpload(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        JSONObject json = new JSONObject();
	    FileManager fileManager = null;

        try {
			fileManager = new FileManager();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
            logger.error("Get file manager failed");
		}

        try {
			fileManager.upload(request, response);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
            logger.error("upload file failed");
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("insert to database failed");
        }

        return json.toString();
    }

    private String getFileInfo(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        JSONObject json = null;
	    FileManager fileManager = null;

        try {
            fileManager = new FileManager();
            json = fileManager.getFileInfo();
        } catch(Exception e){
            e.printStackTrace();
        }

        return json.toString();
    }

}
