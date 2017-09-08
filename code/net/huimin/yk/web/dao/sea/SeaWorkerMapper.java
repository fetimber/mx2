package net.huimin.yk.web.dao.sea;

import java.util.List;
import java.util.Map;

import net.huimin.yk.web.model.sea.SeaWorker;

import org.springframework.stereotype.Repository;
@Repository
public interface SeaWorkerMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(SeaWorker record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(SeaWorker record);

    /**
     * 根据主键查询记录
     */
    SeaWorker selectByPrimaryKey(Integer id);

    SeaWorker queryWorkerByIdNumber(SeaWorker worker);
    
    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(SeaWorker record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(SeaWorker record);
    
    /**
	 * 查询符合条件数据条数
	 * 
	 * @param parameters
	 * @return
	 */
	Integer queryCountByConditions(Map<String, Object> parameters);

	/**
	 * 分页条件检索列表
	 * 
	 * @param parameters
	 * @return
	 */
	List<SeaWorker> queryResultByConditions(Map<String, Object> parameters);
	
    /**
     * 查询所有职工
     */
    List<SeaWorker> selectAllWorkerByUnitId(SeaWorker worker);
    
    int checkIdCard(SeaWorker worker);
    
}