package net.huimin.yk.web.services.bq;


import net.huimin.common.page.PageBean;
import net.huimin.yk.web.model.bq.RoomCheckinfo;

public interface RoomCheckinfoService {
	public boolean saveRoomCheckInfo(RoomCheckinfo checkInfo);
	
	public void queryCheckInfoForPage(PageBean page, RoomCheckinfo checkInfo) ;
	
	public RoomCheckinfo queryCheckInfoByid(RoomCheckinfo info);
	
}
