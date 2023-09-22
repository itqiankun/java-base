package com.itqiankun.classdemo;

import java.lang.reflect.Constructor;

/**
 * @author: ma_qiankun
 * @date: 2023/9/19
 **/
public class ClassDeclaredConstructorDemo {

	public void say(){
		System.out.println("hello");
	}

	public static void main(String[] args) throws Exception {
		Constructor<ClassDeclaredConstructorDemo> declaredConstructor = ClassDeclaredConstructorDemo.class.getDeclaredConstructor();
		ClassDeclaredConstructorDemo classDeclaredConstructorDemo = declaredConstructor.newInstance();
		classDeclaredConstructorDemo.say();
	}
}
