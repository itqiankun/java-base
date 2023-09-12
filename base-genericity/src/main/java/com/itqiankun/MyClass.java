package com.itqiankun;

/**
 * @author: ma_qiankun
 * @date: 2023/9/5
 **/
public class MyClass<T extends Number> {
	// 类定义中使用泛型类型参数和上界通配符
	// 这里的 T 可以是 Number 类型或其子类型
	// 例如，MyClass<Integer> 或 MyClass<Double>

	private T value;

	public MyClass(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}
}

