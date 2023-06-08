package com.itqiankun.nio.selector.one;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author: ma_qiankun
 * @date: 2023/6/7
 **/
public class NioClient {
	public static void main(String[] args) {
		try {
			connect("127.0.0.1", 8888);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void connect(String host, int port) throws IOException {
		// 打开通道
		SocketChannel sChannel = SocketChannel.open();
		//  通道设置为非阻塞
		sChannel.configureBlocking(false);
		//  连接
		sChannel.connect(new InetSocketAddress(host, port));
		//  选择器
		Selector selector = Selector.open();
		//  把通道注册到选择器，监听读事件
		sChannel.register(selector, SelectionKey.OP_READ);

		while (!sChannel.finishConnect()) ;

		//  开启一个线程读数据
		new Thread(new Runnable() {
			@Override
			public void run() {
				// 定义缓冲区
				ByteBuffer buffer = ByteBuffer.allocate(1024);
				try {
					// 轮询
					while (selector.select() > 0) {
						Iterator<SelectionKey> it = selector.selectedKeys().iterator();
						while (it.hasNext()) {
							SelectionKey sk = it.next();
							//  读事件
							if (sk.isReadable()) {
								int len;
								while ((len = sChannel.read(buffer)) > 0) {
									sChannel.read(buffer);
									buffer.flip();
									String str = new String(buffer.array(), 0, len);
									System.out.println("服务端返回信息:" + str);
									buffer.clear();
								}
							}
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();

		//  主线程写数据
		Scanner sc = new Scanner(System.in);
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		while (true) {
			String str = sc.next();
			if ("quit".equals(str)) {
				break;
			}
			buffer.put(str.getBytes());
			buffer.flip();
			sChannel.write(buffer);
			buffer.clear();
		}
		// 关闭通道
		sChannel.close();
	}
}

