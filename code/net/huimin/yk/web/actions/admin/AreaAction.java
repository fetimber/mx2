package net.huimin.yk.web.actions.admin;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;

import net.huimin.common.mvc.AbstractAction;
import net.huimin.yk.web.services.common.AreaService;

public class AreaAction extends AbstractAction{

	@Autowired
	private AreaService areaService;
	
	
	private String name;
	
	private Integer id;
	
	public String execute() {
		this.pushRequest("areas", this.areaService.quertAllArea());
		this.pushRequest("provinces", this.areaService.queryAllProvinces());
		return Action.SUCCESS;
	}
	
	public String add_province() {
		boolean isExist = this.areaService.isProvinceExist(this.name);
		boolean rslt = false;
		if(isExist){
			this.pushJSON("description", "省份名称已经存在");
		} else {
			rslt = this.areaService.addProvince(this.name);
			this.pushJSON("result", Boolean.valueOf(rslt));
		}
		this.pushJSON("result", Boolean.valueOf(rslt));
		return "json";
	}
	
	public String delete_province() {
		boolean rslt = false;
		try {
			rslt = this.areaService.deleteProvince(this.id);
		} catch (Exception e) {
			this.pushJSON("descript", "此数据暂时不能删除，因为有关联数据存在");
		}
		this.pushJSON("result", Boolean.valueOf(rslt));
		return "json";
	}
	
	public String delete_city() {
		boolean rslt = false;
		try {
			rslt = this.areaService.deleteCity(this.id);
		} catch (Exception e) {
			this.pushJSON("descript", "此数据暂时不能删除，因为有关联数据存在");
		}
		this.pushJSON("result", Boolean.valueOf(rslt));
		return "json";
	}
	
	public String edit_province() {
		boolean rslt = false;
		try {
			boolean isExist = this.areaService.isProvinceExist(this.name);
			
			if(isExist){
				this.pushJSON("description", "省份名称已经存在");
			} else{
				rslt = this.areaService.edit_province(this.id,this.name);
			}
			
		} catch (Exception e) {
			this.pushJSON("descript", "此数据暂时不能修改");
		}
		this.pushJSON("result", Boolean.valueOf(rslt));
		return "json";
	}
	
	public String queryCityByProvince() {
		this.pushJSON("citys", this.areaService.queryCityByProvince(this.id));
		return "json";
	}
	
	public String add_city() {
		boolean isExist = this.areaService.isCityExist(this.name);
		boolean rslt = false;
		if(isExist){
			this.pushJSON("description", "市级单位名称已经存在");
		} else {
			rslt = this.areaService.addCity(this.id,this.name);
			this.pushJSON("result", Boolean.valueOf(rslt));
		}
		this.pushJSON("result", Boolean.valueOf(rslt));
		return "json";
	}
	
	public String edit_city() {
		boolean isExist = this.areaService.isCityExist(this.name);
		boolean rslt = false;
		if(isExist){
			this.pushJSON("description", "市级单位名称已经存在");
		} else {
			rslt = this.areaService.editCity(this.id,this.name);
			this.pushJSON("result", Boolean.valueOf(rslt));
		}
		this.pushJSON("result", Boolean.valueOf(rslt));
		return "json";
	}
	
	public String queryAreaByCity(){
		this.pushJSON("areas", this.areaService.queryAreaByCity(this.id));
		return "json";
	}
	
	public String delete_area() {
		boolean rslt = false;
		try {
			rslt = this.areaService.deleteArea(this.id);
		} catch (Exception e) {
			this.pushJSON("descript", "此数据暂时不能删除，因为有关联数据存在");
		}
		this.pushJSON("result", Boolean.valueOf(rslt));
		return "json";
	}
	
	public String edit_area() {
		boolean isExist = this.areaService.isAreaExist(this.name);
		boolean rslt = false;
		if(isExist){
			this.pushJSON("description", "区域名称已经存在");
		} else {
			rslt = this.areaService.editArea(this.id,this.name);
			this.pushJSON("result", Boolean.valueOf(rslt));
		}
		this.pushJSON("result", Boolean.valueOf(rslt));
		return "json";
	}
	
	public String add_area() {
		boolean isExist = this.areaService.isCityExist(this.name);
		boolean rslt = false;
		if(isExist){
			this.pushJSON("description", "区域名称已经存在");
		} else {
			rslt = this.areaService.addArea(this.id,this.name);
			this.pushJSON("result", Boolean.valueOf(rslt));
		}
		this.pushJSON("result", Boolean.valueOf(rslt));
		return "json";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
