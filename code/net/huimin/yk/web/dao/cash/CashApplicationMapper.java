package net.huimin.yk.web.dao.cash;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import net.huimin.yk.web.model.cash.CashApplication;
@Repository
public interface CashApplicationMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(CashApplication record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(CashApplication record);

    /**
     * 根据主键查询记录
     */
    CashApplication selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(CashApplication record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(CashApplication record);
    
    /**
     * 查询现金申请表
     * @param parameters
     * @return
     */
    List<CashApplication> selectCashApplication(Map<String, Object> parameters);
    
    /**
     * 查询现金申请表
     * @param parameters
     * @return
     */
    List<CashApplication> selectCashApplication2(Map<String, Object> parameters);
    
    /**
     * 查询现金申请表Count
     * @param parameters
     * @return
     */
    Integer selectCashApplicationCount(Map<String, Object> parameters);
}