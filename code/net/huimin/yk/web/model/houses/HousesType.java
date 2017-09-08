package net.huimin.yk.web.model.houses;

import java.math.BigDecimal;
import java.util.Date;

public class HousesType {
    /**
     * 主键
     */
    private Integer id;

    private Integer projectId;

    private String houseTypename;

    private String houseTypecontent;

    private Date createTime;

    private Date updateTime;

    private Integer houseArea;

    private BigDecimal housePrice;

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

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getHouseTypename() {
        return houseTypename;
    }

    public void setHouseTypename(String houseTypename) {
        this.houseTypename = houseTypename;
    }

    public String getHouseTypecontent() {
        return houseTypecontent;
    }

    public void setHouseTypecontent(String houseTypecontent) {
        this.houseTypecontent = houseTypecontent;
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

    public Integer getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(Integer houseArea) {
        this.houseArea = houseArea;
    }

    public BigDecimal getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(BigDecimal housePrice) {
        this.housePrice = housePrice;
    }
}