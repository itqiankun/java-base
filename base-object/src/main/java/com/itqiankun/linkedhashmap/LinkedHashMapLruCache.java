package com.itqiankun.linkedhashmap;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * author: ma_qiankun
 * date:  2023/12/25
 **/
@Slf4j
public class LinkedHashMapLruCache<K,V> extends LinkedHashMap<K,V>{

	public Integer maxLruLength;

	public LinkedHashMapLruCache(Integer maxLruLength){
		super(maxLruLength, 0.75f, true);
		this.maxLruLength = maxLruLength;
	}

	// 返回true表示移除元素，就是最老的元素，默认`LinkedHashMap.removeEldestEntry`返回`false`，所以不会移除元素
	// `size()`直接用`LinkedHashMap.size()`
	@Override
	public boolean removeEldestEntry(Map.Entry<K,V> eldest) {
		return size() > maxLruLength;
	}

	public static void main(String[] args) {
		Map<String, String> linkedHashMap = new LinkedHashMapLruCache(6);

		linkedHashMap.put("1", "1");
		linkedHashMap.put("2", "2");
		linkedHashMap.put("3", "3");
		linkedHashMap.put("4", "4");
		linkedHashMap.put("5", "5");
		linkedHashMap.put("6", "6");
		linkedHashMap.put("7", "7");
		linkedHashMap.put("8", "8");
		linkedHashMap.put("9", "9");

		System.out.println("size="+linkedHashMap.size());
		System.out.println(linkedHashMap.get("7"));

		linkedHashMap.forEach((k,v) ->{
			System.out.print(k + ":"+ v +"  ");
		});

		System.out.println();
		System.out.println("size="+linkedHashMap.size());
	}

}
