package com.itqiankun.md5;

import java.security.MessageDigest;

/**
 * @author: ma_qiankun
 * @date: 2023/10/13
 **/
public class Md5Demo {
	public static void main(String[] args) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update("hello".getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		byte[] byteArray = messageDigest.digest();
		StringBuffer md5StrBuff = new StringBuffer();
		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}
		//32位，小写
		String md532Lower = md5StrBuff.toString();
		System.out.println(md532Lower);
	}
}
