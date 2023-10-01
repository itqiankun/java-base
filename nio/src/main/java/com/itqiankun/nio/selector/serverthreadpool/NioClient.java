package com.itqiankun.nio.selector.serverthreadpool;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author: ma_qiankun
 * @date: 2023/6/7
 **/
public class NioClient {
	public static void main(String[] args) {
		try {
			// 创建 Selector
			Selector selector = Selector.open();

			// 创建 SocketChannel 并注册到 Selector
			SocketChannel socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);
			socketChannel.connect(new InetSocketAddress("127.0.0.1", 7888));
			socketChannel.register(selector, SelectionKey.OP_CONNECT);

			// 循环处理通道
			while (true) {
				System.out.println("client select before");
				// 没有需要处理的监听事件，会被阻塞住
				selector.select();
				System.out.println("client select after");
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				Iterator<SelectionKey> iterator = selectedKeys.iterator();

				while (iterator.hasNext()) {
					SelectionKey key = iterator.next();
					iterator.remove();

					if (key.isConnectable()) {
						SocketChannel channel = (SocketChannel) key.channel();
						if (channel.isConnectionPending()) {
							channel.finishConnect();
						}
						channel.register(selector, SelectionKey.OP_WRITE);
					}

					if (key.isWritable()) {
						SocketChannel channel = (SocketChannel) key.channel();
						String message = "Hello, Server!";
						ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
						channel.write(buffer);
						channel.register(selector, SelectionKey.OP_READ);
					}

					if (key.isReadable()) {
						SocketChannel channel = (SocketChannel) key.channel();
						ByteBuffer buffer = ByteBuffer.allocate(1024);
						int bytesRead = channel.read(buffer);
						if (bytesRead == -1) {
							channel.close();
							break;
						}
						buffer.flip();
						byte[] data = new byte[buffer.limit()];
						buffer.get(data);
						String response = new String(data);
						System.out.println("服务器响应：" + response);
						// 关闭连接
//						channel.close();
						key.cancel();
						System.out.println("客户端SocketChannel.close()成功");
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

