package net.huimin.yk.web.services.system.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.huimin.common.helper.Judge;
import net.huimin.common.page.PageBean;
import net.huimin.yk.web.dao.agent.AgentUserMapper;
import net.huimin.yk.web.dao.agent.StoreAgentMapper;
import net.huimin.yk.web.dao.agent.StoreMapper;
import net.huimin.yk.web.dao.common.FilesMapper;
import net.huimin.yk.web.dao.system.SysUserMapper;
import net.huimin.yk.web.model.agent.AgentQueryParameter;
import net.huimin.yk.web.model.agent.AgentUser;
import net.huimin.yk.web.model.agent.Store;
import net.huimin.yk.web.model.agent.StoreAgent;
import net.huimin.yk.web.model.common.Files;
import net.huimin.yk.web.services.common.AccountService;
import net.huimin.yk.web.services.system.AgentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AgentServiceImpl implements AgentService {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AgentUserMapper agentUserMapper;
	
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private FilesMapper filesMapper;
	
	@Autowired
	private StoreMapper storeMapper;
	
	@Autowired
	private StoreAgentMapper storeAgentMapper;
	
	
	public void queryAgentListForPage(PageBean page, AgentQueryParameter query) {
		if(Judge.isNotNull(query)){
			query.setPage(page);
		}
		if(Judge.isNull(query)){
			query = new AgentQueryParameter();
			query.setOrder(0);
			query.setPage(page);
		}
		
		Integer count = this.agentUserMapper.queryCountByConditions(query);
		List<AgentUser> agents = this.agentUserMapper.queryAgentByConditions(query);
		PageBean.Counter(page, count, page.getCurrent(), agents);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void updateAgentInfo(AgentUser agentUser) throws Exception{
		try{
		    this.agentUserMapper.updateByPrimaryKeySelective(agentUser);
		    this.sysUserMapper.updateByPrimaryKeySelective(agentUser.getUser());
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	public AgentUser selectById(Integer id) {
		return this.agentUserMapper.selectByPrimaryKey(id);
	}

	public Boolean insertOrUpdateAgent(AgentUser agentUser) {
		Boolean result = false;
		if(Judge.isNotNull(agentUser.getUser())){
			this.sysUserMapper.updateByPrimaryKeySelective(agentUser.getUser());
		}
		
		if(Judge.isNull(agentUser.getId())){
			result  = this.agentUserMapper.insertSelective(agentUser) == 1;
		}else{
			result  = this.agentUserMapper.updateByPrimaryKeySelective(agentUser) == 1;
		}

		//初次验证时增加推荐奖励
		if(result &&  Judge.isNotNull(agentUser.getRealNameValidate())
				&&  agentUser.getRealNameValidate().equals(1)){			
			
			if(Judge.isNotNull(agentUser.getReferId())){
				AgentUser referUser= this.agentUserMapper.selectByPrimaryKey(agentUser.getReferId());
				this.accountService.openRefferMoney(referUser.getAccountId(),agentUser.getReferId());	
			}
		
		}	
		
		return result;		
	}

	public List<Files> queryFilesForAgentComfirm(Integer agent) {
		return this.filesMapper.queryFilesForAgentComfirm(agent);
	}
	
	
	public void queryStoreListForPage(PageBean page, Store query) {
		
		if(Judge.isNull(query)){
			query = new Store();
		}
  
		 Map<String, Object> parameters  = new HashMap<String, Object>();
		 parameters.put("param", query);
		 parameters.put("start", page.getStart());
		 parameters.put("offset", page.getOffset());
		 
		 Integer count = this.storeMapper.queryStoresCountByConditions(parameters);
		 List<Store> stores = this.storeMapper.queryStoresByConditions(parameters);
			
		PageBean.Counter(page, count, page.getCurrent(), stores);
	}
	

	public List<AgentUser> selectByReferId(Integer agentId) {
        return this.agentUserMapper.selectByReferId(agentId);
	}

	public Boolean insertOrUpdateAgent2(AgentUser agentUser) {
		Boolean result = false;	
		if(Judge.isNull(agentUser.getId())){
			result  = this.agentUserMapper.insertSelective(agentUser) == 1;
			          this.sysUserMapper.insertSelective(agentUser.getUser());
		}else{
			result  = this.agentUserMapper.updateByPrimaryKeySelective(agentUser) == 1;
			          this.sysUserMapper.updateByPrimaryKeySelective(agentUser.getUser());
		}
		return result;
	}

	
	
	public boolean checkStoreName(Store store) {	
		boolean rslt = false;
		try {
			rslt = this.storeMapper.checkStoreName(store) == 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rslt;
	}

	public boolean saveOrUpdateStore(Store store) {
		Boolean result = false;
		if(Judge.isNull(store.getId())){
			result = this.storeMapper.insertSelective(store) == 1;
		}else{
			result = this.storeMapper.updateByPrimaryKeySelective(store) == 1;
		}
		return result;
	}

	public Store queryStoreInfoByid(Integer id) {	
		return this.storeMapper.selectByPrimaryKey(id);
	}

	public List<StoreAgent> queryBottomByStoreId(Integer id) {
		return this.storeAgentMapper.queryBottomByStoreId(id);
	}

	public StoreAgent queryInviteByAgentId(Integer id) {
		return this.storeAgentMapper.queryInviteByAgentId(id);
	}

	public List<StoreAgent> queryInviteByStoreId(Integer id) {
		return this.storeAgentMapper.queryInviteByStoreId(id);
	}

	public List<StoreAgent> queryTopByAgentId(Integer id) {
		return this.storeAgentMapper.queryTopByAgentId(id);
	}

	public Integer inviteAgent(StoreAgent storeAgent) {
		
		AgentUser agentUser = this.agentUserMapper.selectByConditions(storeAgent.getBottom());
		// 2：查询不到此经纪人
		if(null == agentUser){
			return 2;
		}
		
		// 9：不能邀请自己
		if(agentUser.getId() == storeAgent.getStoreId()){
			return 9;
		}
		
//		// 3：已经是别人的下线了
//		List<StoreAgent> agent1 = this.storeAgentMapper.queryTopByAgentId(agentUser.getId());
//		if(null != agent1 && !agent1.isEmpty()){
//			boolean b1 = false;
//			for(StoreAgent a1 : agent1){
//				if(a1.getStoreId() == storeAgent.getStoreId()){
//					b1 = true;
//					break;
//				}
//			}
//			//10：是自己的经纪人
//			if(b1){
//				return 10;
//			}
//		}
//		
//		// 4: 已经是别人的上线了
//		List<StoreAgent> list1 = this.storeAgentMapper.queryBottomByStoreId(agentUser.getId());
//		if(null != list1 && !list1.isEmpty()){
//			return 4;
//		}
//		
//		// 5:邀请其它经纪人中
//		List<StoreAgent> list2 = this.storeAgentMapper.queryInviteByStoreId(agentUser.getId());
//		if(null != list2 && !list2.isEmpty()){
//			return 5;
//		}
//		
//		//6:被其它经纪人邀请中
//		StoreAgent agent2 = this.storeAgentMapper.queryInviteByAgentId(agentUser.getId());
//		if(null != agent2){
//			return 6;
//		}
//		
//		//7:自己不能被其它人邀请中
//		StoreAgent agent3 = this.storeAgentMapper.queryInviteByAgentId(storeAgent.getStoreId());
//		if(null != agent3){
//			return 7;
//		}
//		
//		// 8：自己不能是别人的下线
//		StoreAgent agent4 = this.storeAgentMapper.queryTopByAgentId(storeAgent.getStoreId());
//		if(null != agent4){
//			return 8;
//		}
		
		
		//1校验通过 插入数据
		storeAgent.setAgentId(agentUser.getId());
		storeAgent.setUpdateTime(new Date());
		//如果有关联数据则更新
		StoreAgent temp = this.storeAgentMapper.queryStoreInfoByConditions(storeAgent);
		if(null != temp){
			//已经是自己的下线了
            if(temp.getStatus() == 4){
            	return 10;
			}
			else{
				storeAgent.setId(temp.getId());
    			this.storeAgentMapper.updateByPrimaryKeySelective(storeAgent);
    			return 1;
			}
			
		}
		return this.storeAgentMapper.insert(storeAgent);
	}

	public void updateStoreInfo(StoreAgent storeAgent) {	
		StoreAgent temp = this.storeAgentMapper.queryStoreInfoByConditions(storeAgent);
		storeAgent.setId(temp.getId());
		storeAgent.setUpdateTime(new Date());
		this.storeAgentMapper.updateByPrimaryKeySelective(storeAgent);
	}

	public void delStoreInfoById(Integer id) {
		this.storeAgentMapper.deleteByPrimaryKey(id);
	}

	public void queryStoreAgentListForPage(PageBean page, StoreAgent storeAgent) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("_page", page);
		parameters.put("storeAgent", storeAgent);  
		Integer count = this.storeAgentMapper.queryCountByConditions(parameters);
		List<StoreAgent> storeAgents = this.storeAgentMapper.queryStoreAgentByConditions(parameters);

	    PageBean.Counter(page, count, null, storeAgents);	
	}

	public void concelAllStoreAgent(Integer storeId) {
	    this.storeAgentMapper.concelAll(storeId);
	}

	public StoreAgent queryStoreInfoByConditions(StoreAgent storeAgent) {
		return this.storeAgentMapper.queryStoreInfoByConditions(storeAgent);
	}

	public void querySubordinateListForPage(PageBean page,
			AgentQueryParameter query) {
		if(Judge.isNotNull(query)){
			query.setPage(page);
		}
		if(Judge.isNull(query)){
			query = new AgentQueryParameter();
			query.setPage(page);
		}
		
		Integer count = this.agentUserMapper.querySubordinateCountByConditions(query);
		List<AgentUser> agents = this.agentUserMapper.querySubordinateByConditions(query);
		PageBean.Counter(page, count, page.getCurrent(), agents);
	}

	public void querySuperiorListForPage(PageBean page,
			AgentQueryParameter query) {
		if(Judge.isNotNull(query)){
			query.setPage(page);
		}
		if(Judge.isNull(query)){
			query = new AgentQueryParameter();
			query.setPage(page);
		}
		
		Integer count = this.agentUserMapper.querySuperiorCountByConditions(query);
		List<AgentUser> agents = this.agentUserMapper.querySuperiorByConditions(query);
		PageBean.Counter(page, count, page.getCurrent(), agents);
	}
}
