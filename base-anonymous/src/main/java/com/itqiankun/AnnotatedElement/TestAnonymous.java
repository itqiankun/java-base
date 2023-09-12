package com.itqiankun.AnnotatedElement;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: ma_qiankun
 * @date: 2023/9/5
 **/
@Slf4j
public class TestAnonymous {

	@Test
	public  void it_qk() {
		Father fatherDefault = new Father();
		log.info("name() result :{}", fatherDefault.name());
		log.info("son() result :{}", fatherDefault.son());
		Father father = Father.createFather();
		log.info("name() result :{}", father.name());
		log.info("son() result :{}", father.son());
	}
}
