package com.itqiankun.nio.selector.many;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author: ma_qiankun
 * @date: 2023/6/7
 **/
public class NioDemo {
	public static void main(String[] args) {
		try {
			//1.创建channel
			ServerSocketChannel socketChannel1 = ServerSocketChannel.open();
			//设置为非阻塞模式，默认是阻塞的
			socketChannel1.configureBlocking(false);
			socketChannel1.socket().bind(new InetSocketAddress("127.0.0.1", 8811));

			ServerSocketChannel socketChannel2 = ServerSocketChannel.open();
			socketChannel2.configureBlocking(false);
			socketChannel2.socket().bind(new InetSocketAddress("127.0.0.1", 8822));

			//2.创建selector，并将channel1和channel2进行注册。
			Selector selector = Selector.open();
			socketChannel1.register(selector, SelectionKey.OP_ACCEPT);
			socketChannel2.register(selector, SelectionKey.OP_ACCEPT);

			while (true) {
				//3.一直阻塞直到有至少有一个通道准备就绪,然后又返回值之后就能往下面走了
				int readChannelCount = selector.select();
				Set<SelectionKey> selectionKeys = selector.selectedKeys();
				Iterator<SelectionKey> iterator = selectionKeys.iterator();
				//4.轮训已经就绪的通道
				while (iterator.hasNext()) {
					SelectionKey key = iterator.next();
					//5.判断准备就绪的事件类型，并作相应处理
					if (key.isAcceptable()) {
						// 创建新的连接，并且把连接注册到selector上，并且声明这个channel只对读操作感兴趣。
						ServerSocketChannel serverSocketChannel = (ServerSocketChannel)key.channel();
						SocketChannel socketChannel = serverSocketChannel.accept();
						socketChannel.configureBlocking(false);
						socketChannel.register(selector, SelectionKey.OP_READ);
					}
					if (key.isReadable()) {
						SocketChannel socketChannel = (SocketChannel) key.channel();
						ByteBuffer readBuff = ByteBuffer.allocate(1024);
						socketChannel.read(readBuff);
						readBuff.flip();
						System.out.println("received : " + new String(readBuff.array()));
						System.out.println("received : " + new String(readBuff.array()).trim());
						socketChannel.close();
					}
					iterator.remove();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}