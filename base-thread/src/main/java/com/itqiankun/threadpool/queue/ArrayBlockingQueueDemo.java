package com.itqiankun.threadpool.queue;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author: ma_qiankun
 * @date: 2023/10/9
 **/
@Slf4j
public class ArrayBlockingQueueDemo {
	public static void main(String[] args) {
		ExecutorService pool = new ThreadPoolExecutor(5, 5, 1000, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
		for(int i=0;i<15;i++) {
			pool.execute(()->{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				log.info("打印结果");
			});
		}
	}
}
