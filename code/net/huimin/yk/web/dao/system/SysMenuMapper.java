package net.huimin.yk.web.dao.system;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import net.huimin.yk.web.model.system.SysMenu;
@Repository
public interface SysMenuMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(SysMenu record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(SysMenu record);

    /**
     * 根据主键查询记录
     */
    SysMenu selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(SysMenu record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(SysMenu record);

	int queryOperateRejecte(Map<String, Integer> paramter);

	List<SysMenu> queryAllMenus(Integer role);
}