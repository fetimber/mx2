package net.huimin.yk.web.actions;

import net.huimin.common.mvc.AbstractAction;
import net.huimin.yk.web.model.system.SysMenu;
import net.huimin.yk.web.services.common.CommonService;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;

@Results({@Result(name="success",location="${url}",type="redirect"),
	@Result(name="rejecte",location="/resources/jsp/common/rejecte.html")})
public class DoAction extends AbstractAction {

	@Autowired
	private CommonService commonService;
	
	private Integer id;
	
	private String url;
	
	public String execute() {
		if(this.auth()){
			SysMenu menu = this.commonService.queryMenuByid(this.id);
			this.url = menu.getMenuUrl();
			return Action.SUCCESS;
		} else {
			this.url = null;
			return "rejecte";
		}
	}
	
	private boolean auth(){
		Integer user_id = this.logined(true).getId();
		Integer menu_id = this.id;
		return this.commonService.queryOperateRejecte(user_id,menu_id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
