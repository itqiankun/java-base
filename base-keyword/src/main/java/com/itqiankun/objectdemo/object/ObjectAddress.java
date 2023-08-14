package com.itqiankun.objectdemo.object;

/**
 * @author: ma_qiankun
 * @date: 2023/8/12
 **/
public class ObjectAddress {
	public Integer num = 0;
	public static void main(String[] args) {
		final ObjectAddress objectAddress = new ObjectAddress();
//		objectAddress = new ObjectAddress();  这样不允许
		objectAddress.num++;  // 这样运行
	}
}
