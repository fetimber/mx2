package net.huimin.yk.web.dao.money;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import net.huimin.yk.web.model.money.MoneyApplication;
@Repository
public interface MoneyApplicationMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(MoneyApplication record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(MoneyApplication record);

    /**
     * 根据主键查询记录
     */
    MoneyApplication selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(MoneyApplication record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(MoneyApplication record);
    
    /**
     * 查询佣金申请表
     * @param parameters
     * @return
     */
    List<MoneyApplication> selectMoneyApplication(Map<String, Object> parameters);
    
    /**
     * 查询佣金申请表Count
     * @param parameters
     * @return
     */
    Integer selectMoneyApplicationCount(Map<String, Object> parameters);
    
    /**
     * 查询佣金申请表分页查询
     * @param parameters
     * @return
     */
    List<MoneyApplication> selectMoneyApplicationForPage(Map<String, Object> parameters);
    
    /**
     * 根据customer id查询
     * @param id
     * @return
     */
    MoneyApplication selectByCustomerId(Integer id);
}