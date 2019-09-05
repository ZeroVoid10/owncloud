package xyz.zerovoid.pan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
            printer.print(doUpload(request, response));
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
		}

        return json.toString();
    }

}
