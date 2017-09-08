package net.huimin.yk.web.model.sea;

import java.util.Date;
import java.util.List;

import net.huimin.common.mvc.BaseModel;
import net.huimin.yk.web.model.common.Files;

public class SeaHonorUnit extends BaseModel{
    private Integer id;

    /**
     * 单位名称
     */
    private String honorUnit;

    /**
     * 所在地
     */
    private String unitLocation;

    /**
     * 单位电话
     */
    private String unitPhone;

    /**
     * 单位负责人
     */
    private String unitDuty;

    /**
     * 工会主席
     */
    private String unitLeader;

    /**
     * 获奖岗位责任人
     */
    private String honorDuty;

    /**
     * 获奖部门
     */
    private String honorDept;
    /**
     * 荣誉种类
     */
    private String honorType;

    /**
     * 荣誉级别
     */
    private String honorLevel;

    /**
     * 集体事迹
     */
    private String unitHonorDesc;

    /**
     * 奖章编号
     */
    private String honorCode;

    /**
     * 表彰文件签发单位标题文号
     */
    private String honorTitle;

    /**
     * 获奖时间
     */
    private Date honorTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 删除时间
     */
    private Date deleteTime;

    /**
     * 审核状态
     */
    private String checkFlag;
    
    /**
     * 审核意见
     */
    private String checkDesc;

    /**
     * 是否删除
     */
    private Integer isDelete;
    
    private Integer addUser;
    

    private List<Files> bigPictures;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 单位名称
     */
    public String getHonorUnit() {
        return honorUnit;
    }

    /**
     * @param honorUnit 
	 *            单位名称
     */
    public void setHonorUnit(String honorUnit) {
        this.honorUnit = honorUnit;
    }

    /**
     * @return 所在地
     */
    public String getUnitLocation() {
        return unitLocation;
    }

    /**
     * @param unitLocation 
	 *            所在地
     */
    public void setUnitLocation(String unitLocation) {
        this.unitLocation = unitLocation;
    }

    /**
     * @return 单位电话
     */
    public String getUnitPhone() {
        return unitPhone;
    }

    /**
     * @param unitPhone 
	 *            单位电话
     */
    public void setUnitPhone(String unitPhone) {
        this.unitPhone = unitPhone;
    }

    /**
     * @return 单位负责人
     */
    public String getUnitDuty() {
        return unitDuty;
    }

    /**
     * @param unitDuty 
	 *            单位负责人
     */
    public void setUnitDuty(String unitDuty) {
        this.unitDuty = unitDuty;
    }

    /**
     * @return 工会主席
     */
    public String getUnitLeader() {
        return unitLeader;
    }

    /**
     * @param unitLeader 
	 *            工会主席
     */
    public void setUnitLeader(String unitLeader) {
        this.unitLeader = unitLeader;
    }

    /**
     * @return 获奖岗位责任人
     */
    public String getHonorDuty() {
        return honorDuty;
    }

    /**
     * @param honorDuty 
	 *            获奖岗位责任人
     */
    public void setHonorDuty(String honorDuty) {
        this.honorDuty = honorDuty;
    }

    /**
     * @return 荣誉种类
     */
    public String getHonorType() {
        return honorType;
    }

    /**
     * @param honorType 
	 *            荣誉种类
     */
    public void setHonorType(String honorType) {
        this.honorType = honorType;
    }

    /**
     * @return 荣誉级别
     */
    public String getHonorLevel() {
        return honorLevel;
    }

    /**
     * @param honorLevel 
	 *            荣誉级别
     */
    public void setHonorLevel(String honorLevel) {
        this.honorLevel = honorLevel;
    }

    /**
     * @return 集体事迹
     */
    public String getUnitHonorDesc() {
        return unitHonorDesc;
    }

    /**
     * @param unitHonorDesc 
	 *            集体事迹
     */
    public void setUnitHonorDesc(String unitHonorDesc) {
        this.unitHonorDesc = unitHonorDesc;
    }

    /**
     * @return 奖章编号
     */
    public String getHonorCode() {
        return honorCode;
    }

    /**
     * @param honorCode 
	 *            奖章编号
     */
    public void setHonorCode(String honorCode) {
        this.honorCode = honorCode;
    }

    /**
     * @return 表彰文件签发单位标题文号
     */
    public String getHonorTitle() {
        return honorTitle;
    }

    /**
     * @param honorTitle 
	 *            表彰文件签发单位标题文号
     */
    public void setHonorTitle(String honorTitle) {
        this.honorTitle = honorTitle;
    }

    /**
     * @return 获奖时间
     */
    public Date getHonorTime() {
        return honorTime;
    }

    /**
     * @param honorTime 
	 *            获奖时间
     */
    public void setHonorTime(Date honorTime) {
        this.honorTime = honorTime;
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
     * @return 删除时间
     */
    public Date getDeleteTime() {
        return deleteTime;
    }

    /**
     * @param deleteTime 
	 *            删除时间
     */
    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    /**
     * @return 审核状态
     */
    public String getCheckFlag() {
        return checkFlag;
    }

    /**
     * @param checkFlag 
	 *            审核状态
     */
    public void setCheckFlag(String checkFlag) {
        this.checkFlag = checkFlag;
    }

    /**
     * @return 是否删除
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * @param isDelete 
	 *            是否删除
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

	public List<Files> getBigPictures() {
		return bigPictures;
	}

	public void setBigPictures(List<Files> bigPictures) {
		this.bigPictures = bigPictures;
	}

	public String getCheckDesc() {
		return checkDesc;
	}

	public void setCheckDesc(String checkDesc) {
		this.checkDesc = checkDesc;
	}

	public Integer getAddUser() {
		return addUser;
	}

	public void setAddUser(Integer addUser) {
		this.addUser = addUser;
	}

	public String getHonorDept() {
		return honorDept;
	}

	public void setHonorDept(String honorDept) {
		this.honorDept = honorDept;
	}
    

}