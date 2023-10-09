package com.itqiankun.netty.base.selectortomanythreadproblem;

import lombok.extern.slf4j.Slf4j;

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
@Slf4j
public class AcceptPool implements Runnable{

	private Selector subSelector;
	private Selector parentSelector;


	public AcceptPool(Selector subSelector, Selector parentSelector){
		try {
			this.subSelector = subSelector;
			this.parentSelector = parentSelector;
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
						socketChannel.register(parentSelector, SelectionKey.OP_READ);
						log.info("接受新连接：" + socketChannel.getRemoteAddress());
					}

				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
