package com.itqiankun;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * author: ma_qiankun
 * date:  2024/1/5
 **/
public class HashMapDemo {

	public static void main(String[] args) {
		System.out.println(1);


		HashMap<String, String> stringStringHashMap = new HashMap<>();
		stringStringHashMap.put("name","tom");
		Set<Map.Entry<String, String>> entries = stringStringHashMap.entrySet();
		entries.stream().forEach(x->{
			System.out.println(x.getKey());
			System.out.println(x.getValue());
		});

		for(Map.Entry<String, String> stringEntry : entries){
			System.out.println(stringEntry.getValue());
			System.out.println(stringEntry.getKey());
		}
	}
}
