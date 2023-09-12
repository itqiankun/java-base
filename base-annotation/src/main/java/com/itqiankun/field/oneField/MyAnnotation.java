package com.itqiankun.field.oneField;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author: ma_qiankun
 * @date: 2023/9/7
 **/
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	String value();

}
