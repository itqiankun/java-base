package com.itqiankun.operator;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: ma_qiankun
 * @date: 2023/8/4
 **/
@Slf4j
public class Hello {

	@Test
	public  void it_qk() {
		log.info("输出结果:{}",1 & 2*2-1);
		log.info("输出结果:{}",1 & 2*2*2-1);
		log.info("输出结果:{}",1 & 2*2*2*2-1);
		log.info("输出结果:{}",1 & 2*2*2*2*2-1);
		log.info("输出结果:{}",1 & 2*2*2*2*2*2-1);
		log.info("输出结果:{}",1 & 2*2*2*2*2*2*2-1);
		log.info("输出结果:{}",1 & 2*2*2*2*2*2*2*2-1);
		log.info("输出结果:{}",1 & 2*2*2*2*2*2*2*2*2-1);
		log.info("输出结果:{}",1 & 2*2*2*2*2*2*2*2*2*2-1);
	}
	@Test
	public  void it_qk1() {
		log.info("长度:{}",2*2*2*2-1);
		log.info("输出结果:{}",1999 & 2*2*2*2-1);
		log.info("输出结果:{}",198299 & 2*2*2*2-1);
		log.info("输出结果:{}",19199 & 2*2*2*2-1);
		log.info("输出结果:{}",1922299 & 2*2*2*2-1);
		log.info("输出结果:{}",1999991 & 2*2*2*2-1);
		log.info("输出结果:{}",12239993 & 2*2*2*2-1);
		log.info("输出结果:{}",1 & 2*2*2*2-1);
		log.info("输出结果:{}",2 & 2*2*2*2-1);
		log.info("输出结果:{}",5 & 2*2*2*2-1);
	}
}
