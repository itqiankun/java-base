package com.itqiankun.map.identityhashmap;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * @author: ma_qiankun
 * @date: 2023/8/4
 **/
@Slf4j
public class Demo {

	@Test
	public void it_qk(){
		Map<Integer, String> map = new IdentityHashMap<>();
		Integer integer =1;
		Integer integer1 = new Integer(1);
		map.put(integer, "string");
		map.put(integer1, "string");
		log.info("打印长度:{}", map.size());
	}

	@Test
	public void it_qk1(){
		Map<Integer, String> map = new IdentityHashMap<>();
		Integer integer =127;
		Integer integer1 = 127;
		map.put(integer, "string");
		map.put(integer1, "string");
		log.info("打印长度:{}", map.size());
	}

	@Test
	public void it_qk2(){
		Map<Integer, String> map = new IdentityHashMap<>();
		Integer integer =128;
		Integer integer1 = 128;
		map.put(integer, "string");
		map.put(integer1, "string");
		log.info("打印长度:{}", map.size());
	}

	@Test
	public void it_qk3(){
		Map<String, String> map = new IdentityHashMap<>();
		String str ="128";
		String str1 = "128";
		map.put(str, "string");
		map.put(str1, "string");
		log.info("打印长度:{}", map.size());
	}

	@Test
	public void it_qk4(){
		Map<Person, String> map = new IdentityHashMap<>();
		Person person = new Person(1);
		Person person1 = new Person(1);
		map.put(person, "string");
		map.put(person1, "string1");
		log.info("打印长度:{}", map.size());
		log.info("打印结果:{}", map.get(person));
		log.info("打印结果:{}", map.get(person1));
		log.info("打印结果:{}", map.get(new Person(1)));
	}


}
