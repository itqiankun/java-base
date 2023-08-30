package com.itqiankun.annotation;

/**
 * @author: ma_qiankun
 * @date: 2023/8/22
 **/
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MethodAnnotation {
	String value();
	int count() default 1;
}
