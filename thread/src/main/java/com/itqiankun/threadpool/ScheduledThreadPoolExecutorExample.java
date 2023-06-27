package com.itqiankun.threadpool;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: ma_qiankun
 * @date: 2023/6/12
 **/
public class ScheduledThreadPoolExecutorExample {
	public static void main(String[] args) {
		ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);

		Runnable task = new Runnable() {
			@Override
			public void run() {
				System.out.println("Task executed at " + System.currentTimeMillis());
			}
		};

		executor.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		executor.shutdown();
	}
}
