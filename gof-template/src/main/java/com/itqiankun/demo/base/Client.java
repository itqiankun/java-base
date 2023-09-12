package com.itqiankun.demo.base;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: ma_qiankun
 * @date: 2023/9/4
 **/
@Slf4j
public class Client {

	@Test
	public void it_qk(){
		ConcreteClass concreteClass = new ConcreteClass();
		concreteClass.templateMethod();
	}
}
