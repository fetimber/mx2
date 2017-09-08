package net.huimin.yk.web.services.customer.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.huimin.common.cnst.Const;
import net.huimin.common.helper.EmptyBean;
import net.huimin.common.helper.Judge;
import net.huimin.common.page.PageBean;
import net.huimin.yk.web.dao.agent.StoreAgentMapper;
import net.huimin.yk.web.dao.customer.CustomeRecordMapper;
import net.huimin.yk.web.dao.customer.CustomerApplicationMapper;
import net.huimin.yk.web.dao.customer.CustomerLevelMapper;
import net.huimin.yk.web.dao.customer.CustomerMoneyMapper;
import net.huimin.yk.web.model.agent.StoreAgent;
import net.huimin.yk.web.model.customer.CustomeRecord;
import net.huimin.yk.web.model.customer.CustomerApplication;
import net.huimin.yk.web.model.customer.CustomerLevel;
import net.huimin.yk.web.model.customer.CustomerMoney;
import net.huimin.yk.web.model.customer.CustomerQueryParameter;
import net.huimin.yk.web.services.customer.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService,Const {
	
	@Autowired
	private CustomerApplicationMapper customerApplicationMapper;

	@Autowired
	private CustomeRecordMapper  customeRecordMapper;
	
	@Autowired
	private CustomerLevelMapper customerLevelMapper;
	
	@Autowired
	private CustomerMoneyMapper customerMoney;

	@Autowired
	private CustomerMoneyMapper customerMoneyMapper;
	
	@Autowired
	private StoreAgentMapper storeAgentMapper;
	
	public Date selectFollowTime() {
		return null;
	}

	public CustomerApplication selectCustomerApp(Integer id){
		return this.customerApplicationMapper.selectByPrimaryKey(id);	
	}
	
	public Boolean customerUpdate(CustomerApplication customer) {	
		String isLooked = customer.getIsLooked();
		String isArrived = customer.getIsArrived();
		
		Boolean  result = customerApplicationMapper.updateByPrimaryKeySelective(customer) == 1;
	
		if(result){
			customer = customerApplicationMapper.selectByPrimaryKey(customer.getId());			
			CustomerMoney record = null;
			
			//到访奖 带看奖插入
			if(customer.getCustomerStatus().equals(Const.CUSTTOMER_STATUS_FOUR)){
				
				Boolean flag = false;
				//亲自带看奖
				if(Judge.isNotNull(isLooked) 
						  && isLooked.equals("on")
						  && Judge.isNotNull(customer.getHouseInfo().getViewReward())
						  && customer.getHouseInfo().getViewReward().compareTo(new BigDecimal(0)) > 0){

						record = EmptyBean.customerMoney(Const.MONEY_TYPE3, null, "带看奖励", customer.getAgentInfo().getAccountId(), customer.getHouseInfo().getViewReward(), Const.ABLE_TYPE,  customer.getId());
						customer.setLookStatus(1);
						flag = true;
				}
				//首次到访奖 
				else if (Judge.isNotNull(isArrived)
						  && isArrived.equals("on")
						  && Judge.isNotNull(customer.getHouseInfo().getFirstReward())
						  && customer.getHouseInfo().getFirstReward().compareTo(new BigDecimal(0)) > 0
						  && !flag){
					  record = EmptyBean.customerMoney(Const.MONEY_TYPE2, null, "到访奖励", customer.getAgentInfo().getAccountId(), customer.getHouseInfo().getFirstReward(), Const.ABLE_TYPE,  customer.getId());
					  customer.setArrivedStatus(1);	
				}	
			}
			//签约
			else if (customer.getCustomerStatus().equals(Const.CUSTTOMER_STATUS_SIX)){
				record = EmptyBean.customerMoney(Const.MONEY_TYPE1, null, "签约奖励", customer.getAgentInfo().getAccountId(), 
						customer.getHousePrice().multiply(new BigDecimal(customer.getHouseCount())), Const.ABLE_TYPE, customer.getId());
				customer.setMoneyStatus(1);
			}
			if(Judge.isNotNull(customer)){
				result = customerApplicationMapper.updateByPrimaryKeySelective(customer) == 1;
			}
				
			if(Judge.isNotNull(record)){
				result = customerMoneyMapper.insertSelective(record) == 1;
			}
			
		}
		
		return result;
	}

	public List<CustomerLevel> queryCustomerLeveList(CustomerLevel level)	{	
      return this.customerLevelMapper.selectCustomerLevelist(level);	
	}

	public  void queryCustomerListForPage(PageBean page, CustomerApplication customerApplication){
		page.getParameters().put("_page", page);
		page.getParameters().put("customer", customerApplication);
		
		Integer count = this.customerApplicationMapper.queryCountListByConditions(page.getParameters());
		List<CustomerApplication> customers = this.customerApplicationMapper.queryCustomerListByConditions(page.getParameters());
		
		PageBean.Counter(page, count, null, customers);	
	}
	

	public void queryCustomerForPage(PageBean page, CustomerQueryParameter param) {
		page.getParameters().put("param", param);
		page.getParameters().put("start", page.getStart());
		page.getParameters().put("offset", page.getOffset());
		
		Integer count = this.customerApplicationMapper.queryCountByConditions(page.getParameters());
		List<CustomerApplication> customers = this.customerApplicationMapper.queryCustomerByConditions(page.getParameters());
		
		PageBean.Counter(page, count, null, customers);
	}
	@Transactional
	public Boolean trackCustomer(CustomerApplication customer,
			CustomeRecord record) {
		Boolean result = false;
		if(Judge.isNotNull(record)){
			if(customeRecordMapper.insertSelective(record) == 1
					&& Judge.isNotNull(record.getId())){
				result = customerApplicationMapper.updateByPrimaryKeySelective(customer) == 1;	
			}
		}	
		return result;
	}

	public CustomerApplication queryCustomer(CustomerApplication customer) {
		return this.customerApplicationMapper.selectByPrimaryKey(customer.getId());
	}
	
	
	/**
	 * 查看经纪人可结佣金列表(佣金)
	 * @return
	 */
	public void queryAgentBrokerage(PageBean page, CustomerApplication application) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("_page", page);
		parameters.put("customer", application);
	     
		Integer count = this.customerApplicationMapper.
				selectAgentBrokerageCount(parameters);
			List<CustomerApplication> customers = this.customerApplicationMapper
					.selectAgentBrokerage(parameters);

	    PageBean.Counter(page, count, null, customers);	
	}
	
	/**
	 * 
	 * @return
	 */
	public  List <CustomerMoney> queryCustomerMoney(CustomerMoney record){
		 return  this.customerMoney.selectByAccountId(record);
	}
	

     /**
      * 处理用户申诉
      */
	public Boolean appealCustomer(CustomerApplication customer,
			CustomeRecord record) {
        Boolean result = false;
		
		if(customeRecordMapper.insertSelective(record) == 1
				&& Judge.isNotNull(record.getId())){
			result = customerApplicationMapper.updateByPrimaryKeySelective(customer) == 1;
		}
				
		return result;
	}

	public Boolean updateCustomerApplication(CustomerApplication customer){	
		return customerApplicationMapper.updateByPrimaryKeySelective(customer) == 1;
		
	}
	
	/**
	 * 查询未分配的成员列表
	 */
	public List<CustomerApplication> queryUndealCustomerList(
			CustomerApplication application) {
		return customerApplicationMapper.queryUndealCustomerList(application);
	}

	public List<CustomerApplication> queryAgentBrokerageList(
			CustomerApplication application) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("customer", application);
	     
		List<CustomerApplication> customers = this.customerApplicationMapper
					.selectAgentBrokerage(parameters);
			
		return  customers;
	}

	public Boolean updateCustomerMoney(List<CustomerMoney> regList) {
		Boolean result = false; 
		
		for(int i = 0 ; i < regList.size() ; i ++){
			result = this.customerMoney.updateByPrimaryKeySelective(regList.get(i)) == 1;
		}
		
		return result;
	}

	/**
	 * 
	 * @param record
	 * @return
	 */
	public  Boolean  insertOrupdateCustomerMoney (CustomerMoney record){
		if(Judge.isNotNull(record.getId())){
			return customerMoneyMapper.updateByPrimaryKeySelective(record) == 1;
		}else{
			return customerMoneyMapper.insertSelective(record) == 1;
		}
	}

	public Integer queryDayCustomerCount(Integer agentId) {
		return customerApplicationMapper.queryDayCustomerCount(agentId);
	}

	public Boolean insertOrUpdateCustomeRecord(CustomeRecord record) {
		if(Judge.isNotNull(record.getId())){
			return customeRecordMapper.updateByPrimaryKeySelective(record) == 1;
		}else{
			return customeRecordMapper.insertSelective(record) == 1;
		}	
	}

	public void queryStoreAgentForPage(PageBean page, StoreAgent storeAgent) {
		page.getParameters().put("_page", page);
		page.getParameters().put("customer", storeAgent);
		
		Integer count = this.storeAgentMapper.queryCountByConditions(page.getParameters());
		List <StoreAgent> list = this.storeAgentMapper.queryStoreAgentByConditions(page.getParameters());
		
		PageBean.Counter(page, count, null, list);	
	}
	
}
