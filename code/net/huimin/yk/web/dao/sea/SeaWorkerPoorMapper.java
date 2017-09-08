package net.huimin.yk.web.dao.sea;

import java.util.List;

import net.huimin.yk.web.model.sea.SeaQueryParameter;
import net.huimin.yk.web.model.sea.SeaWorkerPoor;

import org.springframework.stereotype.Repository;
@Repository
public interface SeaWorkerPoorMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(SeaWorkerPoor record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(SeaWorkerPoor record);

    /**
     * 根据主键查询记录
     */
    SeaWorkerPoor selectByPrimaryKey(Integer id);
    
    SeaWorkerPoor selectByWorkerId(Integer workerId);
    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(SeaWorkerPoor record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(SeaWorkerPoor record);
    
    /**
	 * 查询符合条件数据条数
	 * 
	 * @param parameters
	 * @return
	 */
	Integer queryCountByConditions(SeaQueryParameter query);

	/**
	 * 分页条件检索列表
	 * 
	 * @param parameters
	 * @return
	 */
	List<SeaWorkerPoor> queryResultByConditions(SeaQueryParameter query);
}