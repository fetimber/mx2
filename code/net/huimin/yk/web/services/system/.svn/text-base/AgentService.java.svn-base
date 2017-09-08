package net.huimin.yk.web.services.system;

import java.util.List;

import net.huimin.common.page.PageBean;
import net.huimin.yk.web.model.agent.AgentQueryParameter;
import net.huimin.yk.web.model.agent.AgentUser;
import net.huimin.yk.web.model.agent.Store;
import net.huimin.yk.web.model.agent.StoreAgent;
import net.huimin.yk.web.model.common.Files;

public interface AgentService {

//	public  void queryAgentListForPage(PageBean page, AgentUser agentUser,Date startime,Date endtime);
	
	public void updateAgentInfo(AgentUser agentUser) throws Exception;
	
	public AgentUser selectById(Integer id);
	
	public List<AgentUser> selectByReferId(Integer agentId);
	
	public Boolean insertOrUpdateAgent (AgentUser agentUser);
	

	public void queryAgentListForPage(PageBean page, AgentQueryParameter query);
	
	public List<Files> queryFilesForAgentComfirm(Integer agent);
	
	public Boolean insertOrUpdateAgent2 (AgentUser agentUser);
	
	public void queryStoreListForPage(PageBean page, Store query);
	
	public boolean checkStoreName(Store store) ;
	
	public boolean saveOrUpdateStore(Store store);
	
	public Store queryStoreInfoByid(Integer id);
	
	public List<StoreAgent> queryTopByAgentId(Integer id);

	public List<StoreAgent> queryBottomByStoreId(Integer id);
    
	public StoreAgent queryInviteByAgentId(Integer id);
    
	public List<StoreAgent> queryInviteByStoreId(Integer id);
    
	public Integer inviteAgent(StoreAgent storeAgent);
	
	public void updateStoreInfo(StoreAgent storeAgent);  
	
	public void delStoreInfoById(Integer id);
	
	public void queryStoreAgentListForPage(PageBean page, StoreAgent storeAgent);
	
	public void concelAllStoreAgent(Integer storeId);
	
	public StoreAgent queryStoreInfoByConditions(StoreAgent storeAgent);
	
	public void querySuperiorListForPage(PageBean page, AgentQueryParameter query);
	
	public void querySubordinateListForPage(PageBean page, AgentQueryParameter query);
    
}
