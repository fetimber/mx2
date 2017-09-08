package net.huimin.common.helper;

import java.math.BigDecimal;
import java.util.Date;

import net.huimin.yk.web.model.agent.AccountRecord;
import net.huimin.yk.web.model.common.OperateRecord;
import net.huimin.yk.web.model.customer.CustomeRecord;
import net.huimin.yk.web.model.customer.CustomerMoney;
import net.huimin.yk.web.model.system.SysAccount;



public class EmptyBean {
	
	public static OperateRecord operateRecord(String content,
			String ip, Integer operateType , Integer userType ,Integer userId) {
		OperateRecord record = new OperateRecord();
		record.setUserType(userType);
		record.setOperateIp(ip);
		record.setOperateType(operateType);
		record.setOperateContent(content);
		record.setUserId(userId);
		record.setOperateTime(new Date());
		
		return record;
	}
	
    public static SysAccount sysAccount(){
    	SysAccount record = new SysAccount();
    	record.setPending(new BigDecimal(0));
    	record.setTotal(new BigDecimal(0));
    	record.setCash(new BigDecimal(0));
    	record.setHistory(new BigDecimal(0));
    	record.setUsable(new BigDecimal(0));
    	record.setCashing(new BigDecimal(0));
    	return record;
    }
    
    public static AccountRecord accountDetail(Integer accountId,BigDecimal amount,
    		Integer operatType , Integer reason ,String remark){
    	AccountRecord record = new AccountRecord();
    	record.setAccountId(accountId);
    	record.setAmount(amount);
    	record.setOperatType(operatType);
    	record.setReason(reason);
    	record.setRemark(remark);
    	record.setOperatTime(new Date());
    	return record;
    }
    
    public static CustomeRecord customerRecord(Integer operateType,Integer referId,Integer operateUserId,
    		Integer roleId,String remark){
    	
    	CustomeRecord record = new CustomeRecord();
		record.setOperateType(operateType);
		record.setOperateTime(new Date());
		record.setCustomerReferid(referId);
		record.setUserId(operateUserId);
		record.setUserType(roleId);
		record.setOperateContent(remark);
		return record;
    }
    
    
    public static CustomerMoney customerMoney(Integer moneyType,Date finishTime,String remark,
    		Integer accountId,BigDecimal amount ,Integer status ,Integer customerId){
    	CustomerMoney record = new CustomerMoney();
    	record.setMoneyType(moneyType);
    	record.setFinishTime(finishTime);
    	record.setRemark(remark);
    	record.setAccountId(accountId);
    	record.setAmount(amount);
    	record.setCreateTime(new Date());
    	record.setStatus(status);
    	record.setCustomerId(customerId);
    	return record;
    }
}
