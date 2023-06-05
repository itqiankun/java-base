package com.itqiankun.socket;

import java.net.*;
import java.io.*;

/**
 * @author: ma_qiankun
 * @date: 2023/6/5
 **/
public class Server {
    public static void main(String[] args) throws IOException {
        // 1. 创建ServerSocket对象，指定端口号为7777
        ServerSocket serverSocket = new ServerSocket(7777);
        System.out.println("服务器已启动...");

        // 2. 调用accept方法，等待客户端连接
        Socket socket = serverSocket.accept();
        System.out.println("客户端已连接...");

        // 3. 获取输入流和输出流
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        // 4. 读取客户端发送来的数据，并向客户端发送响应
        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            String message = new String(buffer, 0, len);
            System.out.println("接收到客户端发来的消息：" + message);
            outputStream.write(("Server已收到消息：" + message).getBytes());
            outputStream.flush();
        }
        // 5. 关闭资源
        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}

