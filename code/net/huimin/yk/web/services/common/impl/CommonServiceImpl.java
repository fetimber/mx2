package net.huimin.yk.web.services.common.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.huimin.yk.web.dao.common.AreaMapper;
import net.huimin.yk.web.dao.common.CityMapper;
import net.huimin.yk.web.dao.common.ConfigMapper;
import net.huimin.yk.web.dao.common.OperateRecordMapper;
import net.huimin.yk.web.dao.common.ProvinceMapper;
import net.huimin.yk.web.dao.system.SysMenuMapper;
import net.huimin.yk.web.dao.system.SysMenuRoleMapper;
import net.huimin.yk.web.dao.system.SysUserMapper;
import net.huimin.yk.web.dao.system.WechatAutoMapper;
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
import net.huimin.yk.web.services.common.CommonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private SysUserMapper sysUserMapper;
	@Autowired
	private OperateRecordMapper operateRecordMapper;
	@Autowired
	private ConfigMapper configMapper;
	@Autowired
	private AreaMapper areaMapper;
	@Autowired
	private SysMenuRoleMapper sysMenuRoleMapper;
	@Autowired
	private SysMenuMapper menuMapper;
	
	@Autowired
	private ProvinceMapper provinceMapper;
	
	@Autowired
	private CityMapper cityMapper;
	
	@Autowired
	private WechatAutoMapper wechatAutoMapper;
	
	public List<WechatAuto> queryAllKeywordAutos() {
		return this.wechatAutoMapper.queryAllKeywordAutos();
	}

	public WechatAuto queryGuanzhuAuto() {
		return this.wechatAutoMapper.queryGuanzhuAuto();
	}

	public boolean saveAuto(WechatAuto auto) {
		return this.wechatAutoMapper.insertSelective(auto) == 1;
	}
	
	public SysUser queryUser(){
		try {
			return sysUserMapper.selectByPrimaryKey(1);		
		}catch (Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public Config queryConfig(String groupKey){
		Config config = new Config();
		config.setGroupKey(groupKey);
		List<Config> configList = configMapper.selectBySearch(config);
		return configList.size() > 0 ?  configList.get(0) :  null ;
	}
	
	public List<Area> quertAreaList(Area record){
			return this.areaMapper.selectAreaList(record);		
	}
	
	/**
	 * 记录操作日志
	 * @param record
	 */
	public void operatLog(OperateRecord record){
		operateRecordMapper.insertSelective(record);
	}

	public List<Config> queryConfigsBySearch(Config config) {
		return configMapper.selectBySearch(config);
	}

	public Boolean updateConfig(Config config) {
		return configMapper.updateByGroupKeySelective(config) == 1;
		
	}

	public AreaMapper getAreaMapper() {
		return areaMapper;
	}

	public void setAreaMapper(AreaMapper areaMapper) {
		this.areaMapper = areaMapper;
	}

	public void deleteAuto(Integer id) {
		this.wechatAutoMapper.deleteByPrimaryKey(id);
	}

	public boolean queryOperateRejecte(Integer user_id, Integer menu_id) {
		Map<String, Integer> paramter = new HashMap<String, Integer>();
		paramter.put("user_id", user_id);
		paramter.put("menu_id", menu_id);
		return this.menuMapper.queryOperateRejecte(paramter) > 0;
	}

	public SysMenu queryMenuByid(Integer id) {
		return this.menuMapper.selectByPrimaryKey(id);
	}

	public MainInfo queryMainPageInfo(SeaQueryParameter query) {
		return configMapper.selectMenuInfo(query);
	}
	
	public CustomerInfo queryCustomerCountByAgentId(Integer id){
		return configMapper.selectCustomerInfoByAgentId(id);	
	}

	@Override
	public List<City> quertCityList(Integer id) {	
		return cityMapper.queryCityByProvince(id);
	}

	@Override
	public List<MenuInfo> selectByRoleId(Integer roleId) {
		List<MenuInfo> rsList = null;
		try{
			rsList = sysMenuRoleMapper.selectByRoleId(roleId);
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		return rsList;
	}
}
