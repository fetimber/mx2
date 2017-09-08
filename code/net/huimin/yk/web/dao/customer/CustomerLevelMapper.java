package net.huimin.yk.web.dao.customer;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.huimin.yk.web.model.customer.CustomerLevel;
@Repository
public interface CustomerLevelMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(CustomerLevel record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(CustomerLevel record);

    /**
     * 根据主键查询记录
     */
    CustomerLevel selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(CustomerLevel record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(CustomerLevel record);
    
    /**
     * 根据积分查询客户所属等级
     */
    CustomerLevel selectByScore(BigDecimal score);
    
    /**
     * 查询默认的等级
     */
    CustomerLevel selectDefLevel();
    
    /**
     * 查询等级列表
     */
    List<CustomerLevel> selectCustomerLevelist(CustomerLevel level);
    
}