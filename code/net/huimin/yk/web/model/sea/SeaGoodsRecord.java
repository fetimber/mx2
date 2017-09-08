package net.huimin.yk.web.model.sea;

import java.util.Date;
import java.util.List;

import net.huimin.yk.web.model.common.Files;

public class SeaGoodsRecord {
    private Integer id;

    private Integer workPoorId;

    /**
     * 现金
     */
    private String goodsCash;

    /**
     * 物资折合人民币
     */
    private String goodsValue;

    /**
     * 发送时间
     */
    private Date sendTime;

    /**
     * 发送部门
     */
    private String sendDept;

    /**
     * 发送物品
     */
    private String sendThing;

    /**
     * 发送描述
     */
    private String sendRemark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 删除时间
     */
    private Date deleteTime;

    /**
     * 是否删除
     */
    private Integer isDelete;
    
    private SeaWorkerPoor workerInfo;
    
    private List<Files> bigPictures;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWorkPoorId() {
        return workPoorId;
    }

    public void setWorkPoorId(Integer workPoorId) {
        this.workPoorId = workPoorId;
    }

    /**
     * @return 现金
     */
    public String getGoodsCash() {
        return goodsCash;
    }

    /**
     * @param goodsCash 
	 *            现金
     */
    public void setGoodsCash(String goodsCash) {
        this.goodsCash = goodsCash;
    }

    /**
     * @return 物资折合人民币
     */
    public String getGoodsValue() {
        return goodsValue;
    }

    /**
     * @param goodsValue 
	 *            物资折合人民币
     */
    public void setGoodsValue(String goodsValue) {
        this.goodsValue = goodsValue;
    }

    /**
     * @return 发送时间
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * @param sendTime 
	 *            发送时间
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * @return 发送部门
     */
    public String getSendDept() {
        return sendDept;
    }

    /**
     * @param sendDept 
	 *            发送部门
     */
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

	public SeaWorkerPoor getWorkerInfo() {
		return workerInfo;
	}

	public void setWorkerInfo(SeaWorkerPoor workerInfo) {
		this.workerInfo = workerInfo;
	}
	
 
}