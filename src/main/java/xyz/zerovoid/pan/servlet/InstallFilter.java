package xyz.zerovoid.pan.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import xyz.zerovoid.pan.util.AppPreferences;

/**
 * Servlet Filter implementation class InstallFilter
 */
public class InstallFilter implements Filter {

    /**
     * Default constructor. 
     */
    public InstallFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		AppPreferences pref = AppPreferences.getInstance();
        if (pref.getInstalled() == null) {
            request.getRequestDispatcher("/install");
        } else {
		    chain.doFilter(request, response);
        }

		// pass the request along the filter chain
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
