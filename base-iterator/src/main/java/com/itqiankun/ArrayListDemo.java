package com.itqiankun;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * author: ma_qiankun
 * date:  2023/12/14
 **/
public class ArrayListDemo {

	@Test
	public void it_qk(){
		List<String> strings = Lists.newArrayList();
		strings.add("hello");
		strings.add("world");
		Iterator<String> iterator = strings.iterator();
		while (iterator.hasNext()){
			String next = iterator.next();
			if(Objects.equals(next, "world")){
				iterator.remove();
			}
		}
		System.out.println(JSONObject.toJSON(strings));
	}

	@Test
	public void it_qk_(){
		List<String> strings = Lists.newArrayList();
		strings.add("hello");
		strings.add("world");
		for (String string : strings) {
			if(Objects.equals(string, "world")){
				strings.remove(string);
			}
		}
		System.out.println(JSONObject.toJSON(strings));
	}

	@Test
	public void it_qk_1(){
		List<String> strings = Lists.newArrayList();
		strings.add("hello");
		strings.add("world");
		strings.add("tom");
		strings.add("jack");
		for (int i = 0; i < strings.size(); i++) {
			String string = strings.get(i);
			if(Objects.equals(string, "world")){
				strings.remove(string);
			}
		}
		System.out.println(JSONObject.toJSON(strings));
	}
	@Test
	public void it_qk_2(){
		List<String> strings = Lists.newArrayList();
		strings.add("hello");
		strings.add("world");
		strings.add("tom");
		strings.add("jack");
		for (int i = 0; i < strings.size(); i++) {
			String string = strings.get(i);
			if(Objects.equals(string, "world")){
				strings.add("cc");
			}
		}
		System.out.println(JSONObject.toJSON(strings));
	}
}
