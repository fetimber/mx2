package net.huimin.yk.web.dao.bq;

import java.util.List;
import java.util.Map;

import net.huimin.yk.web.model.bq.FloorRoom;
import net.huimin.yk.web.model.bq.RoomCheckinfo;

import org.springframework.stereotype.Repository;

@Repository
public interface RoomCheckinfoMapper {

	 /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(RoomCheckinfo room);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(RoomCheckinfo room);

    /**
     * 根据主键查询记录
     */
    RoomCheckinfo selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(RoomCheckinfo room);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(RoomCheckinfo record);
    
    
    /**
  	 * 查询符合条件数据条数
  	 * 
  	 * @param parameters
  	 * @return
  	 */
  	Integer queryCountByConditions(Map<String, Object> parameters);

  	/**
  	 * 分页条件检索房间列表
  	 * 
  	 * @param parameters
  	 * @return
  	 */
  	List<FloorRoom> queryHousesByConditions(Map<String, Object> parameters);

	
}
