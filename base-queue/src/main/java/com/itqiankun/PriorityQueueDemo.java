package com.itqiankun;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: ma_qiankun
 * @date: 2023/10/13
 **/
@Slf4j
public class PriorityQueueDemo {
	@Test
	public void it_qk_(){
		PriorityQueue<String> strings = new PriorityQueue<>();
		strings.add("hello");

	}


	@Test
	public void it_qk_sort(){
		PriorityQueue<Person> pq = new PriorityQueue<>(new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getAge() - o2.getAge();
			}
		});

		Person person1 = new Person("Alice", 25);
		Person person2 = new Person("Bob", 30);
		Person person3 = new Person("Charlie", 20);
		Person person4 = new Person("Charlie2222", 5);

		pq.offer(person1);
		pq.offer(person2);
		pq.offer(person3);
		pq.offer(person4);

		System.out.println(JSONObject.toJSON(pq));

		System.out.println(JSONObject.toJSON(pq.poll()));
		System.out.println(JSONObject.toJSON(pq.poll()));
		System.out.println(JSONObject.toJSON(pq.poll()));
		System.out.println(JSONObject.toJSON(pq.poll()));

	}

}
