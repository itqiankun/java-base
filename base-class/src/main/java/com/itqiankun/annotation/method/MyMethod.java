package com.itqiankun.annotation.method;

import com.itqiankun.annotation.MethodAnnotation;

/**
 * @author: ma_qiankun
 * @date: 2023/8/22
 **/
public class MyMethod {
	@MethodAnnotation(value = "Hello", count = 5)
	public void myMethod() {
		// 方法体
	}
}

