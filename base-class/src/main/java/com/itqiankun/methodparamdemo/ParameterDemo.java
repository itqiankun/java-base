package com.itqiankun.methodparamdemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author: ma_qiankun
 * @date: 2023/8/15
 **/
@Slf4j
public class ParameterDemo {

	static {
		try {
			Class<?> paramClass = Parameter.class;
			Method getName = paramClass.getMethod("getName");
			Method getParameters = Method.class.getMethod("getParameters");
		} catch (Exception e) {
			// ignore

		}
	}

	public void myMethod(String name, int age) {
		// 方法体
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

}
