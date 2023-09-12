package com.itqiankun;

import com.itqiankun.common.CustomFieldAnnotation;
import com.itqiankun.common.MyFieldClass;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author: ma_qiankun
 * @date: 2023/9/8
 **/
public class AnnotationGetExample {
	public static void main(String[] args) throws NoSuchFieldException {
		Class<MyFieldClass> clazz = MyFieldClass.class;
		Field field = clazz.getDeclaredField("myField");
		Annotation[] annotations = field.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println("annotation result : "+annotation);
		}
		CustomFieldAnnotation myAnnotation = field.getAnnotation(CustomFieldAnnotation.class);
		if (myAnnotation != null) {
			System.out.println("value: " + myAnnotation.value());
			System.out.println("age: " + myAnnotation.age());
		}
	}
}
