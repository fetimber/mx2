package net.huimin.yk.web.model.agent;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import net.huimin.yk.web.model.common.Files;
import net.huimin.yk.web.model.customer.CustomeRecord;
import net.huimin.yk.web.model.system.SysAccount;
import net.huimin.yk.web.model.system.SysUser;

public class AgentUser {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 登录名
     */
    private Integer referId;

    private String referNumber;
    
    private Integer accountId;

    private Integer realNameValidate;

    private String phoneDecimal;
    
    private String idtNum;
    
    private Integer idtFileid;
    
    private Integer cardFileid;
    
    private String bankAccount;
    
    private String bankName;
    
    private String company;

	private String wechatId;
	
	private String workArea;
	
	private String workSpace;

    private BigDecimal customerCount;
    
    private BigDecimal customerNewmessage;
    
    private BigDecimal referCount;
    
    private BigDecimal moneyTotal;
    
    private Integer userId;
    
    private String checkRemark;
    
    private Integer autoLogin;
    
	private SysAccount account;

    private SysUser user;
    
    private Files idtFileInfo;
    
    private Files cardFileInfo;

    private BigDecimal arrivedCount;
    
    private BigDecimal signCount;
    
    private Date dealTime;
    
    private String dealContent;
    
    private String agentPerson;
    
    private String personPhone;
    
    private Date nextTime;
    
    private String agentGroup;
    
    private Integer source;

	private  List<CustomeRecord> records;
    
    private Integer messageTotal;
  
	public Integer getMessageTotal() {
		return messageTotal;
	}

	public void setMessageTotal(Integer messageTotal) {
		this.messageTotal = messageTotal;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	/**
     * @return 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 
	 *            主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 登录名
     */
    public Integer getReferId() {
        return referId;
    }

    /**
     * @param referId 
	 *            登录名
     */
    public void setReferId(Integer referId) {
        this.referId = referId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getRealNameValidate() {
        return realNameValidate;
    }

    public void setRealNameValidate(Integer realNameValidate) {
        this.realNameValidate = realNameValidate;
    }

    public String getPhoneDecimal() {
        return phoneDecimal;
    }

    public void setPhoneDecimal(String phoneDecimal) {
        this.phoneDecimal = phoneDecimal;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public BigDecimal getCustomerCount() {
        return customerCount;
    }

    public void setCustomerCount(BigDecimal customerCount) {
        this.customerCount = customerCount;
    }
    
    public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public SysAccount getAccount() {
		return account;
	}

	public void setAccount(SysAccount account) {
		this.account = account;
	}

	public SysUser getUser() {
		return user;
	}

	public void setUser(SysUser user) {
		this.user = user;
	}
	
    public Integer getAutoLogin() {
		return autoLogin;
	}

	public void setAutoLogin(Integer autoLogin) {
		this.autoLogin = autoLogin;
	}
	
	public String getIdtNum() {
		return idtNum;
	}

	public void setIdtNum(String idtNum) {
		this.idtNum = idtNum;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getIdtFileid() {
		return idtFileid;
	}

	public void setIdtFileid(Integer idtFileid) {
		this.idtFileid = idtFileid;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getWorkArea() {
		return workArea;
	}

	public void setWorkArea(String workArea) {
		this.workArea = workArea;
	}

	public String getWorkSpace() {
		return workSpace;
	}

	public void setWorkSpace(String workSpace) {
		this.workSpace = workSpace;
	}

	public BigDecimal getCustomerNewmessage() {
		return customerNewmessage;
	}

	public void setCustomerNewmessage(BigDecimal customerNewmessage) {
		this.customerNewmessage = customerNewmessage;
	}

	public BigDecimal getReferCount() {
		return referCount;
	}

	public void setReferCount(BigDecimal referCount) {
		this.referCount = referCount;
	}

	public BigDecimal getMoneyTotal() {
		return moneyTotal;
	}

	public void setMoneyTotal(BigDecimal moneyTotal) {
		this.moneyTotal = moneyTotal;
	}

	public String getCheckRemark() {
		return checkRemark;
	}

	public void setCheckRemark(String checkRemark) {
		this.checkRemark = checkRemark;
	}

	public Files getIdtFileInfo() {
		return idtFileInfo;
	}

	public void setIdtFileInfo(Files idtFileInfo) {
		this.idtFileInfo = idtFileInfo;
	}

	public Files getCardFileInfo() {
		return cardFileInfo;
	}

	public void setCardFileInfo(Files cardFileInfo) {
		this.cardFileInfo = cardFileInfo;
	}

	public Integer getCardFileid() {
		return cardFileid;
	}

	public void setCardFileid(Integer cardFileid) {
		this.cardFileid = cardFileid;
	}

	public String getReferNumber() {
		return referNumber;
	}

	public void setReferNumber(String referNumber) {
		this.referNumber = referNumber;
	}

	public BigDecimal getArrivedCount() {
		return arrivedCount;
	}

	public void setArrivedCount(BigDecimal arrivedCount) {
		this.arrivedCount = arrivedCount;
	}

	public BigDecimal getSignCount() {
		return signCount;
	}

	public void setSignCount(BigDecimal signCount) {
		this.signCount = signCount;
	}

	public Date getDealTime() {
		return dealTime;
	}

	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}

	public String getDealContent() {
		return dealContent;
	}

	public void setDealContent(String dealContent) {
		this.dealContent = dealContent;
	}

	public String getAgentPerson() {
		return agentPerson;
	}

	public void setAgentPerson(String agentPerson) {
		this.agentPerson = agentPerson;
	}

	public String getPersonPhone() {
		return personPhone;
	}

	public void setPersonPhone(String personPhone) {
		this.personPhone = personPhone;
	}

	public Date getNextTime() {
		return nextTime;
	}

	public void setNextTime(Date nextTime) {
		this.nextTime = nextTime;
	}

	public String getAgentGroup() {
		return agentGroup;
	}

	public void setAgentGroup(String agentGroup) {
		this.agentGroup = agentGroup;
	}

	public List<CustomeRecord> getRecords() {
		return records;
	}

	public void setRecords(List<CustomeRecord> records) {
		this.records = records;
	}	

}