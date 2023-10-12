package com.itqiankun.threadpool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: ma_qiankun
 * @date: 2023/10/9
 **/
public class FutureThreadPoolExam {
	public static void main(String[] args) {
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), new ThreadFactory() {
			AtomicInteger atomicInteger = new AtomicInteger(0);
			@Override
			public Thread newThread(Runnable r) {
				Thread thread = new Thread(r);
				thread.setName("myPrefix" + atomicInteger.incrementAndGet());
				return thread;
			}
		}, new ThreadPoolExecutor.CallerRunsPolicy());

		// 提交 Callable 任务
		Future<Integer> future = threadPoolExecutor.submit(() -> {
			Thread.sleep(2000);
			return 42;
		});

		try {
			// 等待 Callable 任务完成并获取结果
			Integer result = future.get();
			System.out.println("Callable task result: " + result);

			threadPoolExecutor.shutdown();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
