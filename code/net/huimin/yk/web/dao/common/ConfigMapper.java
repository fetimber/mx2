package net.huimin.yk.web.dao.common;

import java.util.List;

import net.huimin.yk.web.model.common.AgentInfo;
import net.huimin.yk.web.model.common.Config;
import net.huimin.yk.web.model.common.CustomerInfo;
import net.huimin.yk.web.model.common.MainInfo;
import net.huimin.yk.web.model.sea.SeaQueryParameter;

import org.springframework.stereotype.Repository;
@Repository
public interface ConfigMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(Config record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(Config record);

    /**
     * 根据主键查询记录
     */
    Config selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(Config record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(Config record);
    
    
    /**
     * 根据GROUP_key更新属性不为空的记录
     */
    int updateByGroupKeySelective(Config record);
    /**
     * 
     * 根据条件查询
     * @param record
     * @return
     */
    List<Config> selectBySearch(Config record);
    
    /**
     * 查询主页统计信息
     * @return
     */
    MainInfo selectMenuInfo(SeaQueryParameter query);
    
    /**
     * 获取提现排名前10的经纪人
     * @return
     */
    List<AgentInfo> selectAgentIop10(Integer id);
    
    /**
     * 获取统计数据
     * @return
     */
    CustomerInfo selectCustomerInfoByAgentId(Integer id);
}