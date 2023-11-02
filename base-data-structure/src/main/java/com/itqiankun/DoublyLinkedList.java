package com.itqiankun;

/**
 * @author: ma_qiankun
 * @date: 2023/10/9
 **/

public class DoublyLinkedList {
	private DoublyNode head;
	private DoublyNode tail;

	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public void addToHead(int data) {
		DoublyNode newDoublyNode = new DoublyNode(data);
		if (head == null) {
			head = newDoublyNode;
			tail = newDoublyNode;
		} else {
			newDoublyNode.next = head;
			head.prev = newDoublyNode;
			head = newDoublyNode;
		}
	}

	public void addToEnd(int data) {
		DoublyNode newDoublyNode = new DoublyNode(data);
		if (tail == null) {
			head = newDoublyNode;
			tail = newDoublyNode;
		} else {
			newDoublyNode.prev = tail;
			tail.next = newDoublyNode;
			tail = newDoublyNode;
		}
	}

	public void printList() {
		DoublyNode current = head;
		System.out.print("List: ");
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.addToHead(3);
		list.addToHead(2);
		list.addToHead(1);
		list.addToEnd(4);
		list.printList();
	}
}

