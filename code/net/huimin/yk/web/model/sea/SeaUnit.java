package net.huimin.yk.web.model.sea;

import java.util.Date;

import net.huimin.yk.web.model.common.Area;
import net.huimin.yk.web.model.common.City;

public class SeaUnit {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 单位名称
     */
    private String unitName;

    private Integer unitCity;

    private String isMember;

    private Date joinTime;

    private String unitDuty;
    
    private City cityInfo;

    private Date createTime;
    
    /**
     * 是否删除
     */
    private Integer isDelete;
    
    /**
     * 删除时间
     */
    private Date deleteTime;

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

    /**
     * @return 单位名称
     */
    public String getUnitName() {
        return unitName;
    }

    /**
     * @param unitName 
	 *            单位名称
     */
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Integer getUnitCity() {
        return unitCity;
    }

    public void setUnitCity(Integer unitCity) {
        this.unitCity = unitCity;
    }

    public String getIsMember() {
        return isMember;
    }

    public void setIsMember(String isMember) {
        this.isMember = isMember;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public String getUnitDuty() {
        return unitDuty;
    }

    public void setUnitDuty(String unitDuty) {
        this.unitDuty = unitDuty;
    }

	public City getCityInfo() {
		return cityInfo;
	}

	public void setCityInfo(City cityInfo) {
		this.cityInfo = cityInfo;
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