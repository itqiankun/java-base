package com.itqiankun.threadpool.queue;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author: ma_qiankun
 * @date: 2023/10/9
 **/
@Slf4j
public class PriorityBlockingQueueDemoTwo {
	public static void main(String[] args) {
		ExecutorService pool = new ThreadPoolExecutor(3, 3, 1000, TimeUnit.MILLISECONDS,
				new PriorityBlockingQueue<>(500), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
		for(int i=0;i<20;i++) {
			pool.execute(()->{
				log.info("打印");
			});
		}
	}
}
