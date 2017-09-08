package net.huimin.yk.web.model.sea;

import java.util.Date;

import net.huimin.common.mvc.BaseModel;

public class SeaWorkerPoor extends BaseModel{
    private Integer id;

    /**
     * 家庭情况
     */
    private String familyPeople;

    /**
     * 家庭收入
     */
    private String familyIncome;

    /**
     * 贫困原因
     */
    private String poorReason;

    /**
     * 填报单位
     */
    private Integer inUnit;

    /**
     * 审核单位
     */
    private String checkUnit;

    /**
     * 变更说明
     */
    private String changeMemo;

    /**
     * 贫困等级
     */
    private String poorLevel;

    /**
     * 员工ID
     */
    private Integer workerId;
    
    
    private String checkFlag;
    
    private String checkDesc;
    
    private SeaUnit unitInfo;
    /**
     * 
     */
    private SeaWorker workerInfo;


    /**
     * 是否删除
     */
    private Integer isDelete;
    
    /**
     * 删除时间
     */
    private Date deleteTime;
    
    /**
     * 发放时间
     */
    private Date sendTime;
    
    /**
     * 发放主管部门
     */
    private String sendDept;
    
    /**
     * 发放物品
     */
    private String sendThing;
    
    /**
     * 发放记录
     */
    private String sendRemark;
    
    
    private Date createTime;

    public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getWorkerId() {
		return workerId;
	}

	public void setWorkerId(Integer workerId) {
		this.workerId = workerId;
	}

	public SeaWorker getWorkerInfo() {
		return workerInfo;
	}

	public void setWorkerInfo(SeaWorker workerInfo) {
		this.workerInfo = workerInfo;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 家庭情况
     */
    public String getFamilyPeople() {
        return familyPeople;
    }

    /**
     * @param familyPeople 
	 *            家庭情况
     */
    public void setFamilyPeople(String familyPeople) {
        this.familyPeople = familyPeople;
    }

    /**
     * @return 家庭收入
     */
    public String getFamilyIncome() {
        return familyIncome;
    }

    /**
     * @param familyIncome 
	 *            家庭收入
     */
    public void setFamilyIncome(String familyIncome) {
        this.familyIncome = familyIncome;
    }

    /**
     * @return 贫困原因
     */
    public String getPoorReason() {
        return poorReason;
    }

    /**
     * @param poorReason 
	 *            贫困原因
     */
    public void setPoorReason(String poorReason) {
        this.poorReason = poorReason;
    }

    /**
     * @return 填报单位
     */
    public Integer getInUnit() {
        return inUnit;
    }

    /**
     * @param inUnit 
	 *            填报单位
     */
    public void setInUnit(Integer inUnit) {
        this.inUnit = inUnit;
    }

    /**
     * @return 审核单位
     */
    public String getCheckUnit() {
        return checkUnit;
    }

    /**
     * @param checkUnit 
	 *            审核单位
     */
    public void setCheckUnit(String checkUnit) {
        this.checkUnit = checkUnit;
    }

    /**
     * @return 变更说明
     */
    public String getChangeMemo() {
        return changeMemo;
    }

    /**
     * @param changeMemo 
	 *            变更说明
     */
    public void setChangeMemo(String changeMemo) {
        this.changeMemo = changeMemo;
    }

    /**
     * @return 贫困等级
     */
    public String getPoorLevel() {
        return poorLevel;
    }

    /**
     * @param poorLevel 
	 *            贫困等级
     */
    public void setPoorLevel(String poorLevel) {
        this.poorLevel = poorLevel;
    }

	public String getCheckFlag() {
		return checkFlag;
	}

	public void setCheckFlag(String checkFlag) {
		this.checkFlag = checkFlag;
	}

	public SeaUnit getUnitInfo() {
		return unitInfo;
	}

	public void setUnitInfo(SeaUnit unitInfo) {
		this.unitInfo = unitInfo;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public String getSendDept() {
		return sendDept;
	}

	public void setSendDept(String sendDept) {
		this.sendDept = sendDept;
	}

	public String getSendThing() {
		return sendThing;
	}

	public void setSendThing(String sendThing) {
		this.sendThing = sendThing;
	}

	public String getSendRemark() {
		return sendRemark;
	}

	public void setSendRemark(String sendRemark) {
		this.sendRemark = sendRemark;
	}

	public String getCheckDesc() {
		return checkDesc;
	}

	public void setCheckDesc(String checkDesc) {
		this.checkDesc = checkDesc;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Date getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}
	
}