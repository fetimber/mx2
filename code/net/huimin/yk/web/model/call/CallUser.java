package net.huimin.yk.web.model.call;

import net.huimin.yk.web.model.system.SysUser;

public class CallUser {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 团队ID
     */
    private Integer teamId;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 数量
     */
    private Integer customerDecimal;
    
    
    private SysUser userInfo;

    private CallTeam teamInfo;
    
    /**
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
     * @return 团队ID
     */
    public Integer getTeamId() {
        return teamId;
    }

    /**
     * @param teamId 
	 *            团队ID
     */
    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    /**
     * @return 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId 
	 *            用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return 性别
     */
    public Integer getCustomerDecimal() {
        return customerDecimal;
    }

    /**
     * @param customerDecimal 
	 *            性别
     */
    public void setCustomerDecimal(Integer customerDecimal) {
        this.customerDecimal = customerDecimal;
    }

	public SysUser getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(SysUser userInfo) {
		this.userInfo = userInfo;
	}

	public CallTeam getTeamInfo() {
		return teamInfo;
	}

	public void setTeamInfo(CallTeam teamInfo) {
		this.teamInfo = teamInfo;
	}
    
}