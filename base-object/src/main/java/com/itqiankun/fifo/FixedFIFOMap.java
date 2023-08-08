package com.itqiankun.fifo;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: ma_qiankun
 * @date: 2023/7/6
 **/
public class FixedFIFOMap <K, V> extends LinkedHashMap<K, V> {
	private int maxSize;

	public FixedFIFOMap(int maxSize) {
		super(maxSize , 1.0f, false);
		this.maxSize = maxSize;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > maxSize;
	}

	public static void main(String[] args) {
		FixedFIFOMap<String, Integer> map = new FixedFIFOMap<>(3);
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		map.get("A");
		map.put("D", 4);
		System.out.println(map);
	}
}
