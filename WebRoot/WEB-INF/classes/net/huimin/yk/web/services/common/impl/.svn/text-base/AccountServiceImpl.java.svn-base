package net.huimin.yk.web.services.common.impl;

import java.math.BigDecimal;
import java.util.List;

import net.huimin.common.cnst.Const;
import net.huimin.common.cnst.ConstConfig;
import net.huimin.common.helper.EmptyBean;
import net.huimin.common.helper.Judge;
import net.huimin.yk.web.dao.agent.AccountRecordMapper;
import net.huimin.yk.web.dao.common.ConfigMapper;
import net.huimin.yk.web.dao.customer.CustomerMoneyMapper;
import net.huimin.yk.web.dao.system.SysAccountMapper;
import net.huimin.yk.web.model.agent.AccountRecord;
import net.huimin.yk.web.model.common.Config;
import net.huimin.yk.web.model.customer.CustomerMoney;
import net.huimin.yk.web.model.system.SysAccount;
import net.huimin.yk.web.services.common.AccountService;
import net.huimin.yk.web.services.common.CommonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private SysAccountMapper accountMapper;
	@Autowired
	private AccountRecordMapper accountRecordMapper;
	@Autowired
	private CustomerMoneyMapper customerMoneyMapper;
	@Autowired
	private ConfigMapper configMapper;
	@Autowired
	private CommonService commonService;
	
	//推荐人获取金额
	private Integer referAmount = 0;
	
	//普通经纪人账户开户
	@Transactional
	public Integer openAccount() {
		//判断红包是否开启，随机抽范围内的红包数
		BigDecimal  redAmount =  new BigDecimal(randomAmount());
		
		//账户信息
		SysAccount account = EmptyBean.sysAccount();
		Integer  accountId = accountMapper.insertSelective(account);
		
		//账户明细
		if(1 == accountId){
			//新用户开户明细新增
			accountId = account.getId();
			
			Boolean redFlag = false;
			
			//判断活动是否开启
			if(new Integer(1).equals(Integer.parseInt(commonService.queryConfig(ConstConfig.OPEN_STATUS).getConfigKey()))){
				redFlag = true;			
			}
			
			AccountRecord  record  = null;
			if(redFlag){
				record = EmptyBean.accountDetail( accountId , redAmount ,
				    	Const.ACCOUNT_USABLE , 	Const.ACCOUNT_INCOME  , "经纪人注册送红包" );
				
				Integer account_detail = accountRecordMapper.insertSelective(record);	
				
				if(-1 != account_detail){
					CustomerMoney bean = EmptyBean.customerMoney(Const.MONEY_TYPE5, null, "经纪人注册送红包",
							accountId , redAmount , Const.CLICK_TYPE , null);
					//插入佣金申请结算表（红包类型的）
					customerMoneyMapper.insertSelective(bean);
		            
					//增加注册送红包佣金
					redMoney(accountId,redAmount);	
				}

			}

		}
		return accountId;
	}
	
	//专业经纪人注册时，给 推荐人送红包
	@Transactional
	public Boolean openRefferMoney(Integer referAccountId,Integer agentId) {
		//插入佣金申请结算表（推荐类型的）
		Boolean result = false;
		
		if(Judge.isNotNull(referAccountId)){	
			CustomerMoney queryBean = new CustomerMoney();
			queryBean.setAccountId(referAccountId);
			queryBean.setCustomerId(agentId);
			queryBean.setMoneyType(Const.MONEY_TYPE4);
			
			//是否获得过推荐奖励
			List<CustomerMoney>  resultList = this.customerMoneyMapper.selectByAccountId(queryBean);
			CustomerMoney bean = null;
			if(Judge.isNotNull(resultList) && resultList.size() > 0){
				bean = resultList.get(0);
				bean.setStatus(Const.CLICK_TYPE);	
				
				
				result = customerMoneyMapper.updateByPrimaryKeySelective(bean) == 1;
			}else{
				//查询推荐人红包金额
				referAmount = Integer.parseInt(commonService.queryConfig(ConstConfig.RED_REFER).getConfigKey());
				
				bean = EmptyBean.customerMoney(Const.MONEY_TYPE4, null, "推荐注册送红包",
						referAccountId , new BigDecimal(referAmount), Const.ABLE_TYPE , agentId);	
				
				result = customerMoneyMapper.insertSelective(bean) == 1;
			}	
		}
		
		return result ;
	}
	
	/**
	 * 申请结算佣金(经纪人结佣申请的账户变动)
	 */
	public Boolean  redMoney (Integer accountId,BigDecimal amount){
		Boolean flag = false;
		
		flag = updateAccount( -1 , amount, 
				Const.ACCOUNT_USABLE , Const.ACCOUNT_OUT , "经纪人注册红包");
		
		//增加可提现佣金
		flag = updateAccount(accountId , amount,
				Const.ACCOUNT_USABLE, Const.ACCOUNT_INCOME, "经纪人红包结佣申请");
		
		return flag;
	}
	
	
	
	/**
	 * 签约佣金(项目经理更改推荐客户状态为签约时的账户变动)
	 */
	public Boolean  signMoney (Integer accountId,BigDecimal amount){
		Boolean flag = false;
		
		//系统账户发放签约佣金
		flag = updateAccount( accountId , amount,
				Const.ACCOUNT_USABLE, Const.ACCOUNT_OUT , "签约佣金发放,扣除可结佣金");
		
		//增加可提现佣金
		flag = updateAccount(accountId , amount,
				Const.ACCOUNT_PENDING, Const.ACCOUNT_INCOME, "确认签约,签约佣金发放,增加可结佣金");
		
		return flag;
	}
	
	
	/**
	 * 领取结算奖励(经纪人结佣申请的账户变动)
	 */
	public Boolean  clickMoney (Integer accountId,BigDecimal amount,Integer moneyType){
		Boolean flag = false;

		flag = updateAccount( -1 , amount,
				Const.ACCOUNT_USABLE , Const.ACCOUNT_OUT , "经纪人申请奖励");
		
		//增加可提现佣金
		flag = updateAccount(accountId , amount,
				Const.ACCOUNT_USABLE, Const.ACCOUNT_INCOME, "经纪人申请奖励,增加可结算佣金");
		
		return flag;
	}
	

	
	/**
	 * 申请结算佣金(经纪人结佣申请的账户变动)
	 */
	public Boolean  applyMoney (Integer accountId,BigDecimal amount){
		Boolean flag = false;
		
		flag = updateAccount( accountId , amount, 
				Const.ACCOUNT_USABLE , Const.ACCOUNT_OUT , "经纪人结佣申请,扣除可结佣金");
		
		//增加可提现佣金
		flag = updateAccount(accountId , amount,
				Const.ACCOUNT_PENDING, Const.ACCOUNT_INCOME, "经纪人结佣申请,增加申请中的佣金");
		
		return flag;
	}
	
	
	/**
	 * 审核佣金 (账户变动)
	 */
	public Boolean  checkMoney (Integer accountId,BigDecimal amount1 , BigDecimal amount2){
		Boolean flag = false;
		
		flag = updateAccount( accountId , amount1,
				Const.ACCOUNT_PENDING , Const.ACCOUNT_OUT , "佣金结算通过,扣除申请结算佣金");
		
		//增加已结佣金
		flag = updateAccount(accountId , amount2,
				Const.ACCOUNT_TOTAL, Const.ACCOUNT_INCOME, "佣金结算通过,增加已结现金");
		
		//增加可提现佣金
		flag = updateAccount(accountId , amount2,
				Const.ACCOUNT_CASH, Const.ACCOUNT_INCOME, "佣金结算通过,增加可提现金");
		
		return flag;
	}
	
	
	/**
	 * 申请提现佣金(经纪人结佣申请的账户变动)
	 */
	public Boolean  applCash (Integer accountId,BigDecimal amount){
		Boolean flag = false;
		
		flag = updateAccount( accountId , amount,
				Const.ACCOUNT_CASH , Const.ACCOUNT_OUT , "经纪人提现申请,扣除可结佣金");
		
		//增加可提现佣金
		flag = updateAccount(accountId , amount,
				Const.ACCOUNT_CASHING , Const.ACCOUNT_INCOME, "经纪人提现申请,增加审核中现金");
		
		return flag;
	}
	
	/**
	 * 审核提现(账户变动)
	 */
	public Boolean  checkCash (Integer accountId , BigDecimal amount1 , BigDecimal amount2){
		Boolean flag = false;
		
		flag = updateAccount( accountId , amount1,
				Const.ACCOUNT_CASHING , Const.ACCOUNT_OUT , "提现结算通过,扣除申请提现现金");
		
		//增加可提现佣金
		flag =  updateAccount(accountId , amount2,
				Const.ACCOUNT_HISTORY, Const.ACCOUNT_INCOME, "佣金结算通过,增加已结现金");
		
		return flag;
	}
	
	
	
	/**
	 * 更新账户金额
	 * @param referAccountId
	 * @param amount
	 * @param operatType
	 * @param reason
	 * @param remark
	 * @return
	 */
	public Boolean updateAccount(Integer referAccountId,BigDecimal amount,
    		Integer operatType , Integer reason ,String remark) {
	    Boolean result = false;
		
	    SysAccount account = accountMapper.selectByPrimaryKey(referAccountId);
	    
	    if(null != account){	
	    	//新用户开户明细新增
			AccountRecord  record = EmptyBean.accountDetail(referAccountId , amount ,
					operatType , 	reason  , remark );
			
			if(operatType.equals(Const.ACCOUNT_USABLE)
					&& reason.equals(Const.ACCOUNT_OUT)){
				record.setAmount(account.getUsable());
			}
			
			Integer account_detail = accountRecordMapper.insertSelective(record);
			
			if(null != account_detail){
				
				//更新主账户数据
				account = dealAccountBean(operatType , reason, amount ,  account);
				
				if(operatType.equals(Const.ACCOUNT_USABLE)
						&& reason.equals(Const.ACCOUNT_OUT)){
					account.setUsable(new BigDecimal(0));
				}
				result = accountMapper.updateByPrimaryKeySelective(account) == 1;
			}
	    } 
	    return result;
	}
		
	
	/**
	 * 根据配置表数据 ，随机生成一个红包金额
	 */
	private Integer randomAmount(){
		Integer redAmount = 0;
		List<Config> configList = configMapper.selectBySearch(null);
		Integer maxAmount = -1;
		Integer minAmount = -1;
		Integer openStatus = -1;
		
		//获取配置状态
		for(Config config : configList){
			if(ConstConfig.OPEN_STATUS.equals(config.getGroupKey())){
				openStatus = Integer.parseInt(config.getConfigKey()); 				
			}else if(ConstConfig.RED_MAX.equals(config.getGroupKey())){
				maxAmount = Integer.parseInt(config.getConfigKey()); 				
			}else if(ConstConfig.RED_MIN.equals(config.getGroupKey())){
				minAmount = Integer.parseInt(config.getConfigKey()); 				
			}else if(ConstConfig.RED_REFER.equals(config.getGroupKey())){
				referAmount = Integer.parseInt(config.getConfigKey()); 				
			}
		}
		
		//红包开启
		if(Const.RED_OPEN.equals(openStatus)){
			redAmount = getRandomInt(minAmount,maxAmount);	
		}
		
		return redAmount; 
	}
	
	 /**
	 * 根据范围获取随机数
	 * @param a
	 * @param b
	 * @return
	 */
	 public static int getRandomInt(int a, int b) {  
	        if (a > b || a < 0)  
	            return -1;  
	        // 下面两种形式等价  
	        // return a + (int) (new Random().nextDouble() * (b - a + 1));  
	        return a + (int) (Math.random() * (b - a));  
	 } 
	 
	 /**
	  *  处理账户更新BEAN
	  * @param operatType
	  * @param reason
	  * @param amount
	  * @param account
	  * @return
	  */
	 private  SysAccount dealAccountBean(Integer operatType , 
			 Integer reason, BigDecimal amount , SysAccount account){
     	if(operatType.equals(Const.ACCOUNT_CASH)){
     		account.setCash(reason.equals(Const.ACCOUNT_INCOME) ? account.getCash().add(amount) : account.getCash().subtract(amount));
     	}else if(operatType.equals(Const.ACCOUNT_CASHING)){
     		account.setCashing(reason.equals(Const.ACCOUNT_INCOME) ? account.getCashing().add(amount) : account.getCashing().subtract(amount));
     	}else if(operatType.equals(Const.ACCOUNT_PENDING)){
     		account.setPending(reason.equals(Const.ACCOUNT_INCOME) ? account.getPending().add(amount) : account.getPending().subtract(amount));
     	}else if(operatType.equals(Const.ACCOUNT_TOTAL)){
     		account.setTotal(reason.equals(Const.ACCOUNT_INCOME) ? account.getTotal().add(amount) : account.getTotal().subtract(amount));
     	}else if(operatType.equals(Const.ACCOUNT_USABLE)){
     		account.setUsable(reason.equals(Const.ACCOUNT_INCOME) ? account.getUsable().add(amount) : account.getUsable().subtract(amount));
     	} else if(operatType.equals(Const.ACCOUNT_HISTORY)){
     		account.setHistory(reason.equals(Const.ACCOUNT_INCOME) ? account.getHistory().add(amount) : account.getHistory().subtract(amount));
     	}                	

		return account;
	 }

	public SysAccount queryAccountById(Integer id) {
		return this.accountMapper.selectByPrimaryKey(id);
	}
	

	
}
