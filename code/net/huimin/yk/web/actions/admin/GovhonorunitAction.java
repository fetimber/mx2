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

public class GovhonorunitAction  extends AbstractAction{

	private SeaHonorUnit honor;
	
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
		
		
		this.seaService.queryHonorsUnitForPage(this.getPage(), this.query);
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
		
		this.seaService.queryHonorsUnitForPage(this.getPage(), this.query);
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
	
	this.seaService.queryHonorsUnitForPage(this.getPage(), this.query);
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

//		List<SeaWorker> workers = this.seaService.queryWorkerList(worker);
//		this.pushRequest("workers", workers);

		if(Judge.isNotNull(this.honor)
				&& Judge.isNotNull(this.honor.getId())){
			this.honor = this.seaService.querySeaHonorUnitById(this.honor);	
			
//			if(Judge.isNotNull(this.honor.getHonorWorker())){
//				worker.setId(this.honor.getHonorWorker());
//				this.worker = this.seaService.querySeaWorkerById(worker);		
//			}			
		}else {
			this.honor = new SeaHonorUnit();
		
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
			this.honor = this.seaService.querySeaHonorUnitById(this.honor);				
		}else {
			this.honor = new SeaHonorUnit();
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
				this.honor = this.seaService.querySeaHonorUnitById(this.honor);		
			}

			return "detail";		
	}
	
	public String save(){
		this.honor.setCreateTime(new Date());
		this.honor.setIsDelete(0);
		
		if(this.logined(true).getRoleId() <= 12 
				&& !honor.getCheckFlag().equals("0")){
			honor.setCheckFlag(null);
		}
		
		if(Judge.isNotNull(this.logined(false).getCityId())){
			honor.setUnitLocation(this.logined(false).getCityInfo().getCityName());
		}
		
		if(Judge.isNotNull(this.logined(false).getUnitId())){
			honor.setHonorUnit(this.logined(false).getUnitInfo().getUnitName());
		}
		
		this.honor.setAddUser(this.logined(false).getId());

		boolean rslt = this.seaService.saveHonorUnitByFiles(honor, bigPictures);	
		this.pushRequest("result", rslt);

		if(Judge.isNotNull(checkFlag)
				&& "1".equals(checkFlag)){
			this.pushRequest("success_url", "admin/govhonorunit!view1");
		}else{
			this.pushRequest("success_url", "admin/govhonorunit!view");
		}

		this.pushRequest("success_name", "查看单位荣誉列表");
		return "operate-result";
	}
	
	public String delete() {
		boolean rslt = false;
		try{
			//逻辑删除
			SeaHonorUnit unit = new SeaHonorUnit();
			unit.setId(this.honor.getId());
			unit.setIsDelete(1);
			unit.setDeleteTime(new Date());
			rslt = this.seaService.saveHonorUnit(unit);
		}catch (Exception ex){
			ex.printStackTrace();	
		}
		this.pushJSON("result", rslt);
		return "json";
	}
	
	public String check(){	
		boolean rslt = this.seaService.saveHonorUnit(this.honor);
		this.pushJSON("result", rslt);
		return "json";
	}
	
	
	private void honorUnitDataList(){	
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
		
		this.seaService.queryHonorsUnitForPage(this.getPage(), this.query);
	}
	

	public String exportTotal(){
		HttpServletResponse response = ServletActionContext.getResponse();        
		try
        {
			List<Map<String,Object>> dbRes = this.seaService.queryHonorUnitTotal(query);
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
		    List<SeaHonorUnit> honorUnits = new ArrayList<SeaHonorUnit>();
		  
	        try
	        {
	            OutputStream os = response.getOutputStream();// 取得输出流
	            response.reset();// 清空输出流
	            response.setHeader("Content-disposition", "attachment; filename="
	                    + new String("honorunitdata".getBytes("GB2312"), "UTF-8") + ".xls");// 设定输出文件头
	            response.setContentType("application/msexcel");// 定义输出类型
	            WritableWorkbook workbook = Workbook.createWorkbook(os);
	            if (workbook != null)
	            {
	                WritableSheet sheet = workbook.createSheet("获奖数据", 0);
	                // 设置标题 sheet.addCell(new jxl.write.Label(列(从0开始), 行(从0开始), 内容.));
	                sheet.addCell(new Label(0, 0, "单位名称 "));
	                sheet.addCell(new Label(1, 0, "所在地"));
	                sheet.addCell(new Label(2, 0, "单位电话"));
	                sheet.addCell(new Label(3, 0, "单位负责人"));
	                sheet.addCell(new Label(4, 0, "工会主席"));
	                sheet.addCell(new Label(5, 0, "获奖岗位责任人 "));
	                sheet.addCell(new Label(6, 0, "荣誉种类 "));
	                sheet.addCell(new Label(7, 0, "集体事迹"));
	                sheet.addCell(new Label(8, 0, "表彰文件签发单位标题文号"));
	                sheet.addCell(new Label(9, 0, "获奖时间 "));
	                sheet.addCell(new Label(10, 0, "创建时间 "));
	                sheet.addCell(new Label(11, 0, "审核状态"));
	                
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
               
	                this.getPage().setOffset(50000);
	                honorUnitDataList();
	                
	                if(Judge.isNotNull(this.getPage().getBeans())){
	                	honorUnits = (List<SeaHonorUnit>)this.getPage().getBeans();	
	                }
	                  
	                for (int i = 0; i < honorUnits.size(); i++) {
	                    //行编号   
	                	SeaHonorUnit honor = honorUnits.get(i);   
	                    
	                    sheet.addCell(new Label(0, i+1, honor.getHonorUnit()));
	                    sheet.addCell(new Label(1, i+1, honor.getUnitLocation()));
	  	                sheet.addCell(new Label(2, i+1, honor.getUnitPhone()));
	  	                sheet.addCell(new Label(3, i+1, honor.getUnitDuty()));
	  	                sheet.addCell(new Label(4, i+1, honor.getUnitLeader()));
	  	                sheet.addCell(new Label(5, i+1, honor.getHonorDuty()));
	  	                sheet.addCell(new Label(6, i+1, honor.getHonorType()));
	  	                sheet.addCell(new Label(7, i+1, honor.getUnitHonorDesc()));	  	                
	  	                sheet.addCell(new Label(8, i+1, honor.getHonorTitle()));
	  	                sheet.addCell(new Label(9, i+1, DateHelper.dateToString(honor.getHonorTime())));
	  	                sheet.addCell(new Label(10, i+1, DateHelper.dateToString(honor.getCreateTime())));
	  	                sheet.addCell(new Label(11, i+1, changeCheckFlag(honor.getCheckFlag())));

	  	                //	  	             	
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
	


		public SeaService getSeaService() {
			return seaService;
		}

		public void setSeaService(SeaService seaService) {
			this.seaService = seaService;
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

	public SeaHonorUnit getHonor() {
		return honor;
	}

	public void setHonor(SeaHonorUnit honor) {
		this.honor = honor;
	}
	
	
}
