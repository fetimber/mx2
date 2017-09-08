package net.huimin.yk.web.dao.system;

import org.springframework.stereotype.Repository;

import net.huimin.yk.web.model.system.MsgValidateRecord;

@Repository
public interface MsgValidateRecordMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(MsgValidateRecord record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(MsgValidateRecord record);

    /**
     * 根据主键查询记录
     */
    MsgValidateRecord selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(MsgValidateRecord record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(MsgValidateRecord record);

	MsgValidateRecord queryLastCodeByPhoneNumber(String phone);
}