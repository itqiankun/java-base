package com.itqiankun.io.outputstream;

import org.junit.Test;

import java.io.*;

/**
 * @author: ma_qiankun
 * @date: 2023/8/8
 **/
public class OutPutStreamDemo {

	/**
	 * 绝对路径，文件不存在，FileNotFoundException异常
	 * @throws IOException
	 */
	@Test
	public void it_qk() throws IOException {
		FileOutputStream outputStream = new FileOutputStream(new File("/Users/mqk/Desktop/mqk-worker/mqk-code/java-base/base-io/output/it_qk1.txt"));
		outputStream.write(97);
		outputStream.write(98);
		outputStream.write(99);
		outputStream.close();
	}

	/**
	 * 相对路径，带文件夹的文件不存在，FileNotFoundException异常
	 * @throws IOException
	 */
	@Test
	public void it_qk1() throws IOException {
		FileOutputStream outputStream = new FileOutputStream(new File("output/it_qk1.txt"));
		outputStream.write(97);
		outputStream.write(98);
		outputStream.write(99);
		outputStream.close();
	}

	/**
	 * 相对路径，不带文件夹的文件不存在，自动创建文件
	 * @throws IOException
	 */
	@Test
	public void it_qk2() throws IOException {
		FileOutputStream outputStream = new FileOutputStream(new File("auto_file.txt"));
		outputStream.write(97);
		outputStream.write(98);
		outputStream.write(99);
		outputStream.close();
	}


}
