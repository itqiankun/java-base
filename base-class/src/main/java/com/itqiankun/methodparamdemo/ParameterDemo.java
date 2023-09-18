package com.itqiankun.methodparamdemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

/**
 * @author: ma_qiankun
 * @date: 2023/8/15
 **/
@Slf4j
public class ParameterDemo {


	public void myMethod(String name, int age) {
		// 方法体
	}

	public List<Integer> myMethodReturnList(String name, int age) {
		// 方法体
		return null;
	}

	@Test
	public void it_qk() throws Exception {
		Method method = ParameterDemo.class.getMethod("myMethod", String.class, int.class);
		Parameter[] parameters = method.getParameters();

		for (Parameter parameter : parameters) {
			String paramName = parameter.getName();
			Class<?> paramType = parameter.getType();
			int modifiers = parameter.getModifiers();

			System.out.println("Parameter name: " + paramName);
			System.out.println("Parameter type: " + paramType);
			System.out.println("Modifiers: " + modifiers);
		}

	}

	@Test
	public void it_qk_return_list() throws Exception {
		Method method = ParameterDemo.class.getMethod("myMethodReturnList", String.class, int.class);
		Class<?> returnType = method.getReturnType();
		System.out.println(returnType);
	}

}
