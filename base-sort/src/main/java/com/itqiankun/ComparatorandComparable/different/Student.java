package com.itqiankun.ComparatorandComparable.different;

import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: ma_qiankun
 * @date: 2023/10/16
 **/
@Data
public class Student implements  Comparable<Student>  {

	Integer id;

	String name; // 名字

	public Student(){}

	@Override
	public int compareTo(Student o) {
		return this.id - o.id;
	}

	@Test
	public void it_qk(){
		List<Student> list = new ArrayList<>();
		Student student = new Student();
		student.setId(10);
		student.setName("name");
		Student student1 = new Student();
		student1.setId(4);
		student1.setName("tom");
		Student student2 = new Student();
		student2.setId(30);
		student2.setName("jack");
		Student student3 = new Student();
		student3.setId(6);
		student3.setName("ma");
		list.add(student3);
		list.add(student2);
		list.add(student1);
		list.add(student);
		Collections.sort(list);
		System.out.println(list);
	}



}


