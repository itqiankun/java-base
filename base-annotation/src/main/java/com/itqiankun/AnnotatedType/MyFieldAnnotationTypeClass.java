package com.itqiankun.AnnotatedType;

import com.itqiankun.common.CustomTypeUseAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;

/**
 * @author: ma_qiankun
 * @date: 2023/9/8
 **/
public class MyFieldAnnotationTypeClass {

	private String @CustomTypeUseAnnotation [] number;

	public static void main(String[] args) throws NoSuchFieldException {
		Class<MyFieldAnnotationTypeClass> myFieldAnnotationTypeClassClass = MyFieldAnnotationTypeClass.class;
		Field numberField = myFieldAnnotationTypeClassClass.getDeclaredField("number");
		AnnotatedType annotatedType = numberField.getAnnotatedType();
		Annotation[] annotations = annotatedType.getAnnotations();
		System.out.println(annotations);
		for (int i = 0; i < annotations.length; i++) {
			Annotation annotation = annotations[i];
			System.out.println(annotation);
		}
	}

}
