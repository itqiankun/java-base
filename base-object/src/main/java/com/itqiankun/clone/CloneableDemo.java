package com.itqiankun.clone;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * author: ma_qiankun
 * date:  2023/12/25
 **/

@Slf4j
public class CloneableDemo {


	@Test
	public void it_qk() throws CloneNotSupportedException {
		Room room = new Room();
		room.setLocation("杭州");
		System.out.println(room);
		System.out.println(JSONObject.toJSON(room));

		Room clone = room.clone();
		System.out.println(clone);
		System.out.println(JSONObject.toJSON(clone));
	}

	@Test
	public void it_qk_() throws CloneNotSupportedException {
		Person person = new Person();
		person.setName("tom");
		City city = new City();
		city.setArea(10000);
		person.setName("tom");
		person.setCity(city);
		System.out.println(person);
		System.out.println("city地址:"+person.getCity());
		System.out.println(JSONObject.toJSON(person));

		Person clone = person.clone();
		System.out.println(clone);
		System.out.println("city地址:"+clone.getCity());
		System.out.println(JSONObject.toJSON(clone));
	}
}
