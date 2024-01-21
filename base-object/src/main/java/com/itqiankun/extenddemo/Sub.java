package com.itqiankun.extenddemo;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: ma_qiankun
 * @date: 2023/11/14
 **/
@Slf4j
public class Sub extends Parent{
	public void say(){
		log.info("saySub");
	}

	public static void main(String[] args) {
		Sub sub = new Sub();
		sub.say();
		sub.sayHello();
	}
}
