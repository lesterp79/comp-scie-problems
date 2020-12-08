/*
 * AddTwoNumbers.java
 *
 * Copyright (c) 2000-2019 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.leetcode.problems.medium.linkedlists;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(8);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(5);

        final ListNode x = new AddTwoNumbers().addTwoNumbers(l1, l2);

        ListNode n = x;
        while (n != null) {
            System.out.println(n.val + " -> " );
            n = n.next;

        }

        System.out.println(x);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2 ){
        return addTwo(l1, l2, 0);
    }
    public ListNode addTwo(ListNode l1, ListNode l2, int remainder) {

        if (l1 == null && l2 == null) {
            if (remainder > 0) {
                return new ListNode(remainder);
            } else {
                return null;
            }
        }

        if (l1 == null) {
            if (remainder == 0) {
                return l2;
            } else {
                l1 = new ListNode(remainder);
                remainder = 0;
            }
        }

        if (l2 == null) {
            if (remainder == 0) {
                return l1;
            } else {
                l2 = new ListNode(remainder);
                remainder = 0;
            }
        }

        final int x = (l1.val + l2.val + remainder);
        ListNode node = new ListNode(x % 10);
        node.next = addTwo(l1.next, l2.next, x / 10);
        return node;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }
}
