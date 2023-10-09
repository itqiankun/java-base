package com.itqiankun.netty.base.selectortomanythreadproblem;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author: ma_qiankun
 * @date: 2023/9/28
 **/
@Slf4j
public class ServerThread implements Runnable{

	Selector selector;

	public ServerThread(Selector selector){
		try {
			this.selector = selector;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				selector.select(1000);
				Iterator<SelectionKey> it = selector.selectedKeys().iterator();
				while (it.hasNext()){
					SelectionKey key = it.next();
					it.remove();
					if (key.isReadable()) {
						log.info("key.isReadable() execute");
						// 处理读取就绪事件
						SocketChannel socketChannel = (SocketChannel)key.channel();
						try {
							ByteBuffer buffer = ByteBuffer.allocate(1024);
							int len;
							String request = null;
							while ((len = socketChannel.read(buffer)) > 0){
								buffer.flip();
								request = new String(buffer.array(), 0, len);
								System.out.println(request);
								buffer.clear();
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
						 socketChannel.register(selector, SelectionKey.OP_WRITE);
					} else if (key.isWritable()) {
						log.info("key.isWritable() execute");
						SocketChannel socketChannel = (SocketChannel)key.channel();
						try {
							ByteBuffer buffer = ByteBuffer.allocate(1024);
							String response = "服务器收到消息：";
							buffer.put(response.getBytes());
							buffer.flip();
							socketChannel.write(buffer);
							buffer.clear();
							key.cancel();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}


}
