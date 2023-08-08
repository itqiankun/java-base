package com.itqiankun.socket.two;

/**
 * @author: ma_qiankun
 * @date: 2023/6/5
 **/
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8888);
        System.out.println("连接服务器成功...");

        // 开启一个新的线程，用于从服务器中读取数据
        Thread readThread = new Thread(() -> {
            try {
                InputStream inputStream = socket.getInputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len = inputStream.read(buffer)) != -1) {
                    String response = new String(buffer, 0, len);
                    System.out.println("接收到服务器的响应：" + response);
                }
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        readThread.start();

        // 向服务器发送数据
        OutputStream outputStream = socket.getOutputStream();
        String message = "Hello, Server!";
        outputStream.write(message.getBytes());
        outputStream.flush();

        // 等待读取数据的线程结束后再关闭 Socket
        try {
            readThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 关闭资源
        outputStream.close();
        socket.close();
    }
}


