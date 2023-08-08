package com.itqiankun.serializable;

import java.io.Serializable;

/**
 * @author: ma_qiankun
 * @website: itqiankun.com
 * @date: 2023/6/22
 **/
public class ItQKClass implements Serializable {
	private static final long serialVersionUID = 1L; // 序列化版本号

	private String name;
	private int age;

	public ItQKClass(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return "Name: " + name + ", Age: " + age;
	}
}
