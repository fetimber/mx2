package net.huimin.yk.web.services.sea.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.huimin.common.cnst.Const;
import net.huimin.common.helper.DateFormatter;
import net.huimin.common.helper.Judge;
import net.huimin.common.page.PageBean;
import net.huimin.yk.web.dao.common.FilesMapper;
import net.huimin.yk.web.dao.sea.SeaGoodsRecordMapper;
import net.huimin.yk.web.dao.sea.SeaHonorMapper;
import net.huimin.yk.web.dao.sea.SeaHonorUnitMapper;
import net.huimin.yk.web.dao.sea.SeaTotalMapper;
import net.huimin.yk.web.dao.sea.SeaUnitMapper;
import net.huimin.yk.web.dao.sea.SeaWorkerMapper;
import net.huimin.yk.web.dao.sea.SeaWorkerPoorMapper;
import net.huimin.yk.web.dao.system.SysUserMapper;
import net.huimin.yk.web.model.sea.SeaGoodsRecord;
import net.huimin.yk.web.model.sea.SeaHonor;
import net.huimin.yk.web.model.sea.SeaHonorUnit;
import net.huimin.yk.web.model.sea.SeaQueryParameter;
import net.huimin.yk.web.model.sea.SeaUnit;
import net.huimin.yk.web.model.sea.SeaWorker;
import net.huimin.yk.web.model.sea.SeaWorkerPoor;
import net.huimin.yk.web.model.system.SysUser;
import net.huimin.yk.web.services.sea.SeaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SeaSerivceImpl implements SeaService,Const{

	@Autowired
	private SeaUnitMapper seaUnitMapper;
	@Autowired
	private SeaWorkerMapper seaWorkerMapper;
	@Autowired
    private SeaWorkerPoorMapper seaWorkerPoorMapper;
	@Autowired
	private SeaHonorMapper seaHonorMapper;
	@Autowired
	private SeaHonorUnitMapper seaHonorUnitMapper;
	@Autowired
	private SeaGoodsRecordMapper seaGoodsRecordMapper;
	@Autowired
	private SeaTotalMapper seaTotalMapper;
	
	@Autowired
	private FilesMapper filesMapper;
	@Autowired
	private SysUserMapper sysUserMapper;
    /**
     * 
     */
	@Override
	public void queryUnitsForPage(PageBean page, SeaUnit unit) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("_page", page);
		parameters.put("seaunit", unit);
		 
		try{			
			this.queryUnitPage(parameters, page);
		}
		catch (Exception ex){
			ex.printStackTrace();		
		}	
	}

	/**
	 * 查询困难职工列表
	 * @param page
	 * @param worker
	 */
	public void queryWorkersForPage(PageBean page, SeaWorker worker) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("_page", page);
		parameters.put("worker", worker);
		
		try{			
			this.queryWorkerPage(parameters, page);
		}
		catch (Exception ex){
			ex.printStackTrace();		
		}	
	}
	
	/**
	 * 查询困难职工列表
	 * @param page
	 * @param worker
	 */
	public void queryWorkersPoorForPage(PageBean page, SeaQueryParameter query) {		
		if(Judge.isNotNull(query)){
			query.setPage(page);
		}
		if(Judge.isNull(query)){
			query = new SeaQueryParameter();
			query.setOrder(0);
			query.setPage(page);
		}
		
		try{			
			this.queryPoorWorkerPage(query, page);
		}
		catch (Exception ex){
			ex.printStackTrace();		
		}		
	}
	
	
	private void queryUnitPage(Map<String, Object> parameters, PageBean page) {
		Integer count = this.seaUnitMapper
				.queryCountByConditions(parameters);
		List<SeaUnit> units = this.seaUnitMapper
				.queryResultByConditions(parameters);

		PageBean.Counter(page, count, null, units);
	}
	
	private void queryWorkerPage(Map<String, Object> parameters, PageBean page) {
		Integer count = this.seaWorkerMapper
				.queryCountByConditions(parameters);
		List<SeaWorker> units = this.seaWorkerMapper
				.queryResultByConditions(parameters);

		PageBean.Counter(page, count, null, units);
	}
	
	
	private void queryPoorWorkerPage(SeaQueryParameter query, PageBean page) {
		Integer count = this.seaWorkerPoorMapper
				.queryCountByConditions(query); 
		List<SeaWorkerPoor> units = this.seaWorkerPoorMapper
				.queryResultByConditions(query);

		PageBean.Counter(page, count,  page.getCurrent(), units);
	}

	private void queryHonorPage(SeaQueryParameter query, PageBean page) {
		Integer count = this.seaHonorMapper
				.queryCountByConditions(query);
		List<SeaHonor> honors = this.seaHonorMapper
				.queryResultByConditions(query);

		PageBean.Counter(page, count, page.getCurrent(), honors);
	}
	

	private void queryHonorUnitPage(SeaQueryParameter query, PageBean page) {
		Integer count = this.seaHonorUnitMapper
				.queryCountByConditions(query);
		List<SeaHonorUnit> honorUnits = this.seaHonorUnitMapper
				.queryResultByConditions(query);

		PageBean.Counter(page, count, page.getCurrent(), honorUnits);
	}

	private void queryGoodsRecordPage(SeaQueryParameter query, PageBean page) {
		Integer count = this.seaGoodsRecordMapper
				.queryCountByConditions(query);
		List<SeaGoodsRecord> honorUnits = this.seaGoodsRecordMapper
				.queryResultByConditions(query);

		PageBean.Counter(page, count, page.getCurrent(), honorUnits);
	}
	
	@Override
	public void queryGoodsRecordForPage(PageBean page, SeaQueryParameter query) {
		if(Judge.isNotNull(query)){
			query.setPage(page);
		}
		if(Judge.isNull(query)){
			query = new SeaQueryParameter();
			query.setOrder(0);
			query.setPage(page);
		}
		try{			
			this.queryGoodsRecordPage(query, page);
		}
		catch (Exception ex){
			ex.printStackTrace();		
		}
	}
	
	
	
	@Override
	public boolean deleteUnit(Integer id) {
		return this.seaUnitMapper.deleteByPrimaryKey(id) == 1;
	}

	public boolean deleteWorker(Integer workerId) {
		return this.seaWorkerMapper.deleteByPrimaryKey(workerId) == 1;
	}
	
	@Transactional
	public boolean deleteWorkerPoor(SeaWorker worker  ,Integer workerPoorId) {
		boolean result  =  this.seaWorkerPoorMapper.deleteByPrimaryKey(workerPoorId) == 1;
		if(result){			
			//result = this.seaWorkerMapper.updateByPrimaryKeySelective(worker) == 1;
			result = this.seaWorkerMapper.deleteByPrimaryKey(worker.getId()) == 1;
		}
		return result;
	}
	
	

	@Override
	public boolean saveUnit(SeaUnit unit) {
		boolean rslt = false;
		if(Judge.isNull(unit.getId())){
			rslt = this.seaUnitMapper.insertSelective(unit) == 1;
		} else {
			rslt = this.seaUnitMapper.updateByPrimaryKeySelective(unit) == 1;
		}
		return rslt;
	}

	@Override
	public boolean checkUnitName(SeaUnit unit) {
		boolean rslt = false;
		try {
			rslt = this.seaUnitMapper.checkUnitName(unit) == 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rslt;
	}
	
	public boolean checkIdCard(SeaWorker worker) {
		boolean rslt = false;
		try {
			if(Judge.isNotNull(worker.getWorkerIdnumber())){
				worker.setWorkerIdnumber(worker.getWorkerIdnumber().trim());
			}
			rslt = this.seaWorkerMapper.checkIdCard(worker) == 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rslt;
	}
	
	@Override
	public boolean checkUserName(SysUser user) {
		boolean rslt = false;
		try {
			rslt = this.sysUserMapper.checkLoginName(user) == 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rslt;
	}
	
	public SeaWorker checkIdNumber(SeaWorker worker) {
		return this.seaWorkerMapper.queryWorkerByIdNumber(worker);	
	}
	

	@Override
	public List<SeaUnit> queryUnitList(SeaUnit unit) {
		return this.seaUnitMapper.selectAllUnits(unit);
	}
	
	@Override
	public List<SeaWorker> queryWorkerList(SeaWorker worker) {
		return this.seaWorkerMapper.selectAllWorkerByUnitId(worker);
	}

	@Override
	public boolean saveWorker(SeaWorker worker) {
		boolean rslt = false;
		if(Judge.isNull(worker.getId())){
			rslt = this.seaWorkerMapper.insertSelective(worker) == 1;
		} else {
			rslt = this.seaWorkerMapper.updateByPrimaryKeySelective(worker) == 1;
		}
		return rslt;
	}

	@Transactional
	public boolean saveWorkerPoor(SeaWorker worker,SeaWorkerPoor workerPoor) {
		boolean rslt = false;
		
		int workId = 0;
		Date createTime = new Date(); 
		try {
		SeaWorker worker1 = this.checkIdNumber(worker);
		if(worker1 != null){
			worker.setId(worker1.getId());
			workId = worker1.getId();
		}
			if(Judge.isNull(worker.getId())){
			worker.setCreateTime(createTime);
			workId = this.seaWorkerMapper.insertSelective(worker);
		} else {
			rslt = this.seaWorkerMapper.updateByPrimaryKeySelective(worker) == 1;
		}
		
		if(workId != 0){
			workerPoor.setWorkerId(worker.getId());	
		}
		SeaWorkerPoor workerPoor1 = this.seaWorkerPoorMapper.selectByWorkerId(workId);
		if(workerPoor1 != null){
			workerPoor.setId(workerPoor1.getId());
		}
			if(Judge.isNull(workerPoor.getId())){
				workerPoor.setCreateTime(createTime);
				rslt = this.seaWorkerPoorMapper.insertSelective(workerPoor) == 1;		
			} else {
				rslt = this.seaWorkerPoorMapper.updateByPrimaryKeySelective(workerPoor) == 1;
			}
	    } catch (Exception ex){
	    	
	    	ex.printStackTrace();
	    	
	    }
		
		return rslt;
	}
	
	@Transactional
	public boolean saveCheckWorker(SeaWorkerPoor workerPoor) {
		boolean rslt = false;
		try {
			rslt = this.seaWorkerPoorMapper.updateByPrimaryKeySelective(workerPoor) == 1;
	    } catch (Exception ex){
	    	ex.printStackTrace();    	
	    }
		return rslt;
	}
	
	
	@Override
	public SeaWorker querySeaWorkerById(SeaWorker worker) {
		return this.seaWorkerMapper.selectByPrimaryKey(worker.getId());
	}

	@Override
	public SeaWorkerPoor querySeaWorkerPoorById(SeaWorkerPoor worker) {
		return this.seaWorkerPoorMapper.selectByPrimaryKey(worker.getId());
	}

	@Override
	public void queryHonorsForPage(PageBean page, SeaQueryParameter query) {
		if(Judge.isNotNull(query)){
			query.setPage(page);
		}
		if(Judge.isNull(query)){
			query = new SeaQueryParameter();
			query.setOrder(0);
			query.setPage(page);
		}
		try{			
			this.queryHonorPage(query, page);
		}
		catch (Exception ex){
			ex.printStackTrace();		
		}	
	}
	
	@Override
	public void queryHonorsUnitForPage(PageBean page, SeaQueryParameter query) {
		if(Judge.isNotNull(query)){
			query.setPage(page);
		}
		if(Judge.isNull(query)){
			query = new SeaQueryParameter();
			query.setOrder(0);
			query.setPage(page);
		}
		try{			
			this.queryHonorUnitPage(query, page);
		}
		catch (Exception ex){
			ex.printStackTrace();		
		}
	}
	

	@Override
	public boolean deleteHonor(Integer id) {
		return this.seaHonorMapper.deleteByPrimaryKey(id) == 1;
	}

	@Transactional
	public boolean saveHonor(SeaHonor honor) {
		boolean rslt = false;
		if(Judge.isNull(honor.getId())){
			rslt = this.seaHonorMapper.insertSelective(honor) == 1;
		} else {
			rslt = this.seaHonorMapper.updateByPrimaryKeySelective(honor) == 1;
		}
		return rslt;
	}

	@Override
	public boolean saveHonorByFiles(SeaHonor honor, List<Integer> bigPictures) {
		boolean rslt = false;
		if(Judge.isNull(honor.getId())){
			rslt = this.seaHonorMapper.insertSelective(honor) == 1;
		} else {
			rslt = this.seaHonorMapper.updateByPrimaryKeySelective(honor) == 1;
		}
		if(rslt){			
			dealHonorFiles(honor,bigPictures);
		}
		return rslt;
	}
	
	@Override
	public boolean saveHonorUnit(SeaHonorUnit unit) {
		boolean rslt = false;
		if(Judge.isNull(unit.getId())){
			rslt = this.seaHonorUnitMapper.insertSelective(unit) == 1;
		} else {
			rslt = this.seaHonorUnitMapper.updateByPrimaryKeySelective(unit) == 1;
		}
		return rslt;
	}

	@Override
	public boolean saveHonorUnitByFiles(SeaHonorUnit unit,
			List<Integer> bigPictures) {
		boolean rslt = false;
		if(Judge.isNull(unit.getId())){
			rslt = this.seaHonorUnitMapper.insertSelective(unit) == 1;
		} else {
			rslt = this.seaHonorUnitMapper.updateByPrimaryKeySelective(unit) == 1;
		}
		if(rslt){			
			dealHonorUnitFiles(unit,bigPictures);
		}
		return rslt;
	}
	
	@Override
	public SeaHonor querySeaHonorById(SeaHonor honor) {
		return this.seaHonorMapper.selectByPrimaryKey(honor.getId());
	}

	public SeaUnit querySeaUnitById(SeaUnit unit){
		return this.seaUnitMapper.selectByPrimaryKey(unit.getId());	
	}
	
	@Transactional
	public boolean saveHonorAndWokerByFile(SeaHonor honor, SeaWorker worker,List<Integer> bigPictures) {
		boolean rslt = false;
		int workId = 0;
		Date createTime = new Date(); 

		if(Judge.isNull(worker.getId())){
			worker.setCreateTime(createTime);
			workId = this.seaWorkerMapper.insertSelective(worker);
		} else {
			rslt = this.seaWorkerMapper.updateByPrimaryKeySelective(worker) == 1;
		}
		
		if(workId != 0){
			honor.setHonorWorker(worker.getId());	
		}
		try {
			if(Judge.isNull(honor.getId())){
				honor.setCreateTime(createTime);
				rslt = this.seaHonorMapper.insertSelective(honor) == 1;		
			} else {
				rslt = this.seaHonorMapper.updateByPrimaryKeySelective(honor) == 1;
			}
			
			if(rslt){
				dealHonorFiles(honor,bigPictures);
			}
			
	    } catch (Exception ex){ 	
	    	ex.printStackTrace();  	
	    }
		return rslt;
	}

	@Transactional
	public boolean saveHonorAndWoker(SeaHonor honor,SeaWorker worker){
		boolean rslt = false;
		int workId = 0;
		Date createTime = new Date(); 

		if(Judge.isNull(worker.getId())){
			worker.setCreateTime(createTime);
			workId = this.seaWorkerMapper.insertSelective(worker);
		} else {
			rslt = this.seaWorkerMapper.updateByPrimaryKeySelective(worker) == 1;
		}
		
		if(workId != 0){
			honor.setHonorWorker(worker.getId());	
		}
		try {
			if(Judge.isNull(honor.getId())){
				honor.setCreateTime(createTime);
				rslt = this.seaHonorMapper.insertSelective(honor) == 1;		
			} else {
				rslt = this.seaHonorMapper.updateByPrimaryKeySelective(honor) == 1;
			}			
	    } catch (Exception ex){ 	
	    	ex.printStackTrace();  	
	    }
		return rslt;
	}

	private void dealHonorFiles(SeaHonor honor,List<Integer> bigPictures){	
			if(Judge.isNotNull(honor.getId())){
			
					Map<String,Object> param = new HashMap<String, Object>();
					param.put("ref_id", honor.getId());
					param.put("type_id", Const.HOUSE_BIG_FILE);
					//解除关联
					this.filesMapper.deleteRefId(param);

					if(Judge.isNotEmpty(bigPictures)){
						param.put("id", bigPictures);
						this.filesMapper.updateRefId(param);
					}
			}
	}
	
	private void dealHonorUnitFiles(SeaHonorUnit honorUnit,List<Integer> bigPictures){	
		if(Judge.isNotNull(honorUnit.getId())){
		
				Map<String,Object> param = new HashMap<String, Object>();
				param.put("ref_id", honorUnit.getId());
				param.put("type_id", Const.HONORUNIT_FILE);
				//解除关联
				this.filesMapper.deleteRefId(param);

				if(Judge.isNotEmpty(bigPictures)){
					param.put("id", bigPictures);
					this.filesMapper.updateRefId(param);
				}
			
		}
    }
	
	
	private void dealRecordFiles(SeaGoodsRecord goodsRecord,List<Integer> bigPictures){	
		if(Judge.isNotNull(goodsRecord.getId())){
	
				Map<String,Object> param = new HashMap<String, Object>();
				param.put("ref_id", goodsRecord.getId());
				param.put("type_id", Const.GOODSRECORD_FILE);
				//解除关联
				this.filesMapper.deleteRefId(param);

				if(Judge.isNotEmpty(bigPictures)){
					param.put("id", bigPictures);
					this.filesMapper.updateRefId(param);
				}
			
		}
    }
	
	
	@Transactional
	public List<String[]> honorImport (List<String[]> list,SysUser loginUser){
		List<String[]> resultList = new ArrayList<String[]>();
		try{
		SeaWorker worker = null;
		SeaHonor honor = null;
		String[] oneData = null;
        SeaWorker idCheckWorker = null;
		
		for(int i = 0 ; i < list.size() ; i ++){
			worker = new SeaWorker();
			idCheckWorker = new SeaWorker();
			honor = new SeaHonor();
			oneData = list.get(i);
			worker.setWorkerIdnumber(oneData[3]);
			idCheckWorker.setWorkerIdnumber(oneData[3]);
			
			honor.setCreateTime(new Date());
			if(Judge.isNull(honor.getInUnit())){
				if(Judge.isNotNull(loginUser.getUnitId())){
					worker.setUnitId(loginUser.getUnitId());
				    honor.setInUnit(loginUser.getUnitId());
				}else {
					worker.setUnitId(0);
				    honor.setInUnit(0);
				}   
			}
			
			//荣誉设置		
			honor.setHonorTime(DateFormatter.parse(DateFormatter.ANALYSIS_DATE, oneData[8]));
			honor.setHonorType(oneData[9]);
			honor.setHonorLevel(oneData[10]);
			honor.setHonorDesc(oneData[11]);
			honor.setUnitHonorDesc(oneData[12]);
			honor.setHonorTitle(oneData[13]);
			honor.setHonorCode(oneData[14]);
			
			idCheckWorker = this.checkIdNumber(idCheckWorker);
			
			//存在身份证号
			if(Judge.isNotNull(idCheckWorker)){		
				honor.setHonorWorker(idCheckWorker.getId());
				saveHonor(honor);
				resultList.add(new String[]{oneData[3]});
			}else{
				worker.setIsHard("0");
				worker.setWorkerName(oneData[0]);
				worker.setWorkerSex(oneData[1]);
				worker.setWorkerAge(oneData[2]);
				worker.setWorkerIdnumber(oneData[3]);
				worker.setBankCard(oneData[4]);
				worker.setWorkerAddress(oneData[5]);
				worker.setWorkDuty(oneData[6]);
                worker.setWorkerPhone(oneData[7]);	
                saveHonorAndWoker(honor, worker);
			}						
		}		
		  
        if(Judge.isNotNull(resultList) 
        		&& resultList.size() == 0){
       	  resultList = null;
        }
}catch (Exception ex){
		
		ex.printStackTrace();
	}
		return resultList;
	}

	@Override
	public List<String[]> poorWorkerImport(List<String[]> list,SysUser loginUser) {
		List<String[]> resultList = new ArrayList<String[]>();
		try{
			
		SeaWorker worker = null;
		SeaWorkerPoor workerPoor = null;
		String[] oneData = null;
        SeaWorker idCheckWorker = null;
                
        for(int i = 0 ; i < list.size() ; i ++){
			worker = new SeaWorker();
			idCheckWorker = new SeaWorker();
			workerPoor = new SeaWorkerPoor();
			oneData = list.get(i);
			worker.setWorkerIdnumber(oneData[3]);
			idCheckWorker.setWorkerIdnumber(oneData[3]);
			
			workerPoor.setCreateTime(new Date());
			if(Judge.isNull(workerPoor.getInUnit())){
				if(Judge.isNotNull(loginUser.getUnitId())){
					 worker.setUnitId(loginUser.getUnitId());
					 workerPoor.setInUnit(loginUser.getUnitId());
				}else {
					 worker.setUnitId(0);
					 workerPoor.setInUnit(0);
				}		   
			}
			
			//困难职工设置		
			workerPoor.setFamilyPeople(oneData[8]);
			workerPoor.setFamilyIncome(oneData[9]);
			workerPoor.setPoorLevel(oneData[10]);
			workerPoor.setPoorReason(oneData[11]);
			workerPoor.setChangeMemo(oneData[12]);
			
			idCheckWorker = this.checkIdNumber(idCheckWorker);
			
			//存在身份证号
			if(Judge.isNotNull(idCheckWorker)){		
				worker = idCheckWorker;
				worker.setIsHard("1");
				workerPoor.setWorkerId(idCheckWorker.getId());	
				resultList.add(new String[]{oneData[3]});
			}else{
				worker.setIsHard("1");
				worker.setWorkerName(oneData[0]);
				worker.setWorkerSex(oneData[1]);
				worker.setWorkerAge(oneData[2]);
				worker.setWorkerIdnumber(oneData[3]);
				worker.setBankCard(oneData[4]);
				worker.setWorkerAddress(oneData[5]);
				worker.setWorkDuty(oneData[6]);
                worker.setWorkerPhone(oneData[7]);	
                saveWorkerPoor(worker, workerPoor);
			}						
		}		
         
        if(Judge.isNotNull(resultList) && resultList.size() == 0){
        	resultList = null;
        }	
	}catch (Exception ex){
		ex.printStackTrace();
	} 
		return resultList;
	}

	public boolean deleteHonorUnit(Integer id) {
		SeaHonorUnit unit = new SeaHonorUnit();
		unit.setId(id);
		unit.setIsDelete(1);
		return this.seaHonorUnitMapper.updateByPrimaryKeySelective(unit) == 1;
	}

	@Override
	public boolean deleteGoodsRecord(Integer id) {
		SeaGoodsRecord record = new SeaGoodsRecord();
		record.setId(id);
		record.setIsDelete(1);
		return this.seaGoodsRecordMapper.updateByPrimaryKeySelective(record) == 1;
	}

	@Override
	public boolean saveGoodsRecord(SeaGoodsRecord record) {
		boolean rslt = false;
		try{		
			if(Judge.isNull(record.getId())){
				rslt = this.seaGoodsRecordMapper.insertSelective(record) == 1;
			} else {
				rslt = this.seaGoodsRecordMapper.updateByPrimaryKeySelective(record) == 1;
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return rslt;
	}

	@Override
	public boolean saveGoodsRecordByFiles(SeaGoodsRecord record,
			List<Integer> bigPictures) {
		boolean rslt = false;
		if(Judge.isNull(record.getId())){
			rslt = this.seaGoodsRecordMapper.insertSelective(record) == 1;
		} else {
			rslt = this.seaGoodsRecordMapper.updateByPrimaryKeySelective(record) == 1;
		}
		if(rslt){			
			dealRecordFiles(record,bigPictures);
		}
		return rslt;
	}

	@Override
	public SeaHonorUnit querySeaHonorUnitById(SeaHonorUnit honrUnit) {
		return this.seaHonorUnitMapper.selectByPrimaryKey(honrUnit.getId());
	}

	@Override
	public SeaGoodsRecord querySeaGoodsRecordById(SeaGoodsRecord goodsRecord) {
		return this.seaGoodsRecordMapper.selectByPrimaryKey(goodsRecord.getId());
	}
	@Override
	public List<Map<String, Object>> queryHonorTotal(SeaQueryParameter query) {
		// TODO Auto-generated method stub
		return this.seaTotalMapper.queryHonorTotal(query);
	}

	@Override
	public List<Map<String, Object>> queryHonorUnitTotal(SeaQueryParameter query) {
		// TODO Auto-generated method stub
		return this.seaTotalMapper.queryHonorUnitTotal(query);
	}

	@Override
	public List<Map<String, Object>> queryWorkerPoorTotal(
			SeaQueryParameter query) {
		// TODO Auto-generated method stub
		return this.seaTotalMapper.queryWorkerPoorTotal(query);
	}

}
