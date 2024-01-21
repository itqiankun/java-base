package com.itqiankun.lru;

import com.alibaba.fastjson.JSONObject;

import java.util.LinkedList;

/**
 * author: ma_qiankun
 * date:  2023/12/14
 **/
public class LruListCache<E> {
	private int maxSize;

	private LinkedList<E> list = new LinkedList<>();

	public LruListCache(int maxSize){
		this.maxSize = maxSize;
	}

	public void add(E e){
		if(list.size() < maxSize){
			list.addFirst(e);
		} else {
			list.removeLast();
			list.addFirst(e);
		}
	}

	public E get(int index){
		E e = list.get(index);
		// 先移除元素
		list.remove(e);
		// 把元素移除到第一位
		add(e);
		return e;
	}

	@Override
	public String toString(){
		return list.toString();
	}

	public static void main(String[] args) {
		LruListCache<String> stringLruListCache = new LruListCache<String>(10);
		stringLruListCache.add("hello");
		stringLruListCache.add("world");
		stringLruListCache.add("itqiankun.com");
		System.out.println(JSONObject.toJSON(stringLruListCache.toString()));
		stringLruListCache.get(2);
		System.out.println(JSONObject.toJSON(stringLruListCache.toString()));
	}
}
