package com.itqiankun.create;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: ma_qiankun
 * @date: 2023/9/22
 **/
@Slf4j
public class RunnableResolveCreateThread implements Runnable{

	private  Integer availableTickets = 10;

	public static void main(String[] args) {
		Runnable runnable = new RunnableResolveCreateThread();
		Thread thread = new Thread(runnable);
		thread.start();
		Thread thread1 = new Thread(runnable);
		thread1.start();
		Thread thread2 = new Thread(runnable);
		thread2.start();

	}

	@Override
	public void run() {
		while (availableTickets > 0) {
			synchronized (this){
				if(availableTickets >= 0){
					// 模拟售票过程
					log.info("当前线程:{}, availableTickets:{}", Thread.currentThread().getName() , availableTickets);
					availableTickets--;
				}
			}
		}

	}
}
