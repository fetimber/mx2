package net.huimin.yk.web.actions.admin;

import java.util.List;

import net.huimin.common.helper.Judge;
import net.huimin.common.mvc.AbstractAction;
import net.huimin.yk.web.model.call.CallTeam;
import net.huimin.yk.web.model.call.CallUser;
import net.huimin.yk.web.model.customer.CustomerLevel;
import net.huimin.yk.web.model.system.SysUser;
import net.huimin.yk.web.services.common.CommonService;
import net.huimin.yk.web.services.customer.CustomerService;
import net.huimin.yk.web.services.system.UserService;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 团队管理
 * @author Administrator
 *
 */
public class TeamAction  extends AbstractAction{

	@Autowired
	private CommonService commonService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CustomerService customerService;
	
	private CallTeam callTeam;
	
	private CallUser callUser;
	
	private List<CustomerLevel> leveList;
	
	private List<SysUser> leaderList;
	
	private List<SysUser> userList;
	
	private List<CallUser> callUserList;
	
	private List<CallTeam> teamList;
	
	public String view(){
		this.getPage().setOffset(50);
		
		if(Judge.isNotNull(this.callTeam) && Judge.isNotNull(this.callTeam.getId())){
			this.callTeam = this.userService.queryCallTeamInfoById(this.callTeam);	
			SysUser user = new SysUser();
			user.setId(this.callTeam.getLeadId());
			//查询团队对长 
			leaderList = this.userService.queryLeader(user);	
		}else{	
			//查询团队对长
			leaderList = this.userService.queryLeader(new SysUser());	
		}
		
		//查询现有客户等级
		leveList = this.customerService.queryCustomerLeveList(null);
			
		this.userService.queryCallTeam(this.getPage(), callTeam);
		return "view";
	}

	public String save(){
		Boolean result = false;
		if(Judge.isNotNull(this.callTeam)){		
			CallTeam judgeBean = this.userService.queryTeamByName(this.callTeam.getTeamName());
			if(Judge.isNull(judgeBean)){
				result = this.userService.saveOrUpdateTeam(this.callTeam);
				if(result){
					this.callTeam = null;
				} else {
					this.pushRequest("message",  "更新失败");
				}	
			}else{
			    this.pushRequest("message",  "存在相同名称的团队,无法保存");
			}	
		}else {
			this.pushRequest("message",  "无法新增保存,仅在修改后保存");
		}
		
		return this.view();
	}
	
	public String delete(){	
		Boolean result =false;
		if(Judge.isNotNull(this.callTeam)){			
			result = this.userService.deleteTeam(this.callTeam);
			
			if(result){
				this.callTeam = null;
			} 
		}
		this.pushJSON("result", result);
		return  RESULT_JSON;
	}
	
	
	public String user(){
		if(Judge.isNotNull(this.callUser)){	
		    callUserList = this.userService.queryCallUserList(this.callUser);
		}
		return "user";
	}
	
	public String user_new(){
		teamList = this.userService.queryCallTeamList(null);

		this.getPage().setOffset(20);
		this.getPage().setStart((this.getPage().getCurrent() -1 ) * this.getPage().getOffset());
		
		if(Judge.isNotNull(this.callUser)
				&& Judge.isNotNull(this.callUser.getTeamId())){	
			this.userService.queryCallUserList(this.getPage(), this.callUser);
			
			if(Judge.isNotNull(callUser.getId())){
				this.callUser = userService.queryCallUser(callUser);	
				SysUser user = new SysUser();
				user.setId(this.callUser.getUserId());
				userList = this.userService.queryTeamUser(user);	
			}else{
				userList = this.userService.queryTeamUser(new SysUser());		
			}
		}
		
		return "user-new";
	}
	
	public String user_save(){
		if(Judge.isNotNull(this.callUser)
				&& Judge.isNotNull(this.callUser.getTeamId())){	
            Boolean result = this.userService.saveOrUpdateTeamUser(callUser);
            Integer teamId = this.callUser.getTeamId();
			if(result){
				this.callUser = new CallUser();
				this.callUser.setTeamId(teamId);
			} else {
				this.pushRequest("message",  "更新失败");
			}
			
		}else {
			this.pushRequest("message",  "无法保存,仅在修改后保存");
		}
			
		return this.user_new();
	}
	
	
	
	public CallTeam getCallTeam() {
		return callTeam;
	}

	public void setCallTeam(CallTeam callTeam) {
		this.callTeam = callTeam;
	}

	public List<CustomerLevel> getLeveList() {
		return leveList;
	}

	public void setLeveList(List<CustomerLevel> leveList) {
		this.leveList = leveList;
	}

	public List<SysUser> getLeaderList() {
		return leaderList;
	}

	public void setLeaderList(List<SysUser> leaderList) {
		this.leaderList = leaderList;
	}

	public CallUser getCallUser() {
		return callUser;
	}

	public void setCallUser(CallUser callUser) {
		this.callUser = callUser;
	}

	public List<CallUser> getCallUserList() {
		return callUserList;
	}

	public void setCallUserList(List<CallUser> callUserList) {
		this.callUserList = callUserList;
	}

	public List<CallTeam> getTeamList() {
		return teamList;
	}

	public void setTeamList(List<CallTeam> teamList) {
		this.teamList = teamList;
	}

	public List<SysUser> getUserList() {
		return userList;
	}

	public void setUserList(List<SysUser> userList) {
		this.userList = userList;
	}
	
	
}
