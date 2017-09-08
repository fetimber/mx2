package net.huimin.yk.web.model.system;

public class SysMenuRole {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 菜单ID
     */
    private Integer menuId;

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

    /**
     * @return 菜单ID
     */
    public Integer getMenuId() {
        return menuId;
    }

    /**
     * @param menuId 
	 *            菜单ID
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
}