package com.itqiankun.threalocal;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: ma_qiankun
 * @date: 2023/11/10
 **/
@Slf4j
public class ThreadLocalGcTest {
	public static void main(String[] args) throws InterruptedException {
		Thread parentParent = new Thread(() -> {
			ThreadLocal<Integer> hello = new ThreadLocal<>();
			hello.set(1);
			// 这里即使gc，虽然底层`ThreadLocalMap`对`hello`变量的引用是`弱引用`，但是`parentParent`线程对`hello`变量的引用还是强引用，
			// 所以即使gc，底层`ThreadLocalMap`对`hello`变量的引用还是不会被回收的
			System.gc();
			System.out.println(hello.get());
		}, "parentParent");
		parentParent.start();
	}

}
