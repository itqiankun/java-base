package com.itqiankun.threaddemo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author: ma_qiankun
 * @date: 2023/10/16
 **/
@Slf4j
public class ThreadBlockQueueDemo {


	public static void main(String[] args) {
		Thread thread = new Thread(new TaskBlockQueue());
		thread.start();
	}



}

class TaskBlockQueue implements Runnable {

	private LinkedBlockingQueue taskQueue = new LinkedBlockingQueue();
	private AtomicBoolean running = new AtomicBoolean(true);
	public void submitTask(Object task) throws InterruptedException {
		taskQueue.put(task);
	}

	@Override
	public void run() {
		while(running.get()) {
			try {
				Object task = taskQueue.take(); // 如果没有任务，会使线程阻塞，一
				doSomething(task);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	public void shutdown() {
		if(running.compareAndSet(true, false)) {
			System.out.println(Thread.currentThread() + " is stoped");
		}
	}

	private void doSomething(Object task) {
	}
}
