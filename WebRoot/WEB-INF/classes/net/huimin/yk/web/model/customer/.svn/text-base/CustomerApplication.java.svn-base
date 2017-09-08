package net.huimin.yk.web.model.customer;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.huimin.yk.web.model.agent.AgentUser;
import net.huimin.yk.web.model.houses.HousesProject;
import net.huimin.yk.web.model.system.SysUser;

public class CustomerApplication {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 项目Id
     */
    private Integer houseId;
    
    private Integer areaId;
    
    /**
     * 客户姓名
     */
    private String customerName;

    private String customerDecimal;

    private Integer sex;

    /**
     * 客户等级ID
     */
    private Integer customerLevel;

    /**
     * 备注信息
     */
    private String remark;

    private Integer agentId;

    private Integer customerStatus;

    private Date referTime;

    private Integer effectType;

    private Integer appealStatus;
    
    private String appealMsg; 

	private Integer presStatus;
    
    private Integer readStatus;

	private Integer houseCount;
    
    private BigDecimal housePrice;
    
    private HousesProject houseInfo;
    
    private CustomerLevel customerLevelInfo;
    
    private AgentUser agentInfo;
    
    private Date followTime;
    
    private Date nextTime;
    
    private Integer referArea;
    
    private Integer selfSend;
    
    private Integer selfLook;
    
    private Integer batchId;
    
    private Integer moneyStatus;
    
    private Integer arrivedStatus;
    
    private Integer lookStatus;
    
    private Integer dutyId;
    
    private String consultantName;
    /**
     * 最后跟进时间的字符串表示
     */
    private String followTimeDesc;
    
    private List<CustomeRecord> records;
    
    private SysUser duty;
    
    private Integer messageCount;
    
	private String isLooked;
	
	private String isArrived;
    
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
     * @return 项目Id
     */
    public Integer getHouseId() {
        return houseId;
    }

    /**
     * @param houseId 
	 *            项目Id
     */
    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    /**
     * @return 客户姓名
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName 
	 *            客户姓名
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerDecimal() {
        return customerDecimal;
    }

    public void setCustomerDecimal(String customerDecimal) {
        this.customerDecimal = customerDecimal;
    }

    public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
	public Integer getReadStatus() {
		return readStatus;
	}

	public void setReadStatus(Integer readStatus) {
		this.readStatus = readStatus;
	}

	public Integer getHouseCount() {
		return houseCount;
	}

	public void setHouseCount(Integer houseCount) {
		this.houseCount = houseCount;
	}

	public BigDecimal getHousePrice() {
		return housePrice;
	}

	public void setHousePrice(BigDecimal housePrice) {
		this.housePrice = housePrice;
	}

	/**
     * @return 客户等级ID
     */
    public Integer getCustomerLevel() {
        return customerLevel;
    }

    /**
     * @param customerLevel 
	 *            客户等级ID
     */
    public void setCustomerLevel(Integer customerLevel) {
        this.customerLevel = customerLevel;
    }

    /**
     * @return 备注信息
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark 
	 *            备注信息
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public Integer getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(Integer customerStatus) {
        this.customerStatus = customerStatus;
    }

    public Date getReferTime() {
        return referTime;
    }

    public void setReferTime(Date referTime) {
        this.referTime = referTime;
    }

    public Integer getEffectType() {
        return effectType;
    }

    public void setEffectType(Integer effectType) {
        this.effectType = effectType;
    }

	public Integer getAppealStatus() {
		return appealStatus;
	}

	public void setAppealStatus(Integer appealStatus) {
		this.appealStatus = appealStatus;
	}
	
	public String getAppealMsg() {
		return appealMsg;
	}

	public void setAppealMsg(String appealMsg) {
		this.appealMsg = appealMsg;
	}

	public Integer getPresStatus() {
		return presStatus;
	}

	public void setPresStatus(Integer presStatus) {
		this.presStatus = presStatus;
	}

	public HousesProject getHouseInfo() {
		return houseInfo;
	}

	public void setHouseInfo(HousesProject houseInfo) {
		this.houseInfo = houseInfo;
	}

	public CustomerLevel getCustomerLevelInfo() {
		return customerLevelInfo;
	}

	public void setCustomerLevelInfo(CustomerLevel customerLevelInfo) {
		this.customerLevelInfo = customerLevelInfo;
	}

	public AgentUser getAgentInfo() {
		return agentInfo;
	}

	public void setAgentInfo(AgentUser agentInfo) {
		this.agentInfo = agentInfo;
	}
	public Date getFollowTime() {
		return followTime;
	}

	public void setFollowTime(Date followTime) {
		this.followTime = followTime;
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm");
		if(null != followTime){
		  this.setFollowTimeDesc(format.format(this.getFollowTime()));
		}
	}
	
	public String getFollowTimeDesc() {
		return followTimeDesc;
	}

	public void setFollowTimeDesc(String followTimeDesc) {
		this.followTimeDesc = followTimeDesc;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Date getNextTime() {
		return nextTime;
	}

	public void setNextTime(Date nextTime) {
		this.nextTime = nextTime;
	}

	public Integer getReferArea() {
		return referArea;
	}

	public void setReferArea(Integer referArea) {
		this.referArea = referArea;
	}

	public Integer getSelfSend() {
		return selfSend;
	}

	public void setSelfSend(Integer selfSend) {
		this.selfSend = selfSend;
	}

	public Integer getSelfLook() {
		return selfLook;
	}

	public void setSelfLook(Integer selfLook) {
		this.selfLook = selfLook;
	}

	public Integer getBatchId() {
		return batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	public Integer getMoneyStatus() {
		return moneyStatus;
	}

	public void setMoneyStatus(Integer moneyStatus) {
		this.moneyStatus = moneyStatus;
	}

	public Integer getArrivedStatus() {
		return arrivedStatus;
	}

	public void setArrivedStatus(Integer arrivedStatus) {
		this.arrivedStatus = arrivedStatus;
	}

	public Integer getLookStatus() {
		return lookStatus;
	}

	public void setLookStatus(Integer lookStatus) {
		this.lookStatus = lookStatus;
	}

	public Integer getDutyId() {
		return dutyId;
	}

	public void setDutyId(Integer dutyId) {
		this.dutyId = dutyId;
	}

	public String getConsultantName() {
		return consultantName;
	}

	public void setConsultantName(String consultantName) {
		this.consultantName = consultantName;
	}

	public List<CustomeRecord> getRecords() {
		return records;
	}

	public void setRecords(List<CustomeRecord> records) {
		this.records = records;
	}

	public SysUser getDuty() {
		return duty;
	}

	public void setDuty(SysUser duty) {
		this.duty = duty;
	}

	public Integer getMessageCount() {
		return messageCount;
	}

	public void setMessageCount(Integer messageCount) {
		this.messageCount = messageCount;
	}

	public String getIsLooked() {
		return isLooked;
	}

	public void setIsLooked(String isLooked) {
		this.isLooked = isLooked;
	}

	public String getIsArrived() {
		return isArrived;
	}

	public void setIsArrived(String isArrived) {
		this.isArrived = isArrived;
	}
	
	
	
}