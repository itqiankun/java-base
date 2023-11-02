package com.itqiankun;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;

/**
 * @author: ma_qiankun
 * @date: 2023/10/10
 **/
public class Hello {
	public static void main(String[] args) {
		System.out.println(ForkJoinPool.commonPool().getParallelism());
	}

	@Test
	public void it_qk(){
		System.out.println(-1 << 29);
		System.out.println(0 << 29);
		System.out.println(1 << 29);
		System.out.println(2 << 29);
		System.out.println(3 << 29);
		System.out.println((1 << 29) - 1);
	}
}
