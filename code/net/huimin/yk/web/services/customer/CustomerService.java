package net.huimin.yk.web.services.customer;

import java.util.Date;
import java.util.List;

import net.huimin.common.page.PageBean;
import net.huimin.yk.web.model.agent.StoreAgent;
import net.huimin.yk.web.model.customer.CustomeRecord;
import net.huimin.yk.web.model.customer.CustomerApplication;
import net.huimin.yk.web.model.customer.CustomerLevel;
import net.huimin.yk.web.model.customer.CustomerMoney;
import net.huimin.yk.web.model.customer.CustomerQueryParameter;

public interface CustomerService {
   
   /**
	* 查询客户最后跟进时间
	* @return
	*/
   Date selectFollowTime();
   
   /**
    * 更新客户信息
    * @param customer
    * @return
    */
   Boolean customerUpdate(CustomerApplication customer);
   
   /**
    * 查询客户信息
    * @param id
    * @return
    */
   public CustomerApplication selectCustomerApp(Integer id);
   /**
    * 查询客户列表
    * @param page
    * @param customerApplication
    */
   public  void queryCustomerListForPage(PageBean page, CustomerApplication customerApplication);

   /**
    * 根据申请ID查询详细信息
    * @param customer
    * @return
    */
   public  CustomerApplication  queryCustomer (CustomerApplication customer);
   
	/**
	 * 跟踪客户状态
	 * @param customer
	 * @param record
	 * @return
	 */
	public  Boolean  trackCustomer (CustomerApplication customer , CustomeRecord record);
	
	/**
	 * 处理用户申诉
	 * @return
	 */
	public Boolean appealCustomer (CustomerApplication customer , CustomeRecord record);
	/**
	 * 查询客户等级列表
	 * @param level
	 * @return
	 */
	public List<CustomerLevel> queryCustomerLeveList(CustomerLevel level);
	
	/**
	 * 查询经纪人可结佣金列表
	 * @param page
	 * @param application
	 */
	public void queryAgentBrokerage(PageBean page, CustomerApplication application);
	
	public void queryCustomerForPage(PageBean page, CustomerQueryParameter param);
	
	/**
	 * 查询经纪人可结佣金列表
	 * @param page
	 * @param application
	 */
	public List<CustomerApplication> queryAgentBrokerageList (CustomerApplication application);
	
	/**
	 * 查询未分配客户列表
	 * @param application
	 * @return
	 */
	public  List<CustomerApplication> queryUndealCustomerList(CustomerApplication application);
	
	/**
	 * 查询经纪人可结佣金
	 * @param accountId
	 * @return
	 */
	public List <CustomerMoney> queryCustomerMoney(CustomerMoney record);
	
	/**
	 * 更新申请表中的状态（其他类型结佣数据）
	 * @param regList
	 * @return
	 */
	public Boolean updateCustomerMoney(List <CustomerMoney> regList);
	
	/**
	 * 
	 * @param record
	 * @return
	 */
	public  Boolean  insertOrupdateCustomerMoney (CustomerMoney record);
	
	/**
	 * 查询经纪人当日推荐客户数量
	 * @param agentId
	 */
	public Integer queryDayCustomerCount(Integer agentId);
	
	/**
	 * 
	 * @param record
	 * @return
	 */
	public Boolean insertOrUpdateCustomeRecord(CustomeRecord record);
	
	public Boolean updateCustomerApplication(CustomerApplication customer);
	
	/**
	 * 查询门店经纪人列表
	 * @param page
	 * @param storeAgent
	 */
	public void queryStoreAgentForPage(PageBean page, StoreAgent storeAgent);
}
