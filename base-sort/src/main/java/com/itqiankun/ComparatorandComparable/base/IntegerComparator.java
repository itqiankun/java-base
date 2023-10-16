package com.itqiankun.ComparatorandComparable.base;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: ma_qiankun
 * @date: 2023/10/16
 **/
public class IntegerComparator implements Comparator<Integer> {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(10, 5, 100);
		Collections.sort(list, new IntegerComparator());
		System.out.println(list);
	}

	@Override
	public int compare(Integer o1, Integer o2) {
		return o1-o2;
	}
}
