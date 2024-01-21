package com.itqiankun.extenddemo;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: ma_qiankun
 * @date: 2023/11/15
 **/
@Slf4j
public class GrandParent {

	public void say(){
		log.info("sayGrandParent");
	}

	public void sayHello(){
		log.info("sayHelloGrandParent");
	}

}
