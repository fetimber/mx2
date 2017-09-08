package net.huimin.common.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间格式化
 * @author HuXiaoChen
 *
 */
public class DateFormatter {
	
	public final static String NORMAL = "yyyy-MM-dd HH:mm:ss";
	public final static String ANALYSIS_DATE = "yyyy-MM-dd";
	public final static String ANALYSIS_DAY = "MM-dd";
	
	/**
	 * 格式化当前时间<br/>
	 * yyyy-MM-dd HH:mm:ss
	 * @return 当前时间的格式化结果
	 */
	public static String now(){
		return new SimpleDateFormat(NORMAL).format(new Date());
	}
	
	/**
	 * 把指定的字符串格式成时间类型数据
	 * <b>时间格式错误时，返回NULL，调用方法时注意判断</b>
	 * @param partten 时间格式
	 * @param time 表示时间的字符串
	 * @return 时间类型数据
	 */
	public static Date parse(String partten,String time){
		Date result = null;
		try {
			result = new SimpleDateFormat(partten).parse(time);
		} catch (ParseException e) {
			/**忽略此异常**/
		}
		return result;
	}
	
	/**
	 * 把时间格式化成指定格式的字符串
	 * <br />
	 * <b>时间格式错误时，此方法会抛出异常:IllegalArgumentException</b>
	 * @param partten 时间格式
	 * @param time 时间参数
	 * @return 指定格式的时间字符串
	 */
	public static String format(String partten, Date time){
		return new SimpleDateFormat(partten).format(time);
	}
	/**
	 * 获得本周一的日期
	 * @return
	 */
	public static Date getThisMonday(){
		Calendar calendar = Calendar.getInstance();
		int dayOfWeek=calendar.get(Calendar.DAY_OF_WEEK)-1;
		int offset = 7-dayOfWeek;
		calendar.add(Calendar.DATE, offset-6);
		Date date = calendar.getTime();
		date.setHours(0);
		date.setMinutes(0);
		date.setSeconds(0);
		return date;
	}
	
	/**
	 * 获得上周周一的日期
	 * @return
	 */
	public static Date getLastMonday(){
		Calendar calendar = Calendar.getInstance();
		int dayOfWeek=calendar.get(Calendar.DAY_OF_WEEK)-1;
		int offset = 1-dayOfWeek;
		calendar.add(Calendar.DATE, offset-7);
		calendar.getTime().setHours(0);
		calendar.getTime().setMinutes(0);
		Date date = calendar.getTime();
		date.setHours(0);
		date.setMinutes(0);
		date.setSeconds(0);
		return date;
	}
	/**
	 * 获得上周周日的日期
	 * @return
	 */
	public static Date getLastSunday(){
		Calendar calendar = Calendar.getInstance();
		int dayOfWeek=calendar.get(Calendar.DAY_OF_WEEK)-1;
		int offset = 7-dayOfWeek;
		calendar.add(Calendar.DATE, offset-7);
		Date date = calendar.getTime();
		date.setHours(23);
		date.setMinutes(59);
		date.setSeconds(59);
		return date;
	}
	
	/**
	 * 格式化日期，保留（yyyy-MM-dd）
	 * 
	 * @Title: formatDate
	 * @Description: 
	 * @param date
	 * @return String  
	 */
	public static String formatDate(Date date){
		return new SimpleDateFormat(ANALYSIS_DATE).format(date);
	}
	
	/**
	 * 格式化日期，保留（MM-dd）
	 * 
	 * @Title: formatDate
	 * @Description: 
	 * @param date
	 * @return String  
	 */
	public static String formatDateForMd(Date date){
		return new SimpleDateFormat(ANALYSIS_DAY).format(date);
	}
}
