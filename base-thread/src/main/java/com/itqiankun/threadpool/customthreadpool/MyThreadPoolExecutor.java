package com.itqiankun.threadpool.customthreadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: ma_qiankun
 * @date: 2023/10/8
 **/
public class MyThreadPoolExecutor implements Executor {

	private AtomicInteger atomicInteger = new AtomicInteger(0);

	@Override
	public void execute(Runnable command) {
		String prefix ="prefix";
		int i = atomicInteger.incrementAndGet();
		Thread thread = new Thread(command);
		thread.setName(prefix + i);
		thread.start();
	}



}
