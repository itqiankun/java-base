package com.itqiankun.consistency;

import java.util.Random;

/**
 * @author: ma_qiankun
 * @date: 2023/10/13
 **/
public class IPAddressGenerate {

	public String[] getIPAddress(int num) {
		String[] res = new String[num];
		Random random = new Random();
		for (int i = 0; i < num; i++) {
			res[i] = String.valueOf(random.nextInt(256)) + "." + String.valueOf(random.nextInt(256)) + "."
					+ String.valueOf(random.nextInt(256)) + "." + String.valueOf(random.nextInt(256)) + ":"
					+ String.valueOf(random.nextInt(9999));


		}
		return res;
	}
}
