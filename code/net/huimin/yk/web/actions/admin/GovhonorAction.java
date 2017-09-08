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
import net.huimin.yk.web.model.sea.SeaHonorUnit;
import net.huimin.yk.web.model.sea.SeaQueryParameter;
import net.huimin.yk.web.model.sea.SeaUnit;
import net.huimin.yk.web.model.sea.SeaWorker;
import net.huimin.yk.web.model.system.SysUser;
import net.huimin.yk.web.services.sea.SeaService;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

public class GovhonorAction  extends AbstractAction{

	private SeaHonor honor;
	
	private SeaWorker worker;
	
	private SeaUnit unit;
	
	private String checkFlag;
	
	public SeaUnit getUnit() {
		return unit;
	}

	public void setUnit(SeaUnit unit) {
		this.unit = unit;
	}

	private SeaQueryParameter query;
	
	private List<Integer> bigPictures;
	
	@Autowired
	private SeaService seaService;
	
	public String view(){
		if(Judge.isNull(this.query)){
			this.query = new SeaQueryParameter();		
		}
		
		if(Judge.isNotNull(this.query.getCheck())
				&& "3".equals(this.query.getCheck())){
			query.setCheck("-2");
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
			
		this.seaService.queryHonorsForPage(this.getPage(), this.query);
		return "view";
	}
	
     public String view1(){
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
		
		this.seaService.queryHonorsForPage(this.getPage(), this.query);
		return "view1";
	}

    public String view2(){
	
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
	
	this.seaService.queryHonorsForPage(this.getPage(), this.query);
	return "view2";
}

	public String  showorker(){
		this.worker = this.seaService.querySeaWorkerById(this.worker);
		this.pushJSON("result", worker);
		return "json";
	}
    
	public String  showunit(){
		this.unit = this.seaService.querySeaUnitById(this.unit);
		this.pushJSON("result", unit);
		return "json";
	}
	
    
	public String add() {
        SysUser logined  = (SysUser)this.getSession().get(Const.USERINFO_IN_SESSION);
        SeaWorker worker =  new SeaWorker();
        
        List<SeaUnit> units = this.seaService.queryUnitList(new SeaUnit());
 		this.pushRequest("units", units);
         
		if(Judge.isNotNull(logined.getUnitId())){
			worker.setUnitId(logined.getUnitId());
		}

		List<SeaWorker> workers = this.seaService.queryWorkerList(worker);
		this.pushRequest("workers", workers);

		if(Judge.isNotNull(this.honor)
				&& Judge.isNotNull(this.honor.getId())){
			this.honor = this.seaService.querySeaHonorById(this.honor);	
			
			if(Judge.isNotNull(this.honor.getHonorWorker())){
				worker.setId(this.honor.getHonorWorker());
				this.worker = this.seaService.querySeaWorkerById(worker);		
			}			
		}else {
			this.honor = new SeaHonor();
		
		}

		return "add";
	}
	
	public String check1() {
        SysUser logined  = (SysUser)this.getSession().get(Const.USERINFO_IN_SESSION);
        SeaWorker worker =  new SeaWorker();
        
        List<SeaUnit> units = this.seaService.queryUnitList(new SeaUnit());
 		this.pushRequest("units", units);
         
		if(Judge.isNotNull(logined.getUnitId())){
			worker.setUnitId(logined.getUnitId());
		}

		List<SeaWorker> workers = this.seaService.queryWorkerList(worker);
		this.pushRequest("workers", workers);

		if(Judge.isNotNull(this.honor)
				&& Judge.isNotNull(this.honor.getId())){
			this.honor = this.seaService.querySeaHonorById(this.honor);	
			
			if(Judge.isNotNull(this.honor.getHonorWorker())){
				worker.setId(this.honor.getHonorWorker());
				this.worker = this.seaService.querySeaWorkerById(worker);		
			}			
		}else {
			this.honor = new SeaHonor();
		
		}

		return "check1";
	}
	
	
	public String detail(){
		    SysUser logined  = (SysUser)this.getSession().get(Const.USERINFO_IN_SESSION);
	        SeaWorker worker =  new SeaWorker();
	         
	        List<SeaUnit> units = this.seaService.queryUnitList(new SeaUnit());
	 		this.pushRequest("units", units);
	         
			if(Judge.isNotNull(logined.getUnitId())){
				worker.setUnitId(logined.getUnitId());
			}

			List<SeaWorker> workers = this.seaService.queryWorkerList(worker);
			this.pushRequest("workers", workers);

			if(Judge.isNotNull(this.honor)
					&& Judge.isNotNull(this.honor.getId())){
				this.honor = this.seaService.querySeaHonorById(this.honor);	
				worker.setId(this.honor.getHonorWorker());
				this.worker = this.seaService.querySeaWorkerById(worker);		
			}

			return "detail";		
	}
	
	public String save(){
		this.honor.setCreateTime(new Date());
		this.honor.setIsDelete(0);
		
		if(Judge.isNull(this.honor.getInUnit())){
			if(Judge.isNotNull(this.logined(true).getUnitId())){
				this.worker.setUnitId(this.logined(true).getUnitId());
				this.honor.setInUnit(this.logined(true).getUnitId());
			}else{
				this.worker.setUnitId(0);
				this.honor.setInUnit(0);
			}
		}else{
			this.worker.setUnitId(this.honor.getInUnit());
		}
		
		if(Judge.isNotNull(this.worker)){
			this.worker.setIsHard("0");
			this.worker.setCreateTime(new Date());
			if("".equals(this.worker.getId())){
				this.worker.setId(null);		
			}
		}
		
//		if(Judge.isNotNull(this.honor.getId())){
//			honor.setCheckFlag("0");
//		}
		
		if(this.logined(true).getRoleId() <= 12 
				&& Judge.isNotNull(honor.getCheckFlag()) 
				&& !honor.getCheckFlag().equals("0")){
			honor.setCheckFlag(null);
		}
//		if(Judge.isNull(checkFlag)){
//			honor.setCheckFlag("0");
//		}
		
		boolean rslt = false;
		if(Judge.isNotNull(worker.getWorkerIdnumber())){
			worker.setWorkerIdnumber(worker.getWorkerIdnumber().trim());
			SeaWorker worker1 = this.seaService.checkIdNumber(worker);
			if(worker1 != null){
				worker.setId(worker1.getId());
				honor.setHonorWorker(worker.getId());
			}
		}
		if(Judge.isNull(this.worker) 
				|| Judge.isNull(this.worker.getWorkerName()) 
				|| "".equals(this.worker.getWorkerName())){
			rslt = this.seaService.saveHonorByFiles(honor, bigPictures);	
		}else{
			rslt = this.seaService.saveHonorAndWokerByFile(honor, worker,this.bigPictures);
		}
	
		this.pushRequest("result", rslt);

		if(Judge.isNotNull(checkFlag)
				&& "1".equals(checkFlag)){
			this.pushRequest("success_url", "admin/govhonor!view1");
		}else{
			this.pushRequest("success_url", "admin/govhonor!view");
		}

		this.pushRequest("success_name", "查看荣誉列表");
		return "operate-result";
	}
	
	public String delete() {
//		boolean rslt = this.seaService.deleteHonor(this.honor.getId());
//		this.pushJSON("result", rslt);
//		return "json";
		boolean rslt = false;
		try{
			//逻辑删除
			SeaHonor honor = new SeaHonor();
			honor.setId(this.honor.getId());
			honor.setIsDelete(1);
			honor.setDeleteTime(new Date());
			rslt = this.seaService.saveHonor(honor);
		}catch (Exception ex){
			ex.printStackTrace();	
		}
		this.pushJSON("result", rslt);
		return "json";	
	}
	
	public String check(){	
		boolean rslt = this.seaService.saveHonor(this.honor);
		this.pushJSON("result", rslt);
		return "json";
	}
	
	private void honorDataList(){	
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
		
		this.seaService.queryHonorsForPage(this.getPage(), this.query);
	}
	
	
	public String exportTotal(){
		HttpServletResponse response = ServletActionContext.getResponse();        
		try
        {
			List<Map<String,Object>> dbRes = this.seaService.queryHonorTotal(query);
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
		    List<SeaHonor> honors = new ArrayList<SeaHonor>();
		  
	        try
	        {
	            OutputStream os = response.getOutputStream();// 取得输出流
	            response.reset();// 清空输出流
	            response.setHeader("Content-disposition", "attachment; filename="
	                    + new String("honordata".getBytes("GB2312"), "UTF-8") + ".xls");// 设定输出文件头
	            response.setContentType("application/msexcel");// 定义输出类型
	            WritableWorkbook workbook = Workbook.createWorkbook(os);
	            if (workbook != null)
	            {
	                WritableSheet sheet = workbook.createSheet("获奖数据", 0);
	                // 设置标题 sheet.addCell(new jxl.write.Label(列(从0开始), 行(从0开始), 内容.));
	                sheet.addCell(new Label(0, 0, "职工姓名 "));
	                sheet.addCell(new Label(1, 0, "单位名称"));
	                sheet.addCell(new Label(2, 0, "性别"));
	                sheet.addCell(new Label(3, 0, "年龄"));
	                sheet.addCell(new Label(4, 0, "身份证"));
	                sheet.addCell(new Label(5, 0, "银行卡 "));
	                sheet.addCell(new Label(6, 0, "家庭地址 "));
	                sheet.addCell(new Label(7, 0, "职工身份"));
	                sheet.addCell(new Label(8, 0, "联系电话"));
	                sheet.addCell(new Label(9, 0, "获奖时间"));
	                sheet.addCell(new Label(10, 0, "荣誉种类 "));
	                sheet.addCell(new Label(11, 0, "荣誉级别 "));
	                sheet.addCell(new Label(12, 0, "个人主要事迹 "));
	                sheet.addCell(new Label(13, 0, "所属单位 "));
	                sheet.addCell(new Label(14, 0, "成立时间"));
	                sheet.addCell(new Label(15, 0, "负责人"));
	                sheet.addCell(new Label(16, 0, "集体主要事迹"));
	                sheet.addCell(new Label(17, 0, "表彰文件签发单位标题文号"));
	                sheet.addCell(new Label(18, 0, "奖章编号"));
	                sheet.addCell(new Label(19, 0, "审核状态"));
	                
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
	                sheet.setColumnView(16, 30);
	                sheet.setColumnView(17, 30);
	                sheet.setColumnView(18, 30);
	                sheet.setColumnView(19, 30);
	                
	                this.getPage().setOffset(50000);
	                honorDataList();
	                
	                if(Judge.isNotNull(this.getPage().getBeans())){
	                	honors = (List<SeaHonor>)this.getPage().getBeans();	
	                }
	                  
	                for (int i = 0; i < honors.size(); i++) {
	                    //行编号   
	                	SeaHonor honor = honors.get(i);   
	                    
	                	if(Judge.isNotNull(honor.getWorkerInfo().getWorkerName())){	
	                		sheet.addCell(new Label(0, i+1, honor.getWorkerInfo().getWorkerName()));
	                	}else{
	                		sheet.addCell(new Label(0, i+1, ""));
	                	}
	                           
	                    sheet.addCell(new Label(1, i+1, honor.getUnitInfo().getUnitName()));
	  	                sheet.addCell(new Label(2, i+1, honor.getWorkerInfo().getWorkerSex()));
	  	                sheet.addCell(new Label(3, i+1, honor.getWorkerInfo().getWorkerAge()));
	  	                sheet.addCell(new Label(4, i+1, honor.getWorkerInfo().getWorkerIdnumber()));
	  	                sheet.addCell(new Label(5, i+1, honor.getWorkerInfo().getBankCard()));
	  	                sheet.addCell(new Label(6, i+1, honor.getWorkerInfo().getWorkerAddress()));
	  	                sheet.addCell(new Label(7, i+1, honor.getWorkerInfo().getWorkDuty()));
	  	                sheet.addCell(new Label(8, i+1, honor.getWorkerInfo().getWorkerPhone()));
	  	                sheet.addCell(new Label(9, i+1, DateHelper.dateToString(honor.getHonorTime())));
	  	                sheet.addCell(new Label(10, i+1, honor.getHonorType()));
	  	                sheet.addCell(new Label(11, i+1, honor.getHonorLevel()));
	  	                sheet.addCell(new Label(12, i+1, honor.getHonorDesc()));
	  	                sheet.addCell(new Label(13, i+1, honor.getUnitInfo().getUnitName()));
	  	                sheet.addCell(new Label(14, i+1, DateHelper.dateToString(honor.getUnitInfo().getJoinTime())));
	  	                sheet.addCell(new Label(15, i+1, honor.getUnitInfo().getUnitDuty()));
	  	                sheet.addCell(new Label(16, i+1, honor.getUnitHonorDesc()));
	  	                sheet.addCell(new Label(17, i+1, honor.getHonorTitle()));
	  	                sheet.addCell(new Label(18, i+1,  honor.getHonorCode())); 
	  	                sheet.addCell(new Label(19, i+1, changeCheckFlag(honor.getCheckFlag())));
	                	
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
	public SeaHonor getHonor() {
		return honor;
	}

	public void setHonor(SeaHonor honor) {
		this.honor = honor;
	}

	public SeaQueryParameter getQuery() {
		return query;
	}

	public void setQuery(SeaQueryParameter query) {
		this.query = query;
	}

	public SeaWorker getWorker() {
		return worker;
	}

	public void setWorker(SeaWorker worker) {
		this.worker = worker;
	}

	public List<Integer> getBigPictures() {
		return bigPictures;
	}

	public void setBigPictures(List<Integer> bigPictures) {
		this.bigPictures = bigPictures;
	}

	public String getCheckFlag() {
		return checkFlag;
	}

	public void setCheckFlag(String checkFlag) {
		this.checkFlag = checkFlag;
	}
	
	
}
