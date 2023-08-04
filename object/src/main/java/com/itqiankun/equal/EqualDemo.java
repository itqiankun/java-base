package com.itqiankun.equal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: ma_qiankun
 * @date: 2023/8/4
 **/
@Slf4j
public class EqualDemo {

	@Test
	public void equalAndEqualityObject(){
		Person person = new Person();
		Person person1 = new Person();
		log.info("equal符号比较:{}", person.equals(person1));
	}

	@Test
	public void equalAndEqualityIntTwo(){
		Integer integer = 127;
		Integer integer1 = new Integer(127);
		Integer integer2 = 127;

		log.info("equal符号比较:{}", integer.equals(integer1));
		log.info("equal符号比较:{}", integer1.equals(integer2));
		log.info("equal符号比较:{}", integer.equals(integer2));
	}

	@Test
	public void equalAndEqualityString(){
		String str ="a";
		String str1 =new String("a");
		String str2 =new String("a");

		log.info("equal符号比较:{}", str.equals(str1));
		log.info("equal符号比较:{}", str1.equals(str2));
		log.info("equal符号比较:{}", str.equals(str2));
	}
}
