package net.huimin.yk.web.dao.call;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import net.huimin.yk.web.model.call.CallUser;
@Repository
public interface CallUserMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(CallUser record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(CallUser record);

    /**
     * 根据主键查询记录
     */
    CallUser selectByPrimaryKey(Integer id);
    
    /**
     * 根据USER_ID查询
     * @param id
     * @return
     */
    CallUser selectByUserId(Integer id);
    
    /**
     * 根据团队ID 查询Call客列表
     * @return
     */
    List<CallUser> queryCallUserByTeamId(CallUser record);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(CallUser record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(CallUser record);
    
    Integer queryCountByConditions(Map<String, Object> parameters);

	List<CallUser> queryUsersByTeamId(Map<String, Object> parameters);
}