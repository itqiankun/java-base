package com.itqiankun.netty.base.serverpool;

import cn.hutool.core.util.ObjectUtil;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: ma_qiankun
 * @date: 2023/9/28
 **/
@Slf4j
public class ServerThread implements Runnable{

	Selector selector;

	List<NioTask>  nioTasks = Lists.newArrayList();

	private ReentrantLock taskMainLock = new ReentrantLock();

	public ServerThread(){
		try {
			this.selector = Selector.open();
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
						// 处理读取就绪事件
						SocketChannel socketChannel = (SocketChannel)key.channel();
						try {
							ByteBuffer buffer = ByteBuffer.allocate(1024);
							int len;
							String request = null;
							while ((len = socketChannel.read(buffer)) > 0){
								buffer.flip();
								request = new String(buffer.array(), 0, len);
								log.info(request);
								buffer.clear();
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
						 socketChannel.register(selector, SelectionKey.OP_WRITE);
					} else if (key.isWritable()) {
						// 处理读取就绪事件
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

				if(ObjectUtil.isNotEmpty(nioTasks)){
					Iterator<NioTask> iterator = nioTasks.iterator();
					while (iterator.hasNext()){
						NioTask nioTask = iterator.next();
						SocketChannel sc = nioTask.getSc();
						sc.register(selector,  SelectionKey.OP_READ);
						iterator.remove();
					}
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public void register(NioTask task) {
		if (task != null) {
			try {
				taskMainLock.lock();
				nioTasks.add(task);
			} finally {
				taskMainLock.unlock();
			}
		}
	}

}
