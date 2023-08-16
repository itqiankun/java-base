package com.itqiankun.io.randombyteio.write;

import org.junit.Test;

import java.io.RandomAccessFile;

/**
 * @author: ma_qiankun
 * @date: 2023/8/14
 **/
public class RandomAccessFileManyThread {

	/**
	 * 这种多线程方式打印不会再文本里面出现NUL
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) {
		String userDir = System.getProperty("user.dir")+"/base-io/";
		for (int i = 0; i < 10; i++) {
			int finalI = i;
			Runnable runnable = () -> {
				try(RandomAccessFile raf = new RandomAccessFile(userDir+"it_qk_random_write_file.txt", "rw")) {
					System.out.println((raf.getFilePointer()));
					raf.seek(finalI*16);
					raf.write(String.format("第%s个字符串", finalI).getBytes());
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			};
			new Thread(runnable).start();
		}
	}
}

