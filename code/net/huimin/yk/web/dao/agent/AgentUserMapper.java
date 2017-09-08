package net.huimin.yk.web.dao.agent;

import java.util.List;

import net.huimin.yk.web.model.agent.AgentQueryParameter;
import net.huimin.yk.web.model.agent.AgentUser;

import org.springframework.stereotype.Repository;
@Repository
public interface AgentUserMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(AgentUser record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(AgentUser record);

    /**
     * 根据主键查询记录
     */
    AgentUser selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(AgentUser record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(AgentUser record);
    
    /**
     * 根据条件查询经纪人信息
     */
    AgentUser selectByConditions(AgentUser user);
    
    /**
     * 根据ACCOUNT_ID查询 经纪人信息
     * @param id
     * @return
     */
    AgentUser selectByAccontId(Integer id);
    
    /**
     * 根据推荐人ID查询
     * @param agentId
     * @return
     */
    List<AgentUser> selectByReferId(Integer agentId);
    
    /**
	 * 查询符合条件数据条数
	 * 
	 * @param query
	 * @return
	 */
	Integer queryCountByConditions(AgentQueryParameter query);
    
	/**
	 * 分页条件检索楼盘列表
	 * 
	 * @param query
	 * @return
	 */
	List<AgentUser> queryAgentByConditions(AgentQueryParameter query);
	
	/**
	 * 查询符合条件数据条数
	 * 
	 * @param query
	 * @return
	 */
	Integer querySuperiorCountByConditions(AgentQueryParameter query);
    
	/**
	 * 分页条件检索上线经纪人列表
	 * 
	 * @param query
	 * @return
	 */
	List<AgentUser> querySuperiorByConditions(AgentQueryParameter query);
	
	/**
	 * 查询符合条件数据条数
	 * 
	 * @param query
	 * @return
	 */
	Integer querySubordinateCountByConditions(AgentQueryParameter query);
    
	/**
	 * 分页条件检索下线经纪人列表
	 * 
	 * @param query
	 * @return
	 */
	List<AgentUser> querySubordinateByConditions(AgentQueryParameter query);
	
}