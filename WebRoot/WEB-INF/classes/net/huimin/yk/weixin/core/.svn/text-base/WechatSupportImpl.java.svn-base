package net.huimin.yk.weixin.core;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import net.huimin.common.helper.Judge;
import net.huimin.common.helper.SpringHelper;
import net.huimin.yk.web.dao.system.WeChatMessageRecordMapper;
import net.huimin.yk.web.model.system.SysUser;
import net.huimin.yk.web.model.system.WeChatMessageRecord;
import net.huimin.yk.web.services.system.UserService;

import org.apache.log4j.Logger;
import org.sword.wechat4j.common.Config;
import org.sword.wechat4j.event.MsgType;

public class WechatSupportImpl extends MessageHandler {
	
	private Logger logger = Logger.getLogger(WechatSupportImpl.class);
	
	public WechatSupportImpl(HttpServletRequest request) {
		super(request);
	}

	@Override
	protected void click() {
		this.saveRecord();
	}

	@Override
	protected void location() {
		this.saveRecord();
	}

	@Override
	protected void onImage() {
		logger.info("接受到图片客户端发送的图片消息,MediaId:" + this.wechatRequest.getMediaId() + ",OpenId:" + this.wechatRequest.getFromUserName());
		logger.info("图片移交到图片线程进行处理");
		DownloadImageMessage dim = new DownloadImageMessage();
		dim.setMediaId(this.wechatRequest.getMediaId());
		dim.setOpenId(this.wechatRequest.getFromUserName());
		dim.setUrl(this.wechatRequest.getPicUrl());
		synchronized (StaticSync.DOWNLOAD_IMAGE_MESSAGE_QUEUE) {
			StaticSync.DOWNLOAD_IMAGE_MESSAGE_QUEUE.add(dim);
			StaticSync.DOWNLOAD_IMAGE_MESSAGE_QUEUE.notify();
		}
		this.saveRecord();
	}

	@Override
	protected void onLocation() {
		this.saveRecord();
	}

	@Override
	protected void onText() {
		if(!Config.instance().getAutoSwitch()){
			return;
		}
		TextMessage tm = new TextMessage();
		tm.setContent(this.wechatRequest.getContent());
		tm.setOpenId(this.wechatRequest.getFromUserName());
		
		synchronized (StaticSync.TEXT_MESSAGE_QUEUE) {
			StaticSync.TEXT_MESSAGE_QUEUE.add(tm);
			StaticSync.TEXT_MESSAGE_QUEUE.notify();
		}
		this.saveRecord();
	}

	@Override
	protected void subscribe() {
		if(!Config.instance().getAutoSwitch()){
			return;
		}
		TextMessage tm = new TextMessage();
		tm.setOpenId(this.wechatRequest.getFromUserName());
		
		synchronized (StaticSync.GUANZHU_MESSAGE_QUEUE) {
			StaticSync.GUANZHU_MESSAGE_QUEUE.add(tm);
			StaticSync.GUANZHU_MESSAGE_QUEUE.notify();
		}
		this.saveRecord();
	}
	
	private void saveRecord(){
		WeChatMessageRecord record = new WeChatMessageRecord();
		record.setFromUser(this.wechatRequest.getFromUserName());
		record.setToUser(this.wechatRequest.getToUserName());
		SysUser user_from = SpringHelper.Context().getBean(UserService.class).queryUserByOpenId(this.wechatRequest.getFromUserName());
		SysUser user_to = SpringHelper.Context().getBean(UserService.class).queryUserByOpenId(this.wechatRequest.getToUserName());
		record.setFromUserId(Judge.isNull(user_from) ? null : user_from.getId());
		record.setToUserId(Judge.isNull(user_to) ? null : user_to.getId());
		record.setMessageType(this.wechatRequest.getMsgType());
		MsgType msgType = MsgType.valueOf(wechatRequest.getMsgType());
		switch (msgType) {
		case event:
			record.setContent(this.wechatRequest.getEventKey());
			break;
		case text:
			record.setContent(this.wechatRequest.getContent());
			break;
		case image:
			record.setContent(this.wechatRequest.getPicUrl());
			break;
		case voice:
			record.setContent(this.wechatRequest.getMediaId());
			break;
		case video:
			record.setContent(this.wechatRequest.getMediaId());
			break;
		case location:
			record.setContent("X:" + this.wechatRequest.getLocation_X() + "  Y:" + this.wechatRequest.getLocation_Y() + " 位置:" + this.wechatRequest.getLabel());
			break;
		case link:
			record.setContent(this.wechatRequest.getUrl());
			break;
		default:
			break;
		}
		
		record.setSendTime(new Date());
		
		SpringHelper.Context().getBean(WeChatMessageRecordMapper.class).insertSelective(record);
	}

	@Override
	protected void locationSelect() {
		this.saveRecord();
	}

	@Override
	protected void onLink() {
		this.saveRecord();
	}

	@Override
	protected void onVideo() {
		this.saveRecord();
	}

	@Override
	protected void onVoice() {
		this.saveRecord();
	}

	@Override
	protected void picPhotoOrAlbum() {
		this.saveRecord();
	}

	@Override
	protected void scan() {
		this.saveRecord();
	}

	@Override
	protected void scanCodePush() {
		this.saveRecord();
	}

	@Override
	protected void unSubscribe() {
		this.saveRecord();
	}

	@Override
	protected void view() {
		this.saveRecord();
	}
}