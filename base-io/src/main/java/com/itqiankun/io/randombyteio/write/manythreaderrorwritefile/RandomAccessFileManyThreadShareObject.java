package com.itqiankun.io.randombyteio.write.manythreaderrorwritefile;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author: ma_qiankun
 * @date: 2023/8/14
 **/
public class RandomAccessFileManyThreadShareObject  implements Runnable {
	private RandomAccessFile raf;
	private long position;
	private byte[] data;

	public RandomAccessFileManyThreadShareObject(RandomAccessFile raf, long position, byte[] data) {
		this.raf = raf;
		this.position = position;
		this.data = data;
	}

	@Override
	public void run() {
		try {
			// 定位到指定的位置
			raf.seek(position);

			// 写入数据
			raf.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Main {

	/**
	 * 这种方式打印会出现NUL
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String userDir = System.getProperty("user.dir")+"/base-io/";
			// 创建 RandomAccessFile 对象，以读写方式打开文件
			RandomAccessFile raf = new RandomAccessFile(userDir+"example.txt", "rw");

			// 创建多个线程进行文件写入
			Thread thread1 = new Thread(new RandomAccessFileManyThreadShareObject(raf, 0, "Hello".getBytes()));
			Thread thread2 = new Thread(new RandomAccessFileManyThreadShareObject(raf, 5, "World".getBytes()));
			Thread thread3 = new Thread(new RandomAccessFileManyThreadShareObject(raf, 10, "World".getBytes()));
			Thread thread4 = new Thread(new RandomAccessFileManyThreadShareObject(raf, 15, "World".getBytes()));
			Thread thread5 = new Thread(new RandomAccessFileManyThreadShareObject(raf, 20, "World".getBytes()));

			// 启动线程
			thread1.start();
			thread2.start();
			thread3.start();
			thread4.start();
			thread5.start();

			// 等待线程执行完成
			thread1.join();
			thread2.join();
			thread3.join();
			thread4.join();
			thread5.join();

			// 关闭 RandomAccessFile
			raf.close();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}


