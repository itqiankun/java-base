package com.itqiankun;

/**
 * @author: ma_qiankun
 * @date: 2023/10/25
 **/
class DoublyNode {
    int data;
    DoublyNode prev;
    DoublyNode next;

    public DoublyNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
