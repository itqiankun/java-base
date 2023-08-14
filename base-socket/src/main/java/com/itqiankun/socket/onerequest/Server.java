package com.itqiankun.socket.onerequest;

/**
 * @author: ma_qiankun
 * @date: 2023/8/7
 **/
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.*;

@Slf4j
public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(9999);
			log.info("服务器启动，等待客户端连接...");

			Socket socket = serverSocket.accept(); // 这里如果没有客户端来，会阻塞在这里
			log.info("客户端已连接：" + socket.getInetAddress().getHostAddress());

			// 获取输入流和输出流
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(socket.getOutputStream());

			// 处理请求
			String request = reader.readLine(); // 在接受请求前，会阻塞在这里
			log.info("接收到请求：" + request);

			// 假设请求为"GET /hello HTTP/1.1"，则返回"Hello World!"
			String response = "HTTP/1.1 200 OK\r\n\r\nHello World!";
			writer.println(response);
			writer.flush();

			// 关闭连接
			reader.close();
			writer.close();
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}