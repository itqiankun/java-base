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
import java.net.Socket;
@Slf4j
public class Client {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 9999);
			log.info("已连接服务器：" + socket.getRemoteSocketAddress());

			// 获取输入流和输出流
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(socket.getOutputStream());

			// 发送请求
			String request = "GET /hello HTTP/1.1";
			writer.println(request);
			writer.flush();

			// 接收响应
			String response = reader.readLine(); // 在接受响应前，会阻塞在这里
			log.info("接收到响应：" + response);

			// 关闭连接
			reader.close();
			writer.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
