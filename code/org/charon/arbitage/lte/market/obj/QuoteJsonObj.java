package org.charon.arbitage.lte.market.obj;

import org.charon.arbitage.inter.MarketQuote;

public class QuoteJsonObj {
	
	String time;
	String date;
	
	Ticker ticker;
	
	
	
	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public Ticker getTicker() {
		return ticker;
	}


	public void setTicker(Ticker ticker) {
		this.ticker = ticker;
	}


	public class Ticker extends MarketQuote{
		protected Double open;
		
		protected String symbol;

		public Double getOpen() {
			return open;
		}

		public void setOpen(Double open) {
			this.open = open;
		}

		public String getSymbol() {
			return symbol;
		}

		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}
	}
}
