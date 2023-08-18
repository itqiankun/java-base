package com.itqiankun.exception.mybatis;

/**
 * @author: ma_qiankun
 * @date: 2023/8/18
 **/
public class ExceptionFactory {

	private ExceptionFactory() {
		// Prevent Instantiation
	}

	public static RuntimeException wrapException(String message, Exception e) {
		return new PersistenceException(ErrorContext.instance().message(message).cause(e).toString(), e);
	}

}

