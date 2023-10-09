package com.itqiankun.netty.buffer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: ma_qiankun
 * @date: 2023/9/28
 **/
public class BufferCopyExample {
	public static void main(String[] args) {
		String sourceFile = "/Users/mqk/Desktop/img.png";
		String destinationFile = "/Users/mqk/Desktop/server.png";

		try (FileInputStream fis = new FileInputStream(sourceFile);
		     FileOutputStream fos = new FileOutputStream(destinationFile);
		     FileChannel sourceChannel = fis.getChannel();
		     FileChannel destinationChannel = fos.getChannel()) {

			// 创建一个 4KB 的 ByteBuffer
			ByteBuffer buffer = ByteBuffer.allocate(4096);

			while (sourceChannel.read(buffer) != -1) {
				// 切换到读模式，走到这里的时候，buffer缓存区里面已经满满的都是数据了
				buffer.flip();
				// 这里就是把缓存里面的数据给读出到文件里面，
				destinationChannel.write(buffer);
				// 切换到写模式，并且清空当前buffer缓冲区，准备下一次读取
				buffer.clear();
			}

			System.out.println("文件复制完成！");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

