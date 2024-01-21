package com.itqiankun;

import javax.annotation.PostConstruct;

/**
 * @author: ma_qiankun
 * @date: 2023/11/11
 **/
public class PostConstructDemo {
	@PostConstruct
	public void init() {
		// 在对象初始化后执行的初始化操作
		System.out.println("Initialization complete.");
	}

	public static void main(String[] args) {
		// 注解使用不生效
		PostConstructDemo postConstructDemo = new PostConstructDemo();
	}
}
