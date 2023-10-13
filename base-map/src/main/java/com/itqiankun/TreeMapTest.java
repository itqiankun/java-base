package com.itqiankun;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author: ma_qiankun
 * @date: 2023/10/13
 **/
public class TreeMapTest {
	@Test
	public void it_qk(){
		TreeMap<Integer, String> treeMap = new TreeMap<>();

		treeMap.put(3, "Three");
		treeMap.put(8, "One");
		treeMap.put(20, "Two");
		treeMap.put(16, "Two");

		Map.Entry<Integer, String> firstEntry = treeMap.firstEntry();

		System.out.println("Key: " + firstEntry.getKey());
		System.out.println("Value: " + firstEntry.getValue());


	}

	@Test
	public void it_qk_ceilingEntry(){
		TreeMap<Integer, String> treeMap = new TreeMap<>();

		treeMap.put(3, "Three");
		treeMap.put(8, "One");
		treeMap.put(20, "Two");
		treeMap.put(16, "Two");

		Map.Entry<Integer, String> firstEntry = treeMap.ceilingEntry(9);

		System.out.println("Key: " + firstEntry.getKey());
		System.out.println("Value: " + firstEntry.getValue());


	}
}
