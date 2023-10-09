package com.itqiankun.netty.base.base;

import sun.security.action.GetPropertyAction;

import java.security.AccessController;

/**
 * @author: ma_qiankun
 * @date: 2023/10/1
 **/
public class Hello {
	public static void main(String[] args) {
		System.out.println(AccessController
				.doPrivileged(new GetPropertyAction("os.name")));
	}
}
