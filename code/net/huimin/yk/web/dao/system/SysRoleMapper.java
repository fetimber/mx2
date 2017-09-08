package net.huimin.yk.web.dao.system;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.huimin.yk.web.model.system.SysRole;
@Repository
public interface SysRoleMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    
    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(SysRole record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(SysRole record);

    /**
     * 根据主键查询记录
     */
    SysRole selectByPrimaryKey(Integer id);
    
    /**
     * 查询所有角色
     */
    List<SysRole> selectAllRoles(SysRole role);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(SysRole record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(SysRole record);
    
    
    SysRole selectRoleByName(String role);
    
    
}