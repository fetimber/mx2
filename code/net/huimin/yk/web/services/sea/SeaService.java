package net.huimin.yk.web.services.sea;

import java.util.List;
import java.util.Map;

import net.huimin.common.page.PageBean;
import net.huimin.yk.web.model.sea.SeaGoodsRecord;
import net.huimin.yk.web.model.sea.SeaHonor;
import net.huimin.yk.web.model.sea.SeaHonorUnit;
import net.huimin.yk.web.model.sea.SeaQueryParameter;
import net.huimin.yk.web.model.sea.SeaUnit;
import net.huimin.yk.web.model.sea.SeaWorker;
import net.huimin.yk.web.model.sea.SeaWorkerPoor;
import net.huimin.yk.web.model.system.SysUser;

public interface SeaService {
	public void queryUnitsForPage(PageBean page, SeaUnit unit);
	
	public void queryWorkersForPage(PageBean page, SeaWorker worker);
	
	public void queryHonorsForPage(PageBean page, SeaQueryParameter query);
	
	public void queryWorkersPoorForPage(PageBean page, SeaQueryParameter query);
	
	public void queryHonorsUnitForPage(PageBean page, SeaQueryParameter query);
	
	public void queryGoodsRecordForPage(PageBean page, SeaQueryParameter query);
	
	public boolean deleteUnit(Integer id);
	
	public boolean deleteWorker(Integer id);
	
	public boolean deleteWorkerPoor(SeaWorker worker  ,Integer workerPoorId) ;
	
	public boolean deleteHonor(Integer id);
	
	public boolean deleteHonorUnit(Integer id);
	
	public boolean deleteGoodsRecord(Integer id);
	
	public boolean saveUnit(SeaUnit unit);
	
	public boolean saveWorker(SeaWorker worker);
	
	public boolean saveWorkerPoor(SeaWorker worker,SeaWorkerPoor workerPoor);
	
	public boolean saveCheckWorker(SeaWorkerPoor workerPoor);
	
	public boolean saveHonor(SeaHonor honor);
	
	public boolean saveHonorByFiles(SeaHonor honor,List<Integer> bigPictures);
	
	public boolean saveHonorAndWoker(SeaHonor honor,SeaWorker woker);

	public boolean saveHonorAndWokerByFile(SeaHonor honor,SeaWorker woker,List<Integer> bigPictures);
	
	public boolean saveHonorUnit(SeaHonorUnit unit);
	
	public boolean saveHonorUnitByFiles(SeaHonorUnit unit , List<Integer> bigPictures);
	
	public boolean saveGoodsRecord(SeaGoodsRecord record);
	
	public boolean saveGoodsRecordByFiles(SeaGoodsRecord record, List<Integer> bigPictures);
	
	boolean checkUnitName(SeaUnit unit);
	
	boolean checkIdCard(SeaWorker worker);
	
	public boolean checkUserName(SysUser user);
	
	public List<SeaUnit> queryUnitList(SeaUnit unit);
	
	public List<SeaWorker> queryWorkerList(SeaWorker worker);
	
	public SeaUnit querySeaUnitById(SeaUnit unit);
	
	public SeaWorker querySeaWorkerById(SeaWorker worker);
	
	public SeaWorkerPoor querySeaWorkerPoorById(SeaWorkerPoor worker);
	
	public SeaHonor querySeaHonorById(SeaHonor honor);
	
	public SeaHonorUnit querySeaHonorUnitById(SeaHonorUnit honrUnit);
	
	public SeaGoodsRecord querySeaGoodsRecordById(SeaGoodsRecord goodsRecord);
	
	public List<String[]> honorImport (List<String[]> list,SysUser loginUser);
	
	public List<String[]> poorWorkerImport (List<String[]> list,SysUser loginUser);
	
	public SeaWorker checkIdNumber(SeaWorker worker);
	
	List<Map<String,Object>> queryHonorTotal(SeaQueryParameter query);
	
	List<Map<String,Object>> queryHonorUnitTotal(SeaQueryParameter query);
	
	List<Map<String,Object>> queryWorkerPoorTotal(SeaQueryParameter query);
}
