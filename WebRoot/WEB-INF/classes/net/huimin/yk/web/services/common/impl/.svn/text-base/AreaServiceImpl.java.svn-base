package net.huimin.yk.web.services.common.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.huimin.common.helper.Judge;
import net.huimin.yk.web.dao.common.AreaMapper;
import net.huimin.yk.web.dao.common.CityMapper;
import net.huimin.yk.web.dao.common.ProvinceMapper;
import net.huimin.yk.web.model.common.Area;
import net.huimin.yk.web.model.common.City;
import net.huimin.yk.web.model.common.Province;
import net.huimin.yk.web.services.common.AreaService;

@Service
public class AreaServiceImpl implements AreaService {
	
	@Autowired
	private AreaMapper areaMapper;
	@Autowired
	private CityMapper cityMapper;
	
	@Autowired
	private ProvinceMapper provinceMapper;
	
	public List<Area> quertAllArea() {
		return this.areaMapper.queryAreaByCityId(Integer.valueOf(1));
	}

	public List<Province> queryAllProvinces() {
		return this.provinceMapper.queryAllProvinces();
	}

	public boolean isProvinceExist(String name) {
		Province p = this.provinceMapper.queryProvinceByName(name);
		return Judge.isNotNull(p);
	}

	public boolean addProvince(String name) {
		Province province = new Province();
		province.setProvinceName(name);
		return this.provinceMapper.insertSelective(province) == 1;
	}

	public boolean deleteProvince(Integer id) {
		return this.provinceMapper.deleteByPrimaryKey(id) == 1;
	}

	public boolean edit_province(Integer id, String name) {
		Province province = new Province();
		province.setId(id);
		province.setProvinceName(name);
		return this.provinceMapper.updateByPrimaryKeySelective(province) == 1;
	}

	public List<City> queryCityByProvince(Integer id) {
		return this.cityMapper.queryCityByProvince(id);
	}

	public boolean deleteCity(Integer id) {
		return this.cityMapper.deleteByPrimaryKey(id) == 1;
	}

	public boolean isCityExist(String name) {
		return Judge.isNotNull(this.cityMapper.queryCityByName(name));
	}

	public boolean addCity(Integer id, String name) {
		City city = new City();
		city.setCityName(name);
		city.setProvinceId(id);
		return this.cityMapper.insertSelective(city) == 1;
	}

	public boolean editCity(Integer id, String name) {
		City city = new City();
		city.setCityName(name);
		city.setId(id);
		return this.cityMapper.updateByPrimaryKeySelective(city) == 1;
	}

	public boolean deleteArea(Integer id) {
		return this.areaMapper.deleteByPrimaryKey(id) == 1;
	}

	public boolean editArea(Integer id, String name) {
		Area area = new Area();
		area.setAreaName(name);
		area.setId(id);
		return this.areaMapper.updateByPrimaryKeySelective(area) == 1;
	}

	public boolean isAreaExist(String name) {
		return Judge.isNotNull(this.areaMapper.queryAreaByName(name));
	}

	public boolean addArea(Integer id, String name) {
		Area area = new Area();
		area.setAreaName(name);
		area.setCityId(id);
		
		return this.areaMapper.insertSelective(area) == 1;
	}

	public List<Area> queryAreaByCity(Integer id) {
		return this.areaMapper.queryAreaByCityId(id);
	}
}
