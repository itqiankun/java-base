package com.itqiankun;

import java.util.concurrent.ForkJoinPool;

/**
 * @author: ma_qiankun
 * @date: 2023/10/10
 **/
public class Hello {
	public static void main(String[] args) {
		System.out.println(ForkJoinPool.commonPool().getParallelism());
	}
}
