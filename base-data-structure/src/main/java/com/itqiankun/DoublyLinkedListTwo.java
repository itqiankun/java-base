package com.itqiankun;

/**
 * @author: ma_qiankun
 * @date: 2023/10/25
 **/
public class DoublyLinkedListTwo {
    private DoublyNode head;
    private DoublyNode tail;

    public DoublyLinkedListTwo() {
        this.head = null;
        this.tail = null;
    }

    public void addToEnd(int data) {
        DoublyNode newDoublyNode = new DoublyNode(data);
        if (tail == null) {
            head = newDoublyNode;
            tail = newDoublyNode;
        } else {
            tail.next = newDoublyNode;
            newDoublyNode.prev = tail;
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
        DoublyLinkedListTwo list = new DoublyLinkedListTwo();
        list.addToEnd(1);
        list.addToEnd(4);
        list.printList();
    }
}
