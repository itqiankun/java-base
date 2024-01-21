package com.itqiankun.manythreadorderexecute;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * author: ma_qiankun
 * date:  2023/12/16
 **/
@Slf4j
public class ThreadPoolOrderExecute {
	public static void main(String[] args) {
		ExecutorService poolExecutor = Executors.newSingleThreadExecutor();

		poolExecutor.submit(() -> {
			log.info("threadA start...");
			
			log.info("threadA end...");
		});

		poolExecutor.submit(() -> {
			log.info("threadB start...");
			
			log.info("threadB end...");
		});

		poolExecutor.submit(() -> {
			log.info("threadC start...");
			
			log.info("threadC end...");
		});

		poolExecutor.shutdown();
	}
}
