package net.huimin.yk.web.model.sea;

import java.util.Date;

import net.huimin.common.mvc.BaseModel;

public class SeaWorker extends BaseModel{
    /**
     * 主键
     */
    private Integer id;

    private String workerName;

    private String workerSex;

    private String workerAge;

    private String workerIdnumber;

    private String workerAddress;

    private String workerPhone;

    private String honorRemark;

    private Integer unitId;

    private String isHard;
    
    private SeaUnit unitInfo;

    private String bankCard;
    
    private String workDuty;
    
    private Date createTime;

    public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getWorkerSex() {
        return workerSex;
    }

    public void setWorkerSex(String workerSex) {
        this.workerSex = workerSex;
    }

    public String getWorkerAge() {
        return workerAge;
    }

    public void setWorkerAge(String workerAge) {
        this.workerAge = workerAge;
    }

    public String getWorkerIdnumber() {
        return workerIdnumber;
    }

    public String getWorkerIdnumber2() {
        if(workerIdnumber != null && workerIdnumber.length() > 4){
        	return "****"+workerIdnumber.substring(workerIdnumber.length() - 4);
        }
        return workerIdnumber;
    }
    
    
    public void setWorkerIdnumber(String workerIdnumber) {
        this.workerIdnumber = workerIdnumber;
    }

    public String getWorkerAddress() {
        return workerAddress;
    }

    public void setWorkerAddress(String workerAddress) {
        this.workerAddress = workerAddress;
    }

    public String getWorkerPhone() {
        return workerPhone;
    }

    public void setWorkerPhone(String workerPhone) {
        this.workerPhone = workerPhone;
    }

    public String getHonorRemark() {
        return honorRemark;
    }

    public void setHonorRemark(String honorRemark) {
        this.honorRemark = honorRemark;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getIsHard() {
        return isHard;
    }

    public void setIsHard(String isHard) {
        this.isHard = isHard;
    }

	public SeaUnit getUnitInfo() {
		return unitInfo;
	}

	public void setUnitInfo(SeaUnit unitInfo) {
		this.unitInfo = unitInfo;
	}

	public String getBankCard() {
		return bankCard;
	}

	public String getBankCard2() {
		if(bankCard != null && bankCard.length() > 4){
        	return "****"+bankCard.substring(bankCard.length() - 4);
        }
		return bankCard;
	}
	
	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}

	public String getWorkDuty() {
		return workDuty;
	}

	public void setWorkDuty(String workDuty) {
		this.workDuty = workDuty;
	}
    
    
}