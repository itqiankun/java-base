package com.itqiankun.annotation.method;

import com.itqiankun.annotation.MethodAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author: ma_qiankun
 * @date: 2023/8/22
 **/
@Slf4j
public class AnnotationMethodDemo {

	@Test
	public void it_qk_demo() throws NoSuchMethodException {
		MyMethod obj = new MyMethod();
		Method method = obj.getClass().getMethod("myMethod");
		MethodAnnotation annotation = method.getAnnotation(MethodAnnotation.class);

		String value = annotation.value();
		int count = annotation.count();

		System.out.println("Value: " + value);
		System.out.println("Count: " + count);
	}
}
