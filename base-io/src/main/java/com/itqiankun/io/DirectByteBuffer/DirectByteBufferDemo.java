package com.itqiankun.io.DirectByteBuffer;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @author: ma_qiankun
 * @date: 2023/10/9
 **/
public class DirectByteBufferDemo {
	public static void main(String[] args) {
		//创建ByteBuffer
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		byteBuffer.put("hello byte buffer".getBytes());
		//打印出字节数据
		System.out.println(Arrays.toString(byteBuffer.array()));
		//创建DirectByteBuffer
		ByteBuffer directByteBuffer =
				ByteBuffer.allocateDirect(1024);
		directByteBuffer.put("hello direct byte".getBytes());
				//没有数据，数据存放在堆外内存中

		System.out.println(Arrays.toString(directByteBuffer.array()));
	}
}
