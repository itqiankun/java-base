package com.itqiankun.threadpool.orderexecute;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * author: ma_qiankun
 * date:  2023/12/15
 **/
@Slf4j
public class ThreadPoolOrderExecuteDemo {

	@Test
	public void it_qk() throws Exception {
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
		FutureTask<Integer> task1 = new FutureTask<>(() -> {
			try {
				TimeUnit.SECONDS.sleep(5);
				log.info("thread execute");
				return 10;
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		});

		FutureTask<Integer> task2 = new FutureTask<>(() -> {
			try {
				TimeUnit.SECONDS.sleep(5);
				log.info("thread execute");
				return 10;
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		});

		ScheduledFuture<?> schedule1 = scheduledExecutorService.schedule(task1, 0, TimeUnit.SECONDS);
//		ScheduledFuture<?> schedule = scheduledExecutorService.schedule(task2, schedule1.get(), TimeUnit.SECONDS);


	}


}
