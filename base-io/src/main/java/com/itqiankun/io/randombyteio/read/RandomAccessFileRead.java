package com.itqiankun.io.randombyteio.read;

import org.junit.Test;

import java.io.RandomAccessFile;

/**
 * @author: ma_qiankun
 * @date: 2023/8/14
 **/
public class RandomAccessFileRead {

	@Test
	public void it_qk_writer() throws Exception {
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
	public void it_qk_read() throws Exception {
		RandomAccessFile raf = new RandomAccessFile("file.txt", "rw");
		raf.seek(16);
		byte[] bytes = new byte[16];
		raf.read(bytes);
		System.out.println(new String(bytes));
		raf.close();
	}


}

