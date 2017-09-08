package net.huimin.common.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

public class ResponseJson {
	
	private static Logger logger = Logger.getLogger(ResponseJson.class);

	public static void flush(String json) {
		try {
			HttpServletResponse response=ServletActionContext.getResponse();  
		    /* 
		     * 在调用getWriter之前未设置编码(既调用setContentType或者setCharacterEncoding方法设置编码), 
		     * HttpServletResponse则会返回一个用默认的编码(既ISO-8859-1)编码的PrintWriter实例。这样就会 
		     * 造成中文乱码。而且设置编码时必须在调用getWriter之前设置,不然是无效的。 
		     * */  
		    response.setContentType("text/json;charset=utf-8");  
		    PrintWriter out = response.getWriter();
		    
		    out.println(json);  
		    out.flush();  
		    out.close(); 
		} catch (IOException e) {
			logger.error("推送JSON数据时发生错误",e);
		}  
	}

}
