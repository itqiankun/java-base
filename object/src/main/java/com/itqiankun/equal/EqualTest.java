package com.itqiankun.equal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: ma_qiankun
 * @date: 2023/8/4
 **/
@Slf4j
public class EqualTest {

	@Test
	public void equalAndEqualityStr(){
		int a=1000;
		int aa=1000;
		log.info("int==符号比较:{}", a==aa);
		double c=1000;
		double cc=1000;
		log.info("double==符号比较:{}", c==cc);

		Person person = new Person();
		Person person1 = new Person();
		log.info("对象==符号比较:{}", person==person1);
	}

	@Test
	public void equalAndEqualityStrObject(){
		String str =new String("a");
		String str1 =new String("a");
		String str2 =new String("a");

		log.info("==符号比较:{}", str==str1);
		log.info("==符号比较:{}", str1==str2);
		log.info("==符号比较:{}", str==str2);
		log.info("equal符号比较:{}", str.equals(str1));
		log.info("equal符号比较:{}", str1.equals(str2));
		log.info("equal符号比较:{}", str.equals(str2));
	}

	@Test
	public void equalAndEqualityStrAndStringObject(){
		String str ="a";
		String str1 =new String("a");

		log.info("==符号比较:{}", str==str1);
		log.info("equal符号比较:{}", str.equals(str1));
	}

	@Test
	public void equalAndEqualityInt(){
		Integer integer = 1;
		Integer integer1 = 1;
		Integer integer2 = 1;

		log.info("==符号比较:{}", integer==integer1);
		log.info("==符号比较:{}", integer1==integer2);
		log.info("==符号比较:{}", integer==integer2);
		log.info("equal符号比较:{}", integer.equals(integer1));
		log.info("equal符号比较:{}", integer1.equals(integer2));
		log.info("equal符号比较:{}", integer.equals(integer2));
	}

	@Test
	public void equalAndEqualityIntTwo(){
		Integer integer = 127;
		Integer integer1 = 127;
		Integer integer2 = 127;

		log.info("==符号比较:{}", integer==integer1);
		log.info("==符号比较:{}", integer1==integer2);
		log.info("==符号比较:{}", integer==integer2);
		log.info("equal符号比较:{}", integer.equals(integer1));
		log.info("equal符号比较:{}", integer1.equals(integer2));
		log.info("equal符号比较:{}", integer.equals(integer2));
	}

	@Test
	public void equalAndEqualityIntThree(){
		Integer integer = 128;
		Integer integer1 = 128;
		Integer integer2 = 128;

		log.info("==符号比较:{}", integer==integer1);
		log.info("==符号比较:{}", integer1==integer2);
		log.info("==符号比较:{}", integer==integer2);
		log.info("equal符号比较:{}", integer.equals(integer1));
		log.info("equal符号比较:{}", integer1.equals(integer2));
		log.info("equal符号比较:{}", integer.equals(integer2));
	}

	@Test
	public void equalAndEqualityIntObject(){
		Integer integer = new Integer(1);
		Integer integer1 = new Integer(1);
		Integer integer2 = new Integer(1);

		log.info("==符号比较:{}", integer==integer1);
		log.info("==符号比较:{}", integer1==integer2);
		log.info("==符号比较:{}", integer==integer2);
		log.info("equal符号比较:{}", integer.equals(integer1));
		log.info("equal符号比较:{}", integer1.equals(integer2));
		log.info("equal符号比较:{}", integer.equals(integer2));
	}

	@Test
	public void equalAndEqualityPersonObject(){
		Person person = new Person();
		Person person1 = new Person();
		Person person2 = new Person();

		log.info("==符号比较:{}", person==person1);
		log.info("==符号比较:{}", person1==person2);
		log.info("==符号比较:{}", person==person2);
		log.info("equal符号比较:{}", person.equals(person1));
		log.info("equal符号比较:{}", person1.equals(person2));
		log.info("equal符号比较:{}", person.equals(person2));
	}

}
