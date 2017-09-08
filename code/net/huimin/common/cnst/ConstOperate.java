/** 
 * @Title: ConstOperate.java 
 * @author 胡笑尘 <a>huxiaochen@hmeg.net</a>
 * @date 2014-11-17 下午02:12:16
 * @version V1.0
 */
package net.huimin.common.cnst;


/**
 * @author 胡笑尘 huxiaochen@hmeg.net
 * @date 2014-11-17 下午02:12:16
 */
public interface ConstOperate {
	/**
	 * 登入
	 */
	Integer OPERATE_LOGIN = 1;
	/**
	 * 注销登出
	 */
	Integer OPERATE_LOGIN_OUT = 2;

	/**
	 * 新增数据
	 */
	Integer OPERATE_INSERT = 3;
	/**
	 * 修改数据
	 */
	Integer OPERATE_UPDATE = 4;
	/**
	 * 删除数据
	 */
	Integer OPERATE_DELETE = 5;
	/**
	 * 批量修改数据
	 */
	Integer OPERATE_UPDATE_ALL = 6;
	/**
	 * 批量删除数据
	 */
	Integer OPERATE_DELETE_ALL = 7;
	/**
	 * 访问前台页面
	 */
	Integer OPERATE_ACCESS = 8;
	/**
	 * 访问后台页面
	 */
	Integer OPERATE_ACCESS_ADMIN = 9;
	/**
	 * 用户注册
	 */
	Integer OPERATE_REGISTER = 10;
	/**
	 * 管理员操作数据
	 */
	Integer OPERATE_UPDATE_ADMIN = 11;
}
