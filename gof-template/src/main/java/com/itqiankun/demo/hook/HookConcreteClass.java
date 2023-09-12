package com.itqiankun.demo.hook;

/**
 * @author: ma_qiankun
 * @date: 2023/9/4
 **/
// 具体类
public class HookConcreteClass extends HookAbstractClass {
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

	@Override
	protected boolean hook() {
		// 子类覆盖钩子函数，返回true
		return true;
	}

	@Override
	protected void hookLogic() {
		// 钩子函数返回true时执行的自定义逻辑
		System.out.println("hookLogic");
	}
}
