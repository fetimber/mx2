package net.huimin.yk.web.dao.common;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.huimin.yk.web.model.common.Area;
@Repository
public interface AreaMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(Area record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(Area record);

    /**
     * 根据主键查询记录
     */
    Area selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(Area record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(Area record);
    
    /**
     * 查询区域列表
     * @param record
     * @return
     */
    List<Area> selectAreaList(Area record);

    //查询全部
	List<Area> queryAllArea();

	Area queryAreaByName(String name);

	List<Area> queryAreaByCityId(Integer id);
}