package com.itqiankun;

/**
 * @author: ma_qiankun
 * @date: 2023/9/7
 **/
import com.itqiankun.common.CustomMethodAnnotation;
import com.itqiankun.common.CustomTypeAnnotation;
import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

@Slf4j
@CustomTypeAnnotation("type")
public class AnnotatedElementDemo {

	@CustomMethodAnnotation("method")
	public static void main(String[] args)  {
		AnnotatedElement element = AnnotatedElementDemo.class;

		Annotation[] annotations = element.getAnnotations();
		for (Annotation annotation : annotations) {
			log.info("Annotation: {}", annotation);
		}

		if (element.isAnnotationPresent(CustomTypeAnnotation.class)) {
			CustomTypeAnnotation customTypeAnnotation = element.getAnnotation(CustomTypeAnnotation.class);
			String value = customTypeAnnotation.value();
			log.info("CustomAnnotation value: {}", value);
		}

		Method[] methods = AnnotatedElementDemo.class.getMethods();
		for (int i = 0; i < methods.length; i++) {
			AnnotatedElement annotatedElement = methods[i];
			Annotation[] method = annotatedElement.getAnnotations();
			for (Annotation annotation : method) {
				log.info("Annotation: {}", annotation);
			}
		}
	}

}

