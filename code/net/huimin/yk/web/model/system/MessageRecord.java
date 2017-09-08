package net.huimin.yk.web.model.system;

import java.util.Date;

public class MessageRecord {
    private Integer id;

    /**
     * 接受短信的用户ID
     */
    private Integer userId;

    /**
     * 1:验证码，2:账户信息变更通知,3:营销
     */
    private Integer msgType;

    /**
     * 电话号码
     */
    private String phoneNumber;

    /**
     * 发送时间
     */
    private Date sendTime;

    /**
     * 发送内容
     */
    private String content;

    /**
     * 状态，1：成功，0：失败
     */
    private Integer sendStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 接受短信的用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId 
	 *            接受短信的用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return 1:验证码，2:账户信息变更通知,3:营销
     */
    public Integer getMsgType() {
        return msgType;
    }

    /**
     * @param msgType 
	 *            1:验证码，2:账户信息变更通知,3:营销
     */
    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    /**
     * @return 电话号码
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber 
	 *            电话号码
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
     * @return 发送内容
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content 
	 *            发送内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return 状态，1：成功，0：失败
     */
    public Integer getSendStatus() {
        return sendStatus;
    }

    /**
     * @param sendStatus 
	 *            状态，1：成功，0：失败
     */
    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }
}