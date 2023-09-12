package com.itqiankun.demo.base;

/**
 * @author: ma_qiankun
 * @date: 2023/9/4
 **/
// 抽象类
public abstract class AbstractClass {
	// 模板方法
	public final void templateMethod() {
		// 步骤1
		step1();

		// 步骤2
		step2();

		// 步骤3
		step3();
	}

	// 抽象方法，由子类实现
	protected abstract void step1();

	// 抽象方法，由子类实现
	protected abstract void step2();

	// 抽象方法，由子类实现
	protected abstract void step3();
}