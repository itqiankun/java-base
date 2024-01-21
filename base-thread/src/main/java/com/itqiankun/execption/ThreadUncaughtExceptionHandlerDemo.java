package com.itqiankun.execption;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: ma_qiankun
 * @date: 2023/9/22
 **/
@Slf4j
public class ThreadUncaughtExceptionHandlerDemo {
	public static void main(String[] args) {

		Thread thread = new Thread(() -> {
			int i = 1 / 0;
			System.out.println("hello");
		});
		thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		thread.start();
	}

	static class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
		@Override
		public void uncaughtException(Thread t, Throwable e) {
			log.info("线程:{}，抛出异常", t.getName(), e);
		}
	}
}
