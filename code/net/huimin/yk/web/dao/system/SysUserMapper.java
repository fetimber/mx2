package net.huimin.yk.web.dao.system;

import java.util.List;
import java.util.Map;

import net.huimin.yk.web.model.system.SysUser;

import org.springframework.stereotype.Repository;
@Repository
public interface SysUserMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(SysUser record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(SysUser record);

    /**
     * 根据主键查询记录
     */
    SysUser selectByPrimaryKey(Integer id);

    /**
     * 查询可作为团队队长的CALL客
     * @param record
     * @return
     */
    List<SysUser> selectLeader(SysUser record);
    
    /**
     * 查询可做为团队成员的
     * @param record
     * @return
     */
    List<SysUser> selectTeamUser(SysUser record);
    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(SysUser record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(SysUser record);
    
    /**
     * 查询用户根据登录名
     * @param sysUser
     * @return
     */
    SysUser selectUserByName(SysUser sysUser);
    

    /**
     * 查询数量
     * @param parameters
     * @return
     */
    Integer  queryCountByConditions(Map<String, Object> parameters);
    
    /**
     * 根据条件查询
     * @param parameters
     * @return
     */
    List<SysUser> queryUsersByConditions(Map<String, Object> parameters);

    /**
     * 查询PM
     * @return
     */
	List<SysUser> queryAllProjectManager();

	SysUser queryUserByOpenId(String openId);
	
	int checkLoginName(SysUser sysUser);
}