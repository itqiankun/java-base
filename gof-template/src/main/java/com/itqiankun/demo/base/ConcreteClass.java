package com.itqiankun.demo.base;

import com.itqiankun.demo.base.AbstractClass;

/**
 * @author: ma_qiankun
 * @date: 2023/9/4
 **/
// 具体类
public class ConcreteClass extends AbstractClass {
	@Override
	protected void step1() {
		// 子类实现步骤1
		System.out.println("step1");
	}

	@Override
	protected void step2() {
		// 子类实现步骤2
		System.out.println("step2");
	}

	@Override
	protected void step3() {
		// 子类实现步骤3
		System.out.println("step3");
	}
}
