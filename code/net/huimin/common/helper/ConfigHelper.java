package net.huimin.common.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;

public class ConfigHelper {

	private static Logger logger = Logger.getLogger(ConfigHelper.class);
	
	private static final String configFile = "wechat4j.properties";
	
	private String sendMessage;
	
	public ConfigHelper(){
		Properties p = new Properties();
		String root = System.getProperty("app.root.yk").concat(File.separator).concat("WEB-INF").concat(File.separator).concat("classes").concat(File.separator).concat("other").concat(File.separator).concat(configFile);
		
		try {
			InputStream inStream = new FileInputStream(new File(root));
			p.load(inStream);
			sendMessage = p.getProperty("wechat.textsend").trim();
			logger.info("sendMessage : " + sendMessage);
			inStream.close();
		} catch (IOException e) {
			logger.error("load wechat4j.properties error,class根目录下找不到wechat4j.properties文件");
			e.printStackTrace();
		}
		logger.info("load wechat4j.properties success");
	}

	public String getSendMessage() {
		return sendMessage;
	}

}
