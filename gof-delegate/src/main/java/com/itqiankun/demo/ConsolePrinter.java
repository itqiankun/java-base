package com.itqiankun.demo;

/**
 * @author: ma_qiankun
 * @date: 2023/8/27
 **/
public class ConsolePrinter implements Printer {
	@Override
	public void print(String message) {
		System.out.println("console context: " + message);
	}
}