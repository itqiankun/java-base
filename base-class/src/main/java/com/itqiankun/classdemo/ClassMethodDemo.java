package com.itqiankun.classdemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ma_qiankun
 * @date: 2023/8/17
 **/
@Slf4j
public class ClassMethodDemo {


	@Test
	public void it_qk_isAssignableFrom(){
		// 判断String是否可以赋值给Object
		boolean isAssignable = Object.class.isAssignableFrom(String.class);
		log.info("String is assignable to Object:{} " , isAssignable);

		// 判断Integer是否可以赋值给Number
		isAssignable = Number.class.isAssignableFrom(Integer.class);
		log.info("Integer is assignable to Number:{} " , isAssignable);

		// 判断ArrayList是否可以赋值给List
		isAssignable = List.class.isAssignableFrom(ArrayList.class);
		log.info("ArrayList is assignable to List:{} " , isAssignable);
	}
}
