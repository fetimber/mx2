package org.charon.arbitage.inter;
/**
 * 
 * @author cc
 * 交易平台接口
 * 主要提供LTE报价和交易
 */
public interface IBroker {

	/**
	 * 初始化账户信息
	 * @param userName
	 * @param password
	 */
	void initUserAccount(String userName,String password);
	/**
	 * 获取市场实时行情
	 * @return
	 */
	MarketQuote getMarketQuote();
	/**
	 * 获取市场深度
	 * @return
	 */
	MarketLevel getMarketLevel();
	/**
	 * 委托买入
	 * @param price 委托价格
	 * @param num 委托数量
	 * @return 成交数量
	 */
	Double buy(Double price,Double num);
	
	/**
	 * 委托卖出
	 * @param price 委托价格
	 * @param num 委托数量
	 * @return 成交数量
	 */
	Double sell(Double price,Double num);
}
