package net.huimin.yk.web.dao.sea;

import java.util.List;
import java.util.Map;

import net.huimin.yk.web.model.sea.SeaUnit;

import org.springframework.stereotype.Repository;
@Repository
public interface SeaUnitMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(SeaUnit record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(SeaUnit record);

    /**
     * 根据主键查询记录
     */
    SeaUnit selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(SeaUnit record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(SeaUnit record);
    
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
	List<SeaUnit> queryResultByConditions(Map<String, Object> parameters);
	
	int checkUnitName(SeaUnit unit);
	
    /**
     * 查询所有单位
     */
    List<SeaUnit> selectAllUnits(SeaUnit unit);
    
}