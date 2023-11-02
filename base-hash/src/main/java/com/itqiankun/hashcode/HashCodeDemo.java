package com.itqiankun.hashcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: ma_qiankun
 * @date: 2023/8/4
 **/
@Slf4j
public class HashCodeDemo {
	@Test
	public void hello(){
		Integer integer =999;
		Integer integer1 =new Integer(999);
		String s ="999877666";
		String str =new String("999877666");
		log.info("integer值:{}", integer.hashCode());
		log.info("integer值:{}", integer1.hashCode());
		log.info("str值:{}", s.hashCode());
		log.info("str值:{}", str.hashCode());
	}
	@Test
	public void hello1(){
		Person person = new Person("tom",1);
		Person person1 = new Person("tom11",1);
		log.info("integer值:{}", person.hashCode());
		log.info("integer值:{}", person1.hashCode());
	}

}
