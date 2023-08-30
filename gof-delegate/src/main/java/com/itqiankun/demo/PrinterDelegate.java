package com.itqiankun.demo;

/**
 * @author: ma_qiankun
 * @date: 2023/8/27
 **/
public class PrinterDelegate implements Printer {

	private Printer printer;

	public PrinterDelegate(Printer printer) {
		this.printer = printer;
	}

	@Override
	public void print(String message) {
		// 执行委托的任务
		printer.print(message);
	}
}
