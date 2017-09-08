package net.huimin.yk.web.dao.system;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.huimin.yk.web.model.system.WechatAuto;
@Repository
public interface WechatAutoMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(WechatAuto record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(WechatAuto record);

    /**
     * 根据主键查询记录
     */
    WechatAuto selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(WechatAuto record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(WechatAuto record);

	List<WechatAuto> queryAllKeywordAutos();

	WechatAuto queryGuanzhuAuto();
}