package com.itqiankun.common;

import lombok.Data;

/**
 * @author: ma_qiankun
 * @date: 2023/9/7
 **/
@Data
public class MyClass {
	public int publicField =1;
	private String privateField;
	protected boolean protectedField;
	int defaultField;
	// 省略其他代码...
}

