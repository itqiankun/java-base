package com.itqiankun.nio.upload;

import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import java.util.Iterator;

/**
 * @author: ma_qiankun
 * @date: 2023/9/28
 **/
@Slf4j
public class ImageUploadServer {
	public static void main(String[] args) throws Exception {
		int port = 8080;

		// 创建服务器端的 ServerSocketChannel
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.bind(new InetSocketAddress(port));
		serverSocketChannel.configureBlocking(false);

		// 创建 Selector
		Selector selector = Selector.open();
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

		log.info("Server started on port :{} " , port);
		while (true) {
			// 服务端启动后，会在这里阻塞住，只有客户端监听后才能阻塞结束
			selector.select();
			log.info("selector.select() after.");

			Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
			while (keyIterator.hasNext()) {
				SelectionKey key = keyIterator.next();
				keyIterator.remove();

				if (key.isAcceptable()) {
					// 有新的连接到达
					SocketChannel clientChannel = serverSocketChannel.accept();
					clientChannel.configureBlocking(false);
					clientChannel.register(selector, SelectionKey.OP_READ);
					log.info("Accepted new connection from :{} " ,  clientChannel.getRemoteAddress());
				} else if (key.isReadable()) {
					// 有数据可读
					SocketChannel clientChannel = (SocketChannel) key.channel();
					ByteBuffer buffer = ByteBuffer.allocate(1024);
					int bytesRead = clientChannel.read(buffer);

					if (bytesRead == -1) {
						// 客户端关闭连接
						clientChannel.close();
						log.info("Connection closed by client");
					} else {
						// 将读取到的数据写入文件
						buffer.flip();
						Path filePath = Paths.get("/Users/mqk/Desktop/server.png");
						try (FileChannel fileChannel = FileChannel.open(filePath,
								EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.APPEND))) {
							fileChannel.write(buffer);
						}
						buffer.clear();
					}
				}
			}
		}
	}
}

