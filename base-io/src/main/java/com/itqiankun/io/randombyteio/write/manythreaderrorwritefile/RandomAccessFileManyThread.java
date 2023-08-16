package com.itqiankun.io.randombyteio.write.manythreaderrorwritefile;

import java.io.RandomAccessFile;

/**
 * @author: ma_qiankun
 * @date: 2023/8/14
 **/
public class RandomAccessFileManyThread {

	/**
	 * 这种方式打印文本就会出现NUL不合法的文本
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String userDir = System.getProperty("user.dir")+"/base-io/";
		RandomAccessFile raf = new RandomAccessFile(userDir+"it_qk_random_write_file.txt", "rw");
		for (int i = 0; i < 10; i++) {
			int finalI = i;
			Runnable runnable = () -> {
				try {
					raf.seek(finalI * 16);
					System.out.println("后"+raf.getFilePointer());
					raf.write(String.format("第%s个字符串", finalI).getBytes());
				} catch (Exception e) {
					throw new RuntimeException(e);
				}

			};
			new Thread(runnable).start();
		}
	}
}

