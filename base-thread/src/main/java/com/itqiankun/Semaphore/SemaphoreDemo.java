package com.itqiankun.Semaphore;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

/**
 * @author: ma_qiankun
 * @date: 2023/10/18
 **/
@Slf4j
public class SemaphoreDemo {
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(3); // 创建一个初始许可证数量为 3 的 Semaphore

		// 创建多个线程并启动
		for (int i = 0; i < 5; i++) {
			Thread thread = new Thread(new Worker(semaphore, i));
			thread.start();
		}
	}

	static class Worker implements Runnable {
		private final Semaphore semaphore;
		private final int id;

		public Worker(Semaphore semaphore, int id) {
			this.semaphore = semaphore;
			this.id = id;
		}

		@Override
		public void run() {
			try {
				semaphore.acquire();
				log.info("Worker " + id + " has acquired a permit.");

				// 模拟工作
				Thread.sleep(2000);

				semaphore.release();
				log.info("Worker " + id + " has released the permit.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}