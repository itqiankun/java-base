package com.itqiankun.methodparamdemo;

import java.lang.reflect.Method;

/**
 * @author: ma_qiankun
 * @date: 2023/9/25
 **/
public class MethodGetClass {

	public void it_qk(){

	}

	public static void main(String[] args) {
		Method[] methods = MethodGetClass.class.getMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			if (method.getName().contains("it_qk")) {
				System.out.println(method.getClass());
				System.out.println(method.getDeclaringClass());
			}
		}
	}
}
