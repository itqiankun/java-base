package com.itqiankun.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: ma_qiankun
 * @date: 2023/8/27
 **/
@Slf4j
public class Client {

	@Test
	public void it_qk_console(){
		// 创建具体的任务执行者，就是代理对象
		Printer printer = new ConsolePrinter();

		// 创建委托者，并将任务委托给代理对象
		Printer delegator = new PrinterDelegate(printer);

		// 委托者调用方法，实际执行任务的是代理对象
		delegator.print("Hello, Delegate Pattern!");
	}

	@Test
	public void it_qk_file(){
		// 创建具体的任务执行者，就是代理对象
		Printer printer = new FilePrinter();

		// 创建委托者，并将任务委托给代理对象
		Printer delegator = new PrinterDelegate(printer);

		// 委托者调用方法，实际执行任务的是代理对象
		delegator.print("Hello, Delegate Pattern!");
	}
}
