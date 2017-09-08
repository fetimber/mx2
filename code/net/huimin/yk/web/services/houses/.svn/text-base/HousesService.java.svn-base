package net.huimin.yk.web.services.houses;

import java.util.List;
import java.util.Map;

import net.huimin.common.page.PageBean;
import net.huimin.yk.web.model.agent.AgentUser;
import net.huimin.yk.web.model.common.Files;
import net.huimin.yk.web.model.customer.CustomerApplication;
import net.huimin.yk.web.model.customer.CustomerRule;
import net.huimin.yk.web.model.houses.HousesConfig;
import net.huimin.yk.web.model.houses.HousesProject;
import net.huimin.yk.web.model.system.SysUser;
import net.sf.json.JSONArray;

public interface HousesService {
	
	/**
	 * 分特查询楼盘列表
	 * @param page    分页信息
	 * @param project 条件
	 */
	void queryHousesForPage(PageBean page, HousesProject project);
	
	
	/**
	 * 分特查询楼盘列表
	 * @param page    分页信息
	 * @param project 条件
	 * @param agentId 经纪人ID
	 */
	void queryHousesForPage(PageBean page, HousesProject project , int agentId);
	
	/**
	 * 根据楼盘id 查询对应楼盘配套信息
	 * @param pid
	 * @return
	 */
	List<HousesConfig>  queryHouseConfigByPid(Integer pid);
	
	/**
	 * 根据Id 查询楼盘详情
	 * @param id
	 * @return
	 */
	HousesProject selectHouseById(Integer id);
	
	/**
	 * 根据楼盘id 查询对应的图片信息
	 * @param pid
	 * @return
	 */
	List<Files> queryHouseImgs(Integer pid);
	
	/**
	 * 查询所有主打楼盘的大图片
	 * @return
	 */
	List<Files> queryMainHouseImgs();
	
	/**
	 * 根据条件查询用户信息
	 * @param user
	 * @return
	 */
	SysUser agentInfo(SysUser user);
	
	/**
	 * 根据条件查询 经纪人信息
	 * @param agentUser
	 * @return
	 */
	AgentUser queryAgentUser(AgentUser agentUser);
	
	/**
	 * 注册方法
	 * @param agentUser  经纪人信息
	 * @param sysUser    用户信息
	 * @param accountId  账户ID
	 * @return           注册的结果map
	 * @throws Exception
	 */
	Map<String,Object> register(AgentUser agentUser , SysUser sysUser ,Integer accountId) throws Exception;
	
	/**
	 * 查询所有等级规则
	 * @return List<CustomerRule>
	 */
	List<CustomerRule> selectAllRule(CustomerRule record);
	
	/**
	 * 根据条件查询所有楼盘列表
	 * @param project
	 * @return
	 */
	List<HousesProject> selectAllProjectByConditions(HousesProject project);
	
	/**
	 * 经纪人推荐
	 * @param agentId     推荐人ID
	 * @param pids        楼盘id数组
	 * @param score       积分
	 * @param application 推荐客户信息
	 * @return 推荐结果 0 成功 1 失败
	 */
	int recommend(int agentId , JSONArray custArray )throws Exception;
	
	/**
	 * 查询客户信息
	 * @param id
	 * @return
	 */
	CustomerApplication selectCustomer(Integer id);


	boolean saveProject(HousesProject project, List<Integer> bigPictures, List<Integer> smallPictures);


	boolean deleteProject(Integer id);


	boolean deleteConfig(Integer id);


	HousesConfig queryHouseConfigById(Integer id);


	boolean saveOrUpdateHouseConfig(HousesConfig config, List<Integer> pictures);


	boolean checkHouseProjectName(HousesProject project);
	
}
