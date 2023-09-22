package com.itqiankun.fielddemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author: ma_qiankun
 * @date: 2023/8/15
 **/
@Slf4j
public class FinalFieldDemo {

	private final String string = "hello";

	@Test
	public  void it_qk_field_get_value() throws IllegalAccessException {
		FinalFieldDemo finalFieldDemo = new FinalFieldDemo();
		Field[] declaredFields = FinalFieldDemo.class.getDeclaredFields();
		for (int i = 0; i < declaredFields.length; i++) {
			Field declaredField = declaredFields[i];
			if(declaredField.getName().contains("string")){
				System.out.println(declaredField.get(finalFieldDemo));
				declaredField.setAccessible(true);
				declaredField.set(finalFieldDemo, "cc");
				System.out.println(declaredField.get(finalFieldDemo));
			}

		}
	}



}
