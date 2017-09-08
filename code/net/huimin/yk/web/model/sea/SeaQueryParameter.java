package net.huimin.yk.web.model.sea;

import java.io.Serializable;
import java.util.Date;

import net.huimin.common.page.PageBean;

/**
 * 经纪人查询条件
 * @author HuXiaoChen
 *
 */
public class SeaQueryParameter implements Serializable {
	private static final long serialVersionUID = 5792467458766982188L;

	private String keyword;
	
	private Integer familyCountMin;
	
	private Integer familyCountMax;
	
	private Integer ageMin;
	
	private Integer ageMax;
	
	private Integer incomeMin;
	
	private Integer incomeMax;
	
	private String check;
	
	private String checkflag;
	
	private String reason;
	
	private String level;
	
	private String sex;
	
	private Integer order;
	
	private PageBean page;
	
	private Integer unit;
	
	private Integer cityId;
	
	private Integer workPoorId;
	
	private String honorType;
	
	private Date joinTimeStart;
	
	private Date joinTimeEnd;
	
	private Date honorTimeStart;
	
	private Date honorTimeEnd;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public PageBean getPage() {
		return page;
	}

	public void setPage(PageBean page) {
		this.page = page;
	}

	public Integer getFamilyCountMin() {
		return familyCountMin;
	}

	public void setFamilyCountMin(Integer familyCountMin) {
		this.familyCountMin = familyCountMin;
	}

	public Integer getFamilyCountMax() {
		return familyCountMax;
	}

	public void setFamilyCountMax(Integer familyCountMax) {
		this.familyCountMax = familyCountMax;
	}

	public Integer getIncomeMin() {
		return incomeMin;
	}

	public void setIncomeMin(Integer incomeMin) {
		this.incomeMin = incomeMin;
	}

	public Integer getIncomeMax() {
		return incomeMax;
	}

	public void setIncomeMax(Integer incomeMax) {
		this.incomeMax = incomeMax;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getUnit() {
		return unit;
	}

	public void setUnit(Integer unit) {
		this.unit = unit;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getHonorType() {
		return honorType;
	}

	public void setHonorType(String honorType) {
		this.honorType = honorType;
	}

	public Date getJoinTimeStart() {
		return joinTimeStart;
	}

	public void setJoinTimeStart(Date joinTimeStart) {
		this.joinTimeStart = joinTimeStart;
	}

	public Date getJoinTimeEnd() {
		return joinTimeEnd;
	}

	public void setJoinTimeEnd(Date joinTimeEnd) {
		this.joinTimeEnd = joinTimeEnd;
	}

	public Date getHonorTimeStart() {
		return honorTimeStart;
	}

	public void setHonorTimeStart(Date honorTimeStart) {
		this.honorTimeStart = honorTimeStart;
	}

	public Date getHonorTimeEnd() {
		return honorTimeEnd;
	}

	public void setHonorTimeEnd(Date honorTimeEnd) {
		this.honorTimeEnd = honorTimeEnd;
	}

	public Integer getAgeMin() {
		return ageMin;
	}

	public void setAgeMin(Integer ageMin) {
		this.ageMin = ageMin;
	}

	public Integer getAgeMax() {
		return ageMax;
	}

	public void setAgeMax(Integer ageMax) {
		this.ageMax = ageMax;
	}

	public Integer getWorkPoorId() {
		return workPoorId;
	}

	public void setWorkPoorId(Integer workPoorId) {
		this.workPoorId = workPoorId;
	}

	public String getCheckflag() {
		return checkflag;
	}

	public void setCheckflag(String checkflag) {
		this.checkflag = checkflag;
	}

	
	
}
