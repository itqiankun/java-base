package com.itqiankun.fielddemo;

import com.itqiankun.AnnotatedElement.Person;
import com.itqiankun.AnnotatedElement.Sub;
import com.itqiankun.common.MyClass;
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


	@Test
	public  void it_qk_super_class_field_class() throws Exception {
		Class<MyClass> clazz = MyClass.class;

		// 获取指定名称的字段
		Field publicField = clazz.getField("publicField");
		Field privateField = clazz.getDeclaredField("privateField");

		// 设置字段的值
		MyClass instance = new MyClass();
		publicField.set(instance, 10);
		privateField.setAccessible(true); // 私有字段需要设置可访问性
		privateField.set(instance, "Hello");

		// 获取字段的值
		int value1 = (int) publicField.get(instance);
		String value2 = (String) privateField.get(instance);

		System.out.println("publicField: " + value1);
		System.out.println("privateField: " + value2);
		Class<? extends String> aClass = value2.getClass(); // 这里通过field又获取了Class
		System.out.println(aClass);
	}

	@Test
	public  void it_qk_field_set_value() throws Exception {
		Class<MyClass> clazz = MyClass.class;
		Field publicField = clazz.getField("publicField");
		Field privateField = clazz.getDeclaredField("privateField");
		MyClass instance = new MyClass();

		// 共有字段获取值然后设置字段的值
		System.out.println((int) publicField.get(instance));
		publicField.set(instance, 10);
		System.out.println((int) publicField.get(instance));

		// 私有字段获取值和set值必须先setAccessible(true)
		privateField.setAccessible(true);
		System.out.println((String) privateField.get(instance));
		privateField.set(instance, "Hello");
		System.out.println((String) privateField.get(instance));

	}


}
