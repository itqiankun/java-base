package com.itqiankun.callback;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * author: ma_qiankun
 * date:  2023/12/15
 **/
@Slf4j
public class CallBackThreadDemo {

	/**
	 * 线程池使用Callable和FutureTask
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	@Test
	public void it_qk() throws ExecutionException, InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		FutureTask<Integer> task1 = new FutureTask<>(() -> {
			try {
				TimeUnit.SECONDS.sleep(5);
				log.info("thread execute");
				return 10;
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		});

		executorService.execute(task1);
		Object o = task1.get();
		System.out.println(o);


	}
}
