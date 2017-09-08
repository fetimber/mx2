package net.huimin.yk.weixin.core;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import net.huimin.common.cnst.Const;
import net.huimin.common.helper.Judge;
import net.huimin.common.helper.SpringHelper;
import net.huimin.yk.web.dao.common.FilesMapper;
import net.huimin.yk.web.model.common.Files;
import net.huimin.yk.web.model.system.SysUser;
import net.huimin.yk.web.services.system.UserService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;
import org.sword.wechat4j.common.MediaFile;
import org.sword.wechat4j.message.CustomerMsg;
import org.sword.wechat4j.token.TokenProxy;

@Repository
public class ImageHandler implements Runnable,InitializingBean {
		public void afterPropertiesSet() throws Exception {
			Thread thread = new Thread(this);
			thread.start();
			this.logger.info("图片处理线程启动");
		}
		private Logger logger = Logger.getLogger(ImageHandler.class);
		public void run() {
			try {
				while(true){
					DownloadImageMessage dim = null;
					synchronized (StaticSync.DOWNLOAD_IMAGE_MESSAGE_QUEUE) {
						dim = StaticSync.DOWNLOAD_IMAGE_MESSAGE_QUEUE.poll();
						if(Judge.isNull(dim)){
							this.logger.info("图片处理线程未发现新的图片上传消息，进入等待状态");
							StaticSync.DOWNLOAD_IMAGE_MESSAGE_QUEUE.wait();
							continue;
						}
					}
					if(Judge.isNotNull(dim)){
						this.process(dim);
					}
				}
			} catch (Exception e) {
				logger.error("图片处理线程出现异常",e);
			} finally {
				Thread thread = new Thread(new ImageHandler());
				thread.start();
				logger.error("重新启动图片处理线程");
			}
		}
		
		private void process(DownloadImageMessage dim){
			logger.info("接受到微信图片消息，图片下载线程启动.OpenId=" + dim.getOpenId() + ", mediaId=" + dim.getMediaId() + ",url:" + dim.getUrl());
			MediaFile file = new MediaFile();
			byte[] bs = file.download(dim.getMediaId());
			CustomerMsg msg = new CustomerMsg(dim.getOpenId());
			if(Judge.isNull(bs) ){
				logger.info("不存在或字节长度过小，已被放弃");
				return;
			} else if(bs.length < 500){
				try{
					URL url = new URL(dim.getUrl());    
					URLConnection conn = url.openConnection();    
			        //设置超时间为3秒  
					
			        conn.setConnectTimeout(3*1000);
			        //防止屏蔽程序抓取而返回403错误  
			        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");  
			  
			        //得到输入流  
			        InputStream inputStream = conn.getInputStream();    
			        //获取自己数组 
			        bs = new byte[inputStream.available()];
			        inputStream.read(bs);
			        inputStream.close();
				} catch (IOException e){
					logger.error("线程从URL[" + dim.getUrl() + "]获取图片时发生错误",e);
				}
			} else {
				msg.sendText("尊敬的用户您好，您的信息已经收到。如果您提交的信息有效，我们将在2个工作日提供结果。");
				logger.info("线程接收完成，图片大小:" + bs.length + "字节");
			}
			String rondom = rondom();
			String subfix = ".jpg";
			String target_name = new SimpleDateFormat("yyyyMMddHHmmssS").format(new Date()).concat(rondom).concat(subfix);
			String path = System.getProperty("app.root.yk").concat("upload").concat(File.separator).concat(target_name);
			
			File save_file = new File(path);
			try {
				if(save_file.createNewFile()){
					FileOutputStream fos = new FileOutputStream(save_file);
					fos.write(bs);
					fos.flush();
					fos.close();
					logger.info("文件处理完成，保存地址:" + path);
				}
			} catch (IOException e) {
				logger.error("保存文件时发生错误",e);
			}
			
			Files files = new Files();
			files.setFileName(target_name);
			files.setFilePath("upload/".concat(target_name));
			files.setFileSize(String.valueOf(save_file.length()));
			files.setFileType(Const.DOWNLOAD_WX_FILE);
			
			SysUser user = SpringHelper.Context().getBean(UserService.class).queryUserByOpenId(dim.getOpenId());
			if(Judge.isNull(user)){
				logger.warn("未查询倒微信关联的用户信息,OpenId:" + dim.getOpenId());
				return;
			}
			files.setReferId(user.getId());
			files.setUploadTime(new Date());

			SpringHelper.Context().getBean(FilesMapper.class).insertSelective(files);
			logger.info("保存文件信息到数据完成,UserId:" + user.getId());
		}
		
		private String rondom() {
			int max = 9999;
			int min = 1000;
			Random random = new Random();

			int s = random.nextInt(max) % (max - min + 1) + min;
			return String.valueOf(s);
		}
}
