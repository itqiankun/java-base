package com.itqiankun.common;

import org.junit.Test;

/**
 * @author: ma_qiankun
 * @date: 2023/9/21
 **/
public class Person {
	public Integer name;
	public String string ="str";

	private class PersonInner {
		public Integer age;
		public void sayString(){
			System.out.println(string);
		}
	}

	@Test
	public void it_qk_inner() {
		PersonInner personInner = new PersonInner();
		personInner.sayString();
	}
}
