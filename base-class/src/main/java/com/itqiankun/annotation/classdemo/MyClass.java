package com.itqiankun.annotation.classdemo;

import com.itqiankun.annotation.ClassAnnotation;
import com.itqiankun.annotation.MethodAnnotation;

/**
 * @author: ma_qiankun
 * @date: 2023/8/22
 **/
@ClassAnnotation(value = "Hello", count = 5)
public class MyClass {
	@MethodAnnotation(value = "Hello", count = 5)
	public void myMethod() {
		// 方法体
	}
}

