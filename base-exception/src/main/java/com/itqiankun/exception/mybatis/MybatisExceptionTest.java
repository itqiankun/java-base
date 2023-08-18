package com.itqiankun.exception.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: ma_qiankun
 * @date: 2023/8/18
 **/
@Slf4j
public class MybatisExceptionTest {

	@Test
	public void it_qk(){
		try {
			String  str = null;
			System.out.println(str.getBytes());
		} catch (Exception e) {
			throw ExceptionFactory.wrapException("mybatis exception test.", e);
		}
	}
}
