/*
 * RemoveElements.java
 *
 * Copyright (c) 2000-2019 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.leetcode.problems.easy.linkedlists;

public class RemoveElements {

    public ListNode removeElementsRec(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        head.next = removeElementsRec(head.next, val);

        if (head.val == val) {
            return head.next;
        } else {
            return head;
        }
    }

    public ListNode removeElementsIter(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode prev = head;
        ListNode ahead = head.next;

        while(ahead != null) {
            if (ahead.val == val) {
                prev.next = ahead.next;
            } else {
                prev = prev.next;
            }

            ahead = ahead.next;
        }
        return head;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }
}
