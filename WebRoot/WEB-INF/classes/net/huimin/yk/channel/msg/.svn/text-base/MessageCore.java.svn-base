package net.huimin.yk.channel.msg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import net.huimin.yk.channel.http.SmsClient;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class MessageCore {
	
	private Logger logger = Logger.getLogger(MessageCore.class);
	
	private String mandao_seq;
	private String mandao_pwd;
	private String format;
	private String sign;
	private boolean isOK = false;
	private static Properties properties;
	
	public MessageCore() {
		//读取配置信息
		String path = System.getProperty("app.root.yk").concat(File.separator).concat("WEB-INF").concat(File.separator).concat("classes").concat(File.separator).concat("other").concat(File.separator).concat("mandao.properties");
		//String path = "D:\\tool\\apache-tomcat-6.0.32\\webapps\\yk".concat(File.separator).concat("WEB-INF").concat(File.separator).concat("classes").concat(File.separator).concat("other").concat(File.separator).concat("mandao.properties");
		File properties_file = new File(path);
		if(properties_file.exists()){
			//文件存在
			try {
				properties = new Properties();
				properties.load(new FileInputStream(properties_file));
				this.mandao_seq = properties.getProperty("mandao.seq");
				this.mandao_pwd = properties.getProperty("mandao.pwd");
				this.format = properties.getProperty("mandao.format1");
				this.sign = properties.getProperty("mandao.sign");
				isOK = true;
			} catch (IOException e) {
				this.logger.warn("读取配置文件[WEB-INF\\classes\\other\\mandao.properties]时发生错误，短信发送功能将不可用");
			}
		} else {
			this.logger.warn("未能在WEB-INF\\classes\\other目录中找到mandao.properties文件，短信发送功能将不可用");
		}
	}
	
	public static String getProperties(String key){
		return MessageCore.properties.getProperty(key);
	}

	public boolean send(String target,String content){
		boolean rslt = false;
		if(isOK){
			try {
				SmsClient client=new SmsClient(this.mandao_seq,this.mandao_pwd);
				content= URLEncoder.encode(content + this.sign,"utf8");
				
				String rrid = this.seq();
				
				String result_mt = client.mdsmssend(target, content, "", "", rrid, "");
				System.out.println("短信返回" + result_mt);
				rslt = result_mt.equals(rrid);
			} catch (Exception e) { }
		}
		return rslt;
	}
	
	public boolean send(List<String> targets,String content){
		StringBuffer target = new StringBuffer();
		Iterator<String> iterator = targets.iterator();
		while (iterator.hasNext()) {
			target.append(iterator.next());
			if(iterator.hasNext()){
				target.append(",");
			}
		}
		return this.send(target.toString(), content);
	}
	
	private String seq(){
		StringBuffer buffer = new StringBuffer();
		buffer.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		buffer.append((int)(1000+Math.random()*(10-99+1)));
		return buffer.toString();
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public boolean sendValidate(String code, String target) {
		String content = this.format.replace("#CODE#", code);
		return this.send(target, content);
	}
}
