package net.huimin.common.helper;

import java.security.MessageDigest;

/**
 * 生成32位md5码
 * @author chenyiyong
 *
 */
public class MD5Util {
		/***
		 * MD5加码 生成32位md5码
		 */
		public static String string2MD5(String inStr){
			MessageDigest md5 = null;
			try{
				md5 = MessageDigest.getInstance("MD5");
			}catch (Exception e){
				System.out.println(e.toString());
				e.printStackTrace();
				return "";
			}
			char[] charArray = inStr.toCharArray();
			byte[] byteArray = new byte[charArray.length];
	
			for (int i = 0; i < charArray.length; i++)
				byteArray[i] = (byte) charArray[i];
			byte[] md5Bytes = md5.digest(byteArray);
			StringBuffer hexValue = new StringBuffer();
			for (int i = 0; i < md5Bytes.length; i++){
				int val = ((int) md5Bytes[i]) & 0xff;
				if (val < 16)
					hexValue.append("0");
				hexValue.append(Integer.toHexString(val));
			}
			return hexValue.toString();
	
		}
		
		public static void main(String[] args) {
//			//3354045a397621cd92406f1f98cde29
//			String aa=MD5Util.string2MD5("adminyk");
//			System.out.println(aa);
			String password="2";//要加密或者解密的字符串  
	        char[]array=password.toCharArray();//获取字符数组  
	        for(int i=0;i<array.length;i++)//遍历字符数组  
	        {  
	            array[i]=(char)(array[i] ^ 20140908);//对每个数组元素进行异或运算，异或的值可以自己选择  
	        }  
	        System.out.println("加密或者解密结果如下：");  
	        System.out.println(new String(array));//输出加密或者解密结果  
		}

}
