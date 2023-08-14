package com.itqiankun.nio.onerequest;

/**
 * @author: ma_qiankun
 * @date: 2023/6/5
 **/
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server {
    public static void main(String[] args) throws Exception {
        // 创建一个 ServerSocketChannel 并绑定端口
        ServerSocketChannel server = ServerSocketChannel.open();
        server.bind(new InetSocketAddress("localhost", 8080));
        System.out.println("Server started, listening on port 8080...");

        while (true) {
            // 等待客户端连接
            SocketChannel client = server.accept();
            System.out.println("Client connected: " + client.getRemoteAddress());

            String message = "Hello from server!";
            ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());

            // 发送消息给客户端
            client.write(buffer);
            System.out.println("Message sent to client.");

            // 关闭 SocketChannel
            client.close();
            System.out.println("Client disconnected.");
        }
    }
}

