package net.huimin.yk.weixin.core.message;

/**
 * 文本消息
 * @author HuXiaoChen
 *
 */
public class TextMessage extends Message {
	private static final long serialVersionUID = -3087441658254064864L;
	/**
	 * 文本内容
	 */
	private String content;
	
	/**
	 * 文本内容
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 文本内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
}
