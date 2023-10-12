package com.itqiankun.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author: ma_qiankun
 * @date: 2023/10/10
 **/
public class CompletableFutureDemo {



	public static void main(String[] args) throws ExecutionException, InterruptedException {

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

	}
}
