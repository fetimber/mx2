package net.huimin.yk.web.actions.admin;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import net.huimin.common.cnst.Const;
import net.huimin.common.helper.DateHelper;
import net.huimin.common.helper.Judge;
import net.huimin.common.mvc.AbstractAction;
import net.huimin.yk.web.model.sea.SeaHonor;
import net.huimin.yk.web.model.sea.SeaQueryParameter;
import net.huimin.yk.web.model.sea.SeaUnit;
import net.huimin.yk.web.model.sea.SeaWorker;
import net.huimin.yk.web.model.sea.SeaWorkerPoor;
import net.huimin.yk.web.model.system.SysUser;
import net.huimin.yk.web.services.common.AreaService;
import net.huimin.yk.web.services.sea.SeaService;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

public class GovworkerAction  extends AbstractAction{

	private SeaWorker worker;
	
	private SeaWorkerPoor workerPoor;
	
	private SeaQueryParameter query;
	
	private String checkFlag;
	
	@Autowired
	private SeaService seaService;
	
	@Autowired
	private AreaService areaService;
	
	public void setSeaService(SeaService seaService) {
		this.seaService = seaService;
	}

	public String view(){
		SysUser logined  = (SysUser)this.getSession().get(Const.USERINFO_IN_SESSION);
		
		if(Judge.isNotNull(logined.getUnitId())){
			this.worker.setUnitId(logined.getUnitId());
		}
		
		this.seaService.queryWorkersForPage(this.getPage(), worker );
		return "view";
	}

	public String view_poor(){
		if(Judge.isNull(this.query)){
			this.query = new SeaQueryParameter();		
		}
		
		this.getPage().setOffset(10);
		if(Judge.isNotNull(this.logined(true).getCityId())){
			this.query.setCityId(this.logined(true).getCityId());	
		}
		if(Judge.isNotNull(this.logined(true).getUnitId())){
			this.query.setUnit(this.logined(true).getUnitId());	
		}
		if(Judge.isNotNull(this.query.getKeyword())){
			this.query.setKeyword(this.query.getKeyword().trim());	
		}
		
		this.seaService.queryWorkersPoorForPage(this.getPage(), this.query);	
		return "view-poor";
	}
	
	//审核
	public String view_poor1(){
		if(Judge.isNull(this.query)){
			this.query = new SeaQueryParameter();		
		}
		query.setCheck("-1");
		this.getPage().setOffset(10);
		if(Judge.isNotNull(this.logined(true).getCityId())){
			this.query.setCityId(this.logined(true).getCityId());	
		}
		if(Judge.isNotNull(this.logined(true).getUnitId())){
			this.query.setUnit(this.logined(true).getUnitId());	
		}
		if(Judge.isNotNull(this.query.getKeyword())){
			this.query.setKeyword(this.query.getKeyword().trim());	
		}
		
		this.seaService.queryWorkersPoorForPage(this.getPage(), this.query);	
		return "view-poor1";
	}
	
	//统计
	public String view_poor2(){
		if(Judge.isNull(this.query)){
			this.query = new SeaQueryParameter();		
		}
		
		this.query.setCheck("1");		
		this.getPage().setOffset(10);
		
		if(Judge.isNotNull(this.logined(true).getCityId())){
			this.query.setCityId(this.logined(true).getCityId());	
		}
		if(Judge.isNotNull(this.logined(true).getUnitId())){
			this.query.setUnit(this.logined(true).getUnitId());	
		}
		if(Judge.isNotNull(this.query.getKeyword())){
			this.query.setKeyword(this.query.getKeyword().trim());	
		}
		
		this.seaService.queryWorkersPoorForPage(this.getPage(), this.query);
		return "view-poor2";

	}
	
	public String add() {
		List<SeaUnit> units = this.seaService.queryUnitList(new SeaUnit());
		this.pushRequest("units", units);

		if(Judge.isNotNull(this.worker)
				&& Judge.isNotNull(this.worker.getId())){
			this.worker = this.seaService.querySeaWorkerById(this.worker);	
		}
		return "add";
	}
	
	public String add_poor() {
		try{
		
		List<SeaUnit> units = this.seaService.queryUnitList(new SeaUnit());
		this.pushRequest("units", units);

		if(Judge.isNotNull(this.worker)
				&& Judge.isNotNull(this.worker.getId())){
			this.worker = this.seaService.querySeaWorkerById(this.worker);	
		}else{
			this.worker = new SeaWorker();
			this.worker.setUnitId(this.logined(false).getUnitId());
		}

		if(Judge.isNotNull(this.workerPoor)
				&& Judge.isNotNull(this.workerPoor.getId())){
			this.workerPoor = this.seaService.querySeaWorkerPoorById(this.workerPoor);	
		}
		}catch (Exception ex){
			ex.printStackTrace();		
		}
		return "add-poor";
	}
	
	public String check1_poor() {
		List<SeaUnit> units = this.seaService.queryUnitList(new SeaUnit());
		this.pushRequest("units", units);

		if(Judge.isNotNull(this.worker)
				&& Judge.isNotNull(this.worker.getId())){
			this.worker = this.seaService.querySeaWorkerById(this.worker);	
		}else{
			this.worker = new SeaWorker();
			this.worker.setUnitId(this.logined(false).getUnitId());
		}

		if(Judge.isNotNull(this.workerPoor)
				&& Judge.isNotNull(this.workerPoor.getId())){
			this.workerPoor = this.seaService.querySeaWorkerPoorById(this.workerPoor);	
		}
		return "check1-poor";
	}
	
	
	public String detail_poor() {
		List<SeaUnit> units = this.seaService.queryUnitList(new SeaUnit());
		this.pushRequest("units", units);

		if(Judge.isNotNull(this.worker)
				&& Judge.isNotNull(this.worker.getId())){
			this.worker = this.seaService.querySeaWorkerById(this.worker);	
		}else{
			
			this.worker = new SeaWorker();
			this.worker.setUnitId(this.logined(false).getUnitId());
		}
		
		if(Judge.isNotNull(this.workerPoor)
				&& Judge.isNotNull(this.workerPoor.getId())){
			this.workerPoor = this.seaService.querySeaWorkerPoorById(this.workerPoor);	
		}
		return "detail-poor";
	}
	
	public String save(){
		//非困难职工
		this.worker.setIsHard("0");
		this.worker.setCreateTime(new Date());
		if(Judge.isNull(this.worker.getUnitId())){
			SysUser logined  = (SysUser)this.getSession().get(Const.USERINFO_IN_SESSION);
			this.worker.setUnitId(logined.getUnitId());
		}
		
		boolean rslt = this.seaService.saveWorker(this.worker);
		this.pushRequest("result", rslt);
		this.pushRequest("success_url", "admin/govworker!view");
		this.pushRequest("success_name", "查看会员列表");
		return "operate-result";
	}
	
	

	public String save_poor(){
		//困难职工	
		this.worker.setIsHard("1");
		this.workerPoor.setCreateTime(new Date());
		this.workerPoor.setIsDelete(0);
		
		if(Judge.isNull(this.worker.getUnitId())){
			if(Judge.isNotNull(this.logined(true).getUnitId())){
				this.worker.setUnitId(this.logined(true).getUnitId());
				this.workerPoor.setInUnit(this.logined(true).getUnitId());
			}else{
				this.worker.setUnitId(0);
				this.workerPoor.setInUnit(0);
			}
		}else{
			this.workerPoor.setInUnit(this.worker.getUnitId());		
		}
//		if(Judge.isNotNull(this.workerPoor.getId())){
//			workerPoor.setCheckFlag("0");
//		}
		
		if(this.logined(true).getRoleId() <= 12 
				&& Judge.isNotNull(workerPoor.getCheckFlag()) 
				&& !workerPoor.getCheckFlag().equals("0")){
			workerPoor.setCheckFlag(null);
		}
       
		
        if(Judge.isNull(checkFlag)){
        	workerPoor.setSendRemark(null);
		}else {
			//workerPoor.setCheckFlag("1");
			String remark = workerPoor.getSendRemark();
			//"\r\n"
			//发送时间:2016-09-01 部门:人力部1  物资:现金10W
			
			if(Judge.isNotNull(remark)){
				String [] remarkList = remark.split("\r\n");

				String nowRemark = "发送时间:" +  DateHelper.dateToString(workerPoor.getSendTime()) +" 部门:" + workerPoor.getSendDept() + "  物资:" + workerPoor.getSendThing() + "\r\n";
				String lastRemark = remarkList[remarkList.length - 1] + "\r\n";
				
				if(!nowRemark.equals(lastRemark)){
					workerPoor.setSendRemark(remark  + nowRemark);		
				}
			}else{
				workerPoor.setSendRemark("发送时间:" +  DateHelper.dateToString(workerPoor.getSendTime()) +" 部门:" + workerPoor.getSendDept() + "  物资:" + workerPoor.getSendThing() + "\r\n");
			}	
		}
        
		boolean rslt = this.seaService.saveWorkerPoor(worker, workerPoor);
		this.pushRequest("result", rslt);
		if(Judge.isNotNull(checkFlag)
				&& "1".equals(checkFlag)){
		    this.pushRequest("success_url", "admin/govworker!view_poor1");
		}else{
			this.pushRequest("success_url", "admin/govworker!view_poor");
		}
		this.pushRequest("success_name", "查看困难职工列表");
		return "operate-result";
	}
	
	public String delete() {
		boolean rslt = this.seaService.deleteWorker(this.worker.getId());
		this.pushJSON("result", rslt);
		return "json";
	}
	
	public String check(){	
		boolean rslt = this.seaService.saveCheckWorker(this.workerPoor);
		this.pushJSON("result", rslt);
		return "json";
	}
	
	public String delete_poor() {
		if(Judge.isNotNull(this.worker)){
			this.worker.setIsHard("0");
		}
		
		boolean rslt = this.seaService.deleteWorkerPoor(this.worker,this.workerPoor.getId());
		this.pushJSON("result", rslt);
		return "json";
	}
	
	private void wokerDataList(){	
		if(Judge.isNull(this.query)){
			this.query = new SeaQueryParameter();
		}
		
		if(this.checkFlag.equals("0")){
			
		}else if(this.checkFlag.equals("1")){
			this.query.setCheck("-1");		
		}else if(this.checkFlag.equals("2")){
			this.query.setCheck("1");				
		}

		if(Judge.isNotNull(this.logined(true).getCityId())){
			this.query.setCityId(this.logined(true).getCityId());	
		}
		if(Judge.isNotNull(this.logined(true).getUnitId())){
			this.query.setUnit(this.logined(true).getUnitId());	
		}
		if(Judge.isNotNull(this.query.getKeyword())){
			this.query.setKeyword(this.query.getKeyword().trim());	
		}
		
		this.seaService.queryWorkersPoorForPage(this.getPage(), this.query);
	}
	
	

	public String exportTotal(){
		HttpServletResponse response = ServletActionContext.getResponse();        
		try
        {
			List<Map<String,Object>> dbRes = this.seaService.queryWorkerPoorTotal(query);
			OutputStream os = response.getOutputStream();// 取得输出流
            response.reset();// 清空输出流
            response.setHeader("Content-disposition", "attachment; filename="
                    + new String("TotalData".getBytes("GB2312"), "UTF-8") + ".xls");// 设定输出文件头
            response.setContentType("application/msexcel");// 定义输出类型
            WritableWorkbook workbook = Workbook.createWorkbook(os);
            if (workbook != null)
            {
            	WritableSheet sheet = net.huimin.common.helper.FileHelper.convertResult2Sheet(workbook, "汇总数据", dbRes);
            }
            // 从内存中写入文件中
            workbook.write();
            // 关闭资源，释放内存
            workbook.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
		
		return this.view();
	}
	
	
	    //导出
		public String export(){
		    HttpServletResponse response = ServletActionContext.getResponse();        
		    List<SeaWorkerPoor> workers = new ArrayList<SeaWorkerPoor>();
		  
	        try
	        {
	            OutputStream os = response.getOutputStream();// 取得输出流
	            response.reset();// 清空输出流
	            response.setHeader("Content-disposition", "attachment; filename="
	                    + new String("workerdata".getBytes("GB2312"), "UTF-8") + ".xls");// 设定输出文件头
	            response.setContentType("application/msexcel");// 定义输出类型
	            WritableWorkbook workbook = Workbook.createWorkbook(os);
	            if (workbook != null)
	            {
	                WritableSheet sheet = workbook.createSheet("困难职工数据", 0);
	                // 设置标题 sheet.addCell(new jxl.write.Label(列(从0开始), 行(从0开始), 内容.));
	                sheet.addCell(new Label(0, 0, "职工姓名 "));
	                sheet.addCell(new Label(1, 0, "单位名称"));
	                sheet.addCell(new Label(2, 0, "性别"));
	                sheet.addCell(new Label(3, 0, "年龄"));
	                sheet.addCell(new Label(4, 0, "身份证"));
	                sheet.addCell(new Label(5, 0, "银行卡 "));
	                sheet.addCell(new Label(6, 0, "家庭地址"));
	                sheet.addCell(new Label(7, 0, "职工身份"));
	                sheet.addCell(new Label(8, 0, "联系电话"));
	                sheet.addCell(new Label(9, 0, "备注荣誉"));
	                sheet.addCell(new Label(10, 0, "家庭人数 "));
	                sheet.addCell(new Label(11, 0, "家庭收入"));
	                sheet.addCell(new Label(12, 0, "审核状态"));
	                sheet.addCell(new Label(13, 0, "困难标准 "));
	                sheet.addCell(new Label(14, 0, "致困原因"));
	                sheet.addCell(new Label(15, 0, "说明 "));

	                
	                sheet.setColumnView(0, 30);
	                sheet.setColumnView(1, 30);
	                sheet.setColumnView(2, 30);
	                sheet.setColumnView(3, 20);
	                sheet.setColumnView(4, 20);
	                sheet.setColumnView(5, 30);
	                sheet.setColumnView(6, 30);
	                sheet.setColumnView(7, 30);
	                sheet.setColumnView(8, 30);
	                sheet.setColumnView(9, 30);
	                sheet.setColumnView(10, 30);
	                sheet.setColumnView(11, 30);
	                sheet.setColumnView(12, 30);
	                sheet.setColumnView(13, 30);
	                sheet.setColumnView(14, 30);
	                sheet.setColumnView(15, 30);
	                
	                this.getPage().setOffset(50000);
	                wokerDataList();
	                
	                if(Judge.isNotNull(this.getPage().getBeans())){
	                	workers = (List<SeaWorkerPoor>)this.getPage().getBeans();	
	                }
	                  
	                for (int i = 0; i < workers.size(); i++) {
	                    //行编号   
	                	SeaWorkerPoor poor = workers.get(i);   
	                    
	                    sheet.addCell(new Label(0, i+1, poor.getWorkerInfo().getWorkerName()));
	                    sheet.addCell(new Label(1, i+1, poor.getUnitInfo().getUnitName()));
	  	                sheet.addCell(new Label(2, i+1, poor.getWorkerInfo().getWorkerSex()));
	  	                sheet.addCell(new Label(3, i+1, poor.getWorkerInfo().getWorkerAge()));
	  	                sheet.addCell(new Label(4, i+1, poor.getWorkerInfo().getWorkerIdnumber()));
	  	                sheet.addCell(new Label(5, i+1, poor.getWorkerInfo().getBankCard()));
	  	                sheet.addCell(new Label(6, i+1, poor.getWorkerInfo().getWorkerAddress()));
	  	                sheet.addCell(new Label(7, i+1, poor.getWorkerInfo().getWorkDuty()));
	  	                sheet.addCell(new Label(8, i+1, poor.getWorkerInfo().getWorkerPhone()));
		                sheet.addCell(new Label(9, i+1, poor.getWorkerInfo().getHonorRemark()));
		                sheet.addCell(new Label(10, i+1, poor.getFamilyPeople()));
		                sheet.addCell(new Label(11, i+1, poor.getFamilyIncome()));
		                sheet.addCell(new Label(12, i+1, changeCheckFlag(poor.getCheckFlag())));
		                sheet.addCell(new Label(13, i+1, poor.getPoorLevel()));
		                sheet.addCell(new Label(14, i+1,  poor.getPoorReason()));
		                sheet.addCell(new Label(15, i+1, poor.getChangeMemo()));

	                	
	               }   
	                // 从内存中写入文件中
	                workbook.write();
	                // 关闭资源，释放内存
	                workbook.close();
	            }	          
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
			
			return this.view();
		}
	
	private String changeCheckFlag(String sourceFlag){
		String result = "";
		if("0".equals(sourceFlag)){
			result = "未审核";	
		}else if("1".equals(sourceFlag)){
			result = "审核通过";	
		}else if("2".equals(sourceFlag)){
			result = "审核拒绝";		
		}
		return result;
	}	
  
	
	public String check_card() {
		boolean rslt = this.seaService.checkIdCard(this.worker);
		return this.jsonValidate(rslt);
	}
	
	public SeaWorker getWorker() {
		return worker;
	}

	public void setWorker(SeaWorker worker) {
		this.worker = worker;
	}

	public SeaWorkerPoor getWorkerPoor() {
		return workerPoor;
	}

	public void setWorkerPoor(SeaWorkerPoor workerPoor) {
		this.workerPoor = workerPoor;
	}

	public SeaQueryParameter getQuery() {
		return query;
	}

	public void setQuery(SeaQueryParameter query) {
		this.query = query;
	}

	public String getCheckFlag() {
		return checkFlag;
	}

	public void setCheckFlag(String checkFlag) {
		this.checkFlag = checkFlag;
	}
	
	
}
