package net.huimin.common.helper;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.time.DateFormatUtils;

/**
 * 代码书写快捷方法
 * @author 胡笑尘 huxiaochen@hmeg.net
 * @version 2014-11-11 上午09:26:24
 */
public class CodeHelper {
	
	/**
	 * 判断参数不是一个空引用
	 * @Title isNotNull 
	 * @Description 当参数不为NULL时,返回TRUE
	 * @param arg
	 * @return
	 */
	public static boolean isNotNull(Object arg) {
		return null != arg;
	}
	
	/**
	 * 判断参数是否空引用
	 * @Title isNull 
	 * @Description 参数为空引用时,返回TRUE
	 * @param arg
	 * @return
	 */
	public static boolean isNull(Object arg){
		return null == arg;
	}
	
	/**
	 * 判断参数是否为空字符串
	 * @Title isEmpty 
	 * @Description 字符串本身为NULL时,或字符串长度为0时,返回TRUE
	 * @param arg
	 * @return
	 */
	public static boolean isEmpty(String arg){
		return null == arg || arg.length() == 0;
	}
	
	public static boolean isNotEmpty(String arg) {
		return null != arg && arg.length() > 0;
	}
	
	public static boolean isNotEmpty(Map<? extends Object, ? extends Object> param) {
		return CodeHelper.isNotNull(param) && !param.isEmpty();
	}
	
	/**
	 * 判断集合是否为空
	 * @Title isEmpty 
	 * @Description 当集合本身为NULL或集合中包含元素时返回TRUE
	 * @param arg
	 * @return
	 */
	public static boolean isEmpty(Collection<?> arg){
		return null == arg || arg.isEmpty();
	}
	
	/**
	 * 判断集合不为空
	 * @Title isNotEmpty 
	 * @Description 集合本身不为NULL且集合中包含元素时返回TRUE
	 * @param arg
	 * @return
	 */
	public static boolean isNotEmpty(Collection<?> arg){
		return null != arg && !arg.isEmpty();
	}
	
	/**
	 * 获取集合的第一个元素
	 * @Title first 
	 * @Description 集合本身为NULL或集合中不包含元素时都返回NULL
	 * @param <T>
	 * @param arg
	 * @return 集合的第一个元素
	 */
	public static <T> T first(Collection<T> arg){
		if(null == arg || arg.isEmpty()){
			return null;
		} else {
			Iterator<T> iterator = arg.iterator();
			return iterator.next();
		}
	}
	
	/**
	 * 根据身份证号码获取出生日期
	 * @param idcard
	 * @return
	 */
	public static String idCardBirthday(String idcard)
	{
        String birthday = "";
		if(idcard.length() == 15)
        {
        	birthday = idcard.substring(6, 12); 
        	birthday = "19" + birthday;
        }
		else if(idcard.length() == 18)
        {
        	birthday = idcard.substring(6, 14); 
        }
		
		return birthday;
	}
	
	/**
	 * 根据身份证号码获取性别
	 * @param idcard
	 * @return
	 */
	public static BigDecimal idCardSex(String idcard)
	{
        String sex = "";
		if(idcard.length() == 15)
        {
        	sex = idcard.substring(15, 16); 
        }
		else if(idcard.length() == 18)
        {
			sex = idcard.substring(16, 17); 
        }
		
		return Integer.parseInt(sex) % 2 == 0  ? new BigDecimal(2) : new BigDecimal(1) ;
	}
	
    /**
	 * 返回 8位时间戳
	 * @return
	 */
	public static String todayChar8(){
		return DateFormatUtils.format(new Date(), "yyyyMMdd");
	}
	
    /**
	 * 返回 14位时间戳
	 * @return
	 */
	public static String todayChar14(){
		return DateFormatUtils.format(new Date(), "yyyyMMddHHmmss");
	}
}
