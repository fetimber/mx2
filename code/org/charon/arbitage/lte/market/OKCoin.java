package org.charon.arbitage.lte.market;

import org.charon.arbitage.inter.IBroker;
import org.charon.arbitage.inter.MarketLevel;
import org.charon.arbitage.inter.MarketQuote;
import org.charon.arbitage.lte.market.obj.QuoteJsonObj;
import org.charon.arbitage.util.HttpUtil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class OKCoin extends AbstractMarket implements IBroker {

	public OKCoin(String userName, String password) {
		super(userName,password);
	}

	public Double buy(Double price, Double num) {
		// TODO Auto-generated method stub
		return null;
	}


	public MarketLevel getMarketLevel() {
		// TODO Auto-generated method stub
		return null;
	}

	private static final String QUOTE_URL = "https://www.okcoin.cn/api/v1/ticker.do?symbol=ltc_cny";

	public MarketQuote getMarketQuote() {
		MarketQuote res = null;
		String response = HttpUtil.sendGet(QUOTE_URL, null);
		if(response != null && !response.trim().equals("")){
			res = pauseJson(response);
		}
		return res;
	}

	private MarketQuote pauseJson(String json) {
		MarketQuote res = null;
		Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
		QuoteJsonObj obj = gson.fromJson(json, QuoteJsonObj.class);
		if(obj != null){
			res = obj.getTicker();
		}
		return res;
	}
	
	public Double sell(Double price, Double num) {
		// TODO Auto-generated method stub
		return null;
	}

}
