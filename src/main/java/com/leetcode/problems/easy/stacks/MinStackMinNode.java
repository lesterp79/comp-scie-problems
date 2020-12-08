/*
 * MinStackMinNode.java
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

public class MinStackMinNode {

    public static void main(String[] args) {
//["MinStack","push","push","push","getMin","top","pop","getMin"]
//[[],[-2],[0],[-1],[],[],[],[]]
        MinStackMinNode obj = new MinStackMinNode();
        obj.push(-2);
        obj.push(0);
        obj.push(-1);

        System.out.println(obj.getMin());
        System.out.println(obj.top());
        obj.pop();
        System.out.println(obj.getMin());
    }

    Node head;

    int min = Integer.MAX_VALUE;

    public void push(int x) {
        if (x <= min) {
            head = new Node(x, new Node(min, head));
            min = x;
        } else {
            head = new Node(x, head);
        }
    }

    public void pop() {
        if (head == null) {
            return;
        }

        if (head.value == min) {
            head = head.next;
            min = head.value;
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
        return min;
    }

    static class Node {
        Node next;
        int value;


        public Node(int value, Node next) {
            this.next = next;
            this.value = value;
        }
    }
}
