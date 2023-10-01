package com.itqiankun.nio.selector.serverpool;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: ma_qiankun
 * @date: 2023/9/28
 **/
@Slf4j
public class AcceptPool implements Runnable{

	private Selector subSelector;

	private AtomicInteger atomicInteger;

	ServerThreadGroup serverThreadGroup;


	public AcceptPool(Selector subSelector){
		try {
			this.subSelector = subSelector;
			this.atomicInteger = new AtomicInteger(0);
			serverThreadGroup = new ServerThreadGroup();
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
						// 遍历往各个线程里面添加任务
						int i = atomicInteger.incrementAndGet();
						int index = i % serverThreadGroup.getServerThreads().length;
						serverThreadGroup.getServerThreads()[index].register(new NioTask(socketChannel));
						log.info("接受新连接：" + socketChannel.getRemoteAddress());
					}
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
