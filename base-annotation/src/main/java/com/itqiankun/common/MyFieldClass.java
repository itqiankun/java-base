package com.itqiankun.common;

import com.itqiankun.field.oneField.MyAnnotation;

/**
 * @author: ma_qiankun
 * @date: 2023/9/8
 **/
public class MyFieldClass {
	@CustomFieldAnnotation(value = "Hello", age=20)
	private String myField;
}
