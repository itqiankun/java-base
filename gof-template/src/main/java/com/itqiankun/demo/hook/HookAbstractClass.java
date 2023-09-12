package com.itqiankun.demo.hook;

/**
 * @author: ma_qiankun
 * @date: 2023/9/4
 **/
// 抽象类
public abstract class HookAbstractClass {
	// 模板方法
	public void templateMethod() {
		// 步骤1
		step1();

		// 步骤2
		step2();

		// 钩子函数
		if (hook()) {
			// 钩子函数返回true时执行的逻辑
			hookLogic();
		}

		// 步骤3
		step3();
	}
	// 抽象方法，由子类实现
	protected abstract void step1();

	// 抽象方法，由子类实现
	protected abstract void step2();

	// 抽象方法，由子类实现
	protected abstract void step3();

	protected boolean hook() {
		// 钩子函数的默认实现
		return false;
	}

	protected void hookLogic() {
		// 钩子函数的默认逻辑
	}
}