package net.huimin.common.helper;

import java.util.Collection;

/**
 * 代码辅助类
 * <p>
 * 用于代码编写过程中常用的判断
 * </p>
 * @author HuXiaoChen
 */
public class Judge {

	/**
	 * 判断输入的参数是否不为NULL
	 * @param arg0
	 * 需要判断的参数
	 * @return 判断结果，参数不为NULL时返回TRUE，否则返回FALSE
	 */
	public static boolean isNotNull(Object arg0) {
		return null != arg0;
	}

	/**
	 * 判断输入的参数是否为NULL
	 * @param arg0
	 * 需要判断的参数
	 * @return 判断结果，参数为NULL时返回TRUE，否则返回FALSE
	 */
	public static boolean isNull(Object arg0) {
		return null == arg0;
	}

	/**
	 * 判断输入的字符串参数是否为空字符串
	 * <p>
	 * 空字符串包含NULL值和长度为0的字符串
	 * </p>
	 * @param arg0
	 * 需要判断的参数
	 * @return 空字符串时返回TRUE，否则返回FALSE
	 */
	public static boolean isEmpty(String arg0) {
		return null == arg0 || arg0.length() == 0;
	}

	/**
	 * 判断输入的字符串参数是否不为空字符串
	 * <p>
	 * 非空字符串不为NULL，且字符串长度大于0
	 * </p>
	 * @param arg0
	 * 需要判断的字符串参数
	 * @return 非空字符串返回TRUE，否则返回FALSE
	 */
	public static boolean isNotEmpty(String arg0) {
		return null != arg0 && arg0.length() > 0;
	}

	/**
	 * 判断一个范式集合是否为空集合
	 * <p>
	 * 空集合是指一个集合引用本身NULL或集合中不包含任何元素
	 * </p>
	 * @param arg0 需要判断的集合
	 * @return 空集合时返回TRUE，否则返回FALSE
	 */
	public static boolean isEmpty(Collection<?> arg0) {
		return null == arg0 || arg0.isEmpty();
	}
	
	/**
	 * 判断一个范式集合是否不为空
	 * <p>
	 * 非空集合是指至少包含1个元素的集合
	 * </p>
	 * @param arg0 需要判断的集合
	 * @return 参数为非空集合时返回TRUE，否则返回FALSE
	 */
	public static boolean isNotEmpty(Collection<?> arg0) {
		return null != arg0 && !arg0.isEmpty();
	}
	
	public static boolean isNullOrBlank(String arg0){
       return null == arg0 || "".equals(arg0);	
	}
}
