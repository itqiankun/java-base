package com.itqiankun.execption;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author: ma_qiankun
 * @date: 2023/10/10
 **/
@Slf4j
public class CompletableFutureExceptionDemo {


	@Test
	public void it_qk() throws InterruptedException, ExecutionException {
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
			int i = 1 / 0;
			System.out.println("hello");
			return 2000;
		}).handle((x,e)->{
			log.info("last result:{}", x);
			log.info("exception info:{}", e);
			return x;
		});

		Integer integer = future.get();
		System.out.println(integer);
		Thread.sleep(10000);
	}



}
