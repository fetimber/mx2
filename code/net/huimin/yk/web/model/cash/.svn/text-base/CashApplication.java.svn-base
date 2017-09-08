package net.huimin.yk.web.model.cash;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.huimin.yk.web.model.agent.AgentUser;
import net.huimin.yk.web.model.money.MoneyApplication;
import net.huimin.yk.web.model.system.SysAccount;

public class CashApplication {
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

    private Integer resultStatus;
    
    private Integer moneyId;
    
    private List<CashDetail> detailInfo;
    
    private String applicationTimeDesc;
    
    private String finishTimeDesc;
    
    private MoneyApplication moneyAppInfo;
    
    private SysAccount accountInfo;
    
    private AgentUser agentInfo;
    
    private Integer flag;
    
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

	public Integer getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(Integer resultStatus) {
		this.resultStatus = resultStatus;
	}

	public List<CashDetail> getDetailInfo() {
		return detailInfo;
	}

	public void setDetailInfo(List<CashDetail> detailInfo) {
		this.detailInfo = detailInfo;
	}

	public Integer getMoneyId() {
		return moneyId;
	}

	public void setMoneyId(Integer moneyId) {
		this.moneyId = moneyId;
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

	public MoneyApplication getMoneyAppInfo() {
		return moneyAppInfo;
	}

	public void setMoneyAppInfo(MoneyApplication moneyAppInfo) {
		this.moneyAppInfo = moneyAppInfo;
	}

	public SysAccount getAccountInfo() {
		return accountInfo;
	}

	public void setAccountInfo(SysAccount accountInfo) {
		this.accountInfo = accountInfo;
	}

	public AgentUser getAgentInfo() {
		return agentInfo;
	}

	public void setAgentInfo(AgentUser agentInfo) {
		this.agentInfo = agentInfo;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}


}