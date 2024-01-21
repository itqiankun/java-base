package com.itqiankun.manythreadorderexecute;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

/**
 * author: ma_qiankun
 * date:  2023/12/16
 **/
@Slf4j
public class SephmoreOrderExecute {
	public static void main(String[] args) throws InterruptedException {
		Semaphore semaphore = new Semaphore(1);
		semaphore.acquire();
		new Thread(() -> {
			log.info("start...");
			log.info("end...");
			semaphore.release();
		}, "thread-a").start();

		semaphore.acquire();
		new Thread(() -> {
			log.info("start...");
			log.info("end...");
			semaphore.release();
		}, "thread-b").start();
		semaphore.acquire();
		new Thread(() -> {
			log.info("start...");
			
			log.info("end...");
			semaphore.release();
		}, "thread-c").start();
	}
}
