package net.huimin.yk.web.services.finace;

import java.util.Date;
import java.util.List;

import net.huimin.common.page.PageBean;
import net.huimin.yk.web.model.cash.CashApplication;
import net.huimin.yk.web.model.cash.CashBalance;
import net.huimin.yk.web.model.cash.CashDetail;
import net.huimin.yk.web.model.customer.CustomerApplication;
import net.huimin.yk.web.model.customer.CustomerMoney;
import net.huimin.yk.web.model.money.MoneyApplication;
import net.huimin.yk.web.model.money.MoneyBalance;
import net.huimin.yk.web.model.money.MoneyDetail;

public interface FinaceService {

	//查询经纪人佣金申请表
	public List<MoneyApplication> queryAgentMoneyList (MoneyApplication application); 
	
	//查询经纪人佣金申请表
	public void queryAgentMoneyListForPage (PageBean page, MoneyApplication application,Date startime,Date endtime,String keyword); 

	//查询经纪人可提现金列表
	public void queryAgentMoneyBalanceListForPage (PageBean page, MoneyBalance balance); 
	
	//查询经纪人体现申请列表
	public void queryAgentCashApplicationForPage(PageBean page,CashApplication application,Date startime,Date endtime,String keyword);
	
	public void queryAgentCashApplicationForPage2(PageBean page,CashApplication application,Date startime,Date endtime,String keyword);
	
	//申请佣金结算(签约结算)
	public Boolean agentMoneyApplication(MoneyApplication application,MoneyDetail detail,CustomerApplication app ,CustomerMoney money);
	
	//申请佣金结算(其他类型奖励结算)
	public Boolean agentMoneyApplication(MoneyApplication application,MoneyDetail detail,CustomerMoney app);
	
	//申请现金提现
	public Boolean agentCashApplication(CashApplication application,CashDetail detail);
	
	//
	public MoneyApplication queryMoneyApp(Integer id);
	
	//
	public CashApplication queryCashyApp(Integer id);
	
	//查询佣金结算表
	public MoneyBalance queryMoneyBalance(Integer id);
	/**
	 * 根据客户id查询MoneyApplication
	 * @param id
	 * @return
	 */
	public MoneyApplication selectByCustomerId(Integer id);
	
	//佣金审核
	public  Boolean moneyCheck  (MoneyApplication moneyApp, MoneyDetail moneyDetail, MoneyBalance balacne,Integer pass);
	
	//现金审核
    public  Boolean cashCheck  (CashApplication cashApp, CashDetail cashDetail,CashBalance balance,Integer pass);
    
}
