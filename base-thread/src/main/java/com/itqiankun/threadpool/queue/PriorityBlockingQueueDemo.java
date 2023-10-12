package com.itqiankun.threadpool.queue;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author: ma_qiankun
 * @date: 2023/10/9
 **/
@Slf4j
public class PriorityBlockingQueueDemo {
	public static void main(String[] args) {
		ExecutorService pool = new ThreadPoolExecutor(3, 3, 1000, TimeUnit.MILLISECONDS,
				new PriorityBlockingQueue<>(500), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
		for(int i=0;i<20;i++) {
			PriorityThread command = new PriorityThread();
			command.setPriority(i);
			pool.execute(command);
		}
	}
}

class PriorityThread implements  Runnable,Comparable<PriorityThread>{
	private int priority;

	public int getPriority() {
	return priority;
	}

	public void setPriority(int priority) {
	this.priority = priority;
	}
	//当前对象和其他对象做比较，当前优先级大就返回-1，优先级小就返回1,值越小优先级越高
	public int compareTo(PriorityThread o) {
	return  this.priority>o.priority?-1:1;
	}
	public void run() {
		try {
			//让线程阻塞，使后续任务进入缓存队列
			Thread.sleep(1000);
			System.out.println("priority:"+this.priority+",ThreadName:"+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
 }