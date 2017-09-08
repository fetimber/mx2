package net.huimin.yk.web.actions.admin;

import java.util.List;

import net.huimin.common.helper.Judge;
import net.huimin.common.mvc.AbstractAction;
import net.huimin.yk.web.model.common.Area;
import net.huimin.yk.web.model.houses.HousesConfig;
import net.huimin.yk.web.model.houses.HousesProject;
import net.huimin.yk.web.model.system.SysUser;
import net.huimin.yk.web.services.common.AreaService;
import net.huimin.yk.web.services.common.CommonService;
import net.huimin.yk.web.services.houses.HousesService;
import net.huimin.yk.web.services.system.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;

public class HouseAction extends AbstractAction {
   
	private HousesProject project;
	@Autowired
	private HousesService housesService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private UserService userService;
	
	private List<Integer> bigPictures;
	private List<Integer> smallPictures;
	
	@Autowired
	private AreaService areaService;
	
	private HousesConfig config;
	
	
	public String execute() {
		//加载楼盘信息
		this.pushRequest("areas", this.areaService.quertAllArea());
		this.housesService.queryHousesForPage(this.getPage(), this.project);
		
		return Action.SUCCESS;
	}
	
	public String add() {
		List<Area> areas = this.areaService.quertAllArea();
		this.pushRequest("areas", areas);
		List<SysUser> managers = this.userService.queryAllProjectManager();
		this.pushRequest("managers", managers);
		return "add";
	}
	
	public String edit(){
		this.add();
		this.project = this.housesService.selectHouseById(this.project.getId());
		return "edit";
	}
	
	public String save_project(){
		this.project.setProjectName(this.project.getProjectName().trim());
		boolean rslt = this.housesService.saveProject(this.project,this.bigPictures,this.smallPictures);
		this.pushRequest("result", rslt);
		this.pushRequest("success_url", "admin/house");
		this.pushRequest("success_name", "查看楼盘列表");
		return "operate-result";
	}
	
	public String check_name() {
		boolean rslt = this.housesService.checkHouseProjectName(this.project);
		return this.jsonValidate(rslt);
	}
	
	public String delete_house() {
		boolean rslt = this.housesService.deleteProject(this.project.getId());
		this.pushJSON("result", rslt);
		return "json";
	}
	
	public String config(){
		this.project = this.housesService.selectHouseById(this.project.getId());
		List<HousesConfig> configs = this.housesService.queryHouseConfigByPid(this.project.getId());
		this.pushRequest("configs", configs);
		return "config";
	}
	
	public String config_delete() {
		boolean rslt = this.housesService.deleteConfig(this.config.getId());
		this.pushJSON("result", Boolean.valueOf(rslt));
		return "json";
	}
	
	public String config_edit() {
		if(Judge.isNotNull(this.config) && Judge.isNotNull(this.config.getId())){
			this.config = this.housesService.queryHouseConfigById(this.config.getId());
		}
		return "config-edit";
	}
	
	public String config_save() {
		boolean rslt = this.housesService.saveOrUpdateHouseConfig(this.config,this.bigPictures);
		this.pushRequest("result", rslt);
		this.pushRequest("success_url", "admin/house");
		this.pushRequest("success_name", "查看楼盘列表");
		return "operate-result";
	}
	
	public HousesProject getProject() {
		return project;
	}

	public void setProject(HousesProject project) {
		this.project = project;
	}

	public List<Integer> getBigPictures() {
		return bigPictures;
	}

	public void setBigPictures(List<Integer> bigPictures) {
		this.bigPictures = bigPictures;
	}

	public List<Integer> getSmallPictures() {
		return smallPictures;
	}

	public void setSmallPictures(List<Integer> smallPictures) {
		this.smallPictures = smallPictures;
	}

	public HousesConfig getConfig() {
		return config;
	}

	public void setConfig(HousesConfig config) {
		this.config = config;
	}
}
