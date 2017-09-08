package net.huimin.common.cnst;

import java.io.File;

/**
 * 普通常量类
 * @author 胡笑尘 huxiaochen@hmeg.net
 * @date 2014-11-12 上午10:12:21
 */
public interface Const {

	/**
	 * 用户信息在SESSION中的KEY
	 */
	String USERINFO_IN_SESSION = "userinfo_in_session";
	
	/**
	 * 经纪人信息在SESSION中的KEY
	 */
	String AGNETINFO_IN_SESSION = "agentinfo_in_session";
	
	/**
	 * SESSION中保存的最后的地址
	 */
	String LAST_URL_IN_SESSION = "last_url_in_session";
	
	/**
	 * 后台MENU SESSION
	 */
	String MENU_IN_SESSION = "menu_in_session";
	
	/**
	 * 微信侧用户类型
	 */
    Integer WECHAT_TYPE = 1;
    
	/**
	 * 后台用户类型
	 */
    Integer MANAGER_TYPE = 2;
    

	/**
	 * 用户有效
	 */
    Integer EFFECT_TYPE = 1;
    
	/**
	 * 用户无效
	 */
    Integer UNEFFECT_TYPE = 0;
    
    /**
     * 无意向客户
     */
    Integer INTENTION_TYPE = 2;
    
    
	/**
	 * 账户收入
	 */
    Integer ACCOUNT_INCOME = 0;
    
	/**
	 * 账户消费
	 */
    Integer ACCOUNT_OUT = 1;
    
    /**
     * 账户操作类型 (可提现佣金)
     */
    Integer ACCOUNT_CASH = 1;
    
    /**
     * 账户操作类型 (可结佣金)
     */
    Integer ACCOUNT_USABLE = 2;
    
    /**
     * 账户操作类型 (已结佣金)
     */
    Integer ACCOUNT_TOTAL = 3;
    
    /**
     * 账户操作类型 (待审佣金)
     */
    Integer ACCOUNT_PENDING = 4;
    
    /**
     * 账户操作类型 (已提现金)
     */
    Integer ACCOUNT_HISTORY = 5;
    
    
    /**
     * 账户操作类型 (待审现金)
     */
    Integer ACCOUNT_CASHING = 6;
	/**
	 * 红包开启
	 */
    Integer RED_OPEN = 1;
    
	/**
	 * 红包结束
	 */
    Integer RED_CLOSE = 0;
    
	/**
	 * 上传文件路径
	 */
     String UPLOAD_FILEPATH = "resources"+ File.separator+"loanfiles" + File.separator;
	 
 	/**
 	 * 申诉
 	 */
 	Integer CUSTTOMER_STATUS_ZERO = 0 ;
 	
	/**
	 * 未分配
	 */
	Integer CUSTTOMER_STATUS_ONE = 1 ;
	
	/**
	 * 已分配 未处理
	 */
	Integer CUSTTOMER_STATUS_TWO = 2 ;
	
	/**
	 * 电联
	 */
	Integer CUSTTOMER_STATUS_THREE = 3 ;
	
	/**
	 * 到访
	 */
	Integer CUSTTOMER_STATUS_FOUR = 4 ;
	
	/**
	 * 认购
	 */
	Integer CUSTTOMER_STATUS_FIVE = 5 ;
	
	/**
	 * 签约
	 */
	Integer CUSTTOMER_STATUS_SIX = 6 ;
	
	/**
	 * 申请结佣
	 */
	Integer CUSTTOMER_STATUS_SEEVEN = 7 ;
	
	/**
	 * 已结佣
	 */
	Integer CUSTTOMER_STATUS_EIGHT = 8 ;
	
	/**
	 * 申请提现
	 */
	Integer CUSTTOMER_STATUS_NIGHT = 9 ;
	
	/**
	 * 催办
	 */
	Integer CUSTTOMER_STATUS_TEN = 10 ;
	/**
	 * 已经认购
	 */
	Integer AGENT_STATUS_ONE = 1 ;
	/**
	 * 已经签约
	 */
	Integer AGENT_STATUS_TWO = 2 ;
	
	/**
	 * 申请提现佣金
	 */
	Integer AGENT_STATUS_THREE = 3 ;
	
	/**
	 * 已提现佣金
	 */
	Integer AGENT_STATUS_FOUR = 4 ;
	
	
	/**
	 * 申请中
	 */
	Integer MONEY_STATUS_ING  = 0 ;
	
	/**
	 * 审核通过
	 */
	Integer MONEY_STATUS_PASS  = 1 ;
	
	/**
	 * 审核拒绝
	 */
	Integer MONEY_STATUS_NO  = 2 ;
	
	/**
	 * 申请提现
	 */
	Integer MONEY_STATUS_CASH  = 3 ;
	
	
	/**
	 * 图片显示路径
	 */
	String SHOW_FILEPATH = "resources/paperfiles/";
	

	/**
	 * 楼盘列表大图文件类型
	 */
    Integer  HOUSE_BIG_FILE = 2 ;

	/**
	 * 楼盘列表小图文件类型
	 */
    Integer  HOUSE_SMALL_FILE = 1 ;
    
    /**
     * 楼盘配套图片
     */
    Integer  HOUSE_PT_FILE = 3 ;
    
    /**
     * 微信下载的图片
     */
    Integer DOWNLOAD_WX_FILE = 4;
    
    /**
     * 奖励的图片
     */
    Integer REWARD_FILE = 5;
    
    /**
     * 单位荣誉
     */
    Integer HONORUNIT_FILE = 6;
    
    /**
     * 单位荣誉
     */
    Integer GOODSRECORD_FILE = 7;
    
    
    /**
     * 楼盘需求类型：刚需
     */
    Integer  HOUSE_REQ_TYPE1 = 1;
    
    /**
     * 楼盘需求类型：改善
     */
    Integer  HOUSE_REQ_TYPE2 = 2;
    
    /**
	 * 操作成功
	 */
	String OPERAT_SUCCESS = "0000";
	
	/**
	 * 返回结果 成功
	 */
	Integer RESULT_JSON_SUCCESS = 0;
	
	/**
	 * 返回结果 失败
	 */
	Integer RESULT_JSON_FAILURE = 1;
    
	/**
	 * 用户名密码错误
	 */
	String LOGIN_ERROR_YM = "0001";

	/**
	 * 用户名错误
	 */
	String LOGIN_ERROR_Y = "0002";

	/**
	 * 密码错误
	 */
	String LOGIN_ERROR_M = "0003";

    /**
     * 开户错误，用户名已存在
     */
	String ACCOUNT_OPEN_ERROR_1 = "0100";
    /**
     * 开户错误、系统异常
     */
	String ACCOUNT_OPEN_ERROR_2 = "0101";
	/**
     * 开户错误，手机号码已存在
     */
	String ACCOUNT_OPEN_ERROR_3 = "0102";
	/**
     * 开户错误，微信账号已存在
     */
	String ACCOUNT_OPEN_ERROR_4 = "0103";
	
	/**
	 * 申诉状态 已申诉
	 */
	Integer APPEAL_STATUS_YES = 1;
	/**
	 * 申诉状态 未申诉
	 */
	Integer APPEAL_STATUS_NO = 0;
	
	/**
	 * 催办状态 已催办
	 */
	Integer APPEAL_PRESS_YES = 1;
	/**
	 * 催办状态 未催办
	 */
	Integer APPEAL_PRESS_NO = 0;
	
	/**
	 * 阅读状态 已阅读
	 */
	Integer APPEAL_READ_YES = 1;
	/**
	 * 阅读状态 未阅读
	 */
	Integer APPEAL_READ_NO = 0;
	
	/**
	 * 一手房
	 */
	Integer CUST_RULE_TYPE1 = 1;
	/**
	 * 二手房
	 */
	Integer CUST_RULE_TYPE2 = 2;
	
	Integer ADD = 0 ;
	
	Integer SUB = 1;
	
	/**
	 * 佣金类型 签约结佣
	 */
	Integer MONEY_TYPE1 = 1;
	
	/**
	 * 客户到访奖励
	 */
	Integer MONEY_TYPE2 = 2;
	
	/**
	 * 首次带看奖励
	 */
	Integer MONEY_TYPE3 = 3;
	
	/**
	 * 推荐人注册奖励
	 */
	Integer MONEY_TYPE4 = 4;
	
	/**
	 * 注册送红包
	 */
	Integer MONEY_TYPE5 = 5;
	
    /**
     * 其他活动
     */
	Integer MONEY_TYPE6 = 6;
	
	/**
	 * 可点击状态
	 */
	Integer  ABLE_TYPE = 0;
	
	/**
	 * 经纪人已点击申请，可结佣 
	 */
	Integer  CLICK_TYPE= 1;
	
	/**
	 * 申请结佣中
	 */
	Integer  ING_TYPE = 2;
	
	/**
	 * 完成
	 */
	Integer  FINISH_TYPE= 3;
	
	/**
	 * 邀请中
	 */
	Integer STORE_STATUS_INVITE = 1;
	
	/**
	 * 邀请取消
	 */
	Integer STORE_STATUS_CONCEL = 2;
	
	/**
	 * 邀请拒绝
	 */
	Integer STORE_STATUS_REFUSE = 3;
	
	/**
	 * 同意邀请
	 */
	Integer STORE_STATUS_AGREE = 4;
}
