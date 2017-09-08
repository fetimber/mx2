package net.huimin.common.mvc;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import net.huimin.common.cnst.Const;
import net.huimin.common.helper.CodeHelper;
import net.huimin.common.helper.SpringHelper;
import net.huimin.common.page.PageBean;
import net.huimin.yk.web.dao.system.SysUserMapper;
import net.huimin.yk.web.model.system.SysUser;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;

/**
 * Action类的父类
 * @ClassName: AbstractAction 
 * @Description: 提供Action的快速代码访问功能,集成常用访问
 * @author 胡笑尘 huxiaochen@hmeg.net
 * @date 2014-11-7 下午02:42:42
 */
public abstract class AbstractAction implements RequestAware,SessionAware {
	
	//结果
	protected final static String RESULT_SUCCESS = Action.SUCCESS;
	protected final static String RESULT_ERROR = Action.ERROR;
	protected final static String RESULT_LOGIN = Action.LOGIN;
	protected final static String RESULT_INPUT = Action.INPUT;
	protected final static String RESULT_INDEX = "index";
	protected final static String RESULT_FAIL = "fail";
	protected final static String RESULT_JSON = "json";
	
	//AJAXSUBMIT参数
	private String fieldId;
	private String fieldValue;
	private String _;
	private String captcha;
	
	//分页
	private PageBean page;
	
	protected Logger logger = Logger.getLogger(this.getClass());
	
	protected static BigDecimal ZREO = new BigDecimal(0);
	
	private Map<String, Object> JSON_MAP = new HashMap<String, Object>();
	private Map<String, Object> REQUEST_MAP;
	private Map<String, Object> SESSION_MAP;
	
	public String execute(){return RESULT_SUCCESS;}
	
	public SysUser logined(boolean refresh){
		SysUser user = (SysUser)this.getSession().get(Const.USERINFO_IN_SESSION);
		if(CodeHelper.isNull(user)){
			return null;
		} else {
			if(refresh){
				Integer id = user.getId();
				user = SpringHelper.Context().getBean(SysUserMapper.class).selectByPrimaryKey(id);
				this.getSession().put(Const.USERINFO_IN_SESSION, user);
			}
			return user;
		}
	}
	
	protected AbstractAction pushJSON(String key, Object value){
		JSON_MAP.put(key, value);
		return this;
	}
	
	protected AbstractAction pushRequest(String key, Object value){
		REQUEST_MAP.put(key, value);
		return this;
	}
	
	protected AbstractAction pushSession(String key, Object value){
		SESSION_MAP.put(key, value);
		return this;
	}

	public Map<String, Object> getRequest() {
		return REQUEST_MAP;
	}

	public Map<String, Object> getSession() {
		return SESSION_MAP;
	}

	public Map<String, Object> getJSON_MAP() {
		return JSON_MAP;
	}

	public void setSession(Map<String, Object> arg0) {
		SESSION_MAP = arg0;
	}

	public void setRequest(Map<String, Object> arg0) {
		REQUEST_MAP = arg0;
	}

	public String getFieldId() {
		return fieldId;
	}

	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public String get_() {
		return _;
	}

	public void set_(String _) {
		this._ = _;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public PageBean getPage() {
		if(CodeHelper.isNull(this.page)){
			this.page = new PageBean();
		}
		return page;
	}

	public void setPage(PageBean page) {
		this.page = page;
	}
	
	public String jsonValidate(boolean rslt){
		this.pushJSON("_", this.get_());
		this.pushJSON("fieldId", this.getFieldId());
		this.pushJSON("fieldValue", this.getFieldValue());
		this.pushJSON("result", Boolean.valueOf(rslt));
		return RESULT_JSON;
	}
}
