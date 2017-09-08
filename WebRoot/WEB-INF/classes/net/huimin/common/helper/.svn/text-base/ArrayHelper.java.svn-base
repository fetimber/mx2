package net.huimin.common.helper;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组和集合的公用方法
 * @author HuXiaoChen
 *
 */
public class ArrayHelper {
	
	/**
	 * 使用字符串生成Integer数组
	 * @param str 字符串,使用","分割
	 * @return 数组
	 */
	public static Integer[] createArrayFromString(String str){
		String[] strs = str.split(",");
		Integer[] result = new Integer[strs.length];
		for (int i = 0; i < strs.length; i++) {
			result[i] = Integer.valueOf(strs[i]);
		}
		return result;
	}
	
	/**
	 * 使用字符串生成Integer集合
	 * @param str 字符串,使用","分割
	 * @return 集合
	 */
	public static List<Integer> createListFromString(String str){
		String[] strs = str.split(",");
		List<Integer> rslt = new ArrayList<Integer>();
		for (int i = 0; i < strs.length; i++) {
			rslt.add(Integer.valueOf(strs[i]));
		}
		return rslt;
	}
}
