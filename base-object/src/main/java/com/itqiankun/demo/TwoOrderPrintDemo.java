package com.itqiankun.demo;

/**
 * author: ma_qiankun
 * date:  2023/12/25
 **/
public class TwoOrderPrintDemo {

	public static void main(String[] args) {
		Object o = new Object();
		final Integer[] count = {0};

		Thread threadOne = new Thread(() -> {
			while (true){
				synchronized (o){
					if(count[0]<100){
						if(count[0] % 2 == 1 ){
							System.out.println(Thread.currentThread().getName()+":"+ count[0]);
							try {
								o.wait();
							} catch (InterruptedException e) {
								throw new RuntimeException(e);
							}

						}
						count[0]++;
						o.notify();
					}

				}
			}
		});

		Thread threadTwo = new Thread(() -> {
			while (true){
				synchronized (o){
					if(count[0] < 100){
						if(count[0] % 2 == 0 ){
							System.out.println(Thread.currentThread().getName()+":"+ count[0]);
							try {
								o.wait();
							} catch (InterruptedException e) {
								throw new RuntimeException(e);
							}
						}
						count[0]++;
						o.notify();
					}
				}
			}


		});

		threadOne.start();
		threadTwo.start();
	}
}
