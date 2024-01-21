package com.itqiankun.synchronizeddemo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * author: ma_qiankun
 * date:  2023/12/30
 **/
@Slf4j
public class SynchronizedOrderExecute {

	public static final SynchronizedOrderExecute synchronizedOrderExecute = new SynchronizedOrderExecute();

	public static final BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);

	public static final AtomicInteger atomicInteger = new AtomicInteger(0);

	public static void main(String[] args) {
		Thread threadProduct = new Thread(()->{
			while (true){
				synchronized (synchronizedOrderExecute){
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
					blockingQueue.add("string"+atomicInteger.incrementAndGet());
					log.info("add value");
					if(blockingQueue.size() > 0){
						try {
							synchronizedOrderExecute.notify();
							synchronizedOrderExecute.wait();
						} catch (InterruptedException e) {
							throw new RuntimeException(e);
						}
					}

				}
			}
		},"producer");
		threadProduct.start();

		Thread threadConsumer = new Thread(()->{
			while (true){
				synchronized (synchronizedOrderExecute){
					try {
						TimeUnit.SECONDS.sleep(1);
						log.info("get value:{}", blockingQueue.take());
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
					if(blockingQueue.size() == 0){
						try {
							synchronizedOrderExecute.notify();
						} catch (Exception e) {
							throw new RuntimeException(e);
						}
					}
					try {
						synchronizedOrderExecute.wait();
					} catch (Exception e) {
						throw new RuntimeException(e);
					}

				}
			}
		},"consumer");
		threadConsumer.start();
	}

}
