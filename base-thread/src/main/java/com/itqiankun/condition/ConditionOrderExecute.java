package com.itqiankun.condition;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: ma_qiankun
 * date:  2023/12/30
 **/
@Slf4j
public class ConditionOrderExecute {


	public static final ReentrantLock reenTrantLock = new ReentrantLock();
	public static final AtomicInteger atomicInteger = new AtomicInteger(-1);
	public static void main(String[] args) {
		Condition condition1 = reenTrantLock.newCondition();
		Condition condition2 = reenTrantLock.newCondition();
		Condition condition3 = reenTrantLock.newCondition();

		String strA ="A";
		String strB ="B";
		String strC ="C";
		Thread threadA = new Thread(() -> {
			while (true){
				reenTrantLock.lock();
				log.info("sout :{}", strA);
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				condition2.signal();
				if((atomicInteger.get() == -1) || (atomicInteger.incrementAndGet() % 3 != 0)){
					try {
						condition1.await();
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
				reenTrantLock.unlock();
			}
		}, "a");
		Thread threadB = new Thread(() -> {
			while (true){
				reenTrantLock.lock();
				log.info("sout :{}", strB);
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				condition3.signal();
				if(atomicInteger.incrementAndGet() % 3 != 1){
					try {
						condition2.await();
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}


				reenTrantLock.unlock();
			}
		},"b");
		Thread threadC = new Thread(() -> {
			while (true){
				reenTrantLock.lock();
				log.info("sout :{}", strC);
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				condition1.signal();
				if(atomicInteger.incrementAndGet() % 3 != 2){
					try {
						condition3.await();
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
				reenTrantLock.unlock();
			}
		},"c");
		threadA.start();
		threadB.start();
		threadC.start();


	}

}
