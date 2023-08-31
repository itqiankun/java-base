package com.itqiankun.constructor;

/**
 * @author: ma_qiankun
 * @date: 2023/8/31
 **/
public class MyClass  {

	public MyClass() {
		System.out.println("no-args constructor");
	}

	public MyClass(String name, int value) {
		System.out.println("constructor with args: " + name + ", " + value);
	}

}