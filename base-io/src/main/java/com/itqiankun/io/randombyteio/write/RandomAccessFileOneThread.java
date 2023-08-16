package com.itqiankun.io.randombyteio.write;

import org.junit.Test;

import java.io.RandomAccessFile;

/**
 * @author: ma_qiankun
 * @date: 2023/8/14
 **/
public class RandomAccessFileOneThread {

	@Test
	public void it_qk_writer() throws Exception {
		RandomAccessFile raf = new RandomAccessFile("file.txt", "rw");
		long filePointer = raf.getFilePointer();
		System.out.println(filePointer);
		raf.write("第1个字符串".getBytes());
		long filePointer1 = raf.getFilePointer();
		System.out.println(filePointer1);
		raf.write("第2个字符串".getBytes());
		long filePointer2 = raf.getFilePointer();
		System.out.println(filePointer2);
		raf.close();
	}

	@Test
	public void it_qk_writer_two() throws Exception {
		RandomAccessFile raf = new RandomAccessFile("file.txt", "rw");
		long filePointer = raf.getFilePointer();
		System.out.println(filePointer);
		raf.write("第1个字符串".getBytes());
		long filePointer1 = raf.getFilePointer();
		System.out.println(filePointer1);
		raf.seek(16);
		raf.write("第2个字符串".getBytes());
		long filePointer2 = raf.getFilePointer();
		System.out.println(filePointer2);
		raf.close();
	}
	@Test
	public void it_qk_writer_all_zero() throws Exception {
		RandomAccessFile raf = new RandomAccessFile("file.txt", "rw");
		long filePointer = raf.getFilePointer();
		System.out.println(filePointer);
		raf.write("第1个字符串".getBytes());
		long filePointer1 = raf.getFilePointer();
		System.out.println(filePointer1);
		raf.seek(0);
		raf.write("第2个字符串".getBytes());
		long filePointer2 = raf.getFilePointer();
		System.out.println(filePointer2);
		raf.close();
	}

	@Test
	public void it_qk_writer_two_error() throws Exception {
		RandomAccessFile raf = new RandomAccessFile("file.txt", "rw");
		long filePointer = raf.getFilePointer();
		System.out.println(filePointer);
		raf.write("第1个字符串".getBytes());
		long filePointer1 = raf.getFilePointer();
		System.out.println(filePointer1);
		raf.seek(15);
		raf.write("第2个字符串".getBytes());
		long filePointer2 = raf.getFilePointer();
		System.out.println(filePointer2);
		raf.close();
	}

	@Test
	public void it_qk_writer_one_thread() throws Exception {
		RandomAccessFile raf = new RandomAccessFile("file.txt", "rw");
		for (int i = 0; i < 10; i++) {
			raf.seek(16 * i);
			raf.write(String.format("第%s个字符串", i).getBytes());
		}
		raf.close();
	}


}

