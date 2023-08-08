package com.itqiankun.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: ma_qiankun
 * @date: 2023/7/6
 **/
public class LRUCache <K, V> extends LinkedHashMap<K, V> {
	private static final int MAX_ENTRIES = 3; // 设置缓存的最大容量

	public LRUCache() {
		// 调用父类LinkedHashMap的构造函数，并设置accessOrder为true
		super(MAX_ENTRIES, 0.75f, true);
	}

	protected boolean removeEldestEntry(Map.Entry eldest) {
		// 根据缓存的最大容量判断是否需要移除最久未被使用的元素
		return size() > MAX_ENTRIES;
	}

	public static void main(String[] args) {
		LRUCache<Integer, String> cache = new LRUCache<>();
		cache.put(1, "one");
		cache.put(2, "two");
		cache.put(3, "three");
		cache.get(1); // 访问1，将1移到链表末尾
		cache.put(4, "four"); // 添加新元素，超出缓存最大容量，将2移除
		System.out.println(cache); // 输出：{1=one, 3=three, 4=four}
	}
}
