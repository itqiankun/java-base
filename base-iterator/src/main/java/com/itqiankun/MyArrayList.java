package com.itqiankun;

import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T> {
	private T[] elements;
	private int size;

	public MyArrayList(T[] elements) {
		this.elements = elements;
		this.size = elements.length;
	}

	// 实现Iterable接口的iterator()方法，返回一个迭代器对象
	@Override
	public Iterator<T> iterator() {
		return new MyItr();
	}

	// 自定义迭代器类实现Iterator接口
	private class MyItr implements Iterator<T> {
		private int currentIndex;

		public MyItr() {
			this.currentIndex = 0;
		}

		@Override
		public boolean hasNext() {
			return currentIndex != size;
		}

		@Override
		public T next() {
			return elements[currentIndex++];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("remove() method is not supported.");
		}
	}

	public static void main(String[] args) {
		String[] names = {"Alice", "Bob", "Charlie", "Dave"};

		// 创建自定义集合对象
		MyArrayList<String> collection = new MyArrayList<>(names);

		// 使用增强的for循环遍历集合中的元素
		for (String name : collection) {
			System.out.println(name);
		}

		System.out.println("-----");

		// 使用迭代器遍历集合中的元素
		Iterator<String> iterator = collection.iterator();
		while (iterator.hasNext()) {
			String name = iterator.next();
			System.out.println(name);
		}
	}
}
