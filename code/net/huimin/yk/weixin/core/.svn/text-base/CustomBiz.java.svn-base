package net.huimin.yk.weixin.core;

import java.util.HashMap;
import java.util.Map;

public abstract class CustomBiz {
	public CustomBiz(String state,String openId){
		this.state = state;
		this.openId = openId;
	}
	public Map<String, Object> request_map = new HashMap<String, Object>();
	protected String state;
	protected String openId;
	public abstract String execute();
}
