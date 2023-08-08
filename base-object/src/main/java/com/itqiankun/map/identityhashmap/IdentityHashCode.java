package com.itqiankun.map.identityhashmap;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: ma_qiankun
 * @date: 2023/8/4
 **/
@Slf4j
public class IdentityHashCode {
	@Test
	public void it_qk(){
		Integer integer = 1;
		Integer integer1 = new Integer(1);

		log.info("打印:{}", integer == integer1);
		log.info("打印:{}", System.identityHashCode(integer));
		log.info("打印:{}", System.identityHashCode(integer1));
	}

	@Test
	public void it_qk2(){
		Integer integer = 128;
		Integer integer1 = 128;

		log.info("打印:{}", integer == integer1);
		log.info("打印:{}", System.identityHashCode(integer));
		log.info("打印:{}", System.identityHashCode(integer1));
	}

	@Test
	public void it_qk3(){
		Integer integer = 127;
		Integer integer1 = 127;

		log.info("打印:{}", integer == integer1);
		log.info("打印:{}", System.identityHashCode(integer));
		log.info("打印:{}", System.identityHashCode(integer1));
	}

}
