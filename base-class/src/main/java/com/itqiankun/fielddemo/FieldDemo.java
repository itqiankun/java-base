package com.itqiankun.fielddemo;

import com.itqiankun.extendsdemo.Person;
import com.itqiankun.extendsdemo.Sub;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author: ma_qiankun
 * @date: 2023/8/15
 **/
@Slf4j
public class FieldDemo {

	@Test
	public  void it_qk() {
		Class<Sub> subClass = Sub.class;
		Field[] declaredFields = subClass.getDeclaredFields();
		for (int i = 0; i < declaredFields.length; i++) {
			Field declaredField = declaredFields[i];
			System.out.println(declaredField.getName());
		}
	}

	@Test
	public  void it_qk_field_get_value() throws IllegalAccessException {
		Sub sub = new Sub();
		sub.setAge(100);
		sub.setName("name");
		sub.setPerson(new Person());
		Class<? extends Sub> aClass = sub.getClass();
		Field[] declaredFields = aClass.getDeclaredFields();
		for (int i = 0; i < declaredFields.length; i++) {
			Field declaredField = declaredFields[i];
			declaredField.setAccessible(true);
			System.out.println(declaredField.get(sub));
		}
	}


	@Test
	public  void it_qk_super_class_field() {
		Class<Sub> subClass = Sub.class;
		Field[] declaredFields = subClass.getSuperclass().getDeclaredFields();
		for (int i = 0; i < declaredFields.length; i++) {
			Field declaredField = declaredFields[i];
			System.out.println(declaredField.getName());
		}
	}


}
