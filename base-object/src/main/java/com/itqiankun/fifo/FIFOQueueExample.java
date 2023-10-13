package com.itqiankun.fifo;

import java.util.LinkedList;
import java.util.Queue;

public class FIFOQueueExample {
	public static void main(String[] args) {
		Queue<String> fifoQueue = new LinkedList<>();

		// 添加元素到队列
		fifoQueue.offer("A");
		fifoQueue.offer("B");
		fifoQueue.offer("C");

		// 从队列中取出元素并打印
		while (!fifoQueue.isEmpty()) {
			String element = fifoQueue.poll();
			System.out.println("Element: " + element);
		}
	}
}

