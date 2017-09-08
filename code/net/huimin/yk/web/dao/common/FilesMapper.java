package net.huimin.yk.web.dao.common;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import net.huimin.yk.web.model.common.Files;
@Repository
public interface FilesMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(Files record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(Files record);

    /**
     * 根据主键查询记录
     */
    Files selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(Files record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(Files record);
    
    /**
     * 根据file条件查询file列表
     */
    List<Files> selectByConditions(Files file);
    
    /**
     * 查询主打楼盘的大图片
     */
    List<Files> selectMain();

    /**
     * 更新外键
     * @param bigPictures
     * @param id
     * @return
     */
	int updateRefId(Map<String,Object> param);

	void deleteRefId(Map<String,Object> param);

	List<Files> queryFilesForAgentComfirm(Integer agent);
}