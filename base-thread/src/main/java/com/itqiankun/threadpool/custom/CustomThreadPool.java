package com.itqiankun.threadpool.custom;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: ma_qiankun
 * @website: itqiankun.com
 * @date: 2023/6/26
 **/
public class CustomThreadPool {
	public static Executor getAsyncExecutor() {
		AtomicInteger counter = new AtomicInteger(1);
		ThreadPoolExecutor taskExecutor = new ThreadPoolExecutor(10, 10, 0, TimeUnit.SECONDS,
				new ArrayBlockingQueue<>(1000), r -> {
					Thread thread = new Thread(r);
					thread.setName("hello_" + counter.getAndIncrement());
					return thread;
				});
		return taskExecutor;
	}

	public static void main(String[] args) {
		Executor executorService = getAsyncExecutor();
		for (int y=0; y<1000; y++){
			executorService.execute(() -> {
				int total = 0;
				for (int i = 1; i <= 1000; i++) {
					total += i;
				}
				String name = Thread.currentThread().getName();
				System.out.println(name+"_"+total);
			});
		}
	}
}
