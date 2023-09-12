package com.itqiankun.common.GenericArrayType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ma_qiankun
 * @date: 2023/9/6
 **/
public class GenericArrayTypeDemo<T, V> {
	public Number number;

	public T t;
	public V v;

	public T[] tArray;
	public List<T>[] listTArray;

	public List<T> list = new ArrayList<>();
	public Map<Float, T> map = new HashMap<>();

	public int values(T... ts) {
		return ts.length;
	}
}