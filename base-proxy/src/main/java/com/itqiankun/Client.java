package com.itqiankun;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * @author: ma_qiankun
 * @date: 2023/9/21
 **/
public class Client {
	public static void main(String[] args) {
//		it_qk_proxy_source();
		it_qk_proxy_execute();
	}


	public static void it_qk_proxy_source(){
		// 保存代理类的字节码到文件
		byte[] proxyClassBytes = ProxyGenerator.generateProxyClass(
				"$Proxy", // 代理类的名称
				new Class[]{UserService.class} // 代理类实现的接口列表
		);
		try (FileOutputStream fos = new FileOutputStream("$Proxy.class")) {
			fos.write(proxyClassBytes);
			System.out.println("代理类已保存到文件 ProxyClassExample.class");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void it_qk_proxy_execute(){
		UserServiceProxy userServiceProxy = new UserServiceProxy(new UserServiceImpl());
		Class<UserServiceImpl> clazz = UserServiceImpl.class;
		UserService userService = (UserService) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), userServiceProxy);
		userService.getUserByName("nameArg");
	}


}
