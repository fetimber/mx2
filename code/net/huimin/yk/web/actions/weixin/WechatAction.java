package net.huimin.yk.web.actions.weixin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.huimin.common.cnst.Const;
import net.huimin.common.cnst.ConstConfig;
import net.huimin.common.helper.Judge;
import net.huimin.common.helper.MD5Util;
import net.huimin.common.mvc.AbstractAction;
import net.huimin.yk.channel.msg.MessageAPI;
import net.huimin.yk.web.model.agent.AgentUser;
import net.huimin.yk.web.model.agent.StoreAgent;
import net.huimin.yk.web.model.bq.FloorRoom;
import net.huimin.yk.web.model.bq.RoomCheckinfo;
import net.huimin.yk.web.model.cash.CashApplication;
import net.huimin.yk.web.model.cash.CashDetail;
import net.huimin.yk.web.model.common.Area;
import net.huimin.yk.web.model.common.CustomerInfo;
import net.huimin.yk.web.model.common.Files;
import net.huimin.yk.web.model.common.OperateRecord;
import net.huimin.yk.web.model.customer.CustomeRecord;
import net.huimin.yk.web.model.customer.CustomerApplication;
import net.huimin.yk.web.model.customer.CustomerMoney;
import net.huimin.yk.web.model.houses.HousesConfig;
import net.huimin.yk.web.model.houses.HousesProject;
import net.huimin.yk.web.model.money.MoneyApplication;
import net.huimin.yk.web.model.money.MoneyBalance;
import net.huimin.yk.web.model.money.MoneyDetail;
import net.huimin.yk.web.model.system.SysAccount;
import net.huimin.yk.web.model.system.SysUser;
import net.huimin.yk.web.services.bq.FloorRoomService;
import net.huimin.yk.web.services.bq.RoomCheckinfoService;
import net.huimin.yk.web.services.common.AccountService;
import net.huimin.yk.web.services.common.AreaService;
import net.huimin.yk.web.services.common.CommonService;
import net.huimin.yk.web.services.customer.CustomerService;
import net.huimin.yk.web.services.finace.FinaceService;
import net.huimin.yk.web.services.houses.HousesService;
import net.huimin.yk.web.services.system.AgentService;
import net.huimin.yk.web.services.system.UserService;
import net.huimin.yk.weixin.core.WechatSupport;
import net.huimin.yk.weixin.core.WechatSupportImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.sword.wechat4j.common.Config;

public class WechatAction extends AbstractAction implements ServletRequestAware,ServletResponseAware,Const{

	@Autowired
	private CommonService commonService; 
	
	@Autowired
	private HousesService housesService; 
	
	@Autowired
	private RoomCheckinfoService roomCheckinfoService;
	
	@Autowired
	private FloorRoomService floorRoomService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AgentService agentService;
	
	@Autowired
	private FinaceService finaceService;
	
	@Autowired
	private AreaService areaService;
	
	@Resource
	private MessageAPI api;
	
	private HttpServletRequest req;
	
	private HttpServletResponse resp;
	
	private HousesProject project;
	
	private RoomCheckinfo checkInfo;
	
	private AgentUser agent;
	
	private SysUser user;
	
	private StoreAgent storeAgent;

	private FloorRoom room;
	
	private String buildingNo;
	
	public StoreAgent getStoreAgent() {
		return storeAgent;
	}


	public void setStoreAgent(StoreAgent storeAgent) {
		this.storeAgent = storeAgent;
	}


	public HousesProject getProject() {
		return project;
	}


	public void setProject(HousesProject project) {
		this.project = project;
	}
	

	public void setAgent(AgentUser agent) {
		this.agent = agent;
	}


	public void setUser(SysUser user) {
		this.user = user;
	}
	
	public AgentUser getAgent() {
		return agent;
	}


	public SysUser getUser() {
		return user;
	}

	public FloorRoom getRoom() {
		return room;
	}

	public void setRoom(FloorRoom room) {
		this.room = room;
	}

	@Override
	public String execute() {
		return null;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		req = arg0;		
	}
	
	public void setServletResponse(HttpServletResponse arg0) {
		this.resp = arg0;
	}
	
	public RoomCheckinfo getCheckInfo() {
		return checkInfo;
	}


	public void setCheckInfo(RoomCheckinfo checkInfo) {
		this.checkInfo = checkInfo;
	}

	public String scan(){	
		return "scan";
	}

	public String scantest(){	
		return "scantest";
	}
	
	/**
	 * 获取楼盘列表
	 * @return
	 */
	public String houses(){
		// 分页条件查询所有楼盘数据
		this.getPage().setOffset(10);		
		//this.housesService.queryHousesForPage(this.getPage(), project);
		
		this.floorRoomService.queryRoomsForPage(this.getPage(), room);
		
		
		this.pushJSON("Data", this.getPage().getBeans());
		this.pushJSON("total", this.getPage().getCount());
		this.pushJSON("Status", RESULT_JSON_SUCCESS);
		return RESULT_JSON;
	}
	
	/**
	 * 楼盘列表页面
	 * @return
	 */
	public String housesPage(){	
		try {
			//getOpenId();
			String  buildingNo = req.getParameter("buildingno");
			String  roomCode = req.getParameter("roomCode"); 
			
			List<Files> files = this.housesService.queryMainHouseImgs();
			List<Area> areas = this.areaService.queryAreaByCity(1);
			req.setAttribute("areas", areas);
			req.setAttribute("files", files);
			req.setAttribute("build", buildingNo);
			req.setAttribute("room", roomCode);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "houses";
	}
	
	/**
	 * 获取楼盘的配套信息
	 * @param id
	 * @return
	 */
	public String houseDetail(){
		Integer id = Integer.parseInt(req.getParameter("id"));
		HousesProject project = this.housesService.selectHouseById(id);
		List<HousesConfig> configs = this.housesService.queryHouseConfigByPid(id);
		List<Files> imgs = this.housesService.queryHouseImgs(id);
		req.setAttribute("configs", configs);
		req.setAttribute("imgs", imgs);
		req.setAttribute("project", project);
		return "detail";
	}
	
	/**
	 * 登录页面
	 * @return
	 */
	public String toLogin(){
		try{
			//如果已经登录则跳转到个人中心页面
			if(this.checkLogin()){
				return this.myAccount();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "login";
	}
	
	/**
	 * 登录校验
	 * @return
	 */
	public String login(){
		
		try{
		    String loginName = req.getParameter("userName");
		    String pwdCode = req.getParameter("pwd");
	        SysUser user = new SysUser();
	        user.setLoginName(loginName);
	        user.setPwdCode(MD5Util.string2MD5(pwdCode));
	        user.setUserType(WECHAT_TYPE);
	        SysUser user2 = this.housesService.agentInfo(user);

		    if(user2!=null&&Judge.isNotEmpty(user2.getLoginName())&&MD5Util.string2MD5(pwdCode).equals(user2.getPwdCode())){
		    	
		    	AgentUser agentUser = new AgentUser();
		        agentUser.setUserId(user2.getId());
		        AgentUser agentUser2 = this.housesService.queryAgentUser(agentUser);
		        if(null!=agentUser2){
			        this.pushJSON("Status", RESULT_JSON_SUCCESS);
			        this.pushJSON("Message", "登录成功");
			        
			        /**更新最后登录时间*/
			        SysUser user3 = new SysUser();
			        user3.setId(user2.getId());
			        user3.setLastLogintime(new Date());
			        this.userService.userUpdate(user3);
			        
			        /**保存用户信息到session中*/
			        pushSession(AGNETINFO_IN_SESSION, agentUser2);
		        }else{
		        	this.pushJSON("Status", RESULT_JSON_FAILURE);
					this.pushJSON("Message", "登录失败");
		        }
		    }
		    else{
			   this.pushJSON("Status", RESULT_JSON_FAILURE);
			   this.pushJSON("Message", "登录失败");
		    }
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		 return RESULT_JSON;
	}
	
	/**
	 * 注册的执行方法
	 * @return
	 */
	public String register(){
		Map<String , Object> reMap = new HashMap<String, Object>();
		try{
			int accountId = accountService.openAccount();
			if(accountId == -1){
				reMap.put("Status", ACCOUNT_OPEN_ERROR_2);
			}
			else{
				//this.user.setNickName(this.getNickName());
				reMap = this.housesService.register(this.agent, this.user ,accountId);

			}
		}
		catch (Exception e) {
			reMap.put("Status", ACCOUNT_OPEN_ERROR_2);
			e.printStackTrace();
		}
		this.pushJSON("reMap", reMap);
		return RESULT_JSON;
	}
	
	/**
	 * 专业经纪人注册
	 */
	public String speRegist(){
		try{
			/**先获取填写的推荐人信息*/
			AgentUser refer = null;
			if(null != this.agent.getReferNumber()&&!"".equals(this.agent.getReferNumber())){
				AgentUser tempUser = new AgentUser();
				tempUser.setPhoneDecimal(this.agent.getReferNumber());
				refer = this.housesService.queryAgentUser(tempUser);
			}
			/**当填写的经纪人号码为专业经纪人*/
			if(null!=refer && refer.getRealNameValidate() >= 1){
				refer.setReferCount(refer.getReferCount().add(new BigDecimal(1)));
				this.agentService.insertOrUpdateAgent2(refer);
				this.agent.setReferId(refer.getId());
			}
			
			this.agentService.insertOrUpdateAgent2(this.agent);
			this.pushJSON("Status", RESULT_JSON_SUCCESS);
			//短信和微信回复
			AgentUser agentUser2 = this.agentService.selectById(this.agent.getId());
			api.send(agentUser2.getUser().getId(), "【房小帅】已收到您提交的专业经纪人注册信息。还差一步，就可以完成升级注册流程。 请在微信中向【房小帅】上传您的名片和身份证图片。");
			api.sendWechatTextMsg(agentUser2.getWechatId(), "【房小帅】已收到您提交的专业经纪人注册信息。还差一步，就可以完成升级注册流程。 请在微信中向【房小帅】上传您的名片和身份证图片。");
			
		}
		catch (Exception e) {
			this.pushJSON("Status", RESULT_JSON_FAILURE);
			e.printStackTrace();
		}
		return RESULT_JSON;
	}
	
	/**
	 * 注册1
	 */
	public String regStep1(){
		try{
			//String openId = getOpenId();
			//req.setAttribute("openId", openId);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return "regStep1";
	}
	
	/**
	 * 注册2
	 */
	public String regStep2(){
		return "regStep2";
	}
	
	/**
	 * 注册3
	 */
	public String regStep3(){
		try{
			List<Area> areas = this.areaService.queryAreaByCity(1);
			req.setAttribute("areas", areas);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "regStep3";
	}
	
	/**
	 * 注册4
	 */
	public String regStep4(){
		return "regStep4";
	}
	
	/**
	 * 校验经纪人信息
	 */
	public String queryAgentUser(){
		try{
			String referee = req.getParameter("referee");
			AgentUser agentUser = new AgentUser();
			agentUser.setPhoneDecimal(referee);
			// agentUser.setRealNameValidate(1);
			agentUser = this.housesService.queryAgentUser(agentUser);
			if (null != agentUser && agentUser.getRealNameValidate() >= 1) {
				this.pushJSON("Status", RESULT_JSON_SUCCESS);
			} else {
				this.pushJSON("Status", RESULT_JSON_FAILURE);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
        //this.pushJSON("agentUser", agentUser);
		return RESULT_JSON;
	}
	
	/**
	 * 我要推荐页面 选择楼盘情况下
	 */
	public String recommendPage2(){
		try{
			HousesProject curProject  = null;
			if(!this.checkLogin()){
				return "login";
			}
			
			String area = req.getParameter("area"); //地域信息
			String hid = req.getParameter("hid");   //楼盘Id
			if(null!=hid && !"".equals(hid)){
				curProject = this.housesService.selectHouseById(Integer.parseInt(hid));
			}
			AgentUser agentUser = (AgentUser) this.getSession().get(AGNETINFO_IN_SESSION);
			int dayCount = this.customerService.queryDayCustomerCount(agentUser.getId());
			int maxCount = Integer.parseInt(commonService.queryConfig(ConstConfig.COUNT_MAX).getConfigKey());
			int myCount = maxCount - dayCount;
			req.setAttribute("myCount", myCount);
			req.setAttribute("area", area);
			req.setAttribute("hid", hid);
			req.setAttribute("curProject", curProject);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "recommend2";
	}
	
	/**
	 * 我要推荐页面 微信菜单
	 * @return
	 */
	public String recommendPage(){
		try{
			if(!this.checkLogin()){
				return "login";
			}
			String buildNo = req.getParameter("buildno"); 
			String roomCode  = req.getParameter("roomcode");
			List<Area> areas = this.areaService.queryAreaByCity(1);
			AgentUser agentUser = (AgentUser) this.getSession().get(AGNETINFO_IN_SESSION);
			int dayCount = this.customerService.queryDayCustomerCount(agentUser.getId());
			int maxCount = Integer.parseInt(commonService.queryConfig(ConstConfig.COUNT_MAX).getConfigKey());
			int myCount = maxCount - dayCount;
			req.setAttribute("buildno", buildNo);
			req.setAttribute("roomcode", roomCode);
			req.setAttribute("areas", areas);
			req.setAttribute("myCount", myCount);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "recommend";
	}
	
	/**
	 * 根据地区获取楼盘列表
	 */
	public String housesList(){
		try {
			//如果area值为-1 则默认选择全部楼盘
			if(this.project.getArea() == -1){
			    this.project.setArea(null);
			}
			List<HousesProject> projects = this.housesService.selectAllProjectByConditions(this.project);
			this.pushJSON("projects", projects);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RESULT_JSON;
	}
	
	/**
	 * 客户推荐逻辑处理
	 */
	public String recommend(){
		int reCode = 1;   
		try{	
			JSONArray custArray = JSONArray.fromObject(this.req.getParameter("custArray"));
			AgentUser agentUser = (AgentUser) this.getSession().get(AGNETINFO_IN_SESSION);
			reCode = this.housesService.recommend(agentUser.getId(), custArray);
			
			commonService.operatLog(logBean(agentUser.getId(), custArray));
			
			if(reCode == 0){
				//如果是首次推荐  发送短信
				if (agentUser.getCustomerCount().compareTo(new BigDecimal(0))==0){
					api.send(agentUser.getUser().getId(), "【房小帅】恭喜您首次推荐客户成功！我们会及时跟进您的客户。如遇到“客户即时到访”等特殊情况，请及时与您所推荐楼盘的项目经理电话联系（详见楼盘详情页）。");
					api.sendWechatTextMsg(agentUser.getWechatId(), "【房小帅】恭喜您首次推荐客户成功！我们会及时跟进您的客户。如遇到“客户即时到访”等特殊情况，请及时与您所推荐楼盘的项目经理电话联系（详见楼盘详情页）。");
				}
				agentUser = agentService.selectById(agentUser.getId());
				this.pushSession(AGNETINFO_IN_SESSION, agentUser);
			}
		}catch(Exception e){
			reCode = 1;
			e.printStackTrace();
		}
		this.pushJSON("Status", reCode);
		return RESULT_JSON;
	}
	
	/**
	 * 我的账户页面
	 */
	public String myAccount(){
		try{
			if(!this.checkLogin()){
				return "login";
			}
			AgentUser agentUser = (AgentUser) this.getSession().get(AGNETINFO_IN_SESSION);
			agentUser = agentService.selectById(agentUser.getId());
			this.pushSession(AGNETINFO_IN_SESSION, agentUser);
			SysUser sysUser = agentUser.getUser();
			List<StoreAgent> agents = this.agentService.queryBottomByStoreId(agentUser.getId());
			if(agents == null || agents.isEmpty()){
				req.setAttribute("offlines", 0);
			}else{
				req.setAttribute("offlines", agents.size());
			}
			req.setAttribute("agentUser", agentUser);
			req.setAttribute("sysUser", sysUser);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "account";
	}
	
	
	/**
	 * 我的客户页面
	 */
	public String customPage(){
		try {
			if (!this.checkLogin()) {
				return "login";
			}
			AgentUser agentUser = (AgentUser) this.getSession().get(AGNETINFO_IN_SESSION);
			CustomerInfo customerInfo = commonService.queryCustomerCountByAgentId(agentUser.getId()); 
			this.req.setAttribute("customerInfo", customerInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "custom";
	}
	
	/**
	 * 我的客户信息
	 */
	public String myCustom(){
		try{
			if(!this.checkLogin()){
				return "login";
			}
			AgentUser agentUser = (AgentUser) this.getSession().get(AGNETINFO_IN_SESSION);
			CustomerApplication customerApplication = new CustomerApplication();
			customerApplication.setAgentId(agentUser.getId());
			customerApplication.setEffectType(1);
			this.getPage().setOffset(3);
			customerService.queryCustomerListForPage(this.getPage(), customerApplication); 

			this.pushJSON("Data", this.getPage().getBeans());
			this.pushJSON("total", this.getPage().getCount());
			this.pushJSON("Status", RESULT_JSON_SUCCESS);
			
		}catch(Exception e){
			this.pushJSON("Status", RESULT_JSON_FAILURE);
			e.printStackTrace();
		}
		
		return RESULT_JSON;
	}
	
	/**
	 * 我的流失客户信息
	 */
	public String myMissCustom(){
		try{
			if(!this.checkLogin()){
				return "login";
			}
			AgentUser agentUser = (AgentUser) this.getSession().get(AGNETINFO_IN_SESSION);
			CustomerApplication customerApplication = new CustomerApplication();
			customerApplication.setAgentId(agentUser.getId());
			customerApplication.setEffectType(0);
			this.getPage().setOffset(3);
			customerService.queryCustomerListForPage(this.getPage(), customerApplication); 

			this.pushJSON("Data", this.getPage().getBeans());
			this.pushJSON("total", this.getPage().getCount());
			this.pushJSON("Status", RESULT_JSON_SUCCESS);
			
		}catch(Exception e){
			this.pushJSON("Status", RESULT_JSON_FAILURE);
			e.printStackTrace();
		}
		
		return RESULT_JSON;
	}
	
	
	public String customDetail(){
		try{
			int cId = Integer.parseInt(this.req.getParameter("cId"));
			CustomerApplication customer = housesService.selectCustomer(cId);
			MoneyApplication moneyinfo = this.finaceService.selectByCustomerId(cId);
			this.req.setAttribute("customer", customer);
			this.req.setAttribute("moneyinfo", moneyinfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "customDetail";
	}
	
	/**
	 * 我的客户页面
	 */
	public String customPage2(){
		try {
			if (!this.checkLogin()) {
				return "login";
			}
			Integer agentId = Integer.parseInt(this.req.getParameter("agentId"));
			this.req.setAttribute("agentId", agentId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "custom2";
	}
	
	/**
	 * 我的客户信息
	 */
	public String myCustom2(){
		try{
			if(!this.checkLogin()){
				return "login";
			}
			AgentUser agentUser = (AgentUser) this.getSession().get(AGNETINFO_IN_SESSION);
			Integer storeId = agentUser.getId();
			Integer agentId = Integer.parseInt(this.req.getParameter("agentId"));
			
			StoreAgent query = new StoreAgent();
			query.setStoreId(storeId);
			query.setAgentId(agentId);
			StoreAgent result = this.agentService.queryStoreInfoByConditions(query);
			
			CustomerApplication customerApplication = new CustomerApplication();
			customerApplication.setAgentId(agentId);
			customerApplication.setEffectType(1);
            if(null != result){
            	customerApplication.setReferTime(result.getUpdateTime());
			}
			this.getPage().setOffset(3);
			customerService.queryCustomerListForPage(this.getPage(), customerApplication); 

			this.pushJSON("Data", this.getPage().getBeans());
			this.pushJSON("total", this.getPage().getCount());
			this.pushJSON("Status", RESULT_JSON_SUCCESS);
			
		}catch(Exception e){
			this.pushJSON("Status", RESULT_JSON_FAILURE);
			e.printStackTrace();
		}
		
		return RESULT_JSON;
	}
	
	/**
	 * 我的流失客户信息
	 */
	public String myMissCustom2(){
		try{
			if(!this.checkLogin()){
				return "login";
			}
			AgentUser agentUser = (AgentUser) this.getSession().get(AGNETINFO_IN_SESSION);
			Integer storeId = agentUser.getId();
			Integer agentId = Integer.parseInt(this.req.getParameter("agentId"));
			
			StoreAgent query = new StoreAgent();
			query.setStoreId(storeId);
			query.setAgentId(agentId);
			StoreAgent result = this.agentService.queryStoreInfoByConditions(query);
			
			
			CustomerApplication customerApplication = new CustomerApplication();
			customerApplication.setAgentId(agentId);
			customerApplication.setEffectType(0);
			if(null != result){
            	customerApplication.setReferTime(result.getUpdateTime());
			}
			this.getPage().setOffset(3);
			customerService.queryCustomerListForPage(this.getPage(), customerApplication); 

			this.pushJSON("Data", this.getPage().getBeans());
			this.pushJSON("total", this.getPage().getCount());
			this.pushJSON("Status", RESULT_JSON_SUCCESS);
			
		}catch(Exception e){
			this.pushJSON("Status", RESULT_JSON_FAILURE);
			e.printStackTrace();
		}
		
		return RESULT_JSON;
	}
	
	/**
	 * 客户详情
	 */
	public String customDetail2(){
		try{
			int cId = Integer.parseInt(this.req.getParameter("cId"));
			CustomerApplication customer = housesService.selectCustomer(cId);
			MoneyApplication moneyinfo = this.finaceService.selectByCustomerId(cId);
			this.req.setAttribute("customer", customer);
			this.req.setAttribute("moneyinfo", moneyinfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "customDetail2";
	}
	
	/**
	 * 门店经纪人页面
	 */
	public String storeMemberPage(){
		try {
			if (!this.checkLogin()) {
				return "login";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "storeMember";
	}
	
	/**
	 * 门店经纪人列表
	 */
	public String myStoreMember(){
		try{
//			if(!this.checkLogin()){
//				return "login";
//			}
//			AgentUser agentUser = (AgentUser) this.getSession().get(AGNETINFO_IN_SESSION);
//			StoreAgent storeAgent = new StoreAgent();
//			storeAgent.setStoreId(agentUser.getStoreId());
//			this.getPage().setOffset(3);
//			customerService.queryStoreAgentForPage(this.getPage(), storeAgent);
//
//			this.pushJSON("Data", this.getPage().getBeans());
//			this.pushJSON("total", this.getPage().getCount());
//			this.pushJSON("Status", RESULT_JSON_SUCCESS);
			
		}catch(Exception e){
			this.pushJSON("Status", RESULT_JSON_FAILURE);
			e.printStackTrace();
		}
		
		return RESULT_JSON;
	}
	
	
	
	
	/**
	 * 我的申诉页面
	 */
	public String complainPage(){
		try{
			int cId = Integer.parseInt(this.req.getParameter("cId"));
			this.req.setAttribute("cId", cId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "complain";
	}
	
	public String complain(){
		try{
			String cpMsg = this.req.getParameter("cpMsg");
			Integer cid = Integer.parseInt(this.req.getParameter("cId"));
			CustomerApplication application = new CustomerApplication();
			application.setId(cid);
			application.setAppealMsg(cpMsg);
			application.setAppealStatus(APPEAL_STATUS_YES);
			customerService.customerUpdate(application);
			this.pushJSON("Status", RESULT_JSON_SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			this.pushJSON("Status", RESULT_JSON_FAILURE);
		}
		return RESULT_JSON;
	}
	
	/**
	 * 我的佣金
	 */
	public String myBrokerage(){
		try{
			if(!this.checkLogin()){
				return "login";
			}
			
			String tabId = (this.req.getParameter("tabId") == null ? "" : this.req.getParameter("tabId"));
			AgentUser agent = (AgentUser) this.getSession().get(AGNETINFO_IN_SESSION);
			/**这个地方要重新查一遍*/
			agent = agentService.selectById(agent.getId());
			this.pushSession(AGNETINFO_IN_SESSION, agent);
			SysUser sysUser = agent.getUser();
			
			//1  查询经纪人的可结佣金清单
			CustomerApplication application = new CustomerApplication();
			//签约状态和经纪人ID必填
			application.setCustomerStatus(Const.CUSTTOMER_STATUS_SIX);
			application.setAgentId(agent.getId());
			
			BigDecimal total1 = new BigDecimal(0);
			BigDecimal total_1 = new BigDecimal(0);
			BigDecimal total_2 = new BigDecimal(0);
			BigDecimal total_3 = new BigDecimal(0);
			BigDecimal total_4 = new BigDecimal(0);
			BigDecimal total_5 = new BigDecimal(0);
			BigDecimal total_6 = new BigDecimal(0);
			
			
	        
			CustomerMoney record1 = new CustomerMoney();
			record1.setAccountId(agent.getAccountId());
			record1.setStatus(Const.CLICK_TYPE);
			List <CustomerMoney> resultList = this.customerService.queryCustomerMoney(record1);
			
			//其他可结佣金列表  (结果集)
			List <CustomerMoney> type1List = new ArrayList<CustomerMoney>();
			List <CustomerMoney> type2List = new ArrayList<CustomerMoney>();
			List <CustomerMoney> type3List = new ArrayList<CustomerMoney>();
			List <CustomerMoney> type4List = new ArrayList<CustomerMoney>();
			List <CustomerMoney> type5List = new ArrayList<CustomerMoney>();
			List <CustomerMoney> type6List = new ArrayList<CustomerMoney>();
			
			for (int i = 0 ;  i < resultList.size() ; i ++){
				total1 = total1.add(resultList.get(i).getAmount());
				if(resultList.get(i).getMoneyType().equals(Const.MONEY_TYPE1)){
					total_1 = total_1.add(resultList.get(i).getAmount());
					type1List.add(resultList.get(i));	
				}if(resultList.get(i).getMoneyType().equals(Const.MONEY_TYPE2)){
					total_2 = total_2.add(resultList.get(i).getAmount());
					type2List.add(resultList.get(i));	
				}else if(resultList.get(i).getMoneyType().equals(Const.MONEY_TYPE3)){
					total_3 = total_3.add(resultList.get(i).getAmount());
					type3List.add(resultList.get(i));
				}else if(resultList.get(i).getMoneyType().equals(Const.MONEY_TYPE4)){
					total_4 = total_4.add(resultList.get(i).getAmount());
					type4List.add(resultList.get(i));
				}else if(resultList.get(i).getMoneyType().equals(Const.MONEY_TYPE5)){
					total_5 = total_5.add(resultList.get(i).getAmount());
					type5List.add(resultList.get(i));
				}else if(resultList.get(i).getMoneyType().equals(Const.MONEY_TYPE6)){
					total_6 = total_6.add(resultList.get(i).getAmount());
					type6List.add(resultList.get(i));
				}
			}
			
			
			//4 查询佣金申请表(历史记录)  结佣审核办理中  
			MoneyApplication money = new MoneyApplication();
			//账户ID必填
			money.setAccountId(agent.getAccount().getId());
			money.setResultStatus(Const.MONEY_STATUS_ING);
			List<MoneyApplication>  historyList = this.finaceService.queryAgentMoneyList(money);
			
//			BigDecimal total2 = new BigDecimal(0);
//			for(int l = 0 ; l < historyList.size() ; l ++){
//				total2 = total2.add(historyList.get(l).getAmountMoney());	
//			}
			
//			//5 查询经纪人的已结佣金总额 
//			//账户ID必填
//			MoneyBalance balance = new MoneyBalance();
//			balance.setAccountId(1);
////			BigDecimal total3 = new BigDecimal(0);
//			this.finaceService.queryAgentMoneyBalanceListForPage(this.getPage(), balance);
//			
////			for(int m = 0 ;  m <this.getPage().getBeans().size() ; m ++){
////				total3.add(((MoneyBalance)this.getPage().getBeans().get(m)).getFinalMoney());
////			}
//			
//			//6 查询经纪人的提现申请表(已提现总金额)
//			CashApplication cash = new CashApplication();
//			cash.setAccountId(1);
//			this.finaceService.queryAgentCashApplicationForPage(this.getPage(), cash,null,null,null);
			
			
			
			
			
			req.setAttribute("agentUser", agent);
			req.setAttribute("sysUser", sysUser);
			req.setAttribute("total", total1);
			//佣金可结算列表和总额
			req.setAttribute("total_1", total_1);
			req.setAttribute("list1", type1List);
			//客户到访奖励列表和总额
			req.setAttribute("total_2", total_2);
			req.setAttribute("list2", type2List);
			//首次带看列表和总额
			req.setAttribute("total_3", total_3);
			req.setAttribute("list3", type3List);
			//推荐人注册奖励列表和总额
			req.setAttribute("total_4", total_4);
			req.setAttribute("list4", type4List);
			//注册送红包列表和总额
			req.setAttribute("total_5", total_5);
			req.setAttribute("list5", type5List);
			//其他活动列表和总额
			req.setAttribute("total_6", total_6);
			req.setAttribute("list6", type6List);
			//结佣审核办理中
			req.setAttribute("historyList", historyList);
			req.setAttribute("tabId", tabId);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "brokerage";
	}
	
	/**
	 * 佣金记录列表
	 */
	public String money1List(){
		try{
			if(!this.checkLogin()){
				return "login";
			}
			AgentUser agentUser = (AgentUser) this.getSession().get(AGNETINFO_IN_SESSION);
			this.getPage().setOffset(3);
			
			
			//已结佣金
			MoneyBalance balance = new MoneyBalance();
			balance.setAccountId(agentUser.getAccountId());
			this.finaceService.queryAgentMoneyBalanceListForPage(this.getPage(), balance);
			
			
			this.pushJSON("Data", this.getPage().getBeans());
			this.pushJSON("total", this.getPage().getCount());
			this.pushJSON("Status", RESULT_JSON_SUCCESS);
			
		}catch(Exception e){
			this.pushJSON("Status", RESULT_JSON_FAILURE);
			e.printStackTrace();
		}
		
		return RESULT_JSON;
	}
	
	/**
	 * 提现记录列表
	 */
	public String money2List(){
		try{
			if(!this.checkLogin()){
				return "login";
			}
			AgentUser agentUser = (AgentUser) this.getSession().get(AGNETINFO_IN_SESSION);
			this.getPage().setOffset(3);
			
			CashApplication cash = new CashApplication();
			cash.setAccountId(agentUser.getAccountId());
			this.finaceService.queryAgentCashApplicationForPage2(this.getPage(), cash,null,null,null);
			
			
			this.pushJSON("Data", this.getPage().getBeans());
			this.pushJSON("total", this.getPage().getCount());
			this.pushJSON("Status", RESULT_JSON_SUCCESS);
			
		}catch(Exception e){
			this.pushJSON("Status", RESULT_JSON_FAILURE);
			e.printStackTrace();
		}
		
		return RESULT_JSON;
	}
	
	
	/**
	 * 可结佣金页面
	 */
	public String usable(){
		try{
			if(!this.checkLogin()){
				return "login";
			}
			AgentUser agentUser = (AgentUser) this.getSession().get(AGNETINFO_IN_SESSION);
			//查询经纪人的可结佣金列表
			CustomerApplication application = new CustomerApplication();
			//签约状态和经纪人ID必填
			application.setCustomerStatus(Const.CUSTTOMER_STATUS_SIX);
			application.setAgentId(agentUser.getId());
			
			/**暂时查询20条数据*/
			this.getPage().setOffset(20);
			this.getPage().setStart(0);
			this.customerService.queryAgentBrokerage(this.getPage(), application);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "usable";
	}
	
	/**
	 * 佣金结算
	 */
	public String usableApply(){
		try{
			if(!this.checkLogin()){
				return "login";
			}
			 AgentUser agentUser = (AgentUser) this.getSession().get(AGNETINFO_IN_SESSION);
			 SysUser user = agentUser.getUser();
		
			 //账户ID
			 Integer accountId = agentUser.getAccount().getId();

			 CustomerMoney record1 = new CustomerMoney();
			 record1.setAccountId(accountId);
			 record1.setStatus(Const.CLICK_TYPE);
			 List <CustomerMoney> resultList = this.customerService.queryCustomerMoney(record1);
			 
			 for(int i= 0 ; i < resultList.size(); i ++){
				 CustomerMoney app = resultList.get(i);
				  
				 MoneyApplication moneyApp = dealMoneyApp(
						 app.getAmount(),
						 accountId,user.getId(),null,app.getId(),
						 Const.MONEY_STATUS_ING, app.getMoneyType());
				 
				 MoneyDetail detail = dealMoneyDetail(user.getId(),"经纪人申请结佣"); 
				 //更新主表状态
				 app.setStatus(Const.ING_TYPE);
				 
				 if(app.getMoneyType().equals(Const.MONEY_TYPE1)){
					 CustomerApplication application = app.getApp();
					 application.setCustomerStatus(Const.CUSTTOMER_STATUS_SEEVEN);
					 this.finaceService.agentMoneyApplication(moneyApp,detail,application,app);		 
				 }else{
					 this.finaceService.agentMoneyApplication(moneyApp,detail,app);	 
				 }	
			 }
			  
			 this.pushJSON("Status", RESULT_JSON_SUCCESS);
			 
		}catch(Exception e){
			this.pushJSON("Status", RESULT_JSON_FAILURE);
			e.printStackTrace();
		}
		return RESULT_JSON;
	}
	
	//申请成功
	public String applySuccess(){
		return "applySuccess";
	}
	
	//友情提示
	public String attention(){
		try {
			if (!this.checkLogin()) {
				return "login";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "attention";
	}
	
	//活动公告
	public String activity(){
//		try {
//			if (!this.checkLogin()) {
//				return "login";
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return "activity";
	}
	
	//问题帮助
		public String help(){
//			try {
//				if (!this.checkLogin()) {
//					return "login";
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			return "help";
		}
	
		//加入圈子
		public String joins(){
//			try {
//				if (!this.checkLogin()) {
//					return "login";
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			return "joins";
		}	
		
		//会员须知
		public String knows(){
//			try {
//				if (!this.checkLogin()) {
//					return "login";
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			return "knows";
		}	
		
		//关于小帅
		public String about(){
//			try {
//				if (!this.checkLogin()) {
//					return "login";
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			return "about";
		}	
		
	
	//操作成功
	public String operSuccess(){
		try{
			String hid = this.req.getParameter("hid");
			String area = this.req.getParameter("area");
			this.req.setAttribute("hid", hid);
			this.req.setAttribute("area", area);
		}catch (Exception e) {
			e.printStackTrace();
		}
	    return "operSuccess";
	}
	
	//操作失败
	public String operFail(){
		return "operFail";
	}
	
	/**
	 * 会员需知页面
	 */
	public String report(){
		return "report";
	}
	
	/**
	 * 联系我们页面
	 */
	public String contact(){
		return "contact";
	}
	
	/**
	 * 帮助中心
	 */
	public String helpCenter(){
		return "help";
	}
	
	public String cashDetail(){
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "cashDetail";
	}
	
	/**
	 * 现金数据
	 * @return
	 */
	public String cashApplyPage(){
		try{
			if(!this.checkLogin()){
				return "login";
			}
			AgentUser agentUser = (AgentUser) this.getSession().get(AGNETINFO_IN_SESSION);
			//查询经纪人的提现申请表(历史记录)
			MoneyBalance balance = new MoneyBalance();
			balance.setAccountId(agentUser.getAccountId());			
			
			/**暂时查询20条数据*/
			this.getPage().setOffset(20);
			this.getPage().setStart(0);
			this.finaceService.queryAgentMoneyBalanceListForPage(this.getPage(), balance);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "cashApply";
	}
	
	/*
	 * 提现操作
	 */
	public String cashApply() {
		try {
			if(!this.checkLogin()){
				return "login";
			}
			 AgentUser agentUser = (AgentUser) this.getSession().get(AGNETINFO_IN_SESSION);
			 SysUser user = agentUser.getUser();
			 
//			 //更新经纪人的银行卡信息
//			this.agent.setId(agentUser.getId());
//     		this.user.setId(agentUser.getUserId());
//     		this.agent.setUser(this.user);
//     		this.agentService.updateAgentInfo(this.agent);
//     		
//     		/**刷新经纪人信息*/
//     		AgentUser newAgent = this.agentService.selectById(agentUser.getId());
//     		this.pushSession(AGNETINFO_IN_SESSION, newAgent);
			 
			
			//账户ID
			 Integer acountId = agentUser.getAccount().getId();
			 //申请金额
			 BigDecimal amount = new BigDecimal(this.req.getParameter("amount"));
			 SysAccount account = this.accountService.queryAccountById(acountId);
			 
			 if(amount.compareTo(account.getCash()) == 1){
				 return "申请提现金额大于账户可提现金";
			 }
			 
			 CashApplication application = new CashApplication();
			 application.setAmountMoney(amount);
			 application.setAccountId(acountId);
			 application.setApplicationTime(new Date());
			 application.setOperaterId(user.getId());
			 application.setResultStatus(Const.MONEY_STATUS_ING);

			 CashDetail detail = new CashDetail();
			 detail.setOperaterTime(new Date());
			 detail.setOperaterId(user.getId());
			 detail.setResult("经纪人申请提现 金额为" + amount);
			 	 
	         boolean result = this.finaceService.agentCashApplication(application, detail); 
	         this.pushJSON("Status", RESULT_JSON_SUCCESS);
//	         if(result){
//	        	 this.pushJSON("Status", RESULT_JSON_SUCCESS);
//	         }else{
//	        	 this.pushJSON("Status", RESULT_JSON_FAILURE);
//	         }         
			 
		} catch (Exception e) {
			this.pushJSON("Status", RESULT_JSON_FAILURE);
			e.printStackTrace();
		}
		return RESULT_JSON;
	}
	
	/**
	 * 更新银行卡信息
	 */
	public String updateAccountInfo(){
		try{
			if(!this.checkLogin()){
				return "login";
			}
			 AgentUser agentUser = (AgentUser) this.getSession().get(AGNETINFO_IN_SESSION);
			 
			 //更新经纪人的银行卡信息
			this.agent.setId(agentUser.getId());
     		this.user.setId(agentUser.getUserId());
     		this.agent.setUser(this.user);
     		this.agentService.updateAgentInfo(this.agent);
     		
     		/**刷新经纪人信息*/
     		AgentUser newAgent = this.agentService.selectById(agentUser.getId());
     		this.pushSession(AGNETINFO_IN_SESSION, newAgent);
     		this.pushJSON("Status", RESULT_JSON_SUCCESS);
		}catch (Exception e) {
			this.pushJSON("Status", RESULT_JSON_FAILURE);
			e.printStackTrace();
		}
		return RESULT_JSON;
	}
	
	/**
	 * 申诉
	 */
	public String custAppeal(){
		try{
			String cpMsg = this.req.getParameter("cpMsg");
			Integer cid = Integer.parseInt(this.req.getParameter("cid"));
			CustomerApplication application = new CustomerApplication();
			application.setId(cid);
			application.setAppealMsg(cpMsg);
			application.setAppealStatus(APPEAL_STATUS_YES);
			customerService.customerUpdate(application);
			this.pushJSON("Status", RESULT_JSON_SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			this.pushJSON("Status", RESULT_JSON_FAILURE);
		}
		return RESULT_JSON;
	}
	
	/**
	 * 催办
	 */
	public String custPress(){
		try{
			int cid = Integer.parseInt(this.req.getParameter("cid"));
			CustomerApplication customer = new CustomerApplication();
			customer.setId(cid);
			customer.setPresStatus(APPEAL_PRESS_YES);
			this.customerService.customerUpdate(customer);
			this.pushJSON("Status", RESULT_JSON_SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			this.pushJSON("Status", RESULT_JSON_FAILURE);
		}
		return RESULT_JSON;
	}
	
	
	public String myTest1(){
		return "test1";
	}
	
	/**
	 * 微信用户自动登录
	 */
	private String getOpenId()throws IOException{
		
		//如果session中存在openId 直接返回
		if(null != this.getSession().get("openId")){
			return this.getSession().get("openId").toString();
		}
		
		String code = req.getParameter("code");
		
		if(Judge.isEmpty(code)){
			logger.info("未从参数中获取CODE信息，错误的OPENID获取逻辑");
			return "";
		}
		
		//String state = req.getParameter("state");
		String appId = Config.instance().getAppid();
		String secret = Config.instance().getAppSecret();
		
		URL url = new URL("https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appId+"&secret="+secret+"&code=" + code + "&grant_type=authorization_code");
		URLConnection con = url.openConnection();
		InputStreamReader bis = new InputStreamReader(con.getInputStream());
		BufferedReader bf = new BufferedReader(bis);
		String line = "";
		StringBuffer buffer = new StringBuffer();
		while ((line = bf.readLine()) != null) {
			buffer.append(line);
		}
		bis.close();
		JSONObject jo = JSONObject.fromObject(buffer.toString());
		String open_id = jo.getString("openid");
//		String a_token = jo.getString("access_token");
//		
//		//获取用户信息
//		url = new URL("https://api.weixin.qq.com/sns/userinfo?access_token=" + a_token + "&openid=" + open_id + "&lang=zh_CN");
//		con = url.openConnection();
//		bis = new InputStreamReader(con.getInputStream(),"utf-8");
//		bf = new BufferedReader(bis);
//		line = "";
//		buffer = new StringBuffer();
//		while ((line = bf.readLine()) != null) {
//			buffer.append(line);
//		}
//		bis.close();
//		
//		jo = JSONObject.fromObject(buffer.toString());
//		System.out.println(jo.getString("nickname"));
		//把openId放入session
		this.pushSession("openId", open_id);
		//String open_id = "ojMT5txpoLl4VfLQm2xHC30jf-v0";
		return open_id;
	}
	
	public void weiValidate() throws IOException{
		WechatSupport support = new WechatSupportImpl(req);
		String result = support.execute();
		this.response(resp, result);
		
    }
    
    private void response(HttpServletResponse response, String content) throws IOException {
    	if(content.startsWith("<xml/>")){
    		response.getOutputStream().write("".getBytes());
    		return;
    	}
        response.getOutputStream().write(content.getBytes("utf-8"));
	}
    
    /**
     * 登录校验
     * @return
     */
    public boolean checkLogin()throws IOException{
    	boolean isLogin = false;
    	AgentUser agentUser = (AgentUser) this.getSession().get(AGNETINFO_IN_SESSION);
    	if(null == agentUser){
    		AgentUser agentUser2 = new AgentUser();
    		//agentUser2.setWechatId(this.getOpenId());
    		//agentUser2.setPhoneDecimal("");
    		//agentUser2 = housesService.queryAgentUser(agentUser2);
			if (null != agentUser2) {
//				if (agentUser2.getAutoLogin() == 1) {
//					pushSession(AGNETINFO_IN_SESSION, agentUser2);
//					isLogin = true;
//				}
			}
    	}
    	else{
    		isLogin = true;
    	}
    	
    	return isLogin;
    }
    
    
    
    /*
     * 获取微信用户accessToken
     */
    public String getAccessToken()throws IOException{
    	String accessToken = "" ;
    	String appId = Config.instance().getAppid();
		String secret = Config.instance().getAppSecret();
    	URL url = new URL("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appId+"&secret="+secret);
		URLConnection con = url.openConnection();
		InputStreamReader bis = new InputStreamReader(con.getInputStream());
		BufferedReader bf = new BufferedReader(bis);
		String line = "";
		StringBuffer buffer = new StringBuffer();
		while ((line = bf.readLine()) != null) {
			buffer.append(line);
		}
		JSONObject jo = JSONObject.fromObject(buffer.toString());
		accessToken = jo.getString("access_token");
    	return accessToken;
    }
    
    /*
     * 获取微信用户昵称
     */
    public String getNickName()throws IOException{
    	String nickName = "" ;
    	String appId = Config.instance().getAppid();
		String secret = Config.instance().getAppSecret();
    	URL url = new URL("https://api.weixin.qq.com/cgi-bin/user/info?access_token="+getAccessToken()+"&openid="+getOpenId()+"&lang=zh_CN");
		URLConnection con = url.openConnection();
		InputStreamReader bis = new InputStreamReader(con.getInputStream(),"utf-8");
		BufferedReader bf = new BufferedReader(bis);
		String line = "";
		StringBuffer buffer = new StringBuffer();
		while ((line = bf.readLine()) != null) {
			buffer.append(line);
		}
		JSONObject jo = JSONObject.fromObject(buffer.toString());
		nickName = jo.getString("nickname");
        String regex = "([\ud800-\udbff\udc00-\udfff])";
        nickName = nickName.replaceAll(regex, "*");
        System.out.println(nickName);  
		//this.pushJSON("nickname", nickName);
    	return nickName;
		//return RESULT_JSON;
    }
    
    /**
     * 发送手机验证码
     * @return
     */
    public String sendRegMsg(){
    	try{
    		boolean result = false;
    		String phone = this.req.getParameter("phone");
    		if(null != phone || !"".equals(phone)){
    			 result = this.api.sendValidateCode(phone, 2);
    		}
    		if(result){
    		    this.pushJSON("Status", RESULT_JSON_SUCCESS);
    		}
    		else{
    			this.pushJSON("Status", RESULT_JSON_FAILURE);
    		}
    		
    	}catch (Exception e) {
    		this.pushJSON("Status", RESULT_JSON_FAILURE);
			e.printStackTrace();
		}
    	return RESULT_JSON;
    }
    
    /**
     * 验证手机验证码
     * @return
     */
    public String validateRegMsg(){
    	try{
    		String phone = this.req.getParameter("phone");
    		String code = this.req.getParameter("code");
    		int status = this.api.validateCode(phone, code);
    		String msg = "未知错误";
			switch (status) {
			case 1:
				  msg = "正确";
				  break;
			case 2:
				  msg = "已过期";
				  break;
			case 3:
				  msg = "验证码错误";
				  break;
			case 4:
				  msg = "不存在的验证码";
				  break;

			default:
				break;
			}
			this.pushJSON("Status", status);
			this.pushJSON("Msg", msg);
    	}catch (Exception e) {
			e.printStackTrace();
			this.pushJSON("Status", 5);
			this.pushJSON("Msg", "系统错误");
		}
    	return RESULT_JSON;
    }
    
    /*
     * 我推荐的经纪人列表
     */
    public String myRefersList(){
    	try{
    		if(!this.checkLogin()){
				return "login";
			}
			AgentUser agentUser = (AgentUser) this.getSession().get(AGNETINFO_IN_SESSION);
			
    		//3 推荐奖申请
    		CustomerMoney record2 = new CustomerMoney();	
    		record2.setAccountId(agentUser.getAccountId());
    		record2.setStatus(Const.ABLE_TYPE);
    		record2.setMoneyType(Const.MONEY_TYPE4);
    		List <CustomerMoney> regList = this.customerService.queryCustomerMoney(record2);	
			
			List<AgentUser> myRefers = this.agentService.selectByReferId(agentUser.getId());
			this.req.setAttribute("myRefers", myRefers);
			if(null == regList || regList.isEmpty()){
				this.req.setAttribute("regCount", 0);
			}
			else{
				this.req.setAttribute("regCount", 1);
			}
			
    	}catch (Exception e) {
			e.printStackTrace();
		}
    	return "refers";
    }
    
    /**
     * 推荐奖申请
     * @return
     */
    public String applyReferReward(){
    	try{
    		if(!this.checkLogin()){
				return "login";
			}
			AgentUser agentUser = (AgentUser) this.getSession().get(AGNETINFO_IN_SESSION);
    		//3 推荐奖申请
    		CustomerMoney record2 = new CustomerMoney();	
    		record2.setAccountId(agentUser.getAccountId());
    		record2.setStatus(Const.ABLE_TYPE);
    		record2.setMoneyType(Const.MONEY_TYPE4);
    		List <CustomerMoney> regList = this.customerService.queryCustomerMoney(record2);

    		for(int k = 0 ; k < regList.size() ; k ++){
    			CustomerMoney updateRecord = regList.get(k);
    			updateRecord.setStatus(Const.CLICK_TYPE);
    			regList.set(k, updateRecord);
    		}
    		boolean result = this.customerService.updateCustomerMoney(regList);
    		if(result){
    		    this.pushJSON("Status", RESULT_JSON_SUCCESS);
    		}
    		else{
    			this.pushJSON("Status", RESULT_JSON_FAILURE);
    		}
    	}catch (Exception e) {
    		this.pushJSON("Status", RESULT_JSON_FAILURE);
			e.printStackTrace();
		}
    	return RESULT_JSON;
    }
    
    /**
     * 个人中心页面 展示
     * @return
     */
    public String personCenter(){
    	try{
    		if(!this.checkLogin()){
				return "login";
			}
			AgentUser agentUser = (AgentUser) this.getSession().get(AGNETINFO_IN_SESSION);
			agentUser = this.agentService.selectById(agentUser.getId());
    		this.pushSession(AGNETINFO_IN_SESSION, agentUser);
    		//经纪人的上线和下线信息
    		agentTopOrBottom(agentUser);
			this.req.setAttribute("agentUser", agentUser);
    	}catch (Exception e) {
			e.printStackTrace();
		}
    	return "person";
    }
    
    /**
     * 个人中心页面 编辑
     * @return
     */
    public String personEdit(){
    	try{
    		if(!this.checkLogin()){
				return "login";
			}
			AgentUser agentUser = (AgentUser) this.getSession().get(AGNETINFO_IN_SESSION);
			agentUser = this.agentService.selectById(agentUser.getId());
			this.pushSession(AGNETINFO_IN_SESSION, agentUser);
			List<Area> areas = this.areaService.queryAreaByCity(1);
			this.req.setAttribute("areas", areas);
			this.req.setAttribute("agentUser", agentUser);
    	}catch (Exception e) {
			e.printStackTrace();
		}
    	return "person2";
    }
    
    /*
     * 编辑用户信息
     */
    public String editUser(){
    	try{
    		String backPwd = this.req.getParameter("pwd");
    		AgentUser agentUser = (AgentUser) this.getSession().get(AGNETINFO_IN_SESSION);
    		/**如果填写的原密码和数据库存的密码不一致 返回错误信息*/
    		if(!agentUser.getUser().getPwdCode().equals(MD5Util.string2MD5(backPwd))){
    			this.pushJSON("Status", 3);
    		}
    		else{
    			this.agent.setId(agentUser.getId());
        		this.user.setId(agentUser.getUserId());
        		this.user.setPwdCode(MD5Util.string2MD5(this.user.getPwdCode()));
        		this.agent.setUser(this.user);
        		this.agentService.updateAgentInfo(this.agent);
        		
        		/**登录结束要不要重新登录?*/
        		AgentUser newAgent = this.agentService.selectById(agentUser.getId());
        		
        		/**如果从自动登录变为安全登录 则需要清空session信息*/
				if (newAgent.getAutoLogin() == 0
						&& agentUser.getAutoLogin() == 1) {
					this.pushSession(AGNETINFO_IN_SESSION, null);

				} else {
					this.pushSession(AGNETINFO_IN_SESSION, newAgent);
				}
        		this.pushJSON("Status", RESULT_JSON_SUCCESS);
    		}
    		
    		
    	}catch (Exception e) {
    		this.pushJSON("Status", RESULT_JSON_FAILURE);
			e.printStackTrace();
		}
    	return RESULT_JSON;
    }
    
    /**
     * 申请结佣奖励
     * @return
     */
    public String apply1(){
    	try{
    		if(!this.checkLogin()){
				return "login";
			}
			AgentUser agentUser = (AgentUser) this.getSession().get(AGNETINFO_IN_SESSION);
    		//账户ID
    		Integer accountId = agentUser.getAccount().getId();	
    		//客户ID
    		Integer customerApplicationId = Integer.parseInt(this.req.getParameter("cid"));
    		
    		CustomerApplication updateBean = new CustomerApplication();
    		updateBean.setId(customerApplicationId);
    		updateBean = this.customerService.queryCustomer(updateBean);
    		
    		CustomerMoney record = new CustomerMoney();
    		record.setAccountId(accountId);
    		record.setCustomerId(customerApplicationId);
    		record.setStatus(Const.ABLE_TYPE);
    		
    		//签约结佣奖励
    		record.setMoneyType(Const.MONEY_TYPE1);
    		dealResult (record,"经纪人点击签约结佣奖励");
    		//更新状态
    		updateBean.setMoneyStatus(0);
    		this.customerService.updateCustomerApplication(updateBean);
    	
    		this.pushJSON("Status", RESULT_JSON_SUCCESS);
    	}catch (Exception e) {
    		this.pushJSON("Status", RESULT_JSON_FAILURE);
			e.printStackTrace();
		}
    	return RESULT_JSON;
    }
    
    /**
     * 申请到访奖励
     * @return
     */
    public String apply2(){
    	try{
    		if(!this.checkLogin()){
				return "login";
			}
			AgentUser agentUser = (AgentUser) this.getSession().get(AGNETINFO_IN_SESSION);
    		//账户ID
    		Integer accountId = agentUser.getAccount().getId();	
    		//客户ID
    		Integer customerApplicationId = Integer.parseInt(this.req.getParameter("cid"));;
    		
    		CustomerApplication updateBean = new CustomerApplication();
    		updateBean.setId(customerApplicationId);
    		updateBean = this.customerService.queryCustomer(updateBean);
    		
    		CustomerMoney record = new CustomerMoney();
    		record.setAccountId(accountId);
    		record.setCustomerId(customerApplicationId);
    		record.setStatus(Const.ABLE_TYPE);
    		record.setMoneyType(Const.MONEY_TYPE2);
    		dealResult (record,"经纪人点击申请到访奖励");
    		//更新状态
    		updateBean.setArrivedStatus(0);
    		this.customerService.updateCustomerApplication(updateBean);
    		
    		this.pushJSON("Status", RESULT_JSON_SUCCESS);
    	}catch (Exception e) {
    		this.pushJSON("Status", RESULT_JSON_FAILURE);
			e.printStackTrace();
		}
    	return RESULT_JSON;
    }
    
    /**
     * 申请带看奖励
     * @return
     */
    public String apply3(){
    	try{
    		if(!this.checkLogin()){
				return "login";
			}
			AgentUser agentUser = (AgentUser) this.getSession().get(AGNETINFO_IN_SESSION);
    		//账户ID
    		Integer accountId = agentUser.getAccount().getId();	
    		//客户ID
    		Integer customerApplicationId = Integer.parseInt(this.req.getParameter("cid"));;
    		
    		CustomerApplication updateBean = new CustomerApplication();
    		updateBean.setId(customerApplicationId);
    		updateBean = this.customerService.queryCustomer(updateBean);
    		
    		CustomerMoney record = new CustomerMoney();
    		//申请带看奖
    		record.setAccountId(accountId);
    		record.setCustomerId(customerApplicationId);
    		record.setStatus(Const.ABLE_TYPE);
    		record.setMoneyType(Const.MONEY_TYPE3);
    		dealResult (record,"经纪人点击申请带看奖励");
    		//更新状态
    		updateBean.setLookStatus(0);
    		this.customerService.updateCustomerApplication(updateBean);
    		
    		this.pushJSON("Status", RESULT_JSON_SUCCESS);
    	}catch (Exception e) {
    		this.pushJSON("Status", RESULT_JSON_FAILURE);
			e.printStackTrace();
		}
    	return RESULT_JSON;
    }
    
    private static MoneyApplication dealMoneyApp(BigDecimal amount,Integer accountId, Integer operatId , Integer pmId,
    		Integer customerId,Integer resultStatus ,Integer appType){
    	 MoneyApplication moneyApp = new MoneyApplication();
    	 moneyApp.setAmountMoney(amount);
		 moneyApp.setAccountId(accountId);
		 moneyApp.setApplicationTime(new Date());
		 moneyApp.setOperaterId(operatId);
		 moneyApp.setPmId(pmId);
		 moneyApp.setCustomerId(customerId);
		 moneyApp.setResultStatus(resultStatus);
		 moneyApp.setAppType(appType);
    	 
    	 return moneyApp;
    }
	 
	private static  MoneyDetail dealMoneyDetail (Integer operatId, String result){
		 MoneyDetail detail = new MoneyDetail();
		 detail.setOperaterTime(new Date());
		 detail.setOperaterId(operatId);
		 detail.setResult(result);
		 return detail;	
	} 
	
	private Boolean dealResult(CustomerMoney record ,String remark){
		Boolean result = false;
        List <CustomerMoney> records = this.customerService.queryCustomerMoney(record);
		
		if(Judge.isNotNull(records) && records.size() > 0 ){
			//固定取一条
			record = records.get(0);
			record.setStatus(Const.CLICK_TYPE);
			record.setRemark(remark);
			result =  this.customerService.insertOrupdateCustomerMoney(record);
			
			//增加可结佣金账户金额
			if(result){	
				accountService.clickMoney(record.getAccountId(), record.getAmount(),record.getMoneyType());	
			}
		}
		return result;
	}
	
	public String cbSuccess(){
		try{
			int cId = Integer.parseInt(this.req.getParameter("cId"));
			this.req.setAttribute("cId", cId);
		}catch (Exception e) {
			e.printStackTrace();
		}
	    return "cbSuccess";
	}
	
	public String readRecord(){
		try {
			Integer id = Integer.parseInt(req.getParameter("rId"));
			CustomeRecord record = new CustomeRecord();
			record.setId(id);
			record.setMessageType(1);
			this.customerService.insertOrUpdateCustomeRecord(record);
			this.pushJSON("Status", 0);
		} catch (Exception e) {
			this.pushJSON("Status", 1);
			e.printStackTrace();
		}

		return RESULT_JSON;
	}
	
	public String checkSpeAgent(){
		try{
			Integer agentId = Integer.parseInt(this.req.getParameter("agentId"));
			AgentUser agentUser = this.agentService.selectById(agentId);
			if(null != agentUser.getUser().getRealName() && !"".equals(agentUser.getUser().getRealName())){
				this.pushJSON("Status", RESULT_JSON_FAILURE);
			}
			else{
				this.pushJSON("Status", RESULT_JSON_SUCCESS);
			}
		}catch (Exception e) {
			this.pushJSON("Status",3);
			e.printStackTrace();
		}
		return RESULT_JSON;
	}
	
	public void agentTopOrBottom(AgentUser agentUser){
		//个人上线和下线信息查询
		
		//1：查询经纪人有没有上线
//		StoreAgent top = this.agentService.queryTopByAgentId(agentUser.getId());
//		if(null != top){
//		   this.req.setAttribute("top", top);
//		   this.req.setAttribute("storeStatus", 1);
//		   return;
//		}
		
		//2:查询有没有被邀请信息
		StoreAgent invited = this.agentService.queryInviteByAgentId(agentUser.getId());
		if(null != invited){
		   this.req.setAttribute("invited", invited);
//		   this.req.setAttribute("storeStatus", 2);
//		   return;
		}
		
		//3 or 4:查询经纪人有没有下线
//		List<StoreAgent> bottom = this.agentService.queryBottomByStoreId(agentUser.getId());
//		if(null != bottom && !bottom.isEmpty()){
//			this.req.setAttribute("storeStatus", 3);
//		}else{
//			this.req.setAttribute("storeStatus", 4);
//		}
		
		//查询自己邀请中的经纪人列表
		List<StoreAgent> inviting = this.agentService.queryInviteByStoreId(agentUser.getId());
		this.req.setAttribute("inviting", inviting);
	}
	
	//邀请下线页面
	public String invite(){
		try{
			if(!this.checkLogin()){
				return "login";
			}
			AgentUser agentUser = (AgentUser) this.getSession().get(AGNETINFO_IN_SESSION);
			this.req.setAttribute("storeId", agentUser.getId());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	    return "invite";
	}
	
	//邀请下线逻辑处理
	public String inviting(){
		try{
			if(!this.checkLogin()){
				return "login";
			}
			this.storeAgent.setStatus(STORE_STATUS_INVITE);
			Integer result = this.agentService.inviteAgent(this.storeAgent);
			this.pushJSON("Status",result);
		}catch (Exception e) {
			this.pushJSON("Status",-1);
			e.printStackTrace();
		}
		return RESULT_JSON;
	}
	
	//邀请下线页面
	public String invitedInfo(){
		try{
			if(!this.checkLogin()){
				return "login";
			}
			AgentUser agentUser = (AgentUser) this.getSession().get(AGNETINFO_IN_SESSION);
			StoreAgent storeAgent = this.agentService.queryInviteByAgentId(agentUser.getId());
			this.req.setAttribute("storeAgent", storeAgent);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	    return "invite2";
	}
	
	//接受邀请
	public String acceptStore(){
		try{
			if(!this.checkLogin()){
				return "login";
			}
			this.storeAgent.setStatus(STORE_STATUS_AGREE);
			this.agentService.updateStoreInfo(this.storeAgent);
			this.pushJSON("Status",RESULT_JSON_SUCCESS);
		}catch (Exception e) {
			this.pushJSON("Status",RESULT_JSON_FAILURE);
			e.printStackTrace();
		}
		return RESULT_JSON;
	}
	
	//拒绝邀请
	public String refuseStore(){
		try{
			if(!this.checkLogin()){
				return "login";
			}
			this.storeAgent.setStatus(STORE_STATUS_REFUSE);
			this.agentService.updateStoreInfo(this.storeAgent);
			this.pushJSON("Status",RESULT_JSON_SUCCESS);
		}catch (Exception e) {
			this.pushJSON("Status",RESULT_JSON_FAILURE);
			e.printStackTrace();
		}
		return RESULT_JSON;
	}
	
	//取消所有邀请
	public String concelStore(){
		try{
			if(!this.checkLogin()){
				return "login";
			}
			AgentUser agentUser = (AgentUser) this.getSession().get(AGNETINFO_IN_SESSION);
			this.agentService.concelAllStoreAgent(agentUser.getId());
			this.pushJSON("Status",RESULT_JSON_SUCCESS);
		}catch (Exception e) {
			this.pushJSON("Status",RESULT_JSON_FAILURE);
			e.printStackTrace();
		}
		return RESULT_JSON;
	}
	
	//退出上线下线关系
	public String exitStore(){
		try{
			if(!this.checkLogin()){
				return "login";
			}
			Integer id = Integer.parseInt(this.req.getParameter("id"));
			this.agentService.delStoreInfoById(id);
			this.pushJSON("Status",RESULT_JSON_SUCCESS);
		}catch (Exception e) {
			this.pushJSON("Status",RESULT_JSON_FAILURE);
			e.printStackTrace();
		}
		return RESULT_JSON;
	}
	
	//下线列表页面
	public String offlinePage(){
		try{
			if(!this.checkLogin()){
				return "login";
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	    return "offline";
	}
	
	public String offline(){
		try{
			if(!this.checkLogin()){
				return "login";
			}
			this.getPage().setOffset(10);
			
			String  roomId = req.getParameter("roomCode");
			if(null == this.checkInfo){
				this.checkInfo = new RoomCheckinfo();
				this.checkInfo.setCheckRoomId(roomId);
			}
			
			this.roomCheckinfoService.queryCheckInfoForPage(this.getPage(), this.checkInfo);
			
			this.pushJSON("Data", this.getPage().getBeans());
			this.pushJSON("total", this.getPage().getCount());
			this.pushJSON("Status", RESULT_JSON_SUCCESS);
			
		}catch(Exception e){
			this.pushJSON("Status", RESULT_JSON_FAILURE);
			e.printStackTrace();
		}
		
		return RESULT_JSON;
	}
	
	
	
	//上线列表页面
	public String topPage(){
		try{
			if(!this.checkLogin()){
				return "login";
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	    return "topline";
	}
	
	public String topline(){
		try{
			if(!this.checkLogin()){
				return "login";
			}
			AgentUser agentUser = (AgentUser) this.getSession().get(AGNETINFO_IN_SESSION);
			this.getPage().setOffset(3);
			
			
			//下线经纪人列表
			StoreAgent storeAgent = new StoreAgent();
			storeAgent.setAgentId(agentUser.getId());
			storeAgent.setStatus(STORE_STATUS_AGREE);
			this.agentService.queryStoreAgentListForPage(this.getPage(), storeAgent);
			
			this.pushJSON("Data", this.getPage().getBeans());
			this.pushJSON("total", this.getPage().getCount());
			this.pushJSON("Status", RESULT_JSON_SUCCESS);
			
		}catch(Exception e){
			this.pushJSON("Status", RESULT_JSON_FAILURE);
			e.printStackTrace();
		}
		
		return RESULT_JSON;
	}
	
	public String inviteFail(){
		try{
			Integer reason = Integer.parseInt(this.req.getParameter("reason"));
			String  errorMsg = "不能邀请该用户!";
			switch (reason) {
			case 2:
				errorMsg = "查询不到此经纪人";
				break;
			case 3:
				errorMsg = "您邀请的经纪人已经是别人的下线了";
				break;
			case 4:
				errorMsg = "该经纪人已是上线，您不能邀请此经纪人";
				break;
			case 5:
				errorMsg = "您暂时不能邀请此经纪人";
				break;
			case 6:
				errorMsg = "您邀请的经纪人已经被邀请下线中";
				break;
			case 7:
				errorMsg = "您有一条下线邀请还未处理，暂不能邀请其他经纪人";
				break;
			case 8:
				errorMsg = "您已成为下线，不能邀请其他经纪人";
				break;
			case 9:
				errorMsg = "您不能邀请自己";
				break;
			case 10:
				errorMsg = "您邀请的人已经是您的下线";
				break;

			default:
				break;
			}
			
			this.req.setAttribute("errorMsg", errorMsg);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "inviteFail";
	}
	
	
	private OperateRecord logBean(int agentId , JSONArray custArray){
		OperateRecord bean = new OperateRecord();
		bean.setOperateType(10);
		bean.setOperateTime(new Date());
		bean.setUserId(agentId);
		bean.setUserType(Const.WECHAT_TYPE);
		String content = "推荐客户  经纪人ID :" + agentId + "  推荐客户手机号:";
		
		for(int i = 0 ; i < custArray.size(); i++){
			JSONObject custInfo = custArray.getJSONObject(i);
			content += custInfo.getString("cusPhone");
		}
		bean.setOperateContent(content);
		
		return bean;
	}
		
	public String save_check(){
		if(Judge.isNotNull(this.checkInfo)){
			this.checkInfo.setCheckDate(new Date());
			
			AgentUser agentUser = (AgentUser) this.getSession().get(AGNETINFO_IN_SESSION);
			this.checkInfo.setCheckUserId(agentUser.getPhoneDecimal());
		}
		
		boolean rslt = this.roomCheckinfoService.saveRoomCheckInfo(this.checkInfo);
		req.setAttribute("hid", this.buildingNo);
		req.setAttribute("roomCode", this.checkInfo.getCheckRoomId());
		req.setAttribute("totals", this.checkInfo.getCheckResult());
		String  flag =  rslt ? "operSuccess" : "operFail";
		
		return flag;
	}

	public String detail_check(){
		this.checkInfo = this.roomCheckinfoService.queryCheckInfoByid(this.checkInfo);
		return "detailCheck";
	}

	

	public String getBuildingNo() {
		return buildingNo;
	}


	public void setBuildingNo(String buildingNo) {
		this.buildingNo = buildingNo;
	}
	
}
