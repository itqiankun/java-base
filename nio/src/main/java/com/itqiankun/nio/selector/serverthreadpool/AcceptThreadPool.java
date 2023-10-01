package com.itqiankun.nio.selector.serverthreadpool;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author: ma_qiankun
 * @date: 2023/9/28
 **/
public class AcceptThreadPool implements Runnable{

	Selector subSelector;
	ReadOrWriteThread thread;

	public AcceptThreadPool(ReadOrWriteThread thread, Selector subSelector){
		try {
			this.subSelector = subSelector;
			this.thread = thread;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				subSelector.select(1000);
				Iterator<SelectionKey> it = subSelector.selectedKeys().iterator();
				while (it.hasNext()){
					SelectionKey key = it.next();
					it.remove();
					if (key.isAcceptable()) {
						// 处理请求连接的通道
						ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) key.channel();
						SocketChannel socketChannel = serverSocketChannel1.accept();
						socketChannel.configureBlocking(false);
						thread.register(new NioTask(socketChannel));
						System.out.println("接受新连接：" + socketChannel.getRemoteAddress());
					}
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
