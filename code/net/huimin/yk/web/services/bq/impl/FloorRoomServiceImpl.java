package net.huimin.yk.web.services.bq.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.huimin.common.cnst.Const;
import net.huimin.common.page.PageBean;
import net.huimin.yk.web.dao.bq.FloorRoomMapper;
import net.huimin.yk.web.model.bq.FloorRoom;
import net.huimin.yk.web.services.bq.FloorRoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FloorRoomServiceImpl implements FloorRoomService,Const {
	@Autowired
	private FloorRoomMapper floorRoomMapper;
	
	public void queryRoomsForPage(PageBean page, FloorRoom room) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("_page", page);
		parameters.put("room", room);
		 
		try{			
			this.queryPage(parameters, page);
		}
		catch (Exception ex){
			
			ex.printStackTrace();
			
		}
	}

	private void queryPage(Map<String, Object> parameters, PageBean page) {
		Integer count = this.floorRoomMapper
				.queryCountByConditions(parameters);
		List<FloorRoom> rooms = this.floorRoomMapper
				.queryHousesByConditions(parameters);

		PageBean.Counter(page, count, null, rooms);
	}

}
