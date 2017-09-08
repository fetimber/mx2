package net.huimin.yk.web.actions.admin;

import java.util.List;

import javax.annotation.Resource;

import net.huimin.common.helper.DateHelper;
import net.huimin.common.helper.EmptyBean;
import net.huimin.common.helper.Judge;
import net.huimin.common.mvc.AbstractAction;
import net.huimin.common.page.PageBean;
import net.huimin.yk.channel.msg.MessageAPI;
import net.huimin.yk.web.model.agent.AgentQueryParameter;
import net.huimin.yk.web.model.agent.AgentUser;
import net.huimin.yk.web.model.agent.Store;
import net.huimin.yk.web.model.common.Files;
import net.huimin.yk.web.model.customer.CustomeRecord;
import net.huimin.yk.web.model.customer.CustomerApplication;
import net.huimin.yk.web.model.system.SysRole;
import net.huimin.yk.web.services.common.AreaService;
import net.huimin.yk.web.services.customer.CustomerService;
import net.huimin.yk.web.services.houses.HousesService;
import net.huimin.yk.web.services.system.AgentService;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 经纪人管理
 * @author Administrator
 *
 */

public class AgentAction extends AbstractAction{
 
    private AgentUser agentUser;
	
    @Autowired
    private AgentService agentService;
    
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private AreaService areaService;
    
	@Resource
	private MessageAPI api;
    
    @Autowired
    private HousesService housesService;
    
    private AgentQueryParameter query;
    
    private Store store;
    
	public String view() {
		
		this.getPage().setOffset(10);
		this.agentService.queryAgentListForPage(this.getPage(),this.query);
		
		return "view";
	}
  
	public String check(){
		Boolean result = false;
		if(Judge.isNotNull(this.agentUser)
				&& Judge.isNotNull(this.agentUser.getId())){
			this.agentUser = agentService.selectById(this.agentUser.getId());
			result = true;
		}
		
		return result ? "check": RESULT_ERROR;
	}
	
	
	public String confirm(){
		this.pushRequest("result", Boolean.TRUE);
		this.pushRequest("message",  "更新成功");
		if(Judge.isNotNull(this.agentUser)){			
			Boolean result = this.agentService.insertOrUpdateAgent(this.agentUser);
			if(result){
				//插入经纪人跟进数据
				if(!agentUser.getRealNameValidate().equals(1)){
					CustomeRecord record = EmptyBean.customerRecord(100, this.agentUser.getUser().getId(), 
							this.logined(false).getId(), this.logined(false).getRoleId(), "经纪人跟进   " +  DateHelper.dateToString(this.agentUser.getDealTime()) + "  " + this.agentUser.getDealContent());
					this.customerService.insertOrUpdateCustomeRecord(record);
					
				}else{
					AgentUser agentUser2 = this.agentService.selectById(this.agentUser.getId());
					api.send(agentUser.getUser().getId(), "恭喜您升级成为专业经纪人！我们会优先为您提供服务。您还可以推荐您的经纪人朋友注册，一起用更帅的方式赚钱！");
					api.sendWechatTextMsg(agentUser2.getWechatId(), "恭喜您升级成为专业经纪人！我们会优先为您提供服务。您还可以推荐您的经纪人朋友注册，一起用更帅的方式赚钱！");
				}
			    
				
				this.agentUser = null;
				this.pushRequest("result", Boolean.TRUE);
				this.pushRequest("message", "保存完成，数据已更新");
			}
		}else {
			this.pushRequest("message",  "无法新增保存,仅在修改后保存");
		}
		
		return this.view();
	}
	
	public String detail(){
		this.agentUser = agentService.selectById(this.agentUser.getId());
		return "detail";
	}
	
    public String history(){
    	Boolean result = false;
		if(Judge.isNotNull(this.agentUser)
				&& Judge.isNotNull(this.agentUser.getId())){
			//根据某一个经纪人查询 相关推荐客户记录
			CustomerApplication customerApplication  = new CustomerApplication();
			customerApplication.setAgentId(this.agentUser.getId());
			customerService.queryCustomerListForPage(this.getPage(), customerApplication);
			
			result = true;
		}
		
		return result ? "history": RESULT_ERROR;
	}
    
    public String load_pic() {
    	List<Files> pictures = this.agentService.queryFilesForAgentComfirm(this.getAgentUser().getUserId());	
    	this.pushRequest("pictures", pictures);
    	
    	 
    	return "check-picture";
	}
	
    //查询门店列表
    public String store(){

    	this.agentService.queryStoreListForPage(this.getPage(),store);
    	return "store";
    }
    
    //新增门店
    public String store_add(){
    	if(Judge.isNotNull(this.store)){
    		this.store  = this.agentService.queryStoreInfoByid(this.store.getId());
    	}
    	return "store-add";
    }
    
    //校验门店名称
	public String check_storename() {
		boolean rslt = this.agentService.checkStoreName(this.store);
		return this.jsonValidate(rslt);
	}
    
    //新增修改门店
    public String store_save(){
    	Boolean result = false;
    	if(Judge.isNotNull(this.store)){
    		Boolean checkFlag = agentService.checkStoreName(this.store);
			
			if(checkFlag){
				result = this.agentService.saveOrUpdateStore(this.store);
				
				if(result){
					this.store = null;
				} else {
					this.pushRequest("message",  "更新失败");
				}
			}else{
				this.pushRequest("message",  "存在相同门店名称,请修改后保存");	
			}	
		}else {
			this.pushRequest("message",  "无法新增保存,仅在修改后保存");
		}
    	
    	return result ? this.store() : this.store_add();
    }
    
    //删除门店
    public String store_detele(){
    	this.agentService.queryStoreListForPage(this.getPage(),store);
    	return "store";
    }
    
    //门店经纪人管理
    public String store_agent(){
    	this.agentService.queryStoreListForPage(this.getPage(),store);
    	return "store";
    }
    
    //上线经纪人管理
    public String superior(){
    	this.getPage().setOffset(10);
		this.agentService.querySuperiorListForPage(this.getPage(),this.query);
    	return "superior";
    }
    
    //下线经纪人管理
    public String subordinate(){
    	this.getPage().setOffset(10);
    	this.agentService.querySubordinateListForPage(this.getPage(),this.query);
    	return "subordinate";
    }
    
	public AgentUser getAgentUser() {
		return agentUser;
	}

	public void setAgentUser(AgentUser agentUser) {
		this.agentUser = agentUser;
	}

	public AgentQueryParameter getQuery() {
		return query;
	}

	public void setQuery(AgentQueryParameter query) {
		this.query = query;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
	
	
}
