package com.itqiankun.io.filedescriptor;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: ma_qiankun
 * @date: 2023/10/5
 **/
@Slf4j
public class FileDescriptorCustom {

	@Test
	public void it_qk() {

		try {
			// 创建文件输出流并获取其底层文件描述符
			FileOutputStream fos = new FileOutputStream("example.txt");
			FileDescriptor fdOut = fos.getFD();

			// 使用底层文件描述符创建自定义的输出流
			MyCustomOutputStream customOutputStream = new MyCustomOutputStream(fdOut);

			// 写入数据到文件
			String data = "Hello, World!";
			byte[] bytes = data.getBytes();
			customOutputStream.write(bytes);

			customOutputStream.close();

			// 创建文件输入流并获取其底层文件描述符
			FileInputStream fis = new FileInputStream("example.txt");
			FileDescriptor fdIn = fis.getFD();

			// 使用底层文件描述符创建自定义的输入流
			MyCustomInputStream customInputStream = new MyCustomInputStream(fdIn);

			// 读取文件内容
			int dataByte;
			while ((dataByte = customInputStream.read()) != -1) {
				System.out.print((char) dataByte);
			}

			customInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 自定义的输出流，基于底层文件描述符进行操作
	class MyCustomOutputStream extends FileOutputStream {
		public MyCustomOutputStream(FileDescriptor fd) {
			super(fd);
		}

		// 可以在这里添加自定义的写入方法或重写父类的写入方法
		// ...
	}

	// 自定义的输入流，基于底层文件描述符进行操作
	class MyCustomInputStream extends FileInputStream {
		public MyCustomInputStream(FileDescriptor fd) {
			super(fd);
		}

		// 可以在这里添加自定义的读取方法或重写父类的读取方法
		// ...
	}

}
