package net.huimin.yk.web.model.system;

import org.sword.wechat4j.common.Config;


public class WechatConfig {
	
	
	/**
	 * 读取微信配置
	 * @return
	 */
	public static WechatConfig load(){
		WechatConfig config = new WechatConfig();
		Config sc = Config.instance();
		config.setAccessTokenServer(sc.getAccessTokenServer());
		config.setAppid(sc.getAppid());
		config.setAppSecret(sc.getAppSecret());
		config.setEncodingAESKey(sc.getEncodingAESKey());
		config.setJsApiTicketServer(sc.getJsApiTicketServer());
		config.setToken(sc.getToken());
		config.setUrl(sc.getUrl());
		config.setAutoSwitch(sc.getAutoSwitch());
		return config;
	}
	
	/**
	 * 重新微信配置
	 */
	public void write(){
		
	}
	
	private String url;
	private String token;
	private String encodingAESKey;
	private String appid;
	private String appSecret;
	private String accessTokenServer;
	private String jsApiTicketServer;
	private Boolean autoSwitch;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getEncodingAESKey() {
		return encodingAESKey;
	}
	public void setEncodingAESKey(String encodingAESKey) {
		this.encodingAESKey = encodingAESKey;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	public String getAccessTokenServer() {
		return accessTokenServer;
	}
	public void setAccessTokenServer(String accessTokenServer) {
		this.accessTokenServer = accessTokenServer;
	}
	public String getJsApiTicketServer() {
		return jsApiTicketServer;
	}
	public void setJsApiTicketServer(String jsApiTicketServer) {
		this.jsApiTicketServer = jsApiTicketServer;
	}

	public Boolean getAutoSwitch() {
		if(null == this.autoSwitch){
			this.autoSwitch = false;
		}
		return autoSwitch;
	}

	public void setAutoSwitch(Boolean autoSwitch) {
		this.autoSwitch = autoSwitch;
	}
}
