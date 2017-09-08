package net.huimin.yk.web.services.common;

import java.util.List;

import net.huimin.yk.web.model.common.Area;
import net.huimin.yk.web.model.common.City;
import net.huimin.yk.web.model.common.Config;
import net.huimin.yk.web.model.common.CustomerInfo;
import net.huimin.yk.web.model.common.MainInfo;
import net.huimin.yk.web.model.common.MenuInfo;
import net.huimin.yk.web.model.common.OperateRecord;
import net.huimin.yk.web.model.sea.SeaQueryParameter;
import net.huimin.yk.web.model.system.SysMenu;
import net.huimin.yk.web.model.system.SysUser;
import net.huimin.yk.web.model.system.WechatAuto;

public interface CommonService {

	public SysUser queryUser();

	/**
	 * 记录操作日志
	 * @param record
	 */
	public void operatLog(OperateRecord record);

	/**
	 * 查询全部配置
	 * @return
	 */
	public Config queryConfig(String groupKey);

	/**
	 * 更新
	 * @return
	 */
	public Boolean updateConfig(Config config);

	/**
	 * 查询区域列表
	 * @param record
	 * @return
	 */
	public List<Area> quertAreaList(Area record);
	
	/**
	 * 查询城市列表
	 * @param record
	 * @return
	 */
	public List<City> quertCityList(Integer id);

	// 查询所有的自动回复规则
	public List<WechatAuto> queryAllKeywordAutos();

	// 查询被关注时自动回复的消息
	public WechatAuto queryGuanzhuAuto();

	//保存自动回复关键字规则
	public boolean saveAuto(WechatAuto auto);

	//删除
	public void deleteAuto(Integer id);

	public boolean queryOperateRejecte(Integer user_id, Integer menu_id);

	public SysMenu queryMenuByid(Integer id);
	
	public MainInfo queryMainPageInfo(SeaQueryParameter query);
	
	public CustomerInfo queryCustomerCountByAgentId(Integer id);
	
	public List<Config> queryConfigsBySearch(Config config);
	
	public List<MenuInfo> selectByRoleId(Integer roleId);
}
