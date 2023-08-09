package com.itqiankun.io.inputstream;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author: ma_qiankun
 * @date: 2023/8/8
 **/
@Slf4j
public class InPutStreamDemo {

	/**
	 * 绝对路径文件不存在，FileNotFoundException异常
	 * @throws IOException
	 */
	@Test
	public void it_qk() throws IOException {
		FileInputStream inputStream = new FileInputStream("/Users/mqk/Desktop/mqk-worker/mqk-code/java-base/base-io/output/it_qk1.txt");
		int read = inputStream.read();
		System.out.println(read);
	}
	/**
	 * 相对路径，不带文件夹的文件不存在，FileNotFoundException异常
	 * @throws IOException
	 */
	@Test
	public void it_qk1() throws IOException {
		FileInputStream inputStream = new FileInputStream("xxxx.txt");
		int read = inputStream.read();
		System.out.println(read);
	}
}
