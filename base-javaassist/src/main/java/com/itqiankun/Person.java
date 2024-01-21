package com.itqiankun;

import java.io.Serializable;

/**
 * author: ma_qiankun
 * date:  2023/12/31
 **/
public class Person implements Serializable {
	public static void main(String[] args) {
		System.out.println("hello");
		Person person = new Person();
		person.say();
	}

	public void say(){
		System.out.println("say()");
	}
}
