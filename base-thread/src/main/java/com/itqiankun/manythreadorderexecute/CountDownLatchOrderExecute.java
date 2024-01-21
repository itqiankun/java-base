package com.itqiankun.manythreadorderexecute;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

/**
 * author: ma_qiankun
 * date:  2023/12/16
 **/
@Slf4j
public class CountDownLatchOrderExecute {
	
	public static void main(String[] args) {
		CountDownLatch countDownLatchA = new CountDownLatch(1);
		CountDownLatch countDownLatchB = new CountDownLatch(1);
		new Thread(() -> {
			log.info("start...");
			log.info("end...");
			countDownLatchA.countDown();
		}, "thread-a").start();

		new Thread(() -> {
			try {
				countDownLatchA.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			log.info("start...");
			
			log.info("end...");
			countDownLatchB.countDown();
		}, "thread-b").start();

		new Thread(() -> {
			try {
				countDownLatchB.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			log.info("start...");
			
			log.info("end...");
		}, "thread-c").start();
	}


}
