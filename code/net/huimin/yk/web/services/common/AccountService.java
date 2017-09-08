package net.huimin.yk.web.services.common;

import java.math.BigDecimal;

import net.huimin.yk.web.model.system.SysAccount;

public interface AccountService {
 
	public Integer openAccount();
	
	public Boolean openRefferMoney (Integer referAccountId,Integer agentId);
	
	public Boolean  clickMoney (Integer accountId,BigDecimal amount,Integer moneyType);
	
	public Boolean  signMoney (Integer accountId,BigDecimal amount);
	
	public Boolean  applCash (Integer accountId,BigDecimal amount);
	
	public Boolean  applyMoney(Integer accountId,BigDecimal amount);
	
	public Boolean  checkMoney (Integer accountId,BigDecimal amount1, BigDecimal amount2);
	
    public Boolean  checkCash (Integer accountId , BigDecimal amount1 , BigDecimal amount2);
	
	public Boolean updateAccount(Integer referAccountId,BigDecimal amount,
	    		Integer operatType , Integer reason ,String remark);
	
	public SysAccount queryAccountById(Integer id);
}
