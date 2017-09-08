package net.huimin.yk.web.dao.system;

import java.util.List;

import net.huimin.yk.web.model.common.MenuInfo;
import net.huimin.yk.web.model.system.SysMenuRole;

import org.springframework.stereotype.Repository;
@Repository
public interface SysMenuRoleMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(SysMenuRole record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(SysMenuRole record);

    /**
     * 根据主键查询记录
     */
    SysMenuRole selectByPrimaryKey(Integer id);
    

    /**
     * 根据角色ID查询记录
     */
    List<MenuInfo> selectByRoleId(Integer roleId);

    
    /**
     * 根据角色ID查询禁止访问记录
     */
    List<MenuInfo> selectRefuseByRoleId(Integer roleId);
    
    
    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(SysMenuRole record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(SysMenuRole record);

	int deleteRole(Integer role);
}