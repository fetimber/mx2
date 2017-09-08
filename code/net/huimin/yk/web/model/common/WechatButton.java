package net.huimin.yk.web.model.common;

import java.io.Serializable;
import java.util.List;

import net.huimin.common.helper.Judge;

public class WechatButton implements Serializable {
	private static final long serialVersionUID = -1580553352414557862L;

	private String type;
	
	private String name;
	
	private String url;
	
	private List<WechatButton> sub_button;
	
	private Boolean openId;
	
	public boolean hasType(){
		return Judge.isNotNull(this.getType());
	}
	
	public boolean hasSub(){
		return Judge.isNotNull(this.getSub_button());
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<WechatButton> getSub_button() {
		return sub_button;
	}

	public void setSub_button(List<WechatButton> sub_button) {
		this.sub_button = sub_button;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Boolean getOpenId() {
		return openId;
	}

	public void setOpenId(Boolean openId) {
		this.openId = openId;
	}
}
