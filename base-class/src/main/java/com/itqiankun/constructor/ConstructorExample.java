package com.itqiankun.constructor;

import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @author: ma_qiankun
 * @date: 2023/8/31
 **/
public class ConstructorExample {

	@Test
	public void it_qk(){
		Class<?> clazz = MyClass.class;
		try {
			// 获取无参构造函数
			Constructor<?> constructor  = clazz.getConstructor();
			// 获取有参构造函数
			Constructor<?> constructorArg = clazz.getConstructor(String.class, int.class);

			// 创建对象实例
			Object instanceArg = constructorArg.newInstance("example", 123);
			Object instance = constructor.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}