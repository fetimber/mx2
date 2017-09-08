package net.huimin.yk.web.model.agent;

public class Store {
    private Integer id;

    /**
     * 门店名称
     */
    private String storeName;

    /**
     * 门店地址
     */
    private String storeAddress;

    /**
     * 门店管理员联系方式
     */
    private String adminPhone;

    /**
     * 门店管理员姓名
     */
    private String adminName;
    
    private String keyword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 门店名称
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * @param storeName 
	 *            门店名称
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    /**
     * @return 门店地址
     */
    public String getStoreAddress() {
        return storeAddress;
    }

    /**
     * @param storeAddress 
	 *            门店地址
     */
    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    /**
     * @return 门店管理员联系方式
     */
    public String getAdminPhone() {
        return adminPhone;
    }

    /**
     * @param adminPhone 
	 *            门店管理员联系方式
     */
    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    /**
     * @return 门店管理员姓名
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * @param adminName 
	 *            门店管理员姓名
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
    
    
}