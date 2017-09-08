package net.huimin.yk.web.dao.customer;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.huimin.yk.web.model.customer.CustomerChoice;
@Repository
public interface CustomerChoiceMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(CustomerChoice record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(CustomerChoice record);

    /**
     * 根据主键查询记录
     */
    CustomerChoice selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(CustomerChoice record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(CustomerChoice record);
    
    /**
     * 根据ruleId查询记录
     */
    List<CustomerChoice> selectByRuleId(Integer ruleId);
    
}