package com.itqiankun.io;


import java.io.*;
import java.net.Socket;

/**
 * @author: ma_qiankun
 * @date: 2023/9/27
 **/
public class Client {
	public static void main(String[] args) throws IOException {
		File file = new File("/Users/mqk/Desktop/img.png");

		uploadFile(file);
	}

	private static void uploadFile(File file) throws IOException {
		if (!file.exists())
			throw new IOException("文件不存在！");

		Socket s = new Socket("127.0.0.1", 10011);
		BufferedOutputStream out = new BufferedOutputStream(s.getOutputStream());
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));

		byte[] byt = new byte[1024];
		int len = 0;
		int count = 0;
		while ((len=in.read(byt)) != -1) {
			out.write(byt,0,len);
			out.flush();
		}
		s.shutdownOutput();


		InputStream instm  = s.getInputStream();
		int lenIn = instm.read(byt);
		String text = new String(byt,0,lenIn);
		System.out.println(text);

		in.close();
		s.close();
	}
}