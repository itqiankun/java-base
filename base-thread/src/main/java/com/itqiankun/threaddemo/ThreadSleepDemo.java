package com.itqiankun.threaddemo;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: ma_qiankun
 * @date: 2023/10/16
 **/
@Slf4j
public class ThreadSleepDemo {

	public static void main(String[] args) {
		Thread thread = new Thread(new Task());
		thread.start();
	}

}

class Task implements Runnable {
	@Override
	public void run() {
		while(true) {
			if( shouldRun() ) { // 符合业务规则就运行
				doSomething();
			} else {
				try {
					//休眠1s,继续去判断是否可运行
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}

	private void doSomething() {

	}
	private boolean shouldRun() {   //根据具体业务规则进行判断
		return false;
	}
}
