package net.huimin.yk.web.services.system.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.huimin.common.cnst.Const;
import net.huimin.common.helper.CodeHelper;
import net.huimin.common.helper.Judge;
import net.huimin.common.helper.MD5Util;
import net.huimin.common.page.PageBean;
import net.huimin.yk.web.dao.call.CallTeamMapper;
import net.huimin.yk.web.dao.call.CallUserMapper;
import net.huimin.yk.web.dao.system.SysMenuMapper;
import net.huimin.yk.web.dao.system.SysMenuRoleMapper;
import net.huimin.yk.web.dao.system.SysRoleMapper;
import net.huimin.yk.web.dao.system.SysUserMapper;
import net.huimin.yk.web.dao.system.SysUserRoleMapper;
import net.huimin.yk.web.model.call.CallTeam;
import net.huimin.yk.web.model.call.CallUser;
import net.huimin.yk.web.model.system.SysMenu;
import net.huimin.yk.web.model.system.SysMenuRole;
import net.huimin.yk.web.model.system.SysRole;
import net.huimin.yk.web.model.system.SysUser;
import net.huimin.yk.web.model.system.SysUserRole;
import net.huimin.yk.web.services.system.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private SysUserMapper userMapper;
	@Autowired
	private CallTeamMapper callTeamMapper;
	@Autowired
	private CallUserMapper callUserMapper;
	@Autowired
	private SysRoleMapper roleMapper;
	@Autowired
	private SysMenuMapper menuMapper;
	@Autowired
	private SysMenuRoleMapper menuRoleMapper;
	@Autowired
	private SysUserRoleMapper userRoleMapper;
	
	public SysUser userLogin(SysUser user) {
		//查询用户信息
		SysUser user_1 = this.userMapper.selectUserByName(user);
		if(Judge.isNotNull(user_1)){
			String pwd = MD5Util.string2MD5(user.getPwdCode());
			 if(pwd.equals(user_1.getPwdCode()) ){	 
				 return user_1;
			 }else{
				 return null;
			 }
		}else {
			return null;
		}
	}

	public Boolean userUpdate(SysUser user){
		//更新用户信息
		boolean flag = false;
		try{
			flag = this.userMapper.updateByPrimaryKeySelective(user) == 1;	
			
		}catch (Exception ex){		
			ex.printStackTrace();		
		}
		
		return flag;
	}

	//查询团队
	public void queryCallTeam(PageBean page, CallTeam callTeam) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("_page", page);
		parameters.put("team", callTeam); 
	    this.queryTeaamPage(parameters, page);
	}

	private void queryTeaamPage(Map<String, Object> parameters, PageBean page) {
		Integer count = this.callTeamMapper
				.queryCountByConditions(parameters);
		try{
			List<CallTeam> teams = this.callTeamMapper
					.queryCallTeamsByConditions(parameters);

			PageBean.Counter(page, count, null, teams);
		}
		catch (Exception ex){	
			ex.printStackTrace();
		}
	}
	
	/**
	 * 查询某团队的团队信息 
	 * @return
	 */
	public CallTeam queryCallTeamInfoById(CallTeam callTeam){
		return this.callTeamMapper.selectByPrimaryKey(callTeam.getId());	
	}
	
	/**
	 * 查询团队成员
	 */
	public CallUser queryCallUser(CallUser callUser){
	   return callUserMapper.selectByPrimaryKey(callUser.getId());
	}
	
	

	/**
	 * 更新或新增团队
	 */
	public Boolean saveOrUpdateTeam(CallTeam callTeam) {

		Boolean result = false;
	
		if(CodeHelper.isNull(callTeam.getId())){
			callTeam.setCreateTime(new Date());
			result = this.callTeamMapper.insertSelective(callTeam) == 1;
		}else{
			callTeam.setUpdateTime(new Date());
			result = this.callTeamMapper.updateByPrimaryKeySelective(callTeam) == 1;
		}

		return result;
	}
	
	
	/**
	 * 删除团队
	 */
	public Boolean deleteTeam(CallTeam callTeam) {
		return this.callTeamMapper.deleteByPrimaryKey(callTeam.getId()) == 1;
	}
	
	
	/**
	 * 查询团队队长列表
	 * @param record
	 * @return
	 */
	public List<SysUser> queryLeader(SysUser user){   
		   return this.userMapper.selectLeader(user);  
	}
  
	/**
	 * 查询可用团队成员长列表
	 * @param record
	 * @return
	 */
	public List<SysUser> queryTeamUser(SysUser user){   
		   return this.userMapper.selectTeamUser(user);  
	}
	
	
	/**
	 * 查询Call客成员列表
	 * @param record
	 * @return
	 */
	public List<CallUser> queryCallUserList(CallUser user){   
		   try{
			   return this.callUserMapper.queryCallUserByTeamId(user);
		   }
		   catch (Exception ex){
			   ex.printStackTrace();
			   return null;	   
		   }	  
	}
	
	/**
	 * 查询团队队长列表
	 * @param record
	 * @return
	 */
	public List<SysRole> queryRoleList(SysRole role){   
		   return this.roleMapper.selectAllRoles(role);
	}
	
	
	/**
	 * 查询全部后台成员
	 */
	public void queryAllUser(PageBean page, SysUser user) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("_page", page);
		parameters.put("user", user); 
	
	    Integer count = this.userMapper
				.queryCountByConditions(parameters);

		List<SysUser> users = this.userMapper.queryUsersByConditions(parameters);
		PageBean.Counter(page, count, null, users);	
	}

	

	public SysUser queryUser(Integer id) {
		return this.userMapper.selectByPrimaryKey(id);
	}

	@Transactional
	public Boolean saveOrUpdateUser(SysUser user) {
		Boolean result = false;
		SysUserRole userRole = new SysUserRole();
	
		if(null != user.getPwdCode()){
			String pwd = MD5Util.string2MD5(user.getPwdCode());
			user.setPwdCode(pwd);
		}
		
		if(Judge.isNull(user.getId())){
			user.setCreateTime(new Date());
			result = this.userMapper.insertSelective(user) == 1;	
		}else{
			result = this.userMapper.updateByPrimaryKeySelective(user) == 1;
			
			if(result){
				userRoleMapper.deleteByUserId(user.getId());
			}
		}

		if(result){
			userRole.setUserId(user.getId());
			userRole.setRoleId(user.getRoleId());
			result = userRoleMapper.insertSelective(userRole) == 1;
		}
		
		return result;
	}

	@Transactional
	public Boolean deleteUser(SysUser user) {
		boolean flag = false;
		if(userRoleMapper.deleteByUserId(user.getId()) == 1){
			flag = this.userMapper.deleteByPrimaryKey(user.getId()) == 1;
		}
		return flag ;
	}

	public List<SysUser> queryAllProjectManager() {
		return this.userMapper.queryAllProjectManager();
	}

	public SysRole queryRole(Integer id) {
		return this.roleMapper.selectByPrimaryKey(id);
	}

	public Boolean saveOrUpdateRole(SysRole role) {
		Boolean result = false;
		if(Judge.isNull(role.getId())){
			result = this.roleMapper.insertSelective(role) == 1;
		}else{
			result = this.roleMapper.updateByPrimaryKeySelective(role) == 1;
		}

		return result;
	}

	public int deleteRole(SysRole role) {
		return this.roleMapper.deleteByPrimaryKey(role.getId());
	}
	
	public SysUser queryUserByOpenId(String openId) {
		return this.userMapper.queryUserByOpenId(openId);
	}

	public List<SysMenu> queryAllMenus(Integer role) {
		return this.menuMapper.queryAllMenus(role);
	}

	@Transactional
	public boolean saveRoleMenu(List<Integer> menus, Integer role) {
		int total = menus.size(),idx = 0;
		this.menuRoleMapper.deleteRole(role);
		for (Iterator<Integer> iterator = menus.iterator(); iterator.hasNext();) {
			Integer menu = iterator.next();
			SysMenuRole smr = new SysMenuRole();
			smr.setMenuId(menu);
			smr.setRoleId(role);
			idx+=this.menuRoleMapper.insertSelective(smr);
		}
		return total == idx;
	}

	public CallTeam queryTeamByUserid(Integer id) {
		return this.callTeamMapper.selectByLeadid(id);
	}
  	
	/**
	 * 更新用户待处理数量
	 * @param userId
	 * @param count
	 * @param operat
	 * @return
	 */
    public Boolean updateCallUser(Integer userId,Integer count,Integer operat){

    	CallUser record  = this.callUserMapper.selectByUserId(userId);
    	
    	if(Judge.isNotNull(record)){
	        if(Const.ADD.equals(operat) ){
	        	record.setCustomerDecimal(record.getCustomerDecimal() + count);
	        }else if(Const.SUB.equals(operat)){
	        	record.setCustomerDecimal(record.getCustomerDecimal() - count);
	        }
	        return this.callUserMapper.updateByPrimaryKeySelective(record) == 1;
    	}else{
    		return false;
    	}
    		
    	
    }

	public Boolean vaildUser(SysUser user) {	
		SysUser resultUser = this.userMapper.selectUserByName(user);
		return Judge.isNull(resultUser)? true : false;
	}


	
	public void queryCallUserList(PageBean page, CallUser user) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("_page", page);
		parameters.put("user", user); 
	
	    Integer count = this.callUserMapper
				.queryCountByConditions(parameters);

		List<CallUser> users = this.callUserMapper.queryUsersByTeamId(parameters);
		PageBean.Counter(page, count, null, users);	
		
	}

	public List<CallTeam> queryCallTeamList(Map<String, Object> parameters) {
		return this.callTeamMapper.queryCallTeams(parameters);
	}

	public Boolean saveOrUpdateTeamUser(CallUser callUser) {
		Boolean result = false;
		
		if(Judge.isNull(callUser.getId())){
			result = this.callUserMapper.insertSelective(callUser) == 1;
		}else{
			result = this.callUserMapper.updateByPrimaryKeySelective(callUser) == 1;
		}

		return result;
	}

	public boolean deleteRoleMenu(Integer id) {
		try {
			this.menuRoleMapper.deleteRole(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public CallTeam queryTeamByName(String teamName) {
		return this.callTeamMapper.selectByTeamName(teamName);
	}

	public SysRole queryRoleByName(String role) {
		
		return this.roleMapper.selectRoleByName(role);
	}
	
}
