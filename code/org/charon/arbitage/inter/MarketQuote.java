package org.charon.arbitage.inter;

/**
 * �г�ʵʱ����
 * @author cc
 *
 */
public class MarketQuote {

	/*
	 * ���¼�
	 */
	protected Double last;
	/*
	 * �����
	 */
	protected Double buy;
	/*
	 * ������
	 */
	protected Double sell;
	/*
	 * ��ͼ�
	 */
	protected Double low;
	/*
	 * ��߼�
	 */
	protected Double high;
	/*
	 * �ɽ���
	 */
	protected Double vol;
	
	
	public Double getLast() {
		return last;
	}
	public void setLast(Double last) {
		this.last = last;
	}
	public Double getBuy() {
		return buy;
	}
	public void setBuy(Double buy) {
		this.buy = buy;
	}
	public Double getSell() {
		return sell;
	}
	public void setSell(Double sell) {
		this.sell = sell;
	}
	public Double getLow() {
		return low;
	}
	public void setLow(Double low) {
		this.low = low;
	}
	public Double getHigh() {
		return high;
	}
	public void setHigh(Double high) {
		this.high = high;
	}
	public Double getVol() {
		return vol;
	}
	public void setVol(Double vol) {
		this.vol = vol;
	}
	
	
}
