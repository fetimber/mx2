package net.huimin.yk.web.services.finace.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.huimin.common.helper.Judge;
import net.huimin.common.page.PageBean;
import net.huimin.yk.web.dao.cash.CashApplicationMapper;
import net.huimin.yk.web.dao.cash.CashBalanceMapper;
import net.huimin.yk.web.dao.cash.CashDetailMapper;
import net.huimin.yk.web.dao.customer.CustomerApplicationMapper;
import net.huimin.yk.web.dao.customer.CustomerMoneyMapper;
import net.huimin.yk.web.dao.money.MoneyApplicationMapper;
import net.huimin.yk.web.dao.money.MoneyBalanceMapper;
import net.huimin.yk.web.dao.money.MoneyDetailMapper;
import net.huimin.yk.web.model.cash.CashApplication;
import net.huimin.yk.web.model.cash.CashBalance;
import net.huimin.yk.web.model.cash.CashDetail;
import net.huimin.yk.web.model.customer.CustomerApplication;
import net.huimin.yk.web.model.customer.CustomerMoney;
import net.huimin.yk.web.model.money.MoneyApplication;
import net.huimin.yk.web.model.money.MoneyBalance;
import net.huimin.yk.web.model.money.MoneyDetail;
import net.huimin.yk.web.services.common.AccountService;
import net.huimin.yk.web.services.finace.FinaceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinaceServiceImpl implements FinaceService {

	 @Autowired
	 private  MoneyApplicationMapper  moneyMapper;
	 @Autowired
	 private MoneyDetailMapper moneyDetailMapper;
	 @Autowired
	 private  MoneyBalanceMapper balanceMapper; 
	 
	 @Autowired
	 private CashApplicationMapper cashMapper;
	 @Autowired
	 private CashDetailMapper cashDetailMapper;
	 @Autowired
	 private CashBalanceMapper cashBalanceMapper;
	 
	 @Autowired
     private AccountService accountService;
	 @Autowired
	 private CustomerApplicationMapper customerMapper;
	 @Autowired
	 private CustomerMoneyMapper customerMoneyMapper;
	 
	 public void queryAgentMoneyListForPage(PageBean page, MoneyApplication application, Date startime,Date endtime,String keyword) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("_page", page);
		parameters.put("keyword", keyword);
		parameters.put("startime", startime);
		parameters.put("endtime", endtime);
		parameters.put("money", application);
	
		Integer count = this.moneyMapper.
				selectMoneyApplicationCount(parameters);
		
		List<MoneyApplication> moneys = this.moneyMapper
				.selectMoneyApplicationForPage(parameters);

		PageBean.Counter(page, count, null, moneys);		
	 }

	public void queryAgentMoneyBalanceListForPage(PageBean page,
			MoneyBalance balance) {
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("_page", page);
		parameters.put("balance", balance);
		
	
		Integer count = this.balanceMapper.
				selectBalanceCount(parameters);
			List<MoneyBalance> balances = this.balanceMapper
					.selectBalanceApplication(parameters);

			PageBean.Counter(page, count, null, balances);	
		
	}

	public void queryAgentCashApplicationForPage(PageBean page,
			CashApplication application,Date startime,Date endtime,String keyword) {
		try{
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("_page", page);
			parameters.put("cash", application);
			parameters.put("keyword", keyword);
			parameters.put("startime", startime);
			parameters.put("endtime", endtime);
			
			Integer count = this.cashMapper.
					selectCashApplicationCount(parameters);
				List<CashApplication> balances = this.cashMapper.
						selectCashApplication(parameters);

				PageBean.Counter(page, count, null, balances);	
			}catch (Exception ex){
				ex.printStackTrace();	
			}
	}
	
	public void queryAgentCashApplicationForPage2(PageBean page,
			CashApplication application, Date startime, Date endtime,
			String keyword) {
		try{
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("_page", page);
			parameters.put("cash", application);
			parameters.put("keyword", keyword);
			parameters.put("startime", startime);
			parameters.put("endtime", endtime);
			
			Integer count = this.cashMapper.
					selectCashApplicationCount(parameters);
				List<CashApplication> balances = this.cashMapper.
						selectCashApplication2(parameters);

				PageBean.Counter(page, count, null, balances);	
			}catch (Exception ex){
				ex.printStackTrace();	
			}
		
	}

	public Boolean agentMoneyApplication(MoneyApplication application,
		MoneyDetail detail,CustomerApplication app ,CustomerMoney money) {
		Boolean result = false;
		MoneyApplication appBean = this.moneyMapper.selectByCustomerId(application.getCustomerId());
		
		if(Judge.isNull(appBean)){
			if(1 == this.moneyMapper.insertSelective(application)){
				detail.setApplicationId(application.getId());
				if(1 == this.moneyDetailMapper.insertSelective(detail)){	
					result = customerMapper.updateByPrimaryKeySelective(app) == 1;
					result = customerMoneyMapper.updateByPrimaryKeySelective(money) == 1;
					//更新账户
					this.accountService.applyMoney(application.getAccountId(), application.getAmountMoney());
				}
			}
		}
		
		return result;
	}


	public Boolean agentMoneyApplication(MoneyApplication application,
			MoneyDetail detail, CustomerMoney app) {
		Boolean result = false;
		
		if(1 == this.moneyMapper.insertSelective(application)){
			detail.setApplicationId(application.getId());
			if(1 == this.moneyDetailMapper.insertSelective(detail)){	
				result = customerMoneyMapper.updateByPrimaryKeySelective(app) == 1;
				//更新账户
				this.accountService.applyMoney(application.getAccountId(), application.getAmountMoney());
			}
		}
		return result;
	}
	
	
	public Boolean agentCashApplication(CashApplication application , CashDetail detail) {
		Boolean result = false;
		
		if(1 == this.cashMapper.insertSelective(application)){
			detail.setApplicationId(application.getId());
			if(1 == this.cashDetailMapper.insertSelective(detail)){			
				//更新账户
				result = this.accountService.applCash(application.getAccountId(), application.getAmountMoney());
			}
		}
		return result;
	}

	public MoneyApplication queryMoneyApp(Integer id) {
	    return this.moneyMapper.selectByPrimaryKey(id);
	}

	public CashApplication queryCashyApp(Integer id) {
		return this.cashMapper.selectByPrimaryKey(id);
	}

	public MoneyBalance queryMoneyBalance(Integer id) {
		return this.balanceMapper.selectByPrimaryKey(id);
	}
	public MoneyApplication selectByCustomerId(Integer id) {
		return this.moneyMapper.selectByCustomerId(id);
	}
	/**
	 * 佣金审核
	 * @param moneyApp
	 * @param moneyDetail
	 * @param balacne
	 * @return
	 */
	public Boolean moneyCheck(MoneyApplication moneyApp, MoneyDetail moneyDetail, MoneyBalance balacne,Integer pass) {
		//插入详情表
		//更新申请表
		//插入结算表
		Boolean result = false;
				
		if(1 == this.moneyDetailMapper.insertSelective(moneyDetail)){
			if(1 == this.moneyMapper.updateByPrimaryKeySelective(moneyApp)
					&& 1 == pass){	
				 result = balanceMapper.insertSelective(balacne) == 1;
			}else{
				 result = true;
			}
		}
		return result;

	}

	public Boolean cashCheck(CashApplication cashApp, CashDetail cashDetail ,CashBalance balance,Integer pass) {
		Boolean result = false;
		
		if(1 == this.cashDetailMapper.insertSelective(cashDetail)){
			if(1 == this.cashMapper.updateByPrimaryKeySelective(cashApp)
					&& 1 == pass){	
					result = cashBalanceMapper.insertSelective(balance) == 1;
				}else{
					result = true;
				}	
		}
		return result;
	}

	public List<MoneyApplication> queryAgentMoneyList(
			MoneyApplication application) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("money", application);

		return this.moneyMapper.selectMoneyApplication(parameters);
	}



}
