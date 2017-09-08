package net.huimin.yk.web.dao.common;

import org.springframework.stereotype.Repository;

import net.huimin.yk.web.model.common.OperateRecord;
@Repository
public interface OperateRecordMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(OperateRecord record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(OperateRecord record);

    /**
     * 根据主键查询记录
     */
    OperateRecord selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(OperateRecord record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(OperateRecord record);
}