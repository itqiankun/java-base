package com.itqiankun.doublylinkedlist;

/**
 * @author: ma_qiankun
 * @date: 2023/10/9
 **/

public class DoublyLinkedList {
	private Node head;
	private Node tail;

	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public void addToHead(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
	}

	public void addToEnd(int data) {
		Node newNode = new Node(data);
		if (tail == null) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
		}
	}

	public void printList() {
		Node current = head;
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

class Node {
	int data;
	Node prev;
	Node next;

	public Node(int data) {
		this.data = data;
		this.prev = null;
		this.next = null;
	}
}
