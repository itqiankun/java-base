package com.itqiankun.ComparatorandComparable.different;

import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: ma_qiankun
 * @date: 2023/10/16
 **/
@Data
public class StudentTwo {

	Integer id;

	String name;

	public StudentTwo(){}


	@Test
	public void it_qk_sort_id_asc(){
		List<StudentTwo> list = new ArrayList<>();
		StudentTwo student = new StudentTwo();
		student.setId(10);
		student.setName("name");
		StudentTwo student1 = new StudentTwo();
		student1.setId(4);
		student1.setName("tom");
		StudentTwo student2 = new StudentTwo();
		student2.setId(30);
		student2.setName("jack");
		StudentTwo student3 = new StudentTwo();
		student3.setId(6);
		student3.setName("ma");
		list.add(student3);
		list.add(student2);
		list.add(student1);
		list.add(student);
		Collections.sort(list, new Comparator<StudentTwo>() {
			@Override
			public int compare(StudentTwo o1, StudentTwo o2) {
				return o1.id-o2.id;
			}
		});
		System.out.println(list);
	}

	@Test
	public void it_qk_sort_id_desc(){
		List<StudentTwo> list = new ArrayList<>();
		StudentTwo student = new StudentTwo();
		student.setId(10);
		student.setName("name");
		StudentTwo student1 = new StudentTwo();
		student1.setId(4);
		student1.setName("tom");
		StudentTwo student2 = new StudentTwo();
		student2.setId(30);
		student2.setName("jack");
		StudentTwo student3 = new StudentTwo();
		student3.setId(6);
		student3.setName("ma");
		list.add(student3);
		list.add(student2);
		list.add(student1);
		list.add(student);
		Collections.sort(list, new Comparator<StudentTwo>() {
			@Override
			public int compare(StudentTwo o1, StudentTwo o2) {
				return o2.id-o1.id;
			}
		});
		System.out.println(list);
	}


	@Test
	public void it_qk_sort_name(){
		List<StudentTwo> list = new ArrayList<>();
		StudentTwo student = new StudentTwo();
		student.setId(10);
		student.setName("name");
		StudentTwo student1 = new StudentTwo();
		student1.setId(4);
		student1.setName("tom");
		StudentTwo student2 = new StudentTwo();
		student2.setId(30);
		student2.setName("jack");
		StudentTwo student3 = new StudentTwo();
		student3.setId(6);
		student3.setName("ma");
		list.add(student3);
		list.add(student2);
		list.add(student1);
		list.add(student);
		Collections.sort(list, new Comparator<StudentTwo>() {
			@Override
			public int compare(StudentTwo o1, StudentTwo o2) {
				return o1.name.length()-o2.name.length();
			}
		});
		System.out.println(list);
	}

}
