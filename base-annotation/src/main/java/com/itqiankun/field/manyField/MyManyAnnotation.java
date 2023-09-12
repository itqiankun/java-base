package com.itqiankun.field.manyField;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author: ma_qiankun
 * @date: 2023/9/7
 **/
@Retention(RetentionPolicy.RUNTIME)
public @interface MyManyAnnotation {
	String value();
	int age();
	double money();

}
