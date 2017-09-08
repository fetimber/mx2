package net.huimin.yk.web.services.bq.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.huimin.common.cnst.Const;
import net.huimin.common.helper.Judge;
import net.huimin.common.page.PageBean;
import net.huimin.yk.web.dao.bq.RoomCheckinfoMapper;
import net.huimin.yk.web.model.bq.FloorRoom;
import net.huimin.yk.web.model.bq.RoomCheckinfo;
import net.huimin.yk.web.services.bq.RoomCheckinfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoomCheckinfoServiceImpl implements RoomCheckinfoService,Const{
 
	@Autowired
	private RoomCheckinfoMapper roomCheckInfoMapper;
	
	@Transactional
	public boolean saveRoomCheckInfo(RoomCheckinfo checkInfo) {
		boolean rslt = false;
		if(Judge.isNull(checkInfo.getId())){
			rslt = this.roomCheckInfoMapper.insertSelective(checkInfo) == 1;
		} else {
			rslt = this.roomCheckInfoMapper.updateByPrimaryKeySelective(checkInfo) == 1;
		}
		
		return rslt;
	}

	public void queryCheckInfoForPage(PageBean page, RoomCheckinfo room) {
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
		Integer count = this.roomCheckInfoMapper
				.queryCountByConditions(parameters);
		List<FloorRoom> rooms = this.roomCheckInfoMapper
				.queryHousesByConditions(parameters);

		PageBean.Counter(page, count, null, rooms);
	}

	public RoomCheckinfo queryCheckInfoByid(RoomCheckinfo info) {
		return roomCheckInfoMapper.selectByPrimaryKey(info.getId());
	}	
	
	
}
