package net.huimin.common.mvc;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.huimin.common.cnst.Const;
import net.huimin.common.helper.Judge;
import net.huimin.yk.web.actions.LoginAction;
import net.huimin.yk.web.actions.weixin.UploadAction;
import net.huimin.yk.web.actions.weixin.WechatAction;
import net.huimin.yk.web.dao.system.SysMenuRoleMapper;
import net.huimin.yk.web.model.common.MenuInfo;
import net.huimin.yk.web.model.system.SysUser;

import org.apache.log4j.Logger;
import org.apache.struts2.StrutsStatics;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 
 * @ClassName: CheckLoginFilter 
 * @author 胡笑尘 huxiaochen@hmeg.net
 * @date 2014-11-7 下午01:44:28
 */
public class CheckLoginInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = -2081720503203103234L;
	@Autowired
	private SysMenuRoleMapper menuRoleMapper;
	
	private Logger logger = Logger.getLogger(CheckLoginInterceptor.class);
	
	//private static final String SPACE_FRANCHISEE = "/admin";
	/**
	 * (非 Javadoc) 
	 * <p>Title:intercept</p> 
	 * <p>Description: 检测需要登录才访问的资源</p> 
	 * @param arg0
	 * @return
	 * @throws Exception 
	 * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		String space = arg0.getProxy().getNamespace();
		//微信端暂不判断登录
		if(WechatAction.class.equals(arg0.getProxy().getAction().getClass())){
			return arg0.invoke();
		}
		
		if(UploadAction.class.equals(arg0.getProxy().getAction().getClass())){
			return arg0.invoke();
		}
		
		//登录界面无需判断
		if(LoginAction.class.equals(arg0.getProxy().getAction().getClass())){
			return arg0.invoke();
		}
		
		SysUser user = (SysUser) arg0.getInvocationContext().getSession().get(Const.USERINFO_IN_SESSION);
		ActionContext actionContext = arg0.getInvocationContext(); 
		HttpServletRequest request= (HttpServletRequest) actionContext.get(StrutsStatics.HTTP_REQUEST);
		String url = request.getRequestURI();
		System.out.println("++++++++++++++++"+url);
		//判断用户是登录
		if(Judge.isNotEmpty(space) && Judge.isNotNull(user)){
			List<MenuInfo> refuseList = menuRoleMapper.selectRefuseByRoleId(user.getRoleId());
			if(refuseList != null){
				for(MenuInfo m : refuseList){
					if((url+" ").indexOf(m.getMenuUrl()+" ") != -1){
						return Action.LOGIN;
					}
				}
			}
			return arg0.invoke();
		}
		
		return Action.LOGIN;
		
		
	}

	/**
	 * (非 Javadoc) 
	 * <p>Title:destroy</p> 
	 * <p>Description: </p>  
	 * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#destroy()
	 */
	@Override
	public void destroy() {
		this.logger.info("登录拦截器销毁.");
		super.destroy();
	}

	/**
	 * (非 Javadoc) 
	 * <p>Title:init</p> 
	 * <p>Description: </p>  
	 * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#init()
	 */
	@Override
	public void init() {
		this.logger.info("登录拦截器初始化.");
		super.init();
	}
	
	

}
