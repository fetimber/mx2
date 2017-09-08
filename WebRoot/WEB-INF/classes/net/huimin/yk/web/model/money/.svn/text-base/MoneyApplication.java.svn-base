package net.huimin.yk.web.model.money;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.huimin.yk.web.model.agent.AgentUser;
import net.huimin.yk.web.model.customer.CustomerApplication;
import net.huimin.yk.web.model.customer.CustomerMoney;
import net.huimin.yk.web.model.system.SysUser;

public class MoneyApplication {
    /**
     * 主键
     */
    private Integer id;

    private Integer accountId;

    private BigDecimal amountMoney;

    private BigDecimal finalMoney;

    private Date applicationTime;

    private String remark;

    private Date finishTime;

    private Integer operaterId;

    private Integer pmId;
    
    private Integer resultStatus;
    
    private Integer customerId;
    
    private List<MoneyDetail> detailInfo;
    
    private String applicationTimeDesc;
    
    private String finishTimeDesc;

	private SysUser pmInfo;
    
    private MoneyBalance moneyBalance;
    
    private Integer flag;
    
    private Integer appType;
    
    private CustomerMoney  appInfo;
    
    private AgentUser agentInfo; 
   
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

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getAmountMoney() {
        return amountMoney;
    }

    public void setAmountMoney(BigDecimal amountMoney) {
        this.amountMoney = amountMoney;
    }

    public BigDecimal getFinalMoney() {
        return finalMoney;
    }

    public void setFinalMoney(BigDecimal finalMoney) {
        this.finalMoney = finalMoney;
    }

    public Date getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd  HH:mm");
		if(null != applicationTime){
		  this.setApplicationTimeDesc(format.format(this.getApplicationTime()));
		}
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd  HH:mm");
		if(null != finishTime){
		  this.setFinishTimeDesc(format.format(this.getFinishTime()));
		}
    }

    public Integer getOperaterId() {
        return operaterId;
    }

    public void setOperaterId(Integer operaterId) {
        this.operaterId = operaterId;
    }

    public Integer getPmId() {
        return pmId;
    }

    public void setPmId(Integer pmId) {
        this.pmId = pmId;
    }

	public Integer getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(Integer resultStatus) {
		this.resultStatus = resultStatus;
	}

	public List<MoneyDetail> getDetailInfo() {
		return detailInfo;
	}

	public void setDetailInfo(List<MoneyDetail> detailInfo) {
		this.detailInfo = detailInfo;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}	
	
	public String getApplicationTimeDesc() {
		return applicationTimeDesc;
	}

	public void setApplicationTimeDesc(String applicationTimeDesc) {
		this.applicationTimeDesc = applicationTimeDesc;
	}
	
    public String getFinishTimeDesc() {
		return finishTimeDesc;
	}

	public void setFinishTimeDesc(String finishTimeDesc) {
		this.finishTimeDesc = finishTimeDesc;
	}
	
	public SysUser getPmInfo() {
		return pmInfo;
	}

	public void setPmInfo(SysUser pmInfo) {
		this.pmInfo = pmInfo;
	}


	public MoneyBalance getMoneyBalance() {
		return moneyBalance;
	}

	public void setMoneyBalance(MoneyBalance moneyBalance) {
		this.moneyBalance = moneyBalance;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Integer getAppType() {
		return appType;
	}

	public void setAppType(Integer appType) {
		this.appType = appType;
	}

	public CustomerMoney getAppInfo() {
		return appInfo;
	}

	public void setAppInfo(CustomerMoney appInfo) {
		this.appInfo = appInfo;
	}

	public AgentUser getAgentInfo() {
		return agentInfo;
	}

	public void setAgentInfo(AgentUser agentInfo) {
		this.agentInfo = agentInfo;
	}

}