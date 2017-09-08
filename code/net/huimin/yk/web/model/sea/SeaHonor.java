package net.huimin.yk.web.model.sea;

import java.util.Date;
import java.util.List;

import net.huimin.common.mvc.BaseModel;
import net.huimin.yk.web.model.common.Files;

public class SeaHonor extends BaseModel{
    private Integer id;

    /**
     * 主要事迹
     */
    private String honorDesc;

    /**
     * 获奖时间
     */
    private Date honorTime;

    /**
     * 奖章编号
     */
    private String honorCode;

    /**
     * 表彰文件签发单位标题文号
     */
    private String honorTitle;

    /**
     * 荣誉种类
     */
    private String honorType;

    /**
     * 荣誉级别
     */
    private String honorLevel;

    /**
     * 荣誉职工ID
     */
    private Integer honorWorker;
    /**
     * 职工信息
     */
    private SeaWorker workerInfo;

    private String checkFlag;
    
    private String checkDesc;
    
    private String unitHonorDesc;
    
    private SeaUnit unitInfo;
    
    private Date createTime;
    

    /**
     * 是否删除
     */
    private Integer isDelete;
    
    /**
     * 删除时间
     */
    private Date deleteTime;

    
	private List<Files> bigPictures;
	
    /**
     * 获奖时间
     */
    private Date joinTime;
    
    private String unitDuty;
    
    /**
     * 获奖单位
     */
    private Integer inUnit;
    
    
    /**
     * 发放时间
     */
    private Date sendTime;
    
    /**
     * 发放主管部门
     */
    private String sendDept;
    
    /**
     * 
     */
    private String sendThing;
    
    private String extFileDisplayName;
    
    private String extFileName;
    
    private String extFileDisplayName2;
    
    private String extFileName2;
    
    public String getExtFileDisplayName2() {
		return extFileDisplayName2;
	}

	public void setExtFileDisplayName2(String extFileDisplayName2) {
		this.extFileDisplayName2 = extFileDisplayName2;
	}

	public String getExtFileName2() {
		return extFileName2;
	}

	public void setExtFileName2(String extFileName2) {
		this.extFileName2 = extFileName2;
	}

	public String getExtFileDisplayName() {
		return extFileDisplayName;
	}

	public void setExtFileDisplayName(String extFileDisplayName) {
		this.extFileDisplayName = extFileDisplayName;
	}

	public String getExtFileName() {
		return extFileName;
	}

	public void setExtFileName(String extFileName) {
		this.extFileName = extFileName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 主要事迹
     */
    public String getHonorDesc() {
        return honorDesc;
    }

    /**
     * @param honorDesc 
	 *            主要事迹
     */
    public void setHonorDesc(String honorDesc) {
        this.honorDesc = honorDesc;
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
     * @return 荣誉职工ID
     */
    public Integer getHonorWorker() {
        return honorWorker;
    }

    /**
     * @param honorWorker 
	 *            荣誉职工ID
     */
    public void setHonorWorker(Integer honorWorker) {
        this.honorWorker = honorWorker;
    }

	public SeaWorker getWorkerInfo() {
		return workerInfo;
	}

	public void setWorkerInfo(SeaWorker workerInfo) {
		this.workerInfo = workerInfo;
	}

	public String getCheckFlag() {
		return checkFlag;
	}

	public void setCheckFlag(String checkFlag) {
		this.checkFlag = checkFlag;
	}

	public String getUnitHonorDesc() {
		return unitHonorDesc;
	}

	public void setUnitHonorDesc(String unitHonorDesc) {
		this.unitHonorDesc = unitHonorDesc;
	}

	public SeaUnit getUnitInfo() {
		return unitInfo;
	}

	public void setUnitInfo(SeaUnit unitInfo) {
		this.unitInfo = unitInfo;
	}

	public Integer getInUnit() {
		return inUnit;
	}

	public void setInUnit(Integer inUnit) {
		this.inUnit = inUnit;
	}

	public List<Files> getBigPictures() {
		return bigPictures;
	}

	public void setBigPictures(List<Files> bigPictures) {
		this.bigPictures = bigPictures;
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