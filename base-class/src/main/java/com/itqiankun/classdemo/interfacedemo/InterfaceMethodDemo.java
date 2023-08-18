package com.itqiankun.classdemo.interfacedemo;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ma_qiankun
 * @date: 2023/8/11
 **/
public class InterfaceMethodDemo {

	@Test
	public  void it_qk_method_name() {
		Class<InterfaceClass> interfaceClassClass = InterfaceClass.class;
		Method[] methods = interfaceClassClass.getMethods();
		List<Method> list = Arrays.asList(methods);
		for (int i = 0; i < list.size(); i++) {
			Method method = list.get(i);
			System.out.println(method.getName());
		}

	}


	@Test
	public  void it_qk_class_name() {
		Class<InterfaceClass> interfaceClassClass = InterfaceClass.class;
		String name = interfaceClassClass.getName();
		System.out.println(name);
	}

	@Test
	public  void it_qk_class_nameByForName() throws ClassNotFoundException {
		Class<?> aClass = Class.forName("com.itqiankun.classdemo.interfacedemo.InterfaceClass");
		String name = aClass.getName();
		System.out.println(name);
	}
}
