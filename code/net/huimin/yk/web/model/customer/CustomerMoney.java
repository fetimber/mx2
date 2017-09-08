package net.huimin.yk.web.model.customer;

import java.math.BigDecimal;
import java.util.Date;

import net.huimin.yk.web.model.agent.AgentUser;

public class CustomerMoney {
    private Integer id;

    /**
     * 客户申请表ID
     */
    private Integer customerId;

    /**
     * 完成时间
     */
    private Date finishTime;

    /**
     * 奖励金额
     */
    private BigDecimal amount;

    /**
     * 备注
     */
    private String remark;

    /**
     * 佣金类型
     */
    private Integer moneyType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 状态
     */
    private Integer status;
    
    /**
     * 关联账户ID
     */
    private Integer accountId;
    
    private CustomerApplication app;
    
    private AgentUser agent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 客户申请表ID
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId 
	 *            客户申请表ID
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
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
    }

    /**
     * @return 奖励金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * @param amount 
	 *            奖励金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
     * @return 佣金类型
     */
    public Integer getMoneyType() {
        return moneyType;
    }

    /**
     * @param moneyType 
	 *            佣金类型
     */
    public void setMoneyType(Integer moneyType) {
        this.moneyType = moneyType;
    }

    /**
     * @return 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime 
	 *            创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status 
	 *            状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

	public CustomerApplication getApp() {
		return app;
	}

	public void setApp(CustomerApplication app) {
		this.app = app;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public AgentUser getAgent() {
		return agent;
	}

	public void setAgent(AgentUser agent) {
		this.agent = agent;
	}
	
}