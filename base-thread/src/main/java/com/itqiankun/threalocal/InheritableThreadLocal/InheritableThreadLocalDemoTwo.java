package com.itqiankun.threalocal.InheritableThreadLocal;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author: ma_qiankun
 * @date: 2023/11/10
 **/
@Slf4j
public class InheritableThreadLocalDemoTwo {
	public static void main(String[] args) throws InterruptedException {
		Thread parentParent = new Thread(new Runnable() {
			@Override
			public void run() {
				ThreadLocal threadLocal = new ThreadLocal();
				threadLocal.set(1);
				InheritableThreadLocal inheritableThreadLocal = new InheritableThreadLocal();
				inheritableThreadLocal.set(2);


				new Thread(() -> {
					while (true){
						log.info("threadLocal=" + threadLocal.get());
						log.info("inheritableThreadLocal=" + inheritableThreadLocal.get());
						try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							throw new RuntimeException(e);
						}

					}
				}).start();

				for (int i = 0; i < 100; i++) {
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
					inheritableThreadLocal.set(20);
				}
			}
		}, "父线程");
		parentParent.start();
	}

}
