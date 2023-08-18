package com.itqiankun.customexception;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: ma_qiankun
 * @date: 2023/8/18
 **/
@Slf4j
public class CustomExceptionDemo {
	@Test
	public void it_qk_custom_exception(){
		try {
			// 抛出自定义异常
			throw new CustomException("This is a custom exception.");
		} catch (CustomException e) {
			// 捕获自定义异常并处理
			log.info("Custom exception caught." , e);
		}
	}
}
