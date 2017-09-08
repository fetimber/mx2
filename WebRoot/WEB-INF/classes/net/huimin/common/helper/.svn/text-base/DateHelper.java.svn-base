package net.huimin.common.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {
	
	public static boolean compareSystemTime(Date time) {
		return time.getTime() > System.currentTimeMillis();
	}
	
	private static SimpleDateFormat sdf = new SimpleDateFormat();
	
	private static SimpleDateFormat df_date = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * 将日期转换成 1900-01-01 格式 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String dateToString(Date date)
	{
		String format = "yyyy-MM-dd";
		try
		{
			if (null != date && null != format && !"".equals(format))
			{
				sdf.applyPattern(format);
				return sdf.format(date);
			}
		}
		catch (Exception e)
		{
			return "";
		}
		return "";
	}
	
	/** 比较两个字符串的时间类型值
	 * time1 > time2  返回  false
	 * time1 < time2  返回  true
	 * @param time1
	 * @param time2
	 * @return
	 */
	public static int compareTime(String time1,String time2) 
	{
		 int rs = -1; 
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");    
		 Date date1;
		 Date date2;
		 try {
			date1 = format.parse(time1);
			date2 = format.parse(time2);
			if(date2.getTime() > date1.getTime())
		    {
				rs = 1;
		    }
		} catch (ParseException e) 
		{ }
		return rs;
	 }
	
    /**
     * 获取传入时间的
     * @param date
     * @return
     */
	public static String retrunCurrent(Date date)
	{		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return df_date.format(calendar.getTime());
	}
	
	//根据日期 获取向后某一天的日期
	public static Date  returnAfterOfBeforeDate(Date timeDate,  int days) {
	    Calendar  cal = Calendar.getInstance(); 
	    cal.setTime(timeDate); 
	    cal.add(Calendar.DATE, + days);
	    return cal.getTime();   
	} 
	
}
