package net.huimin.yk.weixin.core;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import net.huimin.common.helper.ConfigHelper;
import net.huimin.common.helper.Judge;
import net.huimin.common.helper.SpringHelper;
import net.huimin.yk.web.model.system.WechatAuto;
import net.huimin.yk.web.services.common.CommonService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;
import org.sword.wechat4j.common.MediaFile;
import org.sword.wechat4j.common.MediaType;
import org.sword.wechat4j.message.CustomerMsg;

@Repository
public class TextMessageHandler implements Runnable, InitializingBean {

	private Logger logger = Logger.getLogger(TextMessageHandler.class);
	
	public void afterPropertiesSet() throws Exception {
		Thread thread = new Thread(this);
		thread.start();
		logger.info("文字内容微信信息处理线程启动完成");
	}

	public void run() {
		try {
			while(true){
				TextMessage tm = null;
				synchronized (StaticSync.TEXT_MESSAGE_QUEUE) {
					tm = StaticSync.TEXT_MESSAGE_QUEUE.poll();
					if(Judge.isNull(tm)){
						this.logger.info("微信文本消息处理线程未发现新的消息，进入等待状态");
						StaticSync.TEXT_MESSAGE_QUEUE.wait();
						continue;
					}
				}
				if(Judge.isNotNull(tm)){
					this.logger.info("微信文本消息处理线程有新的消息，开始进行处理文本消息");
					this.process(tm);
				}
			}
		} catch (Exception e) {
			logger.error("微信文本消息处理线程出现异常",e);
		} finally {
			Thread thread = new Thread(new TextMessageHandler());
			thread.start();
			logger.error("重新启动微信文本消息处理线程");
		}
	}

	private void process(TextMessage tm) {
		tm.setContent(tm.getContent().trim());
		
		if(Judge.isEmpty(tm.getContent())){
			logger.info("文本消息为空消息，中止本次文本消息处理");
			return;
		}
		
		
		List<WechatAuto>  list = SpringHelper.Context().getBean(CommonService.class).queryAllKeywordAutos();
		if(Judge.isEmpty(list)){
			logger.info("未发现关键字自动回复策略，处理完成");
			return;
		}
		
		Iterator<WechatAuto> iterator = list.iterator();
		boolean isKeyWord = false;
		while (iterator.hasNext()) {
			WechatAuto auto = iterator.next();
			
			if(tm.getContent().indexOf(auto.getKeyword()) > -1){
				if(auto.getContentType() == 1){
					logger.info("发现图片关键字策略，将向客户端发送图片消息:" + auto.getPicUrl());
			        String file_path = System.getProperty("app.root.yk").concat(auto.getPicUrl()).replaceAll("//", File.separator);
			        File target_file = new File(file_path);
			        
			        if(target_file.exists()){
			        	//上传微信服务器
				        MediaFile mediaFile = new MediaFile();   //创建示例对象
				        //上传文件，并且得到上传后的mediaId
				        String mediaId = mediaFile.upload(target_file, MediaType.image);
				        CustomerMsg customerMsg = new CustomerMsg(tm.getOpenId());
				    	//发送图片消息
				    	customerMsg.sendImage(mediaId); 
			        } else {
			        	logger.info("未发现指定的图片文件，本次发送中断");
			        }
				} else {
					logger.info("发现文字关键字策略，回复内容:" + auto.getContent());
					CustomerMsg cm = new CustomerMsg(tm.getOpenId());
					cm.sendText(auto.getContent());
				}
				
				isKeyWord = true;
				break;
			}
		}
		
		if(!isKeyWord){
			ConfigHelper config = new ConfigHelper();
			//非关键子消息处理
			 CustomerMsg customerMsg = new CustomerMsg(tm.getOpenId());
		    //发送默认文字内容
		    customerMsg.sendText(config.getSendMessage()); 
		    
		    logger.info("发送默认文字内容,open_id:" + tm.getOpenId() + "，回复内容:" + config.getSendMessage());
		    
		}
	}
}
