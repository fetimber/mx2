package net.huimin.yk.channel.http;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;

/**
 * 使用Jsoup解析网页，或进行URL请求
 * @author xiexinzhe
 *
 */
public class JsoupHelper {

	public static String FFAgent = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:30.0) Gecko/20100101 Firefox/30.0";

	/**
	 * 获取网页信息或请求响应报文
	 * @param url 请求地址
	 * @param paramMap 参数MAP
	 * @param method POST或GET
	 * @return
	 */
	public static Response pageReciveResponse(String url,
			Map<String, String> paramMap, Method method) {
		Connection.Response res = null;
		try {
			res = Jsoup.connect(url).timeout(5000).data(paramMap)
					.userAgent(FFAgent).method(method).execute();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return res;
	}

	/**
	 * 获取网页信息或请求响应报文
	 * @param url 请求地址
	 * @param paramMap 参数MAP
	 * @param method  POST或GET
	 * @param referrer  上一个页面的URL地址（部分网页需要上个页面的数据时使用）
	 * @return
	 */
	public static Response pageReciveResponseByRefer(String url,
			Map<String, String> paramMap, Method method, String referrer) {
		Connection.Response res = null;
		try {
			res = Jsoup.connect(url).timeout(5000).data(paramMap)
					.referrer(referrer).userAgent(FFAgent).method(method)
					.execute();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return res;
	}

}
