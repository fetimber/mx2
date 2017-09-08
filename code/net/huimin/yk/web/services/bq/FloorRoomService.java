package net.huimin.yk.web.services.bq;

import net.huimin.common.page.PageBean;
import net.huimin.yk.web.model.bq.FloorRoom;

public interface FloorRoomService {
	public void queryRoomsForPage(PageBean page, FloorRoom room) ;
}
