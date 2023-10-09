package com.itqiankun.waitandnotify;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: ma_qiankun
 * @date: 2023/10/7
 **/
@Slf4j
public class WaitDemo {

	public static void main(String[] args) {
		final Object lock = new Object(); // 用于同步的对象
		Queue<String> queue = new ArrayDeque<>();

		// 生产者线程
		Thread producerThread = new Thread(() -> {
			while (true){
				synchronized (lock) {
					try {
						while (queue.size() >= 5){
							log.info("producer wait");
							// 当线程进入到wait()之后，producerThread线程就会释放掉`lock`这把锁，这样下面的消费者consumerThread就会拥有锁，然后开始执行自己的线程代码
							lock.wait();
							log.info(" producer wait wake up");
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
					queue.add("hello");
					log.info("producer produced index:{}", queue.size());
					// 唤醒等待的消费者线程
					lock.notify();
				}
			}

		});

		// 消费者线程
		Thread consumerThread = new Thread(() -> {
			while (true){
				synchronized (lock) {
					try {
						while (queue.size() == 0){
							log.info("consumer wait");
							lock.wait();
							log.info("consumer wait wake up");
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					queue.poll();
					log.info("consumer index :{}", queue.size());
					lock.notify();
				}
			}

		});

		// 启动生产者和消费者线程
		producerThread.start();
		consumerThread.start();
	}
}
