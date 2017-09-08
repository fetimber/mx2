package net.huimin.yk.web.dao.customer;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import net.huimin.yk.web.model.customer.CustomerApplication;
@Repository
public interface CustomerApplicationMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(CustomerApplication record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(CustomerApplication record);

    /**
     * 根据主键查询记录
     */
    CustomerApplication selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(CustomerApplication record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(CustomerApplication record);
    
    List<CustomerApplication> selectByConditions(CustomerApplication record);
    
    /**
    * 查询数量
    * @param parameters
    * @return
    */
    Integer  selectAgentBrokerageCount (Map<String, Object> parameters);
    
    /**
     * 查询列表
     * @param parameters
     * @return
     */
    List<CustomerApplication> selectAgentBrokerage(Map<String, Object> parameters);
    
    /**
     * 查询数量
     * @param customer
     * @return
     */
    Integer  queryCountByConditions(Map<String, Object> map);
    
    /**
     * 根据条件查询
     * @param customer
     * @return
     */
    List<CustomerApplication> queryCustomerByConditions(Map<String, Object> map);
    
    List<CustomerApplication> queryUndealCustomerList(CustomerApplication record);
    
    List<CustomerApplication> queryLeaderCustomerList(CustomerApplication record);
    /**
     * 查询数量
     * @param customer
     * @return
     */
    Integer  queryCountListByConditions(Map<String, Object> map);
    
    
    /**
     * 根据条件查询
     * @param customer
     * @return
     */
    List<CustomerApplication> queryCustomerListByConditions(Map<String, Object> map);
    
    /**
     * 根据经纪人的ID查询当日推荐的客户数
     * @param id
     * @return
     */
    Integer queryDayCustomerCount(Integer id);
    
}