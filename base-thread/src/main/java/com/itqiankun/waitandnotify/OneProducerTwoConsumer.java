package com.itqiankun.waitandnotify;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: ma_qiankun
 * @date: 2023/10/7
 **/
@Slf4j
public class OneProducerTwoConsumer {
	public static void main(String[] args) {
		final Object lock = new Object(); // 用于同步的对象
		Queue<String> queue = new ArrayDeque<>();

		// 生产者线程
		Thread producerThread = new Thread(() -> {
			while (true){
				synchronized (lock) {
					try {
						while (queue.size() >= 500){
							// 进入wait()
							log.info("producer wait");
							lock.wait();
							log.info(" producer wait wake up");
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
					queue.add("hello");
					log.info("producer produced index:{}", queue.size());

					// 唤醒消费者线程
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
					// 唤醒wait中的生产者
					lock.notify();
				}
			}
		});


		// 消费者线程
		Thread consumerThreadTwo = new Thread(() -> {
			while (true){
				synchronized (lock) {
					try {
						while (queue.size() == 0){
							log.info("consumerTwo wait");
							lock.wait();
							log.info("consumerTwo wait wake up");
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					queue.poll();
					log.info("consumerTwo index :{}", queue.size());
					// 唤醒wait中的生产者
					lock.notify();
				}
			}
		});

		// 启动生产者和消费者线程
		producerThread.start();
		consumerThread.start();
		consumerThreadTwo.start();
	}
}
