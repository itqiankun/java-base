package com.itqiankun.io.filterinputstream;

import cn.hutool.core.date.StopWatch;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author: ma_qiankun
 * @date: 2023/8/8
 **/
@Slf4j
public class BufferedInputStreamDemo {
	/**
	 * 生成测试文本，大概10m
	 * @throws Exception
	 */
	@Test
	public void it_qk_writer() throws Exception {
		FileOutputStream outputStream = new FileOutputStream("it_qk1.txt");

		for (int yz = 0; yz <1; yz++) {
			StringBuilder stringBuilder = new StringBuilder();
			for (int i=1;i<1000;i++){
				for (int y=1;y<1000;y++){
					stringBuilder.append("hello"+i+y);
				}
			}
			outputStream.write(stringBuilder.toString().getBytes());
		}

		outputStream.close();
	}

	/**
	 * read()不用缓冲区，10m的文本内容用8s
	 * @throws Exception
	 */
	@Test
	public void it_qk_read() throws Exception {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		FileInputStream inputStream = new FileInputStream("it_qk1.txt");
		int n = inputStream.read();
		while (n!=-1){
//			System.out.println(n);
			n = inputStream.read();
		}
		stopWatch.stop();
		inputStream.close();
		System.out.println(stopWatch.getTotalTimeSeconds());
	}


	/**
	 * read()用BufferedInputStream自带的缓冲区，10m的文本内容用0.2s
	 * @throws Exception
	 */
	@Test
	public void it_qk_read_buffer() throws Exception {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("it_qk1.txt"));
		int n = bufferedInputStream.read();
		while (n != -1){
//			System.out.println(n);
			n = bufferedInputStream.read();
		}
		stopWatch.stop();
		bufferedInputStream.close();
		System.out.println(stopWatch.getTotalTimeSeconds());
	}

	/**
	 * BufferedInputStream在调用read(byte[] byte)的时候，BufferedInputStream的缓冲区就没有效果了，
	 * 因为bufferedInputStream.read(bytes)调用的还是FileInputStream的read(bytes)方法，消耗0.07s
	 * @throws Exception
	 */
	@Test
	public void it_qk_buffer_not_worker() throws Exception {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("it_qk1.txt"));
		byte[] bytes = new byte[1024];
		while (bufferedInputStream.read(bytes)!=-1){
			System.out.println(new String(bytes, bytes.length));
		}
		stopWatch.stop();
		bufferedInputStream.close();
		System.out.println(stopWatch.getTotalTimeSeconds());
	}

	/**
	 * FileInputStream用自己的byte[]数组缓冲，消耗0.07s
	 * @throws Exception
	 */
	@Test
	public void it_qk_read_byte() throws Exception {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		FileInputStream inputStream = new FileInputStream("it_qk1.txt");
		byte[] bytes = new byte[1024];
		while (inputStream.read(bytes)!=-1){
			System.out.println(new String(bytes, bytes.length));
		}
		stopWatch.stop();
		inputStream.close();
		System.out.println(stopWatch.getTotalTimeSeconds());
	}
}
