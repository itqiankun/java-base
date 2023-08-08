package com.itqiankun.timeuint;

import java.util.concurrent.TimeUnit;

/**
 * @author: ma_qiankun
 * @date: 2023/6/11
 **/
public class TimeUnitSleep {
	public static void main(String[] args) {
		new Thread(()->{
			try {
				TimeUnit.SECONDS.sleep( 5 );
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println( "son thread sleep 5 second end .");
		}).start();
		System.out.println("main thread end.");
	}

}
