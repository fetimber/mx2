package net.huimin.yk.web.model.money;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MoneyBalance {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 账户ID
     */
    private Integer accountId;

    private BigDecimal amountMoney;

    private BigDecimal finalMoney;

    /**
     * 申请时间
     */
    private Date applicationTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 完成时间
     */
    private Date finishTime;

    /**
     * 操作人ID
     */
    private Integer operaterId;

    /**
     * 申请ID
     */
    private Integer applicationId;
    
    /**
     * 
     */
    private MoneyApplication moneyApp;
    
    /**
     * 结束时间的字符串表示
     */
    private String finishTimeDesc;


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
     * @return 账户ID
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * @param accountId 
	 *            账户ID
     */
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

    /**
     * @return 申请时间
     */
    public Date getApplicationTime() {
        return applicationTime;
    }

    /**
     * @param applicationTime 
	 *            申请时间
     */
    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    /**
     * @return 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark 
	 *            备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return 完成时间
     */
    public Date getFinishTime() {
        return finishTime;
    }

    /**
     * @param finishTime 
	 *            完成时间
     */
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm");
		if(null != finishTime){
		  this.setFinishTimeDesc(format.format(this.getFinishTime()));
		}
    }

    /**
     * @return 操作人ID
     */
    public Integer getOperaterId() {
        return operaterId;
    }

    /**
     * @param operaterId 
	 *            操作人ID
     */
    public void setOperaterId(Integer operaterId) {
        this.operaterId = operaterId;
    }

    /**
     * @return 申请ID
     */
    public Integer getApplicationId() {
        return applicationId;
    }

    /**
     * @param applicationId 
	 *            申请ID
     */
    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

	public MoneyApplication getMoneyApp() {
		return moneyApp;
	}

	public void setMoneyApp(MoneyApplication moneyApp) {
		this.moneyApp = moneyApp;
	}
	
    public String getFinishTimeDesc() {
		return finishTimeDesc;
	}

	public void setFinishTimeDesc(String finishTimeDesc) {
		this.finishTimeDesc = finishTimeDesc;
	}
    
}