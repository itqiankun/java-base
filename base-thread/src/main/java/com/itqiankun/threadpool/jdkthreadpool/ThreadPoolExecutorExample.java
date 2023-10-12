package com.itqiankun.threadpool.jdkthreadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author: ma_qiankun
 * @website: itqiankun.com
 * @date: 2023/6/26
 **/
@Slf4j
public class ThreadPoolExecutorExample {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ThreadPoolExecutor taskExecutor = new ThreadPoolExecutor(10, 10, 0, TimeUnit.SECONDS,
				new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory());
		// execute()执行不会有返回值
		taskExecutor.execute(()->{
			log.info("execute() 执行结果");
		});

		// submit()执行可以有返回值
		Future<String> submit = taskExecutor.submit(() -> "submit()执行结果");
		String s = submit.get();
		log.info("获取结果:{}", s);

		taskExecutor.shutdown();
	}
}
