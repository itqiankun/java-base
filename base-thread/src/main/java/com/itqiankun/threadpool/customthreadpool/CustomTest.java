package com.itqiankun.threadpool.customthreadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author: ma_qiankun
 * @date: 2023/10/8
 **/
@Slf4j
public class CustomTest {

	public static void main(String[] args) {
		MyThreadPoolExecutor myThreadPoolExecutor = new MyThreadPoolExecutor();
		myThreadPoolExecutor.execute(()->{
			while (true){
				try {
					TimeUnit.SECONDS.sleep(1);
					log.info("线程池打印");
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		});

		myThreadPoolExecutor.execute(()->{
			while (true){
				try {
					TimeUnit.SECONDS.sleep(1);
					log.info("线程池打印");
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		});

		myThreadPoolExecutor.execute(()->{
			while (true){
				try {
					TimeUnit.SECONDS.sleep(1);
					log.info("线程池打印");
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		});

	}

}
