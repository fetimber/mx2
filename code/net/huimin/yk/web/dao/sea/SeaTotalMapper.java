package net.huimin.yk.web.dao.sea;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import net.huimin.yk.web.model.sea.SeaQueryParameter;
@Repository
public interface SeaTotalMapper {

	List<Map<String,Object>> queryHonorTotal(SeaQueryParameter query);
	
	List<Map<String,Object>> queryHonorUnitTotal(SeaQueryParameter query);
	
	List<Map<String,Object>> queryWorkerPoorTotal(SeaQueryParameter query);
}
