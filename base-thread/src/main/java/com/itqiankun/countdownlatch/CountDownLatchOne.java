package com.itqiankun.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: ma_qiankun
 * @date: 2023/6/10
 **/
public class CountDownLatchOne {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		CountDownLatch startCountDownLatch = new CountDownLatch(1);
		Future<Integer> submitOne = executorService.submit(() -> {
			try {
				startCountDownLatch.await();
				return function1();
			} catch (Exception e) {
				//异常处理
				e.printStackTrace();
			}
			return null;
		});

		Future<Integer> submitTwo = executorService.submit(() -> {
			try {
				startCountDownLatch.await();
				return function2();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});

		try {
			// 发送信号开始执行
			startCountDownLatch.countDown();
			Integer integer = submitOne.get();
			Integer integer1 = submitTwo.get();
			System.out.println("方法1结果:"+integer);
			System.out.println("方法2结果:"+integer1);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("执行线程异常");
		} finally {
			executorService.shutdown();
			System.out.println("执行线程池关闭");
		}
	}

	private static Integer function1(){
        return 11;
	}
	private static Integer function2(){
		return 22;
	}
}
