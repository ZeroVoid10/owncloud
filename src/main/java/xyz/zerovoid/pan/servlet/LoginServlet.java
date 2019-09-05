package xyz.zerovoid.pan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xyz.zerovoid.pan.admin.UserManager;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = 
        LoggerFactory.getLogger(InstallServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        PrintWriter printer = response.getWriter();
        response.setContentType("application/json");
        JSONObject json = new JSONObject();
        Map<String, String[]> map = request.getParameterMap();
        HttpSession session = request.getSession();
        int status = 1;

        try {
			UserManager manager = new UserManager();
            status = manager.login(map, session);
		} catch (SQLException e) {
			e.printStackTrace();
            logger.error("error in login.");
        } finally {
            json.put("login", status);
            printer.print(json.toString());
            printer.flush();
            printer.close();
        }
	}

}
