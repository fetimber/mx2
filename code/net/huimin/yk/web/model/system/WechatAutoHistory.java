package net.huimin.yk.web.model.system;

public class WechatAutoHistory {
    private Integer id;

    /**
     * 用户的OPEN_ID
     */
    private String openId;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 发送的内容
     */
    private String sayWord;

    /**
     * 规则ID
     */
    private Integer roleId;

    /**
     * 图片ID
     */
    private String mediaId;

    /**
     * 回复内容
     */
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 用户的OPEN_ID
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * @param openId 
	 *            用户的OPEN_ID
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * @return 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName 
	 *            昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
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
        this.keyword = keyword;
    }

    /**
     * @return 发送的内容
     */
    public String getSayWord() {
        return sayWord;
    }

    /**
     * @param sayWord 
	 *            发送的内容
     */
    public void setSayWord(String sayWord) {
        this.sayWord = sayWord;
    }

    /**
     * @return 规则ID
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @param roleId 
	 *            规则ID
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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
     * @return 回复内容
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content 
	 *            回复内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}