package net.huimin.yk.web.services.system;

import java.util.List;
import java.util.Map;

import net.huimin.common.page.PageBean;
import net.huimin.yk.web.model.call.CallTeam;
import net.huimin.yk.web.model.call.CallUser;
import net.huimin.yk.web.model.system.SysMenu;
import net.huimin.yk.web.model.system.SysRole;
import net.huimin.yk.web.model.system.SysUser;



public interface UserService {
	public SysUser userLogin(SysUser user);
	
	public Boolean userUpdate(SysUser user);
	
	public void queryCallTeam(PageBean page, CallTeam callTeam);
	
	public CallUser queryCallUser(CallUser callUser);
	
	public CallTeam queryCallTeamInfoById(CallTeam callTeam);
	
	public List<CallTeam> queryCallTeamList(Map<String, Object> parameters);
	
	public List<CallUser> queryCallUserList(CallUser user);
	
	public void queryCallUserList(PageBean page,CallUser user);
	
	public CallTeam queryTeamByUserid(Integer id);
	
	public CallTeam queryTeamByName(String teamName);
	
	public Boolean saveOrUpdateTeam(CallTeam callTeam);
	
	public Boolean saveOrUpdateTeamUser(CallUser callUser);
	
	public Boolean saveOrUpdateUser(SysUser user);
	
	public Boolean saveOrUpdateRole(SysRole role);
	
	public Boolean vaildUser(SysUser user);

	public void queryAllUser(PageBean page,SysUser user);
	
	public SysUser queryUser (Integer id);
	
	public List<SysUser> queryLeader(SysUser user);
	
	public List<SysUser> queryTeamUser(SysUser user);
	
	public List<SysRole> queryRoleList(SysRole role);

	public SysRole queryRoleByName(String role);
	
	public Boolean deleteTeam(CallTeam callTeam);
	
	public Boolean deleteUser(SysUser user);
	
	public int deleteRole(SysRole role);

	public List<SysUser> queryAllProjectManager();
	
	public SysRole queryRole(Integer id);
	
	public SysUser queryUserByOpenId(String openId);

	public List<SysMenu> queryAllMenus(Integer role);

	public boolean saveRoleMenu(List<Integer> menus, Integer id);
  	
	 public Boolean updateCallUser(Integer userId,Integer count,Integer operat);

	public boolean deleteRoleMenu(Integer id);
}
