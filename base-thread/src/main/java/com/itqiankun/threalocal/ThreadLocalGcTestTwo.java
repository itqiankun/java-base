package com.itqiankun.threalocal;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: ma_qiankun
 * @date: 2023/11/10
 **/
@Slf4j
public class ThreadLocalGcTestTwo {
	public static void main(String[] args) throws InterruptedException {
		Thread parentParent = new Thread(() -> {
			ThreadLocal<Integer> hello = new ThreadLocal<>();
			hello.set(1);
			hello = null;
			// 此时`hello=null`，然后再进行`gc`，那么此时底层`ThreadLocalMap`对`hello`变量的引用才会被回收
			// 此时的`hello.set(1);`里面的`1`就会造成`内存泄露`
			System.gc();
		}, "parentParent");
		parentParent.start();
	}

}
