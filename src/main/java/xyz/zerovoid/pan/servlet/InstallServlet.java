package xyz.zerovoid.pan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xyz.zerovoid.pan.admin.SystemManager;
import xyz.zerovoid.pan.util.AppPreferences;

/**
 * Servlet implementation class InstallServlet
 */
public class InstallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = 
        LoggerFactory.getLogger(InstallServlet.class);
       
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
        PrintWriter printer = response.getWriter();
        response.setContentType("application/json");
        JSONObject json = new JSONObject();
        ServletContext app = this.getServletContext();
        if (AppPreferences.getInstance().getInstalled().compareTo("ok") == 0) {
            logger.error("Inlegal reinstall!!! Redirection to index.");
            app.setAttribute("installed", "installed");
            json.put("inlegal", true);
            printer.print(json.toString());
            printer.flush();
            printer.close();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
        boolean installed = true;
        PrintWriter printer = response.getWriter();
        response.setContentType("application/json");
        JSONObject json = new JSONObject();
        
        ServletContext app = this.getServletContext();
        if (AppPreferences.getInstance().getInstalled().compareTo("ok") == 0) {
            json.put("inlegal", true);
            app.setAttribute("installed", "installed");
            printer.print(json.toString());
            printer.flush();
            printer.close();
            logger.error("inlegal reinstall!");
            return;
        }

        Map<String, String[]> map = request.getParameterMap();

        try {
            SystemManager manager = new SystemManager(map);
			manager.install();
		} catch (Exception e) {
            // 方便调试安装过程
            installed = false;
            json.put("installed", false);
            logger.error("Install failed.");
			e.printStackTrace();
        } 
        if (installed) {
            app.setAttribute("installed", "installed");
            json.put("installed", true);
        }
        printer.print(json.toString());
        printer.flush();
        printer.close();
    }

}
