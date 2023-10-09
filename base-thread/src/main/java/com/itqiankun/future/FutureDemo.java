package com.itqiankun.future;

import com.itqiankun.create.CallableCreateThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author: ma_qiankun
 * @date: 2023/10/7
 **/
public class FutureDemo implements Callable<Integer> {

	public static void main(String[] args) {
		CallableCreateThread callable = new CallableCreateThread();
		FutureTask<Integer> future = new FutureTask<>(callable);

		Thread thread = new Thread(future);
		thread.start();

		Integer integer = null;
		try {
			integer = future.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("FutureTask 返回内容: " + integer);
	}

	@Override
	public Integer call() throws Exception {
		TimeUnit.SECONDS.sleep(5);
		System.out.println("5s后返回1");
		return 1;
	}
}
