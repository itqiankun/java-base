package com.itqiankun.nio.noselector.exception;

/**
 * @author: ma_qiankun
 * @date: 2023/6/5
 **/

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    public static void main(String[] args) throws Exception {
        // 连接到服务器
        SocketChannel clientChannel = SocketChannel.open(new InetSocketAddress("localhost", 8080));
        System.out.println("Connected to server: " + clientChannel.getRemoteAddress());

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 发送消息
        buffer.put("hello".getBytes());
        while (buffer.hasRemaining()) {
            clientChannel.write(buffer);
        }

        buffer.clear();

        while (clientChannel.read(buffer) != -1){
            buffer.flip();
            System.out.println(new String(buffer.array(), 0, buffer.limit()));
            buffer.clear();
        }

        // 关闭 SocketChannel
        clientChannel.close();
        System.out.println("Disconnected from server.");
    }
}

