package net.huimin.yk.web.dao.houses;

import org.springframework.stereotype.Repository;

import net.huimin.yk.web.model.houses.HousesType;
@Repository
public interface HousesTypeMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(HousesType record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(HousesType record);

    /**
     * 根据主键查询记录
     */
    HousesType selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(HousesType record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(HousesType record);
}