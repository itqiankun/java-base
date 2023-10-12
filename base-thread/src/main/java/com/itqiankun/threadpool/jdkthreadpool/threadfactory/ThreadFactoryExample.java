package com.itqiankun.threadpool.jdkthreadpool.threadfactory;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author: ma_qiankun
 * @website: itqiankun.com
 * @date: 2023/6/26
 **/
@Slf4j
public class ThreadFactoryExample {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ThreadPoolExecutor taskExecutor = new ThreadPoolExecutor(10, 10, 0, TimeUnit.SECONDS,
				new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory());
		Future<String> future = taskExecutor.submit(() -> {
			log.info("输出结果");
			return "结果";
		});
		String s = future.get();
		log.info("打印结果:{}", s);
		taskExecutor.shutdown();
	}
}
