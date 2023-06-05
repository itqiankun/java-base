package com.itqiankun.socket;

/**
 * @author: ma_qiankun
 * @date: 2023/6/5
 **/
import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException {
        // 1. 创建Socket对象，指定服务器地址和端口号
        Socket socket = new Socket("localhost", 7777);

        // 2. 获取输入流和输出流
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        // 3. 向服务器发送消息，并接收服务器响应
        String message = "Hello, Server!";
        outputStream.write(message.getBytes());
        outputStream.flush();

        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            String response = new String(buffer, 0, len);
            System.out.println("接收到服务器的响应：" + response);
        }
        // 4. 关闭资源
        outputStream.close();
        inputStream.close();
//        socket.close();
    }
}
