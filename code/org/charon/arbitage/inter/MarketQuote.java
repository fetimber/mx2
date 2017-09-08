package org.charon.arbitage.inter;

/**
 * 市场实时行情
 * @author cc
 *
 */
public class MarketQuote {

	/*
	 * 最新价
	 */
	protected Double last;
	/*
	 * 买入价
	 */
	protected Double buy;
	/*
	 * 卖出价
	 */
	protected Double sell;
	/*
	 * 最低价
	 */
	protected Double low;
	/*
	 * 最高价
	 */
	protected Double high;
	/*
	 * 成交量
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
