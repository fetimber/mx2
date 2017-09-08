package net.huimin.yk.web.services.common;

import java.util.List;

import net.huimin.yk.web.model.common.Area;
import net.huimin.yk.web.model.common.City;
import net.huimin.yk.web.model.common.Province;

public interface AreaService {
	//查询全部区域
		public List<Area> quertAllArea();

		public List<Province> queryAllProvinces();

		public boolean isProvinceExist(String name);

		public boolean addProvince(String name);

		public boolean deleteProvince(Integer id);

		public boolean edit_province(Integer id, String name);

		public List<City> queryCityByProvince(Integer id);

		public boolean deleteCity(Integer id);

		public boolean isCityExist(String name);

		public boolean addCity(Integer id, String name);

		public boolean editCity(Integer id, String name);

		public boolean deleteArea(Integer id);

		public boolean editArea(Integer id, String name);

		public boolean isAreaExist(String name);

		public boolean addArea(Integer id, String name);

		public List<Area> queryAreaByCity(Integer id);
}
