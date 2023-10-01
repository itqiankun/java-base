package com.itqiankun.nio.buffer;

import java.nio.ByteBuffer;

/**
 * @author: ma_qiankun
 * @date: 2023/9/28
 **/
public class BufferStringExample {
	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		buffer.put("hello world".getBytes());

		// 切换成读模式
		buffer.flip();

		String response = new String(buffer.array(), 0, buffer.limit());
		System.out.println("获取字符串：" + response);
	}
}

