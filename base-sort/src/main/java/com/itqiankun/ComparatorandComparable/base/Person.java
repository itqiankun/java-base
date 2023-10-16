package com.itqiankun.ComparatorandComparable.base;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: ma_qiankun
 * @date: 2023/10/16
 **/
public class Person implements Comparable<Person> {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public int compareTo(Person other) {
		// 则按照年龄比较
		return this.age - other.age;
	}

	public static void main(String[] args) {
		Person alice = new Person("Alice", 25);
		Person alace = new Person("Alace", 10);
		Person acace = new Person("Acace", 30);
		Person bob = new Person("Bob", 30);
		Person charlie = new Person("Charlie", 20);
		Person david = new Person("David", 25);
		List<Person> list = new ArrayList<>();
		list.add(alice);
		list.add(alace);
		list.add(acace);
		list.add(bob);
		list.add(charlie);
		list.add(david);
		Collections.sort(list);
		System.out.println(JSONObject.toJSON(list));
	}
}