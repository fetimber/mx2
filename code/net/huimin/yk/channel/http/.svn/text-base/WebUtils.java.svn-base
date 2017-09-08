package net.huimin.yk.channel.http;

public class WebUtils {

	public static String sendHttp(String url, Object parameters) {
		String outStr = "";
		try {
			String charSet = "UTF-8";
			String timeOut = "200000";// 自行配置
			outStr = HttpClientHelper.doHttp(url, charSet, parameters, timeOut);
			// System.out.println("outStr="+outStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outStr;
	}
}