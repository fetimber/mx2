package net.huimin.common.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Sequence {

	private static DateFormat FORMATOR = new SimpleDateFormat("yyyyMMddHHmmss");

	public static String createContractNumber() {
		StringBuffer buffer = new StringBuffer();
		String random = String.valueOf(Math.abs(new Random().nextLong()));
		buffer.append(FORMATOR.format(new Date())).append(
				random.length() > 5 ? random.substring(0, 5) : random);
		return buffer.toString();
	}

	public static String transactionSerialNumber() {
		return Sequence.createContractNumber();
	}
	
	/**
	  * 生成短信验证码
	  * @return 短信验证码
	  */
	public static String createPhoneValiedateCode() {
		String retStr = "";
		String strTable = "1234567890abcdefghijkmnpqrstuvwxyz";
		int len = strTable.length();
		boolean bDone = true;
		do {
			retStr = "";
			int count = 0;
			for (int i = 0; i < 6; i++) {
				double dblR = Math.random() * len;
				int intR = (int) Math.floor(dblR);
				char c = strTable.charAt(intR);
				if (('0' <= c) && (c <= '9')) {
					count++;
				}
				retStr += strTable.charAt(intR);
			}
			if (count >= 2) {
				bDone = false;
			}
		} while (bDone);

		
		return retStr;
	}

}
