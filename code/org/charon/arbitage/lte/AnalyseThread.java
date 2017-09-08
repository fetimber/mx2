package org.charon.arbitage.lte;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.charon.arbitage.inter.MarketQuote;
import org.charon.arbitage.lte.market.HuoBi;
import org.charon.arbitage.lte.market.OKCoin;
import org.charon.arbitage.util.JDBCConn;


public class AnalyseThread extends Thread {

	private OKCoin okcoin = new OKCoin("","");
	private HuoBi huobi = new HuoBi("","");
	
	public void run(){
		try {
			save2db();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void save2db() throws Exception {
		String uuid = java.util.UUID.randomUUID().toString();
		saveTimeRecord(uuid);
		saveOKCoin(this.okcoin.getMarketQuote(),uuid);
		saveHuoBi(this.huobi.getMarketQuote(),uuid);
	}

	private static final String SQL_HUOBI = "insert into t_lte_quote_huobi(recuuid,last,buy,sell,low,high,vol) values(?,?,?,?,?,?,?)";
	/**
	 * ������������
	 * @param huobi 
	 * @param uuid
	 */
	private void saveHuoBi(MarketQuote huobi, String uuid)throws Exception {
		saveQuote(SQL_HUOBI,huobi,uuid);
	}

	private void saveQuote(String sql, MarketQuote quote, String uuid) throws Exception {
		Connection connection = new JDBCConn().getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, uuid);
			ps.setDouble(2, quote.getLast());
			ps.setDouble(3, quote.getBuy());
			ps.setDouble(4, quote.getSell());
			ps.setDouble(5, quote.getLow());
			ps.setDouble(6, quote.getHigh());
			ps.setDouble(7, quote.getVol());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

	private static final String SQL_OKCOIN = "insert into t_lte_quote_okcoin(recuuid,last,buy,sell,low,high,vol) values(?,?,?,?,?,?,?)";
	/**
	 * ����OKCOIN����
	 * @param okcoin
	 * @param uuid
	 */
	private void saveOKCoin(MarketQuote okcoin, String uuid) throws Exception{
		saveQuote(SQL_OKCOIN,okcoin,uuid);
	}

	/**
	 * ����ʱ����
	 * @param uuid
	 */
	private static final String SQL_REC = "insert into t_lte_timerec(uuid,rectime) values(?,now())";
	private void saveTimeRecord(String uuid) throws Exception {
		Connection connection = new JDBCConn().getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(SQL_REC);
			ps.setString(1, uuid);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}
	
	public static void main(String[] arg){
		try {
			new AnalyseThread().save2db();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
