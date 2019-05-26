/*
 * MergeLinkedLists.java
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
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the
 * first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4
 */
public class MergeSortedLinkedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

}