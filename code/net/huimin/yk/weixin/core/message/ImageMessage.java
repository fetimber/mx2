package net.huimin.yk.weixin.core.message;

/**
 * 图片消息
 * @author HuXiaoChen
 *
 */
public class ImageMessage extends MediaMessage {
	private static final long serialVersionUID = -73623244042190316L;

	/**
	 * 图片地址
	 */
	private String picUrl;

	/**
	 * 图片地址
	 */
	public String getPicUrl() {
		return picUrl;
	}

	/**
	 * 图片地址
	 */
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
