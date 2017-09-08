package net.huimin.yk.web.model.system;

public class SysUserRole {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户Id
     */
    private Integer userId;

    /**
     * 角色ID
     */
    private Integer roleId;

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
     * @return 用户Id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId 
	 *            用户Id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return 角色ID
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @param roleId 
	 *            角色ID
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}