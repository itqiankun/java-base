package com.itqiankun.classdemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author: ma_qiankun
 * @date: 2023/8/17
 **/
@Slf4j
public class ClassIsPrimitiveDemo {
	int a = 3;
	Integer b = 3;

	@Test
	public void it_qk_isAssignableFrom() throws NoSuchFieldException {
		Field fielda = ClassIsPrimitiveDemo.class.getDeclaredField("a");
		System.out.println(fielda.getType().isPrimitive()); // true

		Field fieldb = ClassIsPrimitiveDemo.class.getDeclaredField("b");
		System.out.println(fieldb.getType().isPrimitive()); // false
	}
}
