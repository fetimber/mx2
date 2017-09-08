package org.charon.arbitage.inter;
/**
 * 
 * @author cc
 * ����ƽ̨�ӿ�
 * ��Ҫ�ṩLTE���ۺͽ���
 */
public interface IBroker {

	/**
	 * ��ʼ���˻���Ϣ
	 * @param userName
	 * @param password
	 */
	void initUserAccount(String userName,String password);
	/**
	 * ��ȡ�г�ʵʱ����
	 * @return
	 */
	MarketQuote getMarketQuote();
	/**
	 * ��ȡ�г����
	 * @return
	 */
	MarketLevel getMarketLevel();
	/**
	 * ί������
	 * @param price ί�м۸�
	 * @param num ί������
	 * @return �ɽ�����
	 */
	Double buy(Double price,Double num);
	
	/**
	 * ί������
	 * @param price ί�м۸�
	 * @param num ί������
	 * @return �ɽ�����
	 */
	Double sell(Double price,Double num);
}
