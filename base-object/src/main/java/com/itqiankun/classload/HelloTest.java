package com.itqiankun.classload;

import java.net.URL;

/**
 * @author: ma_qiankun
 * @date: 2023/7/13
 **/
public class HelloTest {
	public static void main(String[] args) {
		Class<HelloTest> helloTestClass = HelloTest.class;
		ClassLoader classLoader = helloTestClass.getClassLoader();
		URL resource = classLoader.getResource("hello.txt");
		System.out.println(resource);
	}
}
