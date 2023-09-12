package com.itqiankun.demo.hook;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: ma_qiankun
 * @date: 2023/9/4
 **/
@Slf4j
public class HookClient {

	@Test
	public void it_qk(){
		HookConcreteClass concreteClass = new HookConcreteClass();
		concreteClass.templateMethod();
	}
}
