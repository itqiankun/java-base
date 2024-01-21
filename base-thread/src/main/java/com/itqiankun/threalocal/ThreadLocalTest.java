package com.itqiankun.threalocal;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: ma_qiankun
 * @date: 2023/11/10
 **/
@Slf4j
public class ThreadLocalTest {
	public static void main(String[] args) throws InterruptedException {
		Thread parentParent = new Thread(() -> {
			ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
			threadLocal.set(1);

			Thread subThread = new Thread(() -> {
				log.info("threadLocal result: " + threadLocal.get());
			}, "subThread");
			subThread.start();

		}, "parentParent");
		parentParent.start();
	}

}
