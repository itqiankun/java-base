package com.itqiankun;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: ma_qiankun
 * @date: 2023/9/21
 **/
public class UserServiceProxy implements InvocationHandler {
	// 目标类对象
	private Object target;

	// 获取目标类对象
	public UserServiceProxy(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("代理类名称"+proxy.getClass());
		System.out.println("执行代理方法");
		return method.invoke(target, args);
	}
}
