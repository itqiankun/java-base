package com.itqiankun.field.oneField;

import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

/**
 * @author: ma_qiankun
 * @date: 2023/9/7
 **/
@MyAnnotation("Hello")
@Slf4j
public class OneFieldAnnotationDemo {
	public static void main(String[] args) {
		AnnotatedElement element = OneFieldAnnotationDemo.class;
		Annotation[] annotations = element.getAnnotations();
		for (Annotation annotation : annotations) {
			log.info("Annotation: {}", annotation);
		}
	}
}
