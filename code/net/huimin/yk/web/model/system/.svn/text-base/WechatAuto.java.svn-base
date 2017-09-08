package net.huimin.yk.web.model.system;

import java.util.Date;

import net.huimin.common.helper.Judge;

public class WechatAuto {
    /**
     * ID
     */
    private Integer id;

    /**
     * 0:关注时自动回复，1:消息自动回复
     */
    private Integer autoType;

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 1:图片,2:文字
     */
    private Integer contentType;

    /**
     * 图片ID
     */
    private String mediaId;

    /**
     * 文字内容
     */
    private String content;

    /**
     * 规则名称
     */
    private String roleName;

    /**
     * 创建时间
     */
    private Date createTime;
    
    private String picUrl;

    public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	/**
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 
	 *            ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 0:关注时自动回复，1:消息自动回复
     */
    public Integer getAutoType() {
        return autoType;
    }

    /**
     * @param autoType 
	 *            0:关注时自动回复，1:消息自动回复
     */
    public void setAutoType(Integer autoType) {
        this.autoType = autoType;
    }

    /**
     * @return 关键字
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * @param keyword 
	 *            关键字
     */
    public void setKeyword(String keyword) {
        this.keyword = Judge.isNull(keyword) ? "" : keyword.trim();
    }

    /**
     * @return 1:图片,2:文字
     */
    public Integer getContentType() {
        return contentType;
    }

    /**
     * @param contentType 
	 *            1:图片,2:文字
     */
    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    /**
     * @return 图片ID
     */
    public String getMediaId() {
        return mediaId;
    }

    /**
     * @param mediaId 
	 *            图片ID
     */
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    /**
     * @return 文字内容
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content 
	 *            文字内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return 规则名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName 
	 *            规则名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
}