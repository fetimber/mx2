package net.huimin.yk.web.model.customer;

import java.io.Serializable;
import java.util.Date;

public class CustomerQueryParameter implements Serializable {
	private static final long serialVersionUID = 3516008591739323305L;

	private String customerPhone;
	
	private String dutyName;
	
	private String agentName;
	
	private String agentPhone;
	
	private Integer recommendType;
	
	private Integer customerStatus;
	
	private Date referDateStart;
	
	private Date referDateEnd;
	
	private Integer appealStatus;
	
	private Integer pressStatus;
	
	private Integer customerLevelId;
	
	private Integer order;
	
	private Boolean isTeamLeader;
	
	private Boolean isTeam;
	
	private Integer userId;
	
	private Integer tableType;

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getDutyName() {
		return dutyName;
	}

	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getAgentPhone() {
		return agentPhone;
	}

	public void setAgentPhone(String agentPhone) {
		this.agentPhone = agentPhone;
	}

	public Integer getRecommendType() {
		return recommendType;
	}

	public void setRecommendType(Integer recommendType) {
		this.recommendType = recommendType;
	}

	public Integer getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(Integer customerStatus) {
		this.customerStatus = customerStatus;
	}

	public Date getReferDateStart() {
		return referDateStart;
	}

	public void setReferDateStart(Date referDateStart) {
		this.referDateStart = referDateStart;
	}

	public Date getReferDateEnd() {
		return referDateEnd;
	}

	public void setReferDateEnd(Date referDateEnd) {
		this.referDateEnd = referDateEnd;
	}

	public Integer getAppealStatus() {
		return appealStatus;
	}

	public void setAppealStatus(Integer appealStatus) {
		this.appealStatus = appealStatus;
	}

	public Integer getPressStatus() {
		return pressStatus;
	}

	public void setPressStatus(Integer pressStatus) {
		this.pressStatus = pressStatus;
	}

	public Integer getCustomerLevelId() {
		return customerLevelId;
	}

	public void setCustomerLevelId(Integer customerLevelId) {
		this.customerLevelId = customerLevelId;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Boolean getIsTeamLeader() {
		return isTeamLeader;
	}

	public void setIsTeamLeader(Boolean isTeamLeader) {
		this.isTeamLeader = isTeamLeader;
	}

	public Integer getTableType() {
		return tableType;
	}

	public void setTableType(Integer tableType) {
		this.tableType = tableType;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Boolean getIsTeam() {
		return isTeam;
	}

	public void setIsTeam(Boolean isTeam) {
		this.isTeam = isTeam;
	}
}
