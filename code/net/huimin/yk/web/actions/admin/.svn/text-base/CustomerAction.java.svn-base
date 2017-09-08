package net.huimin.yk.web.actions.admin;

import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import net.huimin.common.cnst.Const;
import net.huimin.common.helper.DateHelper;
import net.huimin.common.helper.EmptyBean;
import net.huimin.common.helper.Judge;
import net.huimin.common.mvc.AbstractAction;
import net.huimin.yk.web.model.agent.AgentUser;
import net.huimin.yk.web.model.call.CallTeam;
import net.huimin.yk.web.model.call.CallUser;
import net.huimin.yk.web.model.cash.CashApplication;
import net.huimin.yk.web.model.cash.CashDetail;
import net.huimin.yk.web.model.common.Area;
import net.huimin.yk.web.model.customer.CustomeRecord;
import net.huimin.yk.web.model.customer.CustomerApplication;
import net.huimin.yk.web.model.customer.CustomerMoney;
import net.huimin.yk.web.model.customer.CustomerQueryParameter;
import net.huimin.yk.web.model.houses.HousesProject;
import net.huimin.yk.web.model.money.MoneyApplication;
import net.huimin.yk.web.model.money.MoneyBalance;
import net.huimin.yk.web.model.money.MoneyDetail;
import net.huimin.yk.web.model.system.SysAccount;
import net.huimin.yk.web.model.system.SysUser;
import net.huimin.yk.web.services.common.AccountService;
import net.huimin.yk.web.services.common.CommonService;
import net.huimin.yk.web.services.customer.CustomerService;
import net.huimin.yk.web.services.finace.FinaceService;
import net.huimin.yk.web.services.houses.HousesService;
import net.huimin.yk.web.services.system.AgentService;
import net.huimin.yk.web.services.system.UserService;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 客户管理
 * @author Administrator
 *
 */
public class CustomerAction extends AbstractAction{

	@Autowired
	private  CustomerService customerService;
	@Autowired
	private  HousesService houseService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private FinaceService finaceService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private UserService userService;
	@Autowired
	private AgentService agentService;
	
	private CustomerApplication customerApplication;
	
	private CustomerQueryParameter param;
	
	private List<HousesProject> houseList;
	
	private List<Area> areaList;
	
	private CallTeam  teamInfo;
	
	private Integer[] calluser;
	
	
	
	public String execute() {
		return RESULT_LOGIN;
	}

	public String view(){
		if(this.logined(false).getRoleId().equals(3)){
			teamInfo = this.userService.queryTeamByUserid(this.logined(false).getId());
		}
		
		/**
		this.getPage().setOffset(10);
		this.getPage().setStart((this.getPage().getCurrent() -1 ) * this.getPage().getOffset());
		
		areaList = commonService.quertAreaList(null);
		
		houseList = this.houseService.selectAllProjectByConditions(new HousesProject());
		
		//Call客队长 ROLE_ID
		customerService.queryCustomerListForPage(this.getPage(), customerApplication);
		return "view";
		**/
		return this.search();
	}
	
	//查询
	public String search(){
		customerList();
		return "view";
	}
	
	private void customerList(){	
		if(Judge.isNull(this.param)){
			this.param = new CustomerQueryParameter();
		}
		this.param.setIsTeamLeader(Integer.valueOf(3).equals(this.logined(false).getRoleId()));
		this.param.setIsTeam(Integer.valueOf(4).equals(this.logined(false).getRoleId()));
		this.param.setUserId(this.logined(false).getId());
		if(Judge.isNull(this.param.getTableType())){
			this.param.setTableType(Integer.valueOf(0));
		}
		
		this.customerService.queryCustomerForPage(this.getPage(),this.param);
		
	}
	
	//导出
	public String export(){
	    HttpServletResponse response = ServletActionContext.getResponse();
	        
	    List<CustomerApplication> customers = new ArrayList<CustomerApplication>();
	  
        try
        {
            OutputStream os = response.getOutputStream();// 取得输出流
            response.reset();// 清空输出流
            response.setHeader("Content-disposition", "attachment; filename="
                    + new String("customerdata".getBytes("GB2312"), "UTF-8") + ".xls");// 设定输出文件头
            response.setContentType("application/msexcel");// 定义输出类型
            WritableWorkbook workbook = Workbook.createWorkbook(os);
            if (workbook != null)
            {
                WritableSheet sheet = workbook.createSheet("客户数据", 0);
                // 设置标题 sheet.addCell(new jxl.write.Label(列(从0开始), 行(从0开始), 内容.));
                sheet.addCell(new Label(0, 0, "区域 "));
                sheet.addCell(new Label(1, 0, "项目"));
                sheet.addCell(new Label(2, 0, "客户"));
                sheet.addCell(new Label(3, 0, "客户分类"));
                sheet.addCell(new Label(4, 0, "最新跟进 "));
                sheet.addCell(new Label(5, 0, "经纪人 "));
                sheet.addCell(new Label(6, 0, "进度 "));
                sheet.addCell(new Label(7, 0, "申诉催办 "));
                sheet.addCell(new Label(8, 0, "报备时间"));
                sheet.addCell(new Label(9, 0, "下次跟进  "));
                
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
                
                this.getPage().setOffset(10000);
                customerList();
                
                if(Judge.isNotNull(this.getPage().getBeans())){
                   customers = (List<CustomerApplication>)this.getPage().getBeans();	
                }
                  
                for (int i = 0; i < customers.size(); i++) {
                    //行编号   
                	CustomerApplication customer = customers.get(i);   
                    //区域 
                	//项目
                	if(customer.getReferArea().equals(1)){
                		sheet.addCell(new Label(0, i + 1 , customer.getHouseInfo().getAreaInfo().getAreaName() + "[推]"));  
                		sheet.addCell(new Label(1, i + 1 , customer.getHouseInfo().getProjectName() + "[推]"));   
                	}else{
                		sheet.addCell(new Label(0, i + 1 , customer.getHouseInfo().getAreaInfo().getAreaName()));   
                		sheet.addCell(new Label(1, i + 1 , customer.getHouseInfo().getProjectName()));   
                	}
                    
                	//客户
                	sheet.addCell(new Label(2, i + 1, customer.getCustomerName()+ "[" + customer.getCustomerDecimal() +"]")); 
                	
                	
                	//客户分类
                	String customerDesc = "";
                	if(customer.getEffectType().equals(0) ){
                		customerDesc = "无效客户[ ";	
                	}else{
                		customerDesc = "有效 客户[";
                	}

                	if(Judge.isNull(customer.getCustomerLevel())
                			|| customer.getCustomerLevel().equals(1)){
                		customerDesc += "A类 ]";	
                	}else if (customer.getCustomerLevel().equals(2)){
                		customerDesc += "B类]";
                	}else if (customer.getCustomerLevel().equals(3)){
                		customerDesc += "C类]";
                	}else if (customer.getCustomerLevel().equals(4)){
                		customerDesc += "D类]";
                	}else if (customer.getCustomerLevel().equals(5)){
                		customerDesc += "E类]";
                	}
                	
                	sheet.addCell(new Label(3, i + 1,  customerDesc)); 
            		
                	// 最后跟进
                	if(Judge.isNotNull(customer.getDuty())){
                		sheet.addCell(new Label(4, i + 1,  customer.getDuty().getRealName() + "[" +  customer.getDuty().getPhone()  + "]")); 
                	}else{
                		sheet.addCell(new Label(4, i + 1, "暂无跟进人")); 
                	}
                	
                	// 经纪人
                	if(Judge.isNotNull(customer.getAgentInfo())){
                		if(Judge.isNotNull(customer.getAgentInfo().getUser().getNickName())){
                			sheet.addCell(new Label(5, i + 1,  customer.getAgentInfo().getUser().getNickName() + "[" +  customer.getAgentInfo().getPhoneDecimal()  + "]")); 
                		}else {
                			sheet.addCell(new Label(5, i + 1,   "[" +  customer.getAgentInfo().getPhoneDecimal()  + "]")); 
                		}   		
                	}else{
                		sheet.addCell(new Label(5, i + 1, "暂无经济人")); 
                	}
                	
                	// 进度
                	if(customer.getCustomerStatus().equals(1)){
                		sheet.addCell(new Label(6, i + 1, "未分配"));
                	}else if (customer.getCustomerStatus().equals(2)){
                		sheet.addCell(new Label(6, i + 1, "未处理"));
                	}else if (customer.getCustomerStatus().equals(3)){
                		sheet.addCell(new Label(6, i + 1, "电联"));
                	}else if (customer.getCustomerStatus().equals(4)){
                		sheet.addCell(new Label(6, i + 1, "到访"));
                	}else if (customer.getCustomerStatus().equals(5)){
                		sheet.addCell(new Label(6, i + 1, "认购"));
                	}else if (customer.getCustomerStatus().equals(6)){
                		sheet.addCell(new Label(6, i + 1, "签约"));
                	}else if (customer.getCustomerStatus().equals(7)){
                		sheet.addCell(new Label(6, i + 1, "申请结佣"));
                	}else if (customer.getCustomerStatus().equals(8)){
                		sheet.addCell(new Label(6, i + 1, "已结佣"));
                	}else if (customer.getCustomerStatus().equals(9)){
                		sheet.addCell(new Label(6, i + 1, "申请提现"));
                	}else if (customer.getCustomerStatus().equals(10)){
                		sheet.addCell(new Label(6, i + 1, "提现成功"));
                	}
                		
                	// 申诉催办
                	String statusDesc = "";
                	if(customer.getAppealStatus().equals(1)){
                		statusDesc =  "已申诉";
                	}else{
                		statusDesc =  "未申诉"; 
                	}
                	if(customer.getPresStatus().equals(1)){
                		statusDesc +=  "已催办";
                	}else{
                		statusDesc +=  "未催办"; 
                	}
                	
                	sheet.addCell(new Label(7, i + 1, statusDesc)); 	
                	// 报备时间
                	if(Judge.isNotNull(customer.getReferTime())){
                		sheet.addCell(new Label(8, i + 1, DateHelper.dateToString(customer.getReferTime()))); 
                	}
                	
                	// 下次跟进时间
                	if(Judge.isNull(customer.getNextTime())){
                		sheet.addCell(new Label(9, i + 1, "未设置")); 
                	}else{
                		sheet.addCell(new Label(9, i + 1, DateHelper.dateToString(customer.getNextTime()))); 
                	}
	
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
	
	
	public String appeal(){
		
	   if(Judge.isNotNull(this.customerApplication) 
				&& Judge.isNotNull(this.customerApplication.getId())){
			
		   this.customerApplication = this.customerService.queryCustomer(
				   this.customerApplication);
	   }
	   
	   return "appeal";
	}
	
	public String deal(){
		Boolean result = false;
		if(Judge.isNotNull(this.customerApplication) 
				&& Judge.isNotNull(this.customerApplication.getId())){
			
			CustomeRecord record = EmptyBean.customerRecord(Const.CUSTTOMER_STATUS_ZERO, 
					this.customerApplication.getId(), this.logined(false).getId(), this.logined(false).getRoleId(), this.customerApplication.getRemark());
			
	
			result = this.customerService.appealCustomer(customerApplication, record);
	    }
		
		return result ?  this.view() : RESULT_ERROR;
	}
	
	//跟踪状态
	public String track(){
		houseList = this.houseService.selectAllProjectByConditions(new HousesProject());	
		
	   if(Judge.isNotNull(this.customerApplication) 
				&& Judge.isNotNull(this.customerApplication.getId())){
			
		   this.customerApplication = this.customerService.queryCustomer(
				   this.customerApplication);
	   }
		
	   return "track";
	}
	
	//跟踪状态
	public String track_confirm(){
		Boolean result = false;
		
		//主表中的数据不更新
		String trackRemark = this.customerApplication.getRemark();
		
		this.customerApplication.setRemark(null);
		
		if(Judge.isNotNull(this.customerApplication.getAgentInfo())){
			this.agentService.insertOrUpdateAgent(this.customerApplication.getAgentInfo());
		}
			
		if(Judge.isNotNull(this.customerApplication) 
				&& Judge.isNotNull(this.customerApplication.getId())){
			this.customerApplication.setDutyId(this.logined(false).getId());
			result = this.customerService.customerUpdate(this.customerApplication);
			
			if(result){
				//更新最后根据时间
				this.customerApplication.setFollowTime(new Date());
				this.customerApplication.setFollowTimeDesc(trackRemark);
			
				String remark = "";
				if(Judge.isNotNull(this.customerApplication.getCustomerStatus())){
					//if(this.customerApplication.getCustomerStatus().equals(Const.CUSTTOMER_STATUS_TWO)){
					//	remark = "分配";
					//}
					if(this.customerApplication.getCustomerStatus().equals(Const.CUSTTOMER_STATUS_THREE)){
						remark = "电联";
					}else if(this.customerApplication.getCustomerStatus().equals(Const.CUSTTOMER_STATUS_FOUR)){
						remark = "到访";
					}else if(this.customerApplication.getCustomerStatus().equals(Const.CUSTTOMER_STATUS_FIVE)){
						remark = "认购";
						
					}else if(this.customerApplication.getCustomerStatus().equals(Const.CUSTTOMER_STATUS_SIX)){
						remark = "签约";
					}else if(this.customerApplication.getCustomerStatus().equals(Const.CUSTTOMER_STATUS_SEEVEN)){
						remark = "申请结佣";
					}else if(this.customerApplication.getCustomerStatus().equals(Const.CUSTTOMER_STATUS_EIGHT)){
						remark = "已结佣";
					}
				}else if (this.customerApplication.getAppealStatus().equals(2)){
					this.customerApplication.setCustomerStatus(Const.ABLE_TYPE);
					remark = "申诉处理";
				}
				
				String customerDesc = "";
				if(Judge.isNull(this.customerApplication.getCustomerLevel())
            			|| (this.customerApplication.getCustomerLevel().equals(1))){
            		customerDesc = "A类 ";	
            	}else if ((this.customerApplication.getCustomerLevel().equals(2))){
            		customerDesc = "B类";
            	}else if ((this.customerApplication.getCustomerLevel().equals(3))){
            		customerDesc = "C类";
            	}else if ((this.customerApplication.getCustomerLevel().equals(4))){
            		customerDesc = "D类";
            	}else if ((this.customerApplication.getCustomerLevel().equals(5))){
            		customerDesc = "E类";
            	}
            	
				CustomeRecord record = EmptyBean.customerRecord(this.customerApplication.getCustomerStatus(), 
						this.customerApplication.getId(), this.logined(false).getId(), 
						this.logined(false).getRoleId(), remark + " " + trackRemark  + " 客户等级[" + customerDesc.trim() + "]");
						
				if(this.customerApplication.getCustomerStatus().equals(Const.CUSTTOMER_STATUS_TWO)){
				     record = null;	
			    }
				
			
				
				result = this.customerService.trackCustomer(this.customerApplication, record);	
				this.customerApplication = this.customerService.queryCustomer(this.customerApplication);
				
				//删除待处理数量
				if(Judge.isNotNull(this.customerApplication.getRecords())
						&& this.customerApplication.getRecords().size() == 1){
					 userService.updateCallUser(this.customerApplication.getDutyId() ,new Integer(1) , Const.SUB);
				}
	        }
		}
		
		this.pushRequest("result", result);
		this.pushRequest("success_url", "admin/customer!view");
		this.pushRequest("success_name", "查看客户列表");
		return "operate-result";
	}
	
	
	public String test(){
		//1  查询经纪人的可结佣金清单
		CustomerApplication application = new CustomerApplication();
		//签约状态和经纪人ID必填
		application.setCustomerStatus(Const.CUSTTOMER_STATUS_SIX);
		application.setAgentId(1);
		AgentUser agent = agentService.selectById(application.getAgentId());
		
		BigDecimal total1 = new BigDecimal(0);
		//查询签约佣金可结算列表  (结果集)
		List<CustomerApplication> signList = this.customerService.queryAgentBrokerageList(application);
		
		for(int j = 0 ; j < signList.size() ; j ++){
			CustomerApplication app = signList.get(j);
			total1 = total1.add(app.getHousePrice().multiply(new BigDecimal(app.getHouseCount())));
		}
        
		CustomerMoney record1 = new CustomerMoney();
		record1.setAccountId(agent.getAccountId());
		record1.setStatus(Const.CLICK_TYPE);
		List <CustomerMoney> resultList = this.customerService.queryCustomerMoney(record1);
		
		//其他可结佣金列表  (结果集)
		List <CustomerMoney> type1List = new ArrayList<CustomerMoney>();
		List <CustomerMoney> type2List = new ArrayList<CustomerMoney>();
		List <CustomerMoney> type3List = new ArrayList<CustomerMoney>();
		List <CustomerMoney> type4List = new ArrayList<CustomerMoney>();
		List <CustomerMoney> type5List = new ArrayList<CustomerMoney>();
		List <CustomerMoney> type6List = new ArrayList<CustomerMoney>();
		
		for (int i = 0 ;  i < resultList.size() ; i ++){
			if(resultList.get(i).getMoneyType().equals(Const.MONEY_TYPE1)){
				type1List.add(resultList.get(i));	
			}
			else if(resultList.get(i).getMoneyType().equals(Const.MONEY_TYPE2)){
				type2List.add(resultList.get(i));	
			}else if(resultList.get(i).getMoneyType().equals(Const.MONEY_TYPE3)){
				type3List.add(resultList.get(i));
			}else if(resultList.get(i).getMoneyType().equals(Const.MONEY_TYPE4)){
				type4List.add(resultList.get(i));
			}else if(resultList.get(i).getMoneyType().equals(Const.MONEY_TYPE5)){
				type5List.add(resultList.get(i));
			}else if(resultList.get(i).getMoneyType().equals(Const.MONEY_TYPE6)){	
				type6List.add(resultList.get(i));
			}
		}
		
		//2 查询可申请推荐奖列表
		Integer agentId = 1;
		List<AgentUser> referList = this.agentService.selectByReferId(agentId);
		
		//3 推荐奖申请
		CustomerMoney record2 = new CustomerMoney();	
		record2.setAccountId(agent.getAccountId());
		record2.setStatus(Const.ABLE_TYPE);
		record2.setMoneyType(Const.MONEY_TYPE4);
		List <CustomerMoney> regList = this.customerService.queryCustomerMoney(record2);

		for(int k = 0 ; k < regList.size() ; k ++){
			CustomerMoney updateRecord = regList.get(k);
			updateRecord.setStatus(Const.CLICK_TYPE);
			regList.set(k, updateRecord);
		}
		
		this.customerService.updateCustomerMoney(regList);
		
		//4 查询佣金申请表(历史记录)  结佣审核办理中  
		MoneyApplication money = new MoneyApplication();
		//账户ID必填
		money.setAccountId(1);
		money.setResultStatus(Const.MONEY_STATUS_ING);
		List<MoneyApplication>  historyList = this.finaceService.queryAgentMoneyList(money);
		
		BigDecimal total2 = new BigDecimal(0);
		for(int l = 0 ; l < historyList.size() ; l ++){
			total2 = total2.add(historyList.get(l).getAmountMoney());	
		}
		
		//5 查询经纪人的已结佣金总额 
		//账户ID必填
		MoneyBalance balance = new MoneyBalance();
		balance.setAccountId(1);
		BigDecimal total3 = new BigDecimal(0);
		this.finaceService.queryAgentMoneyBalanceListForPage(this.getPage(), balance);
		
		for(int m = 0 ;  m <this.getPage().getBeans().size() ; m ++){
			total3.add(((MoneyBalance)this.getPage().getBeans().get(m)).getFinalMoney());
		}
		
		//6 查询经纪人的提现申请表(已提现总金额)
		CashApplication cash = new CashApplication();
		cash.setAccountId(1);
		this.finaceService.queryAgentCashApplicationForPage(this.getPage(), cash,null,null,null);
		
		
		return RESULT_JSON;
	}
	
	  /**
	   * 一键申请结佣
	   * @return
	   */
	 public String test1(){
		 //账户ID
		 Integer accountId = 1;
 
		 CustomerMoney record1 = new CustomerMoney();
		 record1.setAccountId(accountId);
		 record1.setStatus(Const.CLICK_TYPE);
		 List <CustomerMoney> resultList = this.customerService.queryCustomerMoney(record1);
		 
		 for(int i= 0 ; i < resultList.size(); i ++){
			 CustomerMoney app = resultList.get(i);
			  
			 MoneyApplication moneyApp = dealMoneyApp(
					 app.getAmount(),
					 accountId,this.logined(false).getId(),null,app.getId(),
					 Const.MONEY_STATUS_ING, app.getMoneyType());
			 
			 MoneyDetail detail = dealMoneyDetail(this.logined(false).getId(),"经纪人申请结佣"); 
			 //更新主表状态
			 app.setStatus(Const.ING_TYPE);
			 
			 if(app.getMoneyType().equals(Const.MONEY_TYPE1)){
				 CustomerApplication application = app.getApp();
				 application.setCustomerStatus(Const.CUSTTOMER_STATUS_SEEVEN);
				 this.finaceService.agentMoneyApplication(moneyApp,detail,application,app);		 
			 }else{
				 this.finaceService.agentMoneyApplication(moneyApp,detail,app);	 
			 }	
		 }
		  
		 return RESULT_JSON;
	}
	 
	public String test4(){

		
		//更新消息
		CustomeRecord record = new CustomeRecord();
		record.setId(1);
		record.setMessageType(1);
		this.customerService.insertOrUpdateCustomeRecord(record);
		
		
		return RESULT_JSON;
	}
	 
	 
     
    private static MoneyApplication dealMoneyApp(BigDecimal amount,Integer accountId, Integer operatId , Integer pmId,
    		Integer customerId,Integer resultStatus ,Integer appType){
    	 MoneyApplication moneyApp = new MoneyApplication();
    	 moneyApp.setAmountMoney(amount);
		 moneyApp.setAccountId(accountId);
		 moneyApp.setApplicationTime(new Date());
		 moneyApp.setOperaterId(operatId);
		 moneyApp.setPmId(pmId);
		 moneyApp.setCustomerId(customerId);
		 moneyApp.setResultStatus(resultStatus);
		 moneyApp.setAppType(appType);
    	 
    	 return moneyApp;
    }
	 
	private static  MoneyDetail dealMoneyDetail (Integer operatId, String result){
		 MoneyDetail detail = new MoneyDetail();
		 detail.setOperaterTime(new Date());
		 detail.setOperaterId(operatId);
		 detail.setResult(result);
		 return detail;	
	} 
	 	 
	//提现申请
	public String test2(){
		 //账户ID
		 Integer acountId = 1;
		 //申请金额
		 BigDecimal amount = new BigDecimal(22);
		 SysAccount account = this.accountService.queryAccountById(acountId);
		 
		 if(amount.compareTo(account.getCash()) == 1){
			 return "申请提现金额大于账户可提现金";
		 }
		 
		 CashApplication application = new CashApplication();
		 application.setAmountMoney(amount);
		 application.setAccountId(acountId);
		 application.setApplicationTime(new Date());
		 application.setOperaterId(this.logined(false).getId());
		 application.setResultStatus(Const.MONEY_STATUS_ING);

		 CashDetail detail = new CashDetail();
		 detail.setOperaterTime(new Date());
		 detail.setOperaterId(this.logined(false).getId());
		 detail.setResult("经纪人申请提现 金额为" + amount);
		 	 
         this.finaceService.agentCashApplication(application, detail); 
    	 
 		return RESULT_JSON;
 	}
	
	/**
	 * 奖励申请
	 * @return
	 */
	public String test3(){
		//账户ID
		Integer accountId = 110;	
		//客户ID
		Integer customerApplicationId = 67;
		CustomerApplication queryBean = new CustomerApplication();
		queryBean.setId(customerApplicationId);
		CustomerApplication customerApp = this.customerService.queryCustomer(queryBean);
		
		CustomerMoney record = new CustomerMoney();
		record.setAccountId(accountId);
		record.setCustomerId(customerApplicationId);
		record.setStatus(Const.ABLE_TYPE);
		
		//签约结佣奖励
		record.setMoneyType(Const.MONEY_TYPE1);
		dealResult (record,"经纪人点击签约结佣奖励");
		customerApp.setMoneyStatus(0);
		this.customerService.updateCustomerApplication(customerApp);
		
		//申请到访奖
		record.setAccountId(accountId);
		record.setCustomerId(customerApplicationId);
		record.setStatus(Const.ABLE_TYPE);
		record.setMoneyType(Const.MONEY_TYPE2);
		dealResult (record,"经纪人点击申请到访奖励");
		customerApp.setArrivedStatus(0);
		this.customerService.updateCustomerApplication(customerApp);
		
		//申请带看奖
		record.setAccountId(accountId);
		record.setCustomerId(customerApplicationId);
		record.setStatus(Const.ABLE_TYPE);
		record.setMoneyType(Const.MONEY_TYPE3);
		dealResult (record,"经纪人点击申请带看奖励");
		customerApp.setLookStatus(0);
		this.customerService.updateCustomerApplication(customerApp);
		
		return RESULT_JSON;
	}
	
	
	private Boolean dealResult(CustomerMoney record ,String remark){
		Boolean result = false;
        List <CustomerMoney> records = this.customerService.queryCustomerMoney(record);
		
		if(Judge.isNotNull(records) && records.size() > 0 ){
			//固定取一条
			record = records.get(0);
			record.setStatus(Const.CLICK_TYPE);
			record.setRemark(remark);
			result =  this.customerService.insertOrupdateCustomerMoney(record);
			
			//增加可结佣金账户金额
			if(result){	
				accountService.clickMoney(record.getAccountId(), record.getAmount(),record.getMoneyType());	
			}
		}
		return result;
	}
	
	
	//分配客户
	public String allot(){
		Boolean result = false;
		if(Judge.isNotNull(calluser)
				&& Judge.isNotNull(customerApplication)){	
			//查询申请详细信息
			this.customerApplication = customerService.queryCustomer(customerApplication);
			this.customerApplication.setCustomerStatus(Const.CUSTTOMER_STATUS_TWO);
			this.customerApplication.setDutyId(calluser[0]);
			
			//this.customerApplication.setRemark(this.logined(false).getLoginName() + " 分配给 " + calluser[0]);
            SysUser user = this.userService.queryUser(calluser[0]);
			
			CustomeRecord record = EmptyBean.customerRecord(this.customerApplication.getCustomerStatus(), 
					this.customerApplication.getId(), this.logined(false).getId(), 
					this.logined(false).getRoleId(), this.logined(false).getLoginName() + " 分配给 " + user.getRealName());
			
		    result = this.customerService.trackCustomer(this.customerApplication, record);
		    
		    //新增待处理数量
		    userService.updateCallUser(calluser[0],new Integer(1) ,Const.ADD);
		}
	
		this.pushJSON("result", Boolean.valueOf(result));
		return RESULT_JSON;
	}

	/**
	 * 自动分配客户
	 * @return
	 */
	public String autoallot(){
		Boolean result = false;
		//选择Call客队长
		CallUser user = new CallUser();
		
		if(this.logined(false).getRoleId().equals(3)){
			teamInfo = this.userService.queryTeamByUserid(this.logined(false).getId());
			user.setTeamId(teamInfo.getId());
		}
       
		//所有未处理的请求
		List<CustomerApplication> appList =   this.customerService.queryUndealCustomerList(null);
	 
		
		//团队成员LIST
		List<CallUser> userList = userService.queryCallUserList(user);
		CustomerApplication app = new CustomerApplication();
		
		int j = 0;
		
		if(Judge.isNotNull(appList) && Judge.isNotNull(userList)){
			for(int i= 0 ; i < appList.size(); i ++){
				//查询申请详细信息
				app = appList.get(i);
				app.setCustomerStatus(Const.CUSTTOMER_STATUS_TWO);
				app.setDutyId(userList.get(j).getUserId());
				//app.setRemark(this.logined(false).getLoginName() + " 自动分配给 " + userList.get(j).getUserId());
	
				CustomeRecord record = null;
//						EmptyBean.customerRecord(app.getCustomerStatus(), 
//						app.getId(), this.logined(false).getId(), 
//						this.logined(false).getRoleId(), app.getRemark());
				
			    result = this.customerService.trackCustomer(app, record);
			    
			    //新增待处理数量
			    userService.updateCallUser(userList.get(j).getUserId() ,new Integer(1) ,Const.ADD);
			    
			    if(j == userList.size() - 1){
			    	j = 0;
			    }else{
			    	j ++;
			    }   
			}
			if(appList.size() >0 && userList.size() > 0){
				result = true;
			}
			
		}else{
			
			result = false;
		}
		
		
		this.pushJSON("result", Boolean.valueOf(result));
		return RESULT_JSON;
	}
	
	public CustomerApplication getCustomerApplication() {
		return customerApplication;
	}

	public void setCustomerApplication(CustomerApplication customerApplication) {
		this.customerApplication = customerApplication;
	}

	public List<HousesProject> getHouseList() {
		return houseList;
	}

	public void setHouseList(List<HousesProject> houseList) {
		this.houseList = houseList;
	}

	public List<Area> getAreaList() {
		return areaList;
	}
	
	public void setAreaList(List<Area> areaList) {
		this.areaList = areaList;
	}

	public CallTeam getTeamInfo() {
		return teamInfo;
	}

	public void setTeamInfo(CallTeam teamInfo) {
		this.teamInfo = teamInfo;
	}

	public Integer[] getCalluser() {
		return calluser;
	}

	public void setCalluser(Integer[] calluser) {
		this.calluser = calluser;
	}

	public CustomerQueryParameter getParam() {
		return param;
	}

	public void setParam(CustomerQueryParameter param) {
		this.param = param;
	}
	
}
