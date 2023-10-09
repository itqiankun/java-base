package com.itqiankun.netty.base.base;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author: ma_qiankun
 * @date: 2023/6/7
 **/
@Slf4j
public class NioServer {

    public static void main(String[] args) {
        try {
            openServer(7888);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void openServer(int port) throws IOException {
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        ssChannel.configureBlocking(false);
        ssChannel.socket().bind(new InetSocketAddress(port));
        Selector selector = Selector.open();
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        // 一直循环
        while (true){
            System.out.println("server select before");
            // 没有需要处理的监听事件，会被阻塞住
            selector.select(1000);
            System.out.println("server select after");
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()){
                SelectionKey sk = it.next();
                it.remove();
                if(sk.isAcceptable()){
                    log.info("server execute key.isAcceptable()");
                    ServerSocketChannel channel = (ServerSocketChannel) sk.channel();
                    SocketChannel sChannel = channel.accept();
                    sChannel.configureBlocking(false);
                    sChannel.register(selector, SelectionKey.OP_READ);
                }
                else if(sk.isReadable()){
                    log.info("server execute key.isReadable()");
                    SocketChannel sChannel = (SocketChannel) sk.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    while (sChannel.read(buffer) > 0){
                        buffer.flip();
                        String response = new String(buffer.array(), 0, buffer.limit());
                        System.out.println(response);
                        buffer.clear();
                    }
                    sChannel.register(selector, SelectionKey.OP_WRITE);
                } else if(sk.isWritable()){
                    log.info("server execute key.isWritable()");
                    SocketChannel sChannel = (SocketChannel) sk.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    buffer.put("server response".getBytes());
                    buffer.flip();
                    sChannel.write(buffer);
                    buffer.clear();
                    sk.cancel();
                }
            }
        }
    }

}