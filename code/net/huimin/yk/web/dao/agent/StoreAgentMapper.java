package net.huimin.yk.web.dao.agent;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import net.huimin.yk.web.model.agent.StoreAgent;
@Repository
public interface StoreAgentMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(StoreAgent record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(StoreAgent record);

    /**
     * 根据主键查询记录
     */
    StoreAgent selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(StoreAgent record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(StoreAgent record);
    
    /**
     * 查询列表
     * @param parameters
     * @return
     */
    List<StoreAgent> queryStoreAgentByConditions(Map<String, Object> parameters);
    
    /**
     * 查询数量
     * @param parameters
     * @return
     */
    Integer  queryCountByConditions(Map<String, Object> parameters);
    
    /**
     * 根据下线经纪人Id查询对应的上线记录
     * @param id
     * @return
     */
    List<StoreAgent> queryTopByAgentId(Integer id);
    
    /**
     * 根据上线经纪人Id查询对应的下线记录
     * @param id
     * @return
     */
    List<StoreAgent> queryBottomByStoreId(Integer id);
    
    /**
     * 根据下线经纪人ID查询邀请中的记录
     * @param id
     * @return
     */
    StoreAgent queryInviteByAgentId(Integer id);
    
    /**
     * 根据上线经纪人ID查询邀请中的记录
     * @param id
     * @return
     */
    List<StoreAgent> queryInviteByStoreId(Integer id);
    
    /**
     * 根据指定条件查询具体的上线下线关联信息
     * @param storeAgent
     * @return
     */
    StoreAgent queryStoreInfoByConditions(StoreAgent storeAgent);
    
    /**
     * 取消指定经纪人所有下线
     * @param id
     * @return
     */
    void concelAll(Integer id);
    

}