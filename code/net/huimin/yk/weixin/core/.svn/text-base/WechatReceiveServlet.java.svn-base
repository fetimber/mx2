package net.huimin.yk.weixin.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WechatReceiveServlet extends HttpServlet {
	private static final long serialVersionUID = 8756993774303703966L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		request.setCharacterEncoding("UTF-8");
		WechatSupport support = new WechatSupportImpl(request);
		String result = support.execute();
		this.response(response, result);
	}

	private void response(HttpServletResponse response, String content) throws IOException {
		if(content.startsWith("<")){
			content = "<?xml version=\"1.0\" encoding=\"gbk\"?>" + content;
		}
        response.getOutputStream().write(content.getBytes());
	}
}
