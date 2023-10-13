package com.itqiankun.lfu;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: ma_qiankun
 * @date: 2023/10/13
 **/
@Slf4j
public class LFUCache<k, v> {
	private final int capcity;

	private Map<k, HitRate> itqiankunCountMap = new HashMap<>();

	public LFUCache(int capcity) {
		this.capcity = capcity;
	}

	public void put(k key, v value) {
		HitRate v = itqiankunCountMap.get(key);
		if (v == null) {
			if (itqiankunCountMap.size() == capcity) {
				removeElement();
			}
			HitRate hitRate = new HitRate(key, value, 1, System.nanoTime());
			itqiankunCountMap.put(key, hitRate);
		} else {
			addHitCount(key);
		}
	}

	public v get(k key) {
		HitRate value = itqiankunCountMap.get(key);
		if (value != null) {
			addHitCount(key);
			return value.value;
		}
		return null;
	}

	//移除元素
	private void removeElement() {
		HitRate hr = Collections.min(itqiankunCountMap.values());
		itqiankunCountMap.remove(hr.key);
	}

	//更新访问元素状态
	private void addHitCount(k key) {
		HitRate hitRate = itqiankunCountMap.get(key);
		hitRate.hitCount = hitRate.hitCount + 1;
		hitRate.lastTime = System.nanoTime();
	}

	//内部类
	class HitRate implements Comparable<HitRate> {
		private k key;
		private v value;
		private int hitCount;
		private long lastTime;

		private HitRate(k key,v value, int hitCount, long lastTime) {
			this.key = key;
			this.value = value;
			this.hitCount = hitCount;
			this.lastTime = lastTime;
		}

		@Override
		public int compareTo(HitRate o) {
			int compare = Integer.compare(this.hitCount, o.hitCount);
			return compare == 0 ? Long.compare(this.lastTime, o.lastTime) : compare;
		}
	}


	public static void main(String[] args) {
		LFUCache<Integer, Integer> cache = new LFUCache<>(3);
		cache.put(2, 2);
		cache.put(1, 1);

		cache.get(2);
		cache.get(1);
		cache.get(2);
		cache.put(3, 3);
		cache.put(4, 4);

		// 1、2元素都有访问次数，放入3后缓存满，加入4时淘汰3，所以这里就会获取为null
		System.out.println(cache.get(3));
		cache.get(2);
		cache.get(4);

		// 目前2访问2次，1访问一次，4访问一次，由于4的时间比较新，放入5的时候移除1元素。
		cache.put(5, 5);
		cache.itqiankunCountMap.forEach((key, value) -> {
			System.out.println(key);
			System.out.println(value);
		});


	}
}

