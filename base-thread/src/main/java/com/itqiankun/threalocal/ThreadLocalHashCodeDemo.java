package com.itqiankun.threalocal;

import java.lang.reflect.Field;

/**
 * @author: ma_qiankun
 * @date: 2023/11/10
 **/
public class ThreadLocalHashCodeDemo {
	public static void main(String[] args) throws InterruptedException {
		Thread parentParent = new Thread(() -> {
			ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
			threadLocal.set(1);
			try {
				getPrivateValue(threadLocal);
				getPrivateValue(threadLocal);
				getPrivateValue(threadLocal);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}

			ThreadLocal<Integer> threadLocalTwo = new ThreadLocal<>();
			threadLocalTwo.set(100);
			try {
				getPrivateValue(threadLocalTwo);
				getPrivateValue(threadLocalTwo);
				getPrivateValue(threadLocalTwo);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}

		}, "parentParent");
		parentParent.start();
	}


	public static void getPrivateValue(ThreadLocal instance) throws Exception {
		// 获取类的 Class 对象
		Class<?> clazz = ThreadLocal.class;

		// 获取私有属性 Field 对象
		Field field = clazz.getDeclaredField("threadLocalHashCode");

		// 设置 Field 对象可访问
		field.setAccessible(true);

		// 获取私有属性的值
		int value = (int) field.get(instance);

		System.out.println("Private Field Value: " + value);
	}
}
