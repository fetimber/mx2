package net.huimin.yk.weixin.core;

import javax.servlet.http.HttpServletRequest;


public abstract class MessageHandler extends WechatSupport {

	public MessageHandler(HttpServletRequest request) {
		super(request);
	}

	@Override
	protected abstract void click();

	@Override
	protected abstract void location();

	@Override
	protected abstract void locationSelect();
	
	@Override
	protected abstract void onImage();

	@Override
	protected abstract void onLink();

	@Override
	protected abstract void onLocation();

	@Override
	protected abstract void onText();

	@Override
	protected void onUnknown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected abstract void onVideo();

	@Override
	protected abstract void onVoice();

	@Override
	protected abstract void picPhotoOrAlbum();

	@Override
	protected void picSysPhoto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void picWeixin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected abstract void scan() ;

	@Override
	protected abstract void scanCodePush();

	@Override
	protected void scanCodeWaitMsg() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected abstract void subscribe();

	@Override
	protected void templateMsgCallback() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected abstract void unSubscribe();

	@Override
	protected abstract void view();
}
