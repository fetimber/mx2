package net.huimin.yk.web.model.common;

public class Config {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 分组名称
     */
    private String groupName;

    /**
     * 分组KEY
     */
    private String groupKey;

    private String configName;

    /**
     * 配置项KEY
     */
    private String configKey;

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
     * @return 分组名称
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * @param groupName 
	 *            分组名称
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * @return 分组KEY
     */
    public String getGroupKey() {
        return groupKey;
    }

    /**
     * @param groupKey 
	 *            分组KEY
     */
    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    /**
     * @return 配置项KEY
     */
    public String getConfigKey() {
        return configKey;
    }

    /**
     * @param configKey 
	 *            配置项KEY
     */
    public void setConfigKey(String configKey) {
        this.configKey = configKey;
    }
}