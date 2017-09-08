package net.huimin.common.helper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class StrHelper {
	public static List<BigDecimal> strToArray(String str){
		List<BigDecimal> result = new ArrayList<BigDecimal>();
		if(CodeHelper.isNotEmpty(str)){
			String[] ary = str.split(",");
			for (String s : ary) {
				result.add(new BigDecimal(s));
			}
		}
		return result;
	}
}
