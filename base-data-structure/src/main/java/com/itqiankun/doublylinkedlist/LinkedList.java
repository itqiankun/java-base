package com.itqiankun.doublylinkedlist;

/**
 * @author: ma_qiankun
 * @date: 2023/10/10
 **/
public class LinkedList {
	private Node head;

	// 在链表末尾添加节点
	public void append(int data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

	// 打印链表中的元素
	public void display() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.append(1);
		list.append(2);
		list.append(3);
		list.display(); // 输出: 1 2 3

	}

}


class Node {
	int data; // 节点数据
	Node next; // 下一个节点的引用

	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}


