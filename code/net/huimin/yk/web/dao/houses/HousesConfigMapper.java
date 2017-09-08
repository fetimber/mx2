package net.huimin.yk.web.dao.houses;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.huimin.yk.web.model.houses.HousesConfig;
@Repository
public interface HousesConfigMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(HousesConfig record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(HousesConfig record);

    /**
     * 根据主键查询记录
     */
    HousesConfig selectByPrimaryKey(Integer id);
    
    /**
     * 根据楼盘id查询配套信息
     */
    List<HousesConfig> selectByPid(Integer pid);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(HousesConfig record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(HousesConfig record);
}