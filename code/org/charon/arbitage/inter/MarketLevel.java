package org.charon.arbitage.inter;

import java.util.List;

/**
 * 市场深度
 * @author cc
 *
 */
public class MarketLevel {

	public class MarketPrice {
		/*
		 * 价格
		 */
		private Double price;
		/*
		 * 数量
		 */
		private Double num;
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
			this.price = price;
		}
		public Double getNum() {
			return num;
		}
		public void setNum(Double num) {
			this.num = num;
		}
		
		
	};
	//private Double latestPrice;
	/*
	 * 卖出深度
	 */
	private List<MarketPrice> asks;
	/*
	 * 买入深度
	 */
	private List<MarketPrice> bids;
	
	public List<MarketPrice> getAsks() {
		return asks;
	}
	public void setAsks(List<MarketPrice> asks) {
		this.asks = asks;
	}
	public List<MarketPrice> getBids() {
		return bids;
	}
	public void setBids(List<MarketPrice> bids) {
		this.bids = bids;
	}
	
	
}
