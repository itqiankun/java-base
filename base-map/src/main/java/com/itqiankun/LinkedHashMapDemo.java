package com.itqiankun;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.LinkedHashMap;

/**
 * @author: ma_qiankun
 * @date: 2023/10/13
 **/
@Slf4j
public class LinkedHashMapDemo {
	@Test
	public void it_qk_sort_insert(){
		LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();

		linkedHashMap.put(3, "C");
		linkedHashMap.put(1, "A");
		linkedHashMap.put(4, "D");
		linkedHashMap.put(2, "B");

		System.out.println("Original LinkedHashMap: " + linkedHashMap);
	}

	@Test
	public void it_qk_sort_get(){
		LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);

		linkedHashMap.put(3, "C");
		linkedHashMap.put(1, "A");
		linkedHashMap.put(4, "D");
		linkedHashMap.put(2, "B");  // 这里顺序是3,1,4,2

		// 这里`get(4)`之后，就变成了3,1,2,4
		linkedHashMap.get(4);
		// 这里`get(1)`之后，就变成了3,2,4,1
		linkedHashMap.get(1);

		System.out.println("Original LinkedHashMap: " + linkedHashMap);
	}

}
