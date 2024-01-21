package com.itqiankun.manythreadorderexecute;

import lombok.extern.slf4j.Slf4j;

/**
 * author: ma_qiankun
 * date:  2023/12/16
 **/
public class ManyThreadOutputOrderNum {
	public static volatile int count =0;

	public static void main(String[] args) {
		Object o = new Object();
		new Thread(new Seq(0,o)).start();
		new Thread(new Seq(1, o)).start();
		new Thread(new Seq(2, o)).start();


	}
}

@Slf4j
class Seq implements Runnable{

	private final int i;
	private final Object o;

	public Seq(int i, Object o){
		this.i=i;
		this.o = o;
	}

	@Override
	public void run() {
		while (ManyThreadOutputOrderNum.count < 100){
			synchronized (o){
				try {
					while (ManyThreadOutputOrderNum.count   % 3 != i){
						o.wait();
					}
					log.info("count:{}", ManyThreadOutputOrderNum.count);
					ManyThreadOutputOrderNum.count++;
					o.notifyAll();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
}
