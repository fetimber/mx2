package net.huimin.yk.web.dao.money;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.huimin.yk.web.model.money.MoneyDetail;
@Repository
public interface MoneyDetailMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(MoneyDetail record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(MoneyDetail record);

    /**
     * 根据主键查询记录
     */
    MoneyDetail selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(MoneyDetail record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(MoneyDetail record);
    
    /**
     * 根据申请表信息查询详情结果
     */
    List<MoneyDetail> selectByApplicationId (Integer id);
}