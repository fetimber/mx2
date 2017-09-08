package net.huimin.yk.web.dao.customer;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.huimin.yk.web.model.customer.CustomerMoney;
@Repository
public interface CustomerMoneyMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(CustomerMoney record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(CustomerMoney record);

    /**
     * 根据主键查询记录
     */
    CustomerMoney selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(CustomerMoney record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(CustomerMoney record);
    
    /**
     * 
     * @return
     */
    List<CustomerMoney> selectByAccountId(CustomerMoney record);
    
   
}