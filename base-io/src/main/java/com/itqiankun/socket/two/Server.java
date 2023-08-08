package com.itqiankun.socket.two;

/**
 * @author: ma_qiankun
 * @date: 2023/6/5
 **/import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务器已启动...");

        // 等待客户端请求
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("客户端已连接...");

            // 创建一个新的线程，为该连接进行处理
            new Thread(() -> {
                try {
                    InputStream inputStream = clientSocket.getInputStream();
                    OutputStream outputStream = clientSocket.getOutputStream();

                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = inputStream.read(buffer)) != -1) {
                        String message = new String(buffer, 0, len);
                        System.out.println("接收到客户端发来的消息：" + message);
                        // 向客户端发送响应
                        outputStream.write(("已收到消息：" + message).getBytes());
                        outputStream.flush();
                    }
                    // 关闭资源
                    outputStream.close();
                    inputStream.close();
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}

