package net.huimin.yk.web.dao.customer;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.huimin.yk.web.model.customer.CustomerRule;
@Repository
public interface CustomerRuleMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(CustomerRule record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(CustomerRule record);

    /**
     * 根据主键查询记录
     */
    CustomerRule selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(CustomerRule record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(CustomerRule record);
    
    /**
     * 根据条件查询所有等级规则
     */
    List<CustomerRule> selectAllRule(CustomerRule record);
}