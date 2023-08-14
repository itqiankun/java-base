package com.itqiankun.io.byteio.outputstream;

import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: ma_qiankun
 * @date: 2023/8/8
 **/
public class BufferStreamFlushDemo {


	@Test
	public void it_qk_noFlush() throws IOException {
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("it_qk1.txt"));
		// 写入数据到缓冲区
		for (int y=0;y<1000;y++){
			String data = "Hello, world!\r\n";
			bufferedOutputStream.write(data.getBytes());
//			bufferedOutputStream.flush();
		}
	}

	@Test
	public void it_qk_flush() throws IOException {
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("it_qk1.txt"));
		// 写入数据到缓冲区
		for (int y=0;y<1000;y++){
			String data = "Hello, world!\r\n";
			bufferedOutputStream.write(data.getBytes());
			bufferedOutputStream.flush();
		}
	}

	@Test
	public void it_qk_noFlush_butClose() throws IOException {
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("it_qk1.txt"));
		// 写入数据到缓冲区
		for (int y=0;y<1000;y++){
			String data = "Hello, world!\r\n";
			bufferedOutputStream.write(data.getBytes());
		}
		bufferedOutputStream.close();
	}

	@Test
	public void it_qk_fileOutPutStream_not_need_flush() throws IOException {
		FileOutputStream outputStream = new FileOutputStream("it_qk1.txt");
		// 写入数据到缓冲区
		for (int y=0;y<1000;y++){
			String data = "Hello, world!\r\n";
			outputStream.write(data.getBytes());
		}
	}

	@Test
	public void it_qk_hello()  {
		for (int yz = 0; yz <10; yz++) {
			for (int i=1;i<10000;i++){
				StringBuilder stringBuilder = new StringBuilder();
				for (int y=1;y<1000;y++){
					stringBuilder.append("hello"+i+y);
				}
				System.out.println(stringBuilder);
			}
		}
	}



}
