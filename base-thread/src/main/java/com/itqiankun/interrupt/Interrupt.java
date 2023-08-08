package com.itqiankun.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @author: ma_qiankun
 * @date: 2023/6/11
 **/
public class Interrupt {
	private static int i;
	public static void main(String[] args) throws InterruptedException {
		Thread thread=new Thread(()->{
			while(! Thread.currentThread().isInterrupted()){
				i++;
			}
			System.out.println("itqiankun.com:"+i);
		});
		thread.start();

		TimeUnit.SECONDS.sleep(1);
		thread.interrupt();
	}
}
