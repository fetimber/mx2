package org.charon.arbitage.inter;

import java.util.List;

/**
 * �г����
 * @author cc
 *
 */
public class MarketLevel {

	public class MarketPrice {
		/*
		 * �۸�
		 */
		private Double price;
		/*
		 * ����
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
	 * �������
	 */
	private List<MarketPrice> asks;
	/*
	 * �������
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
