package com.itqiankun.classdemo;

/**
 * @author: ma_qiankun
 * @date: 2023/9/21
 **/
public final class FinalClassDemo {
	public static void main(String[] args) {
		Class<FinalClassDemo> finalClassDemoClass = FinalClassDemo.class;
		System.out.println(finalClassDemoClass.getName());
	}
}
