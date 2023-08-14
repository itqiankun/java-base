package com.itqiankun.nio.onerequest;

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
        SocketChannel client = SocketChannel.open(new InetSocketAddress("localhost", 8080));
        System.out.println("Connected to server: " + client.getRemoteAddress());

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 从服务器读取消息
        client.read(buffer);
        byte[] bytes = new byte[buffer.position()];
        buffer.flip();
        buffer.get(bytes);
        String message = new String(bytes, "UTF-8");
        System.out.println("Message received from server: " + message);

        // 关闭 SocketChannel
        client.close();
        System.out.println("Disconnected from server.");
    }
}

