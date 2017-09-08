/** 
 * @Title: MessageApi.java 
 * @author 胡笑尘 <a>huxiaochen@hmeg.net</a>
 * @date 2014-11-24 上午10:48:16
 * @version V1.0
 */ 
package net.huimin.yk.channel.msg;

import java.util.List;

/** 
 * @author 胡笑尘 huxiaochen@hmeg.net
 * @date 2014-11-24 上午10:48:16  
 */
public interface MessageAPI {
	/**
	 * 发送短信
	 * @param userId 发送用户ID
	 * @param content 短信内容
	 */
	boolean send(Integer userId,String content);
	
	/**
	 * 发送短信
	 * @param target 目标号码
	 * @param content 短信内容
	 */
	boolean send(String target,String content);
	
	/**
	 * 批量发送短信
	 * @param users 目标号码
	 * @param content 短信内容
	 */
	boolean batchForUser(List<Integer> users , String content);
	
	/**
	 * 批量发送短信
	 * @param targets 目标号码
	 * @param content 短信内容
	 */
	boolean batchForTarget(List<String> targets , String content);
	
	/**
	 * 向指定用户发送短信验证码
	 * @param flag 1:支付，2:注册,3:修改资料
	 * @param userId 用户ID
	 */
	boolean sendValidateCode(Integer userId,int flag);
	
	/**
	 * 向指定用户发送短信验证码
	 * @param flag 1:支付，2:注册,3:修改资料
	 * @param userId 用户ID
	 */
	boolean sendValidateCode(String target,int flag);
	
	/**
	 * 验证指定用户的验证码
	 * @param userId 用户ID
	 * @param code 验证码
	 * @return 验证结果,1:正确,2:已过期,3:验证码错误,4:不存在的验证码
	 */
	int validateCode(Integer userId,String code);
	
	/**
	 * 验证指定用户的验证码
	 * @param phone 手机号
	 * @param code 验证码
	 * @return 验证结果,1:正确,2:已过期,3:验证码错误,4:不存在的验证码
	 */
	int validateCode(String phone, String code);
	
	/**
	 * 发送微信消息(文本)
	 * @param openId OPENID
	 * @param content 消息内容
	 */
	void sendWechatTextMsg(String openId,String content);
	
	/**
	 * 发送短信到指定的电话，固定内容
	 * @param phone 电话号码
	 * @param key PROPERTY KEY
	 * @return
	 */
	boolean sendMsgForKey(String phone,String key);
	
	/**
	 * 发送短信到指定的电话，固定内容
	 * @param userId USERID
	 * @param key PROPERTY KEY
	 * @return
	 */
	boolean sendMsgForKey(Integer userId,String key);
}
