package com.itqiankun.threalocal.InheritableThreadLocal;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: ma_qiankun
 * @date: 2023/11/10
 **/
@Slf4j
public class InheritableThreadLocalDemoThree {
	public static void main(String[] args) throws InterruptedException {
		InheritableThreadLocal<String> local = new InheritableThreadLocal<>();
		local.set("我是主线程");
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		CountDownLatch c1 = new CountDownLatch(1);
		CountDownLatch c2 = new CountDownLatch(1);
		executorService.submit(() -> {
			log.info("我是线程1：" + local.get());
			c1.countDown();
		});

		c1.await();

		local.set("修改主线程");
		log.info(local.get());
		executorService.submit(() -> {
			log.info("我是线程2：" + local.get());
			c2.countDown();
		});
		c2.await();
	}

}
