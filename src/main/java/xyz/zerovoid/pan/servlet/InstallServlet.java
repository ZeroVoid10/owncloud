package xyz.zerovoid.pan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import xyz.zerovoid.pan.util.*;
import xyz.zerovoid.pan.dao.DatabaseConnection;
import xyz.zerovoid.pan.install.InitTable;

/**
 * Servlet implementation class InstallServlet
 */
public class InstallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InstallServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
        //doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
        ServletContext app = this.getServletContext();
        if (app.getAttribute("appStatus") != null) {
            //非法重新安装。
            return;
        }
        
        PrintWriter printer = response.getWriter();
        response.setContentType("application/json");
        JSONObject json = new JSONObject();
        json.put("connection", true);

        String dbType = request.getParameter("db_type");
        String host = request.getParameter("db_host");
        String port = request.getParameter("db_port");
        String db_name = request.getParameter("db_name");
        String username = request.getParameter("db_username");
        String db_password = request.getParameter("db_password");

        //TODO: registe
        String root_password = request.getParameter("root_password");

        AppPreferences pref = AppPreferences.getInstance();

        pref.setDBDriver(dbType);
        pref.setHost(host);
        pref.setPort(port);
        pref.setCredentials(username, db_password);
        pref.setDabaseName(db_name);

        DatabaseConnection dc = null;
        InitTable it;
        try {
            dc = new DatabaseConnection();
            it = new InitTable();
            if (it.init()) {
                app.setAttribute("appStatus", "installed");
            }
        } catch(SQLException e) {
            json.put("connection", false);
            pref.clear();
            e.printStackTrace();
        } finally {
            try {
				dc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
        }

        printer.print(json.toString());
        printer.flush();
        printer.close();
	}

}
