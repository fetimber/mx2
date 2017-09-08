package net.huimin.yk.web.actions.admin;

import java.util.Date;
import java.util.List;

import net.huimin.common.helper.Judge;
import net.huimin.common.mvc.AbstractAction;
import net.huimin.yk.web.model.common.City;
import net.huimin.yk.web.model.sea.SeaUnit;
import net.huimin.yk.web.services.common.AreaService;
import net.huimin.yk.web.services.sea.SeaService;

import org.springframework.beans.factory.annotation.Autowired;

public class GovunitAction  extends AbstractAction{

	private SeaUnit unit;
	
	private String unitCity;

	private String unitDuty;
	
	private Date joinTime;
	
	//private 
	
	public void setUnitCity(String unitCity) {
		this.unitCity = unitCity;
	}

	public void setUnit(SeaUnit unit) {
		this.unit = unit;
	}
	
	public void setUnitDuty(String unitDuty) {
		this.unitDuty = unitDuty;
	}



	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}



	@Autowired
	private AreaService areaService;
	
	@Autowired
	private SeaService seaService;
	
	public String view(){
		if(Judge.isNull(unit)){
			unit = new SeaUnit();	
		}

		if(Judge.isNotNull(this.logined(true).getCityId())){
			this.unit.setUnitCity(this.logined(true).getCityId());	
		}
	
		if(Judge.isNotNull(this.unit.getUnitName())){
			this.unit.setUnitName(this.unit.getUnitName().trim());	
		}
		
		this.seaService.queryUnitsForPage(this.getPage(), unit);
		return "view";
	}
	
	public String delete() {
		boolean rslt = this.seaService.deleteUnit(this.unit.getId());
		this.pushJSON("result", rslt);
		return "json";
	}
	
	public String add() {
		List<City> citys = this.areaService.queryCityByProvince(1);
		this.pushRequest("citys", citys);

		if(Judge.isNotNull(this.unit)
				&& Judge.isNotNull(this.unit.getId())){
			this.unit = this.seaService.querySeaUnitById(this.unit);	
			unitDuty = this.unit.getUnitDuty();
			joinTime = this.unit.getJoinTime();
			unitCity = String.valueOf(this.unit.getUnitCity());
		}else {
			this.unit = new SeaUnit();
		}
		
		return "add";
	}
	
	public String save(){
		this.unit.setUnitName(this.unit.getUnitName().trim());
		this.unit.setIsMember("1");
		
		if(Judge.isNull(this.unit.getUnitDuty())){
			this.unit.setUnitDuty(unitDuty);	
		}
		
		if(Judge.isNull(this.unit.getJoinTime())){
			if(Judge.isNotNull(this.joinTime)){
				this.unit.setJoinTime(this.joinTime);
			}else{
				this.unit.setJoinTime(new Date());
			}
		}
		
		if(Judge.isNotNull(unitCity)){
			this.unit.setUnitCity(Integer.parseInt(unitCity));
		}
		
		if(Judge.isNotNull(this.logined(true).getCityInfo())){
			this.unit.setUnitCity(this.logined(false).getCityId());
		}
		
		boolean rslt = this.seaService.saveUnit(this.unit);
		this.pushRequest("result", rslt);
		this.pushRequest("success_url", "admin/govunit!view");
		this.pushRequest("success_name", "查看单位列表");
		return "operate-result";
	}
	
	public String check_name() {
		boolean rslt = false;
		
		if(Judge.isNotNull(this.unit.getId())){
			rslt = true;		
		}else{
			rslt = this.seaService.checkUnitName(this.unit);	
		}		
		return this.jsonValidate(rslt);
	}

	public SeaUnit getUnit() {
		return unit;
	}

	public String getUnitCity() {
		return unitCity;
	}

	public String getUnitDuty() {
		return unitDuty;
	}

	public Date getJoinTime() {
		return joinTime;
	}
	
	
}
