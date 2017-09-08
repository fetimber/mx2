package net.huimin.yk.web.actions.admin;

import java.util.ArrayList;
import java.util.List;

import net.huimin.common.cnst.Const;
import net.huimin.common.cnst.ConstConfig;
import net.huimin.common.helper.Judge;
import net.huimin.common.mvc.AbstractAction;
import net.huimin.yk.web.dao.sea.SeaUnitMapper;
import net.huimin.yk.web.model.common.City;
import net.huimin.yk.web.model.common.Config;
import net.huimin.yk.web.model.common.MainInfo;
import net.huimin.yk.web.model.sea.SeaQueryParameter;
import net.huimin.yk.web.model.sea.SeaUnit;
import net.huimin.yk.web.model.system.SysMenu;
import net.huimin.yk.web.model.system.SysRole;
import net.huimin.yk.web.model.system.SysUser;
import net.huimin.yk.web.services.common.CommonService;
import net.huimin.yk.web.services.sea.SeaService;
import net.huimin.yk.web.services.system.UserService;

import org.springframework.beans.factory.annotation.Autowired;

public class UserAction extends AbstractAction{

	@Autowired
	private UserService userService;
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private SeaUnitMapper seaUnitMapper;
	
	@Autowired
	private SeaService seaService;
	
	private List<SysRole> roleList;
	
	private List<SeaUnit> unitList;
	
	private List<City> cityList;
	
	private List<Config> levelList;
	
	private SysUser user;
	
	private SysRole role;
	
	private String checked;
	
    private MainInfo  info;
    
    private String oldPassword;
    
    private String newPassword;
	
	public String view() {
		this.getPage().setOffset(10);
		this.getPage().setStart((this.getPage().getCurrent() -1 ) * this.getPage().getOffset());
		
		if(Judge.isNotNull(this.user) && Judge.isNotNull(this.user.getId())){
			this.user = this.userService.queryUser(this.user.getId());
		}else{
			if(Judge.isNull(this.user)){
				this.user = new SysUser();		
			}	
		}
		
		if(Judge.isNotNull(this.user) && Judge.isNull(this.user.getId())){
			this.user.setRoleId(this.logined(true).getRoleId());		
		}
		
		if(Judge.isNotNull(this.logined(false).getCityId())){
			this.user.setCityId(this.logined(false).getCityId());
		}

		if(Judge.isNotNull(this.user) && Judge.isNotNull(this.user.getLoginName())){
			this.user.setLoginName(this.user.getLoginName().trim());	
		}
		
//		SysRole role = new SysRole();
//		role.setId(this.logined(false).getRoleId());
//		roleList = this.userService.queryRoleList(role);
		
//		cityList = this.commonService.quertCityList(1);
//		Config config = new Config();
//		config.setGroupKey(ConstConfig.USER_LEVEL);
//		config.setConfigKey(String.valueOf(this.logined(false).getRoleId()));
//		levelList  = this.commonService.queryConfigsBySearch(config);
		
		this.userService.queryAllUser(this.getPage(), user);

		return "view";
	}

	public String add(){
		SeaUnit unit = new SeaUnit();
		if(Judge.isNotNull(this.logined(true).getCityId())){
			unit.setUnitCity(this.logined(false).getCityId());
		}
		if(Judge.isNotNull(this.logined(false).getRoleId())
				&& 12 == this.logined(false).getRoleId()){
			if(Judge.isNull(user)){
				user = new SysUser();
				user.setRoleId(13);
				user.setUserLevel("13");
			}
			
		}
		
		unitList = this.seaService.queryUnitList(unit);	
		cityList = this.commonService.quertCityList(1);
		
		SysRole role = new SysRole();
		role.setId(this.logined(false).getRoleId());
		roleList = this.userService.queryRoleList(role);

		Config config = new Config();
		config.setGroupKey(ConstConfig.USER_LEVEL);
		config.setConfigKey(String.valueOf(this.logined(false).getRoleId()));
		levelList  = this.commonService.queryConfigsBySearch(config);
		
		if(Judge.isNotNull(this.user) 
				&& Judge.isNotNull(this.user.getId())){
			this.user = this.userService.queryUser(this.user.getId());
		}
		return "add";
	}
	
	public String role(){
		SysRole sysRole = new SysRole();
		sysRole.setId((this.logined(true).getRoleId()));
		roleList = this.userService.queryRoleList(sysRole);
		
		if(Judge.isNotNull(this.role) && Judge.isNotNull(this.role.getId())){
		   this.role = this.userService.queryRole(this.role.getId());	
		}
	
		return "role";
	}
	
	public String check_name() {
		boolean rslt = this.seaService.checkUserName(this.user);
		return this.jsonValidate(rslt);
	}
	
	public String rolesave(){
		if(Judge.isNotNull(this.role)){
			Boolean result = false;
			SysRole  newBean = this.userService.queryRoleByName(this.role.getRoleName());
			
			if(Judge.isNull(newBean)
					|| newBean.getId().equals(this.role.getId())){
				result = this.userService.saveOrUpdateRole(this.role);
				if(result){
					this.role = null;
				} else {
					this.pushRequest("message",  "更新失败");
				}
			}else{
				this.pushRequest("message",  "存在相同角色名称,请修改后保存");	
			}	
		}else {
			this.pushRequest("message",  "无法新增保存,仅在修改后保存");
		}
		
		return this.role();	
	}
	
	public String roledel(){
		Boolean result =false;
		if(Judge.isNotNull(this.role)){			
			result = this.userService.deleteRole(this.role) == 1;
		
			if(result){
				this.user = null;
			} 
		}
		this.pushJSON("result", result);
		return  RESULT_JSON;	
	}
	
	public String main(){
		SeaQueryParameter query = new SeaQueryParameter();
		if(Judge.isNotNull(this.logined(true).getCityId())){
			query.setCityId(this.logined(true).getCityId());	
		}
		if(Judge.isNotNull(this.logined(true).getUnitId())){
			query.setUnit(this.logined(true).getUnitId());	
		}
		
		if(Judge.isNotNull(this.logined(false).getRoleId())
				&& 1 == this.logined(false).getRoleId()){
			//query.setCheck("-1");
		}
		
		else if(Judge.isNotNull(this.logined(false).getRoleId())
				&& 11 == this.logined(false).getRoleId()){
			query.setCheck("1");
		}
		
		else if(Judge.isNotNull(this.logined(false).getRoleId())
				&& 12 == this.logined(false).getRoleId()){
			query.setCheck("-1");
		}
		
		else if(Judge.isNotNull(this.logined(false).getRoleId())
				&& 13 == this.logined(false).getRoleId()){
			//query.setCheck("1");
		}
	
		info = commonService.queryMainPageInfo(query);
		return "main";
	}
	
	public String save(){	
		if(Judge.isNotNull(this.user)){		
			this.user.setUserType(Const.MANAGER_TYPE);
			if(Judge.isNull(this.user.getCityId())){
				this.user.setCityId(this.logined(true).getCityId());
			}
			if(Judge.isNotNull(this.user.getUnitId())
					&& Judge.isNull(this.user.getCityId())){
				SeaUnit unit = seaUnitMapper.selectByPrimaryKey(this.user.getUnitId());
				this.user.setCityId(unit.getCityInfo().getId());
			}
			if(Judge.isNull(this.user.getRoleId())
					&& Judge.isNull(this.user.getUserLevel())){
				this.user.setRoleId(13);
				this.user.setUserLevel("13");	
			}
//			if(!"13".equals(this.user.getRoleId())){
			if(this.user.getRoleId() != 13){
				this.user.setUnitId(null);
			}
			
			Boolean result = this.userService.vaildUser(user);
 
			if(result){
				result  = this.userService.saveOrUpdateUser(this.user);
				if(result){
					this.user = null;
					//this.pushRequest("message",  "操作成功");
				} else {
					this.pushRequest("message",  "操作失败");
				}
			} else {
				this.user.setLoginName(null);
				this.pushRequest("message",  "已存在相同登录名用户，请重新填写");
			}	
		}else {
			this.pushRequest("message",  "无法新增保存,仅在修改后保存");
		}
		
		return this.view();
	}
	
	public String delete(){
		Boolean result =false;
		if(Judge.isNotNull(this.user)){			
			result = this.userService.deleteUser(this.user);
			
			if(result){
				this.user = null;
			} 
		}
		this.pushJSON("result", result);
		return  RESULT_JSON;	
	}
	
	public String reset(){
		Boolean result =false;
		if(Judge.isNotNull(this.user)){		
			SysUser reset_user = this.userService.queryUser(this.user.getId());
			if(Judge.isNotNull(reset_user)){
				reset_user.setPwdCode(reset_user.getLoginName());
				result  = this.userService.saveOrUpdateUser(reset_user);
			}
//			result = this.userService.deleteUser(this.user);
			if(result){
				this.user = null;
			} 
		}
		this.pushJSON("result", result);
		return  RESULT_JSON;	
	}
	
	public String role_auth() {
		List<SysMenu> list = this.userService.queryAllMenus(Judge.isNull(this.role) ? null : this.role.getId());
		this.pushRequest("menus", list);
		return "role-auth";
	}
	
	public String role_auth_save() {
		boolean rslt = false;
		if(Judge.isNotEmpty(this.checked)){
			String[] sp = this.checked.split(",");
			List<Integer> menus = new ArrayList<Integer>();
			for (int i = 0; i < sp.length; i++) {
				menus.add(Integer.valueOf(sp[i]));
			}
			rslt = this.userService.saveRoleMenu(menus,this.role.getId());
		} else {
			rslt = this.userService.deleteRoleMenu(this.role.getId());
		}
		this.pushJSON("result", Boolean.valueOf(rslt));
		return "json";
	}
	
	public String password(){
		return "password";
	}
	
	public String save_password(){		
		SysUser logined  = (SysUser)this.getSession().get(Const.USERINFO_IN_SESSION);
		Boolean result = false;
		
		if(Judge.isNotNull(oldPassword) 
				&& Judge.isNotNull(newPassword) ){
			if(oldPassword.equals(newPassword)){
				logined.setPwdCode(newPassword);
				result  = this.userService.saveOrUpdateUser(logined);
				if(result){
					this.user = null;
				}
			}
		}
		
		this.pushJSON("result", result);
		return  RESULT_JSON;	
	}
	
	public SysUser getUser() {
		return user;
	}

	public void setUser(SysUser user) {
		this.user = user;
	}

	public List<SysRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<SysRole> roleList) {
		this.roleList = roleList;
	}

	public SysRole getRole() {
		return role;
	}

	public void setRole(SysRole role) {
		this.role = role;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public MainInfo getInfo() {
		return info;
	}

	public void setInfo(MainInfo info) {
		this.info = info;
	}

	public List<SeaUnit> getUnitList() {
		return unitList;
	}

	public void setUnitList(List<SeaUnit> unitList) {
		this.unitList = unitList;
	}


	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public List<Config> getLevelList() {
		return levelList;
	}

	public void setLevelList(List<Config> levelList) {
		this.levelList = levelList;
	}
	
	
}
