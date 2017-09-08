
package net.huimin.yk.web.actions.admin;

import java.util.Date;

import net.huimin.common.cnst.Const;
import net.huimin.common.helper.Judge;
import net.huimin.common.mvc.AbstractAction;
import net.huimin.yk.web.model.cash.CashApplication;
import net.huimin.yk.web.model.cash.CashBalance;
import net.huimin.yk.web.model.cash.CashDetail;
import net.huimin.yk.web.model.money.MoneyApplication;
import net.huimin.yk.web.model.money.MoneyBalance;
import net.huimin.yk.web.model.money.MoneyDetail;
import net.huimin.yk.web.services.common.AccountService;
import net.huimin.yk.web.services.finace.FinaceService;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 财务管理
 * @author Administrator
 *
 */
public class FinaceAction extends AbstractAction{
  
	@Autowired
	private FinaceService finaceService;
	
	@Autowired
	private AccountService accountService;
	
	private MoneyApplication moneyApp;
	
	private CashApplication cashApp;
	
    //查询条件
	private Integer status;

    private Date startime;
    
    private Date endtime;
    
    private String keyword;
	
	private Integer tab = 0;
	
	private Integer pass;
	
	private Integer flag;
	
	public String view(){
//		this.getPage().setOffset(10);
//		this.getPage().setStart((this.getPage().getCurrent() -1 ) * this.getPage().getOffset());
		
		//默认显示待结佣审核的数据
		if(tab == 0){
			MoneyApplication application = new MoneyApplication();
			if(Judge.isNotNull(status) && -1 != status){
				    application.setResultStatus(status);
			}else{
				   application.setResultStatus(Const.MONEY_STATUS_ING);
			}	
			finaceService.queryAgentMoneyListForPage(this.getPage(), application , startime , endtime , keyword );
		}
		//默认显示待提现审核的数据
		else if(tab == 1){
			CashApplication application = new CashApplication();
			if(Judge.isNotNull(status) && -1 != status){
			    application.setResultStatus(status);
			}else{
				application.setResultStatus(Const.MONEY_STATUS_ING);
			}
			finaceService.queryAgentCashApplicationForPage(this.getPage(), application , startime , endtime , keyword);
		}
		
		//全部佣金
		else if(tab == 2){
			finaceService.queryAgentMoneyListForPage(this.getPage(), null , startime , endtime , keyword);	
		}
		//全部现金
		else if(tab == 3){	
			finaceService.queryAgentCashApplicationForPage(this.getPage(), null  ,startime , endtime , keyword);
		}
		
		return "view";
	}
	
	
	public String money(){
		Boolean result = false;
		if(Judge.isNotNull(moneyApp)){
			moneyApp = finaceService.queryMoneyApp(moneyApp.getId());
			moneyApp.setFlag(flag);
			result = true;
		}

		return result ?  "money-check" : this.view();
	}
	
	
	public String cash(){
		Boolean result = false;
		if(Judge.isNotNull(cashApp)){
			cashApp = finaceService.queryCashyApp(cashApp.getId());
			cashApp.setFlag(flag);
			result = true;
		}
	
		return result ?  "cash-check" : this.view();
	}
	

	
	/**
	 * 佣金申请审核
	 * @returnA
	 */
	public String moneycheck(){
		Boolean result = false;
		if(Judge.isNotNull(moneyApp) 
				&& Judge.isNotNull(moneyApp.getId())
				&& Judge.isNotNull(pass)){	
			//现有数据
			MoneyApplication moneyNewBean = finaceService.queryMoneyApp(moneyApp.getId());
			
			moneyApp.setFinishTime(new Date());
			if(1 == pass){
				moneyApp.setResultStatus(Const.MONEY_STATUS_PASS);
			}else{
				moneyApp.setResultStatus(Const.MONEY_STATUS_NO);
			}
		
			MoneyDetail moneyDetail = new MoneyDetail();
			moneyDetail.setApplicationId(moneyApp.getId());
			moneyDetail.setOperaterId(this.logined(false).getId());
			moneyDetail.setOperaterTime(new Date());
			moneyDetail.setResult(moneyApp.getRemark());
			
			MoneyBalance balance = new MoneyBalance();
			balance.setAccountId(moneyNewBean.getAccountId());
            //修改为结算金额
			balance.setAmountMoney(moneyNewBean.getAmountMoney());
			balance.setApplicationTime(moneyNewBean.getApplicationTime());
			balance.setApplicationId(moneyApp.getId());
			
			balance.setFinalMoney(moneyApp.getFinalMoney());
			balance.setFinishTime(new Date());
			balance.setOperaterId(this.logined(false).getId());
			balance.setRemark(moneyApp.getRemark());
   
			result = this.finaceService.moneyCheck(moneyApp,moneyDetail,balance,pass);
			
			if(result && 1 == pass){
				//扣除可结算佣金
				accountService.checkMoney(moneyNewBean.getAccountId() , moneyNewBean.getAmountMoney(), balance.getFinalMoney());
				this.moneyApp = null;	
			} 
		}
		
		this.pushRequest("result", result);
		this.pushRequest("success_url", "admin/finace!view");
		this.pushRequest("success_name", "查看财务列表");
		return "operate-result";

	}
	
	/**
	 * 现金申请审核
	 * @return
	 */
	public String cashcheck(){
		Boolean result = false;
		if(Judge.isNotNull(cashApp) 
				&& Judge.isNotNull(cashApp.getId())
				&& Judge.isNotNull(pass)){	
			//现有数据
			CashApplication cashNewBean = finaceService.queryCashyApp(cashApp.getId());
			
			cashApp.setFinishTime(new Date());
			if(1 == pass){
				cashApp.setResultStatus(Const.MONEY_STATUS_PASS);
			}else{
				cashApp.setResultStatus(Const.MONEY_STATUS_NO);
			}
		
			CashDetail cashDetail = new CashDetail();
			cashDetail.setApplicationId(cashApp.getId());
			cashDetail.setOperaterId(this.logined(false).getId());
			cashDetail.setOperaterTime(new Date());
			cashDetail.setResult(cashApp.getRemark());
			
			CashBalance balance = new CashBalance();
			balance.setAccountId(cashNewBean.getAccountId());
			balance.setAmountMoney(cashNewBean.getAmountMoney());
			balance.setApplicationTime(cashNewBean.getApplicationTime());
			balance.setApplicationId(cashApp.getId());
			balance.setFinalMoney(cashApp.getFinalMoney());
			balance.setFinishTime(new Date());
			balance.setOperaterId(this.logined(false).getId());
			balance.setRemark(cashApp.getRemark());
			balance.setFinalMoney(cashApp.getFinalMoney());
   
			result = this.finaceService.cashCheck(cashApp , cashDetail , balance, pass);
			
			if(result && 1 == pass){
				//扣除可结算佣金
			    accountService.checkCash(cashNewBean.getAccountId() , cashNewBean.getAmountMoney() , balance.getFinalMoney());
				this.moneyApp = null;
			} 
		}
	
		this.pushRequest("result", result);
		this.pushRequest("success_url", "admin/finace!view");
		this.pushRequest("success_name", "查看财务列表");
		return "operate-result";
	}
	

	public MoneyApplication getMoneyApp() {
		return moneyApp;
	}


	public void setMoneyApp(MoneyApplication moneyApp) {
		this.moneyApp = moneyApp;
	}


	public CashApplication getCashApp() {
		return cashApp;
	}


	public void setCashApp(CashApplication cashApp) {
		this.cashApp = cashApp;
	}


	public Integer getTab() {
		return tab;
	}


	public void setTab(Integer tab) {
		this.tab = tab;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public Date getStartime() {
		return startime;
	}


	public void setStartime(Date startime) {
		this.startime = startime;
	}


	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}


	public Integer getPass() {
		return pass;
	}


	public void setPass(Integer pass) {
		this.pass = pass;
	}


	public Integer getFlag() {
		return flag;
	}


	public void setFlag(Integer flag) {
		this.flag = flag;
	}


	public String getKeyword() {
		return keyword;
	}


	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
