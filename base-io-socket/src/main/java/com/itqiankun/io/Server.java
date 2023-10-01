package com.itqiankun.io;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: ma_qiankun
 * @date: 2023/9/27
 **/

public class Server {
	public static void main(String[] args) throws IOException {
		File file = new File("/Users/mqk/Desktop/server.jpg");
		if (!file.exists())
			file.createNewFile();
		fileReceive(file);
	}

	private static void fileReceive(File file) throws IOException {
		if (!file.exists())
			throw new IOException("文件" + file + "不存在！");
		ServerSocket ss = new ServerSocket(10011);
		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip + "is connnected.");
		BufferedInputStream bufIn = new BufferedInputStream(s.getInputStream());
		FileOutputStream out = new FileOutputStream(file);

		byte[] byt = new byte[1024];
		int len = 0;
		while ((len = bufIn.read(byt)) != -1) {
			out.write(byt, 0, len);
		}
		System.out.println("文件接收完成，发送完成确认.");
		OutputStream outStm = s.getOutputStream();
		outStm.write("上传成功".getBytes());
		out.close();
		s.close();
	}
}
