/*
 * MiddleOfLinkedList.java
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

/**
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * <p>
 * If there are two middle nodes, return the second middle node.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4,5] Output: Node 3 from this list (Serialization: [3,4,5]) The returned node has value 3.  (The judge's
 * serialization of this node is [3,4,5]). Note that we returned a ListNode object ans, such that: ans.val = 3, ans.next.val = 4,
 * ans.next.next.val = 5, and ans.next.next.next = NULL. Example 2:
 * <p>
 * Input: [1,2,3,4,5,6] Output: Node 4 from this list (Serialization: [4,5,6]) Since the list has two middle nodes with values 3 and
 * 4, we return the second one.
 */
public class MiddleOfLinkedList {

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode back;

        ListNode forward;

        back = forward = head;

        while (forward.next != null) {
            back = back.next;
            forward = forward.next;
            if (forward.next != null) {
                forward = forward.next;
            }
        }

        return back;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }
}
