package com.itqiankun.deadlock;

/**
 * author: ma_qiankun
 * date:  2023/12/15
 **/
public class MustDeadLock implements Runnable {
	//标记位, 不同的线程根据标记位执行不同的代码
	int flag = 1 ;

	//两把锁
	static Object o1 = new Object();
	static Object o2 = new Object();

	public static void main(String[] args) {
		MustDeadLock r1 = new MustDeadLock();
		MustDeadLock r2 = new MustDeadLock();
		//给不同的线程, 设置不同的标记位
		r1.flag=1;
		r2.flag=2;

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}

	@Override
	public void run() {
		//打印出标记位
		System.out.println("flag = "+flag);
		if (flag == 1) {
			synchronized (o1) {

				try {
					//线程1持有锁o1, 并且等待500ms ,让线程2执行
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//线程1尝试去获取锁o2
				synchronized (o2) {
					System.out.println("线程1成功拿到两把锁");
				}

			}
		}

		if (flag == 2) {

			synchronized (o2) {

				try {
					//持有锁o2, 并且等待500ms ,让线程1执行
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				//线程2尝试去获取锁o1
				synchronized (o1) {
					System.out.println("线程2成功拿到两把锁");
				}
			}
		}
	}

}

