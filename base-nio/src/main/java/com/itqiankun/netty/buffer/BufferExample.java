package com.itqiankun.netty.buffer;

import java.nio.ByteBuffer;

/**
 * @author: ma_qiankun
 * @date: 2023/9/28
 **/
public class BufferExample {
	public static void main(String[] args) {
		// 创建一个容量为 10 的 ByteBuffer
		ByteBuffer buffer = ByteBuffer.allocate(10);

		// 写入数据
		buffer.put((byte) 1);
		buffer.put((byte) 2);
		buffer.put((byte) 3);

		// 切换到读模式
		buffer.flip();

		// 读取数据
		while (buffer.hasRemaining()) {
			byte data = buffer.get();
			System.out.println(data);
		}
	}
}

