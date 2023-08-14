package com.itqiankun.socket.manyrequest;

/**
 * @author: ma_qiankun
 * @date: 2023/8/7
 **/

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(9999);
			log.info("服务器启动，等待客户端连接...");

			while (true){
				Socket socket = serverSocket.accept(); // 这里如果没有客户端来，会阻塞在这里
				// 一个线程负责一个请求
				Runnable runnable = () -> {
					try {
						log.info("threadName:{}, 客户端已连接：" + Thread.currentThread().getName(), socket.getInetAddress().getHostAddress());

						// 获取输入流和输出流
						BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						PrintWriter writer = new PrintWriter(socket.getOutputStream());

						// 处理请求
						String request = null; // 在接受请求前，会阻塞在这里
						request = reader.readLine();
						log.info("接收到请求：" + request);

						// 假设请求为"GET /hello HTTP/1.1"，则返回"Hello World!"
						String response = "HTTP/1.1 200 OK\r\n\r\nHello World!";
						writer.println(response);
						writer.flush();
						// 关闭连接
						reader.close();
						writer.close();
						socket.close();
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				};
				new Thread(runnable).start();
			}
//			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}