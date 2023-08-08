package com.itqiankun.countdownlatch;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.*;

/**
 * @author: ma_qiankun
 * @date: 2023/6/10
 **/
public class CountDownLatchTwo {
	public static void main(String[] args) {
		final CountDownLatch startCountDownLatch = new CountDownLatch(1); // 开始计数器
		final CountDownLatch numCountDownLatch = new CountDownLatch(10); // 并发计数器
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
		try {
			for (int i = 0; i < 10; i++) {
				threadPoolExecutor.submit(new Runnable() {
					@Override
					public void run() {
						try {
							startCountDownLatch.await();
							long l = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
							TimeUnit.SECONDS.sleep(1);
							System.out.println(l);
							numCountDownLatch.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				});
				numCountDownLatch.countDown();
			}
			startCountDownLatch.countDown();
			threadPoolExecutor.shutdown();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
