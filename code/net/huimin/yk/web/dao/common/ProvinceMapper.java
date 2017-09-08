package net.huimin.yk.web.dao.common;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.huimin.yk.web.model.common.Province;
@Repository
public interface ProvinceMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(Province record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(Province record);

    /**
     * 根据主键查询记录
     */
    Province selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(Province record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(Province record);

	List<Province> queryAllProvinces();

	Province queryProvinceByName(String name);
}