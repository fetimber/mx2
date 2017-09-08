package net.huimin.common.mvc;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class JSPFilter implements Filter {

	private Logger logger = Logger.getLogger(JSPFilter.class);
	
	/**
	 * (非 Javadoc) 
	 * <p>Title:destroy</p> 
	 * <p>Description: </p>  
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		this.logger.info("JSP Filter 销毁....");		
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		String url = request.getRequestURI();
		if(url.endsWith(".jsp")){
			String redirect = request.getContextPath() + "/error/jsp.html";
			response.sendRedirect(redirect);
		} else {
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Pragma", "no-cache");
			response.setDateHeader("Expires", -1);
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.logger.info("JSP Filter 初始化.");		
	}

}
