package com.itqiankun.threalocal.InheritableThreadLocal;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: ma_qiankun
 * @date: 2023/11/10
 **/
@Slf4j
public class InheritableThreadLocalDemo {
	public static void main(String[] args) throws InterruptedException {
		Thread parentParent = new Thread(() -> {
			ThreadLocal threadLocal = new ThreadLocal();
			threadLocal.set(1);
			InheritableThreadLocal inheritableThreadLocal = new InheritableThreadLocal();
			inheritableThreadLocal.set(2);

			Thread subThread = new Thread(() -> {
				log.info("threadLocal=" + threadLocal.get());
				log.info("inheritableThreadLocal=" + inheritableThreadLocal.get());
			}, "subThread");
			subThread.start();

		}, "parentParent");
		parentParent.start();
	}

}
