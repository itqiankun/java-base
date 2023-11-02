package com.itqiankun.netty.ByteBufAllocator;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import org.junit.Test;

/**
 * @author: ma_qiankun
 * @date: 2023/10/19
 **/
public class ByteBufAllocatorExample {

	@Test
	public void it_qk_buffer(){
		ByteBufAllocator allocator = ByteBufAllocator.DEFAULT;
		ByteBuf buffer = allocator.buffer();
		buffer.writeBytes("Hello, Netty!".getBytes());
		byte[] data = new byte[buffer.readableBytes()];
		buffer.readBytes(data);
		System.out.println(new String(data));
		buffer.release();
	}

	@Test
	public void it_qk_direct_buffer(){
		ByteBufAllocator allocator = ByteBufAllocator.DEFAULT;
		ByteBuf buffer = allocator.directBuffer();
		buffer.writeBytes("Hello, Netty!".getBytes());
		byte[] data = new byte[buffer.readableBytes()];
		buffer.readBytes(data);
		System.out.println(new String(data));
		buffer.release();
	}



}

