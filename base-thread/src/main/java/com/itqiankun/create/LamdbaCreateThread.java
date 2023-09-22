package com.itqiankun.create;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: ma_qiankun
 * @date: 2023/9/22
 **/
@Slf4j
public class LamdbaCreateThread {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(() -> {
				log.info("当前线程:{}", Thread.currentThread().getName());
			});
			thread.start();
		}
	}
}
