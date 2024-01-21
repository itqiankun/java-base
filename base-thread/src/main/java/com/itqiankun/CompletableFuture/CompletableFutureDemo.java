package com.itqiankun.CompletableFuture;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: ma_qiankun
 * @date: 2023/10/10
 **/
@Slf4j
public class CompletableFutureDemo {


	@Test
	public void it_qk() throws InterruptedException, ExecutionException {
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			return 20000;
		});

		Integer integer = future.get();
		System.out.println(integer);
		Thread.sleep(10000);
	}

	@Test
	public  void it_qk_thenApply() throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
			log.info("supplyAsync execute");
			return 20000;
		}, executorService
		).thenApply(x->{
			log.info("thenApply arg:{}", x);
			return x;
		});
		Integer integer = future.get();
		log.info("final result:{}", integer);
		Thread.sleep(10000);
	}


	@Test
	public  void it_qk_thenAccept() throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		CompletableFuture.supplyAsync(() -> {
			log.info("supplyAsync execute");
			return 20000;
		}, executorService
		).thenAccept(x->{
			log.info("thenAccept arg:{}", x);
		});
		Thread.sleep(10000);
	}


	@Test
	public  void it_qk_thenRun() throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		CompletableFuture.supplyAsync(() -> {
			log.info("supplyAsync execute");
			return 20000;
		}, executorService
		).thenRun(()->{
			log.info("thenRun arg");
		});
		Thread.sleep(10000);
	}


}
