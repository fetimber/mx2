package net.huimin.yk.web.dao.common;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.huimin.yk.web.model.common.City;
@Repository
public interface CityMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(City record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(City record);

    /**
     * 根据主键查询记录
     */
    City selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(City record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(City record);

	List<City> queryCityByProvince(Integer id);

	City queryCityByName(String name);
}