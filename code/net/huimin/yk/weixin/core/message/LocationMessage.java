package net.huimin.yk.weixin.core.message;

/**
 * 位置消息
 * @author HuXiaoChen
 *
 */
public class LocationMessage extends Message {
	private static final long serialVersionUID = 8561238095969176812L;

	/**
	 * 纬度
	 */
	private String locationX;

	/**
	 * 经度
	 */
	private String locationY;

	/**
	 * 地图缩放
	 */
	private Integer scale;

	/**
	 * 位置信息
	 */
	private String label;

	/**
	 * 纬度
	 */
	public String getLocationX() {
		return locationX;
	}
	
	/**
	 * 纬度
	 */
	public void setLocationX(String locationX) {
		this.locationX = locationX;
	}

	/**
	 * 经度
	 */
	public String getLocationY() {
		return locationY;
	}

	/**
	 * 经度
	 */
	public void setLocationY(String locationY) {
		this.locationY = locationY;
	}

	/**
	 * 地图缩放
	 */
	public Integer getScale() {
		return scale;
	}

	/**
	 * 地图缩放
	 */
	public void setScale(Integer scale) {
		this.scale = scale;
	}

	/**
	 * 位置信息
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * 位置信息
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
