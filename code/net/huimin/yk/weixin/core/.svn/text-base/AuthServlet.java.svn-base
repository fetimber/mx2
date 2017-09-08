package net.huimin.yk.weixin.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.huimin.yk.weixin.demo.CustomBizDemo;

import com.alibaba.fastjson.JSONObject;

public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = -3619949177805753857L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		URL url = new URL("https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx9e0db0496c9798f3&secret=b9609f4cdc2bd9bfd3e9cc19418e7cbc&code=" + code + "&grant_type=authorization_code");
		URLConnection con = url.openConnection();
		InputStreamReader bis = new InputStreamReader(con.getInputStream());
		BufferedReader bf = new BufferedReader(bis);
		String line = "";
		StringBuffer buffer = new StringBuffer();
		while ((line = bf.readLine()) != null) {
			buffer.append(line);
		}
		JSONObject jo = JSONObject.parseObject(buffer.toString());
		String open_id = jo.getString("openid");
		CustomBiz biz = new CustomBizDemo(state, open_id);
		String forward = biz.execute();
		Map<String, Object> map = biz.request_map;
		for (Iterator<String> iterator = map.keySet().iterator(); iterator.hasNext();) {
			String key =  iterator.next();
			request.setAttribute(key, map.get(key));
		}
		request.getRequestDispatcher(forward).forward(request, response);
	}
}
