package com.itqiankun.interrupt;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author: ma_qiankun
 * @date: 2023/6/11
 **/
@Slf4j
public class InterruptNoBlockThread {
	private static int i;
	public static void main(String[] args) throws InterruptedException {
		Thread thread=new Thread(()->{
			while(! Thread.currentThread().isInterrupted()){
				i++;
			}
			log.info("thread end result:{}", i);
		});
		thread.start();

		TimeUnit.SECONDS.sleep(1);
		thread.interrupt();
	}
}
