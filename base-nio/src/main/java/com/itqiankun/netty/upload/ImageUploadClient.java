package com.itqiankun.netty.upload;

/**
 * @author: ma_qiankun
 * @date: 2023/9/28
 **/
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
public class ImageUploadClient {
	public static void main(String[] args) {
		String serverHost = "localhost";
		int serverPort = 8080;
		String filePath = "/Users/mqk/Desktop/img.png";

		try {
			// 创建客户端的 SocketChannel
			SocketChannel socketChannel = SocketChannel.open();
			socketChannel.connect(new InetSocketAddress(serverHost, serverPort));
			socketChannel.configureBlocking(true);

			// 读取图片文件
			Path imagePath = Paths.get(filePath);
			FileChannel fileChannel = FileChannel.open(imagePath);
			ByteBuffer buffer = ByteBuffer.allocate(1024);

			// 发送图片数据到服务器
			log.info("fileChannel.read() before.");
			while (fileChannel.read(buffer) > 0) {
				log.info("fileChannel.read() read().");
				buffer.flip();
				socketChannel.write(buffer);
				buffer.clear();
			}

			// 关闭连接和文件通道
			fileChannel.close();
			socketChannel.close();
			System.out.println("Image uploaded successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
