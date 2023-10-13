package com.itqiankun.consistency;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author: ma_qiankun
 * @date: 2023/10/13
 **/
public class Analysis {

	// 计算出所有节点的命中次数的`方差`
	public static double variance(List<Integer> arr) {
		int m = arr.size();
		double sum = 0;
		for (int i = 0; i < m; i++) {
			sum += arr.get(i);
		}
		double dAve = sum / m;
		double dVar = 0;
		for (int i = 0; i < m; i++) {
			dVar += (arr.get(i) - dAve) * (arr.get(i) - dAve);
		}
		return dVar / m;
	}

	public static void main(String[] args) {
		List<Integer> integers = Lists.newArrayList();
		integers.add(0);
		integers.add(0);
		integers.add(0);
		integers.add(0);
		double variance = variance(integers);
		System.out.println(variance);


		List<Integer> integersTwo = Lists.newArrayList();
		integersTwo.add(0);
		integersTwo.add(0);
		integersTwo.add(1);
		integersTwo.add(1);
		double varianceTwo = variance(integersTwo);
		System.out.println(varianceTwo);
	}
}

