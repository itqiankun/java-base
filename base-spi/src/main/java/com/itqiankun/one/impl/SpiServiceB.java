package com.itqiankun.one.impl;

import com.itqiankun.one.SpiService;

/**
 * @author: ma_qiankun
 * @date: 2023/11/8
 **/
public class SpiServiceB implements SpiService {
	@Override
	public void hello() {
		System.out.println("console SpiServiceB");
	}
}
