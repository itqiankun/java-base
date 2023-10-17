package com.itqiankun.interrupt;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author: ma_qiankun
 * @date: 2023/6/11
 **/
@Slf4j
public class InterruptBlockThreadTwo {
	private static int i;

	public static void main(String[] args) throws InterruptedException {
		Thread thread=new Thread(()->{
			log.info("isInterrupted() result:{}", Thread.currentThread().isInterrupted());
			while (! Thread.currentThread().isInterrupted()){
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// 这里因为`interrupt()`一个阻塞线程，所以会走到这里，并且会把中断状态的`true`变成`false`
					log.info("thread end  isInterrupted() result:{}", Thread.currentThread().isInterrupted());
					// 因为上面的中断状态`变成了false`，所以这里需要重新进行中断，这样while循环才会结束
					Thread.currentThread().interrupt();
				}
			}
			log.info("thread end result:"+i);
		});
		thread.start();

		TimeUnit.SECONDS.sleep(1);
		thread.interrupt();
	}
}
