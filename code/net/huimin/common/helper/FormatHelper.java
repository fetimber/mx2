package net.huimin.common.helper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class FormatHelper {
	public static String number(BigDecimal param){
		if(CodeHelper.isNull(param)){
			return "0";
		} else {
			NumberFormat format = NumberFormat.getInstance();
			format.setRoundingMode(RoundingMode.HALF_UP);
			format.setMaximumFractionDigits(2);
			return format.format(param);
		}
	}
	
	/**
	 * 将BigDeimal的数字转换成
	 * @param b
	 * @return
	 */
	public static String removeTailZero(BigDecimal b) {
		 String s = b.toString();
		 int i, len = s.length();
		 for (i = 0; i < len; i++)
		   if (s.charAt(len - 1 - i) != '0')
		   break;
		 if (s.charAt(len - i - 1) == '.')
		   return s.substring(0, len - i - 1);
		 return s.substring(0, len - i);
	  }
}
