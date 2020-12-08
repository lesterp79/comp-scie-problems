/*
 * MinStackLinkedList.java
 *
 * Copyright (c) 2000-2018 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.leetcode.problems.easy.stacks;

public class MinStackLinkedList {

    public static void main(String[] args) {
        MinStackLinkedList obj = new MinStackLinkedList();
        obj.push(-2);
        obj.push(0);
        obj.push(-1);

        System.out.println(obj.getMin());
        System.out.println(obj.top());
        obj.pop();
        System.out.println(obj.getMin());
    }


    public MinStackLinkedList() {
    }

    Node head;



    public void push(int x) {
        if (head == null) {
            head = new Node(x, x);
        } else {
            head = new Node(x, Math.min(x, head.min), head);
        }
    }

    public void pop() {
        if (head == null) {
            return;
        }

        head = head.next;
    }

    public int top() {
        if (head == null) {
            return 0;
        }
        return head.value;
    }

    public int getMin() {
        if (head == null) {
            return 0;
        }
        return head.min;
    }

    static class Node {
        Node next;
        int value;
        int min;

        public Node(int value, int min) {
            this.value = value;
            this.min = min;
        }

        public Node(int value, int min, Node next) {
            this.next = next;
            this.value = value;
            this.min = min;
        }
    }

}


