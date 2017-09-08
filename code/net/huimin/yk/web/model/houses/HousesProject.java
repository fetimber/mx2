package net.huimin.yk.web.model.houses;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import net.huimin.yk.web.model.common.Area;
import net.huimin.yk.web.model.common.City;
import net.huimin.yk.web.model.common.Files;
import net.huimin.yk.web.model.common.Province;
import net.huimin.yk.web.model.system.SysUser;

public class HousesProject {
    /**
     * 主键
     */
    private Integer id;

    private String projectName;

    private String projectSummary;

    private Integer province;

    private Integer city;

    private Integer area;

    private BigDecimal price;

    private BigDecimal brokerage;
    
    private BigDecimal upArea;
    
    private BigDecimal downArea;
    
    private BigDecimal upSum;
    
    private BigDecimal downSum;
    
    private BigDecimal firstReward;
    
    private BigDecimal viewReward;
    
    private String limitDesc;
    
    private String broDesc;
    
    private String address;

    private Date createTime;

    private Date updateTime;

    private Integer pmId;
    
    private Integer isMain;
    
    private Integer reqType;
    
    private Integer deleteStatus;
    
    private Integer soleCount;
    
    private BigDecimal maxBro;
    
    private String orderStyle;
    
    private String imgPath;

    private Province provInfo;
    
    private City cityInfo;
    
    private Area areaInfo;

	private SysUser pmInfo;
	
	private List<Files> bigPictures;
	
	private List<Files> smallPictures;
	
	private Integer dealPoint;
	
	private Integer commissionPoint;
	
	private Integer priceImageId;
	
	private Files priceImage;
    
	public Integer getDealPoint() {
		return dealPoint;
	}

	public void setDealPoint(Integer dealPoint) {
		this.dealPoint = dealPoint;
	}

	public Integer getCommissionPoint() {
		return commissionPoint;
	}

	public void setCommissionPoint(Integer commissionPoint) {
		this.commissionPoint = commissionPoint;
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
    
    
    public BigDecimal getUpArea() {
		return upArea;
	}

	public void setUpArea(BigDecimal upArea) {
		this.upArea = upArea;
	}

	public BigDecimal getDownArea() {
		return downArea;
	}

	public void setDownArea(BigDecimal downArea) {
		this.downArea = downArea;
	}

	public BigDecimal getUpSum() {
		return upSum;
	}

	public void setUpSum(BigDecimal upSum) {
		this.upSum = upSum;
	}

	public BigDecimal getDownSum() {
		return downSum;
	}

	public void setDownSum(BigDecimal downSum) {
		this.downSum = downSum;
	}

	public BigDecimal getFirstReward() {
		return firstReward;
	}

	public void setFirstReward(BigDecimal firstReward) {
		this.firstReward = firstReward;
	}

	public BigDecimal getViewReward() {
		return viewReward;
	}

	public void setViewReward(BigDecimal viewReward) {
		this.viewReward = viewReward;
	}

	public String getLimitDesc() {
		return limitDesc;
	}

	public void setLimitDesc(String limitDesc) {
		this.limitDesc = limitDesc;
	}

	public String getBroDesc() {
		return broDesc;
	}

	public void setBroDesc(String broDesc) {
		this.broDesc = broDesc;
	}

	public Integer getIsMain() {
		return isMain;
	}

	public void setIsMain(Integer isMain) {
		this.isMain = isMain;
	}

	public Integer getReqType() {
		return reqType;
	}

	public void setReqType(Integer reqType) {
		this.reqType = reqType;
	}

    public Integer getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Integer deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public Integer getSoleCount() {
		return soleCount;
	}

	public void setSoleCount(Integer soleCount) {
		this.soleCount = soleCount;
	}

	public BigDecimal getMaxBro() {
		return maxBro;
	}

	public void setMaxBro(BigDecimal maxBro) {
		this.maxBro = maxBro;
	}

	public String getOrderStyle() {
		return orderStyle;
	}

	public void setOrderStyle(String orderStyle) {
		this.orderStyle = orderStyle;
	}

	public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectSummary() {
        return projectSummary;
    }

    public void setProjectSummary(String projectSummary) {
        this.projectSummary = projectSummary;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getBrokerage() {
        return brokerage;
    }

    public void setBrokerage(BigDecimal brokerage) {
        this.brokerage = brokerage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getPmId() {
        return pmId;
    }

    public void setPmId(Integer pmId) {
        this.pmId = pmId;
    }
    
    public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Province getProvInfo() {
		return provInfo;
	}

	public void setProvInfo(Province provInfo) {
		this.provInfo = provInfo;
	}

	public City getCityInfo() {
		return cityInfo;
	}

	public void setCityInfo(City cityInfo) {
		this.cityInfo = cityInfo;
	}

	public Area getAreaInfo() {
		return areaInfo;
	}

	public void setAreaInfo(Area areaInfo) {
		this.areaInfo = areaInfo;
	}

	public SysUser getPmInfo() {
		return pmInfo;
	}

	public void setPmInfo(SysUser pmInfo) {
		this.pmInfo = pmInfo;
	}

	public List<Files> getBigPictures() {
		return bigPictures;
	}

	public void setBigPictures(List<Files> bigPictures) {
		this.bigPictures = bigPictures;
	}

	public List<Files> getSmallPictures() {
		return smallPictures;
	}

	public void setSmallPictures(List<Files> smallPictures) {
		this.smallPictures = smallPictures;
	}

	public Integer getPriceImageId() {
		return priceImageId;
	}

	public void setPriceImageId(Integer priceImageId) {
		this.priceImageId = priceImageId;
	}

	public Files getPriceImage() {
		return priceImage;
	}

	public void setPriceImage(Files priceImage) {
		this.priceImage = priceImage;
	}
}