package net.huimin.yk.weixin.core;

import java.util.concurrent.LinkedBlockingQueue;

public class StaticSync {
	public static LinkedBlockingQueue<DownloadImageMessage> DOWNLOAD_IMAGE_MESSAGE_QUEUE = new LinkedBlockingQueue<DownloadImageMessage>();
	
	public static LinkedBlockingQueue<TextMessage> TEXT_MESSAGE_QUEUE = new LinkedBlockingQueue<TextMessage>();
	
	public static LinkedBlockingQueue<TextMessage> GUANZHU_MESSAGE_QUEUE = new LinkedBlockingQueue<TextMessage>();
}
