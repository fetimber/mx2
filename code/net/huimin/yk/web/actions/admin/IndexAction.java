package net.huimin.yk.web.actions.admin;

import java.util.List;

import net.huimin.common.mvc.AbstractAction;
import net.huimin.yk.web.model.common.MenuInfo;
import net.huimin.yk.web.services.common.CommonService;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

@Results({@Result(name="index",location="index.jsp")})
public class IndexAction extends AbstractAction{

	@Autowired
	private CommonService commonService;
	
	private  List<MenuInfo> menuList;
	
	public String execute() {
		return "index";
	}
	
	public String left() {
	    menuList = commonService.selectByRoleId(this.logined(true).getRoleId());
	    //this.pushRequest("menu", menuList);
	    return "left";
	}

	public String header() {
		return "header";
	}
	
	public String bottom() {
		return "bottom";
	}

	public List<MenuInfo> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<MenuInfo> menuList) {
		this.menuList = menuList;
	}

}
