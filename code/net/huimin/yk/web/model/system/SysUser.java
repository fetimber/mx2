package net.huimin.yk.web.model.system;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.huimin.yk.web.model.common.City;
import net.huimin.yk.web.model.sea.SeaUnit;

public class SysUser {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 登录密码
     */
    private String pwdCode;

    /**
     * 真实姓名
     */
    private String realName;

    
    private String nickName;
    
    /**
     * 性别
     */
    private Integer sex;

    private Integer userType;

    private Integer roleId;

    private Date lastLogintime;

    private Date createTime;
    
    private String createTimeDesc;

	private SysRole roleInfo;
    
    private String phone;

    private Date wechatTime;
    
    private Integer unitId;
    
    private SeaUnit unitInfo;
    
    private Integer cityId;
    
    private City cityInfo;
    
    private String userLevel;
    
    private String ip;
    
    /**
     * .
     * @return 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 
	 *            主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 登录名
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * @param loginName 
	 *            登录名
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * @return 登录密码
     */
    public String getPwdCode() {
        return pwdCode;
    }

    /**
     * @param pwdCode 
	 *            登录密码
     */
    public void setPwdCode(String pwdCode) {
        this.pwdCode = pwdCode;
    }

    /**
     * @return 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * @param realName 
	 *            真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * @return 性别
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * @param sex 
	 *            性别
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }


    public Date getLastLogintime() {
        return lastLogintime;
    }

    public void setLastLogintime(Date lastLogintime) {
        this.lastLogintime = lastLogintime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm");
		if(null != createTime){
		  this.setCreateTimeDesc(format.format(this.getCreateTime()));
		}
    }
    
    public String getCreateTimeDesc() {
		return createTimeDesc;
	}

	public void setCreateTimeDesc(String createTimeDesc) {
		this.createTimeDesc = createTimeDesc;
	}

	public SysRole getRoleInfo() {
		return roleInfo;
	}

	public void setRoleInfo(SysRole roleInfo) {
		this.roleInfo = roleInfo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Date getWechatTime() {
		return wechatTime;
	}

	public void setWechatTime(Date wechatTime) {
		this.wechatTime = wechatTime;
	}

	public Integer getUnitId() {
		return unitId;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	public SeaUnit getUnitInfo() {
		return unitInfo;
	}

	public void setUnitInfo(SeaUnit unitInfo) {
		this.unitInfo = unitInfo;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public City getCityInfo() {
		return cityInfo;
	}

	public void setCityInfo(City cityInfo) {
		this.cityInfo = cityInfo;
	}

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
}