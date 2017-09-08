package net.huimin.yk.web.model.agent;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StoreAgent {
    private Integer id;

    /**
     * 下线经纪人ID
     */
    private Integer agentId;

    /**
     * 上线经纪人ID
     */
    private Integer storeId;
    
    /**
     * 状态
     */
    private Integer status;
    
    /**
     * 更新时间
     */
    private Date updateTime;
    
    /**
     * 备注
     */
    private String memo;

	/**
     * 更新时间字符串描述
     */
    private String updateTimeDesc;

	/**
     * 上线经纪人详细信息
     */
    private AgentUser top;
    
    /**
     * 下线经纪人详细信息
     */
    private AgentUser bottom;

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 经纪人表ID
     */
    public Integer getAgentId() {
        return agentId;
    }

    /**
     * @param agentId 
	 *            经纪人表ID
     */
    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    /**
     * @return 门店表ID
     */
    public Integer getStoreId() {
        return storeId;
    }

    /**
     * @param storeId 
	 *            门店表ID
     */
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm");
		if(null != updateTime){
		  this.setUpdateTimeDesc(format.format(this.getUpdateTime()));
		}
	}

	public String getUpdateTimeDesc() {
		return updateTimeDesc;
	}

	public void setUpdateTimeDesc(String updateTimeDesc) {
		this.updateTimeDesc = updateTimeDesc;
	}

	public AgentUser getTop() {
		return top;
	}

	public void setTop(AgentUser top) {
		this.top = top;
	}

	public AgentUser getBottom() {
		return bottom;
	}

	public void setBottom(AgentUser bottom) {
		this.bottom = bottom;
	}
	
    public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
    
}