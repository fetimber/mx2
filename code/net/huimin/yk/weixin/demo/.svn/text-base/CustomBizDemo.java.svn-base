package net.huimin.yk.weixin.demo;

import net.huimin.yk.weixin.core.CustomBiz;

public class CustomBizDemo extends CustomBiz {

	public CustomBizDemo(String state, String openId) {
		super(state, openId);
	}

	@Override
	public String execute() {
		if(this.state == "123"){
			return this.toLogin();
		}
		
		return "/.jsp";
	}
	
	private String toLogin(){
		this.request_map.put("open_id", this.openId);
		return "/login.jsp";
	}

}
