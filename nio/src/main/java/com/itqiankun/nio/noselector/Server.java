package com.itqiankun.nio.noselector;

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
            // 等待客户端连接，如果没有客户端连接，会阻塞到这里
            SocketChannel clisnetChannel = server.accept();
            System.out.println("Client connected: " + clisnetChannel.getRemoteAddress());

            String message = "Hello from server!";
            ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());

            // 发送消息给客户端
            clisnetChannel.write(buffer);
            System.out.println("Message sent to clisnetChannel.");

            // 关闭SocketChannel，服务端不需要关闭，由客户端关闭，然后服务端就自动关闭了
//            clisnetChannel.close();
            System.out.println("Client disconnected.");
        }
    }
}

