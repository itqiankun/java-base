package com.itqiankun.linkedhashmap;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * author: ma_qiankun
 * date:  2023/12/25
 **/
@Slf4j
public class LinkedHashMapDemo {
	@Test
	public void it_qk(){
		Map<String, String> hashMap = new LinkedHashMap<>();
		hashMap.put("1","tom");
		hashMap.put("2","jack");
		hashMap.put("3","fi");
		System.out.println(hashMap);
		hashMap.get("1");
		System.out.println(hashMap);
	}


	@Test
	public void it_qk_1(){
		Map<String, String> linkedHashMap = new LinkedHashMap<>(10, 0.75f, true);
		linkedHashMap.put("1", "1");
		linkedHashMap.put("2", "2");
		linkedHashMap.put("3", "3");
		linkedHashMap.put("4", "4");
		linkedHashMap.put("5", "5");
		linkedHashMap.put("6", "6");
		linkedHashMap.put("7", "7");
		linkedHashMap.put("8", "8");
		linkedHashMap.put("9", "9");
		linkedHashMap.put("10", "10");
		linkedHashMap.put("11", "11");
		System.out.println(linkedHashMap);
		linkedHashMap.get("1");
		System.out.println(linkedHashMap);
	}

}
