package net.huimin.yk.web.actions.admin;

import java.util.Date;
import java.util.List;

import net.huimin.common.cnst.Const;
import net.huimin.common.helper.Judge;
import net.huimin.common.mvc.AbstractAction;
import net.huimin.yk.web.model.sea.SeaGoodsRecord;
import net.huimin.yk.web.model.sea.SeaHonorUnit;
import net.huimin.yk.web.model.sea.SeaQueryParameter;
import net.huimin.yk.web.model.sea.SeaUnit;
import net.huimin.yk.web.model.sea.SeaWorker;
import net.huimin.yk.web.model.system.SysUser;
import net.huimin.yk.web.services.sea.SeaService;

import org.springframework.beans.factory.annotation.Autowired;

public class RecordAction extends AbstractAction{

	
	private SeaGoodsRecord record;
	/**
	 * @param args
	 */

	private SeaQueryParameter query;
	
	private List<Integer> bigPictures;
	
	@Autowired
	private SeaService seaService;
	
	
public String view(){
		
		if(Judge.isNull(this.query)){
			this.query = new SeaQueryParameter();		
		}
		
		this.getPage().setOffset(100);
		if(Judge.isNotNull(this.logined(true).getCityId())){
			this.query.setCityId(this.logined(true).getCityId());	
		}
		if(Judge.isNotNull(this.logined(true).getUnitId())){
			this.query.setUnit(this.logined(true).getUnitId());	
		}
		if(Judge.isNotNull(this.query.getKeyword())){
			this.query.setKeyword(this.query.getKeyword().trim());	
		}

		this.seaService.queryGoodsRecordForPage(this.getPage(), this.query);
		return "view";
	}
	
	
	public String add() {
	    //SysUser logined  = (SysUser)this.getSession().get(Const.USERINFO_IN_SESSION);
	
		if(Judge.isNotNull(this.record)
				&& Judge.isNotNull(this.record.getId())){
			this.record = this.seaService.querySeaGoodsRecordById(this.record);			
		}else {
		     if( Judge.isNull(this.record.getWorkPoorId())){
					this.record = new SeaGoodsRecord();	
			 }	
		}
	
		return "add";
	}
	
	public String detail(){
		if(Judge.isNotNull(this.record)
				&& Judge.isNotNull(this.record.getId())){
			this.record = this.seaService.querySeaGoodsRecordById(this.record);			
		}else {
		     if( Judge.isNull(this.record.getWorkPoorId())){
					this.record = new SeaGoodsRecord();	
			 }	
		}

		return "detail";		
}
	
	

	public String delete() {
		boolean rslt = false;
		try{
			//逻辑删除
			SeaGoodsRecord record = new SeaGoodsRecord();
			record.setId(this.record.getId());
			record.setIsDelete(1);
			rslt = this.seaService.saveGoodsRecord(record);
		}catch (Exception ex){
			ex.printStackTrace();	
		}
		this.pushJSON("result", rslt);
		return "json";
	}
	
	public String save(){
		this.record.setCreateTime(new Date());
		this.record.setIsDelete(0);
		
		boolean rslt = this.seaService.saveGoodsRecordByFiles(record, bigPictures);	
		this.pushRequest("result", rslt);

		this.pushRequest("success_url", "admin/record!view?query.workPoorId=" + record.getWorkPoorId());
		this.pushRequest("success_name", "查看物资发放列表");
		return "operate-result";
	}
	

	public SeaGoodsRecord getRecord() {
		return record;
	}
	public void setRecord(SeaGoodsRecord record) {
		this.record = record;
	}
	public SeaQueryParameter getQuery() {
		return query;
	}
	public void setQuery(SeaQueryParameter query) {
		this.query = query;
	}

	public List<Integer> getBigPictures() {
		return bigPictures;
	}

	public void setBigPictures(List<Integer> bigPictures) {
		this.bigPictures = bigPictures;
	}
	
}
