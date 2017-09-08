package net.huimin.common.mvc;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.huimin.common.helper.CodeHelper;
import net.huimin.yk.web.actions.weixin.UploadAction;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author HuXiaoChen
 *
 */
public class AttackInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = -2081720503203103234L;
	
	private Logger logger = Logger.getLogger(AttackInterceptor.class);
	
	private static final String[] ILLEGAL_CHARACTERS = {" and "," or "," AND "," OR ","javascript","update ","UPDATE" ,"where ", "WHERE", "delete", "DELETE"};
	
	private static final String[] CONNOTATION_CHARACTERS = {"&","<",">","'","\""};
	
	private static final String[] REPLACE_CHARACTERS = {"&amp;","&lt;","&gt;","&apos;","&quot;"};
	
	private static String BASE_PATH = "";
	/**
	 * (非 Javadoc) 
	 * <p>Title:intercept</p> 
	 * <p>Description: 跨站攻击和SQL注入拦截器</p> 
	 * @param arg0
	 * @return
	 * @throws Exception 
	 * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		
		//跨站点请求处理
		ActionContext ctx = arg0.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		
		String referer = request.getHeader("Referer");
		
		if(CodeHelper.isEmpty(referer)){
			if(arg0.getAction().getClass().equals(UploadAction.class) && "login".equals(arg0.getProxy().getMethod())){
				return arg0.invoke();
			} else {
				//直接访问，跳转到登录
				this.logger.warn("客户端使用浏览器直接请求非法地址，已经屏蔽:" + this.base_path(request));
				return "login";
			}
		} else {
			String path = this.base_path(request);
			
			if(!referer.startsWith(path)){
				this.logger.warn("客户端使用跨站访问，已经屏蔽:" + this.base_path(request));
				return "login";
			}
		}
		
		Map<String, String[]> parameters = ServletActionContext.getRequest().getParameterMap();
		
		if(CodeHelper.isNotEmpty(parameters)){
			Iterator<String> keys = parameters.keySet().iterator();
			boolean _is_modify = false;
			while (keys.hasNext()) {
				String key = keys.next();
				String[] values = parameters.get(key);
				String value = this.append(values);
				if(CodeHelper.isNotNull(values)){
					for (int i = 0; i < values.length; i++) {
						for (int j = 0; j < ILLEGAL_CHARACTERS.length; j++) {
							if(values[i].contains(ILLEGAL_CHARACTERS[j])){
								values[i] = values[i].replaceAll(ILLEGAL_CHARACTERS[j], "*");
								_is_modify = true;
							}
						}
						for (int j = 0; j < CONNOTATION_CHARACTERS.length; j++) {
							if(values[i].contains(CONNOTATION_CHARACTERS[j])){
								values[i] = values[i].replaceAll(CONNOTATION_CHARACTERS[j], REPLACE_CHARACTERS[j]);
								_is_modify = true;
							}
						}
					}
				}
				if(_is_modify){
					this.logger.info("发现非法的参数KEY:" + key + ",参数值:" + value + ",已被服务器强制重置为:" + this.append(values));
				}
			}
		}
		
		return arg0.invoke();
	}
	
	private String base_path(HttpServletRequest request) {
		BASE_PATH = "";
		if(CodeHelper.isEmpty(BASE_PATH)){
			StringBuffer buffer = new StringBuffer();
			String scheme = request.getScheme();
			buffer.append(scheme).append("://").append(request.getServerName());
			if(("http".equals(scheme) && request.getServerPort() != 80) || ("https".equals(scheme) && request.getServerPort() != 443)){
				buffer.append(":").append(request.getServerPort());
			} 
			buffer.append(request.getContextPath());
			System.out.println(BASE_PATH);
			BASE_PATH = buffer.toString();
		}
		return BASE_PATH;
	}

	private String append(String[] arg){
		if(CodeHelper.isNull(arg)){
			return "";
		}
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < arg.length; i++) {
			buffer.append(arg[i]);
		}
		
		return buffer.toString();
	}

	/**
	 * (非 Javadoc) 
	 * <p>Title:destroy</p> 
	 * <p>Description: </p>  
	 * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#destroy()
	 */
	@Override
	public void destroy() {
		this.logger.info("JS跨站攻击和SQL注入拦截器销毁.");
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
		this.logger.info("JS跨站攻击和SQL注入拦截器初始化.");
		super.init();
	}
}
