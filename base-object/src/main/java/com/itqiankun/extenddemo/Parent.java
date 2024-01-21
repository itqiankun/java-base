package com.itqiankun.extenddemo;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: ma_qiankun
 * @date: 2023/11/14
 **/
@Slf4j
public class Parent extends GrandParent{

	public void say(){
		log.info("sayParent");
	}

	public void sayHello(){
		log.info("sayHelloParent");
	}

}
