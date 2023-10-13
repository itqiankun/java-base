package com.itqiankun.consistency;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;


/**
 * @author: ma_qiankun
 * @date: 2023/10/13
 **/
public class KetamaHash {

	public long hashKey(String key) {
		byte[] digest = computeMd5(key);
		return ((long) (digest[3] & 0xFF) << 24)
				| ((long) (digest[2] & 0xFF) << 16)
				| ((long) (digest[1] & 0xFF) << 8)
				| (digest[0] & 0xFF);
	}

	private byte[] computeMd5(String key) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(key.getBytes());
			return md.digest();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("MD5 algorithm not found.");
		}
	}


	@Test
	public void it_qk1(){
		System.out.println(hashKey("192.168.0.1:111"));
		System.out.println(hashKey("192.168.0.3:111"));
		System.out.println(hashKey("192.168.0.2:111"));
	}




	@Test
	public void it_qk_xuni(){
		// 排序最终的集合方便观看区间
		List<Long> sorList = Lists.newArrayList();
		List<String> strings = Lists.newArrayList();
		strings.add("192.168.0.1:111");
		strings.add("192.168.0.2:111");
		strings.add("192.168.0.3:111");
		for (String s : strings) {
			for (int i = 0; i < 10; i++) {
				String vnNode = s + "&&VN" + i;
				sorList.add(hashKey(vnNode));
			}
		}

		Object[] array = sorList.toArray();
		Arrays.sort(array);
		for (int i = 0; i < array.length; i++) {
			Long l =(Long) array[i];
			System.out.println(l);
		}
	}



}

