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
            logger.error("Inlegal reinstall!");
            return;
        }
        
        PrintWriter printer = response.getWriter();
        response.setContentType("application/json");
        JSONObject json = new JSONObject();

        Map<String, String[]> map = request.getParameterMap();

        SystemManager manager = null;
        try {
            manager = new SystemManager(map);
			manager.install();
		} catch (SQLException e) {
            // 方便调试安装过程
            //app.setAttribute("appStatus", "installed");
            logger.error("Install failed.");
            json.put("installed", false);
			e.printStackTrace();
        } 
        json.put("installed", true);
        printer.print(json.toString());
        printer.flush();
        printer.close();
}

}
