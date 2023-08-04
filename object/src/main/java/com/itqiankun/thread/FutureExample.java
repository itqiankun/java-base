package com.itqiankun.thread;

/**
 * @author: ma_qiankun
 * @date: 2023/6/8
 **/
import com.alibaba.fastjson.JSONObject;

import java.util.concurrent.*;

public class FutureExample {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newSingleThreadExecutor();

		Future<Integer> future = executor.submit(() -> {
			// 模拟一个耗时的任务，这里计算1到10的和
			int sum = 0;
			for (int i = 1; i <= 10; i++) {
				sum += i;
				Thread.sleep(500);
				StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
				System.out.println(JSONObject.toJSON(stackTraceElements[2].getMethodName()));
			}
			return sum;
		});

		System.out.println("异步任务已提交。");


		while (! future.isDone()) {
			int sum = 0;
			for (int i=0;i<1000;i++){
				sum += i;
			}
			System.out.println("主线程开始处理其他代码结果"+sum);
			Thread.sleep(1000);
		}

		int result = future.get();
		System.out.println("异步任务已完成，结果为：" + result);

		executor.shutdown();
	}
}

