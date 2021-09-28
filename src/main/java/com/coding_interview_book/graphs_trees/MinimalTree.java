/*
 * MinimalTree.java
 *
 * Copyright (c) 2000-2018 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.coding_interview_book.graphs_trees;

import com.util.BTreePrinter;
import com.util.DoublyLinkedTreeNode;
import com.util.BTreeNode;

/**
 * Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algorithm
 * to create a binary search tree with minimal height.
 * Hints: #19, #73, #176
 */
public class MinimalTree {
    public static void main(String[] args) {
        int[] listNumbers = new int[]{1, 2, 4, 4, 5, 6, 7, 8, 9, 12, 13, 35, 36, 45, 56, 79};

        BTreeNode root = minimalTree(listNumbers, 0, listNumbers.length - 1);

        BTreePrinter.printNode(root);
    }

    public static BTreeNode minimalTree(int numbers[], int lower, int upper) {

        if (lower > upper) {
            return null;
        }

        int middle = (upper + lower) / 2;

        BTreeNode<Integer> n = new BTreeNode<>(numbers[middle]);

        n.left = minimalTree(numbers, lower, middle - 1);
        n.right = minimalTree(numbers, middle + 1, upper);

        return n;
    }

    static DoublyLinkedTreeNode minimalDoublyLinkedTree(int numbers[], int lower, int upper, DoublyLinkedTreeNode aParent) {

        if (lower > upper) {
            return null;
        }

        int middle = (upper + lower) / 2;

        DoublyLinkedTreeNode<Integer> n = new DoublyLinkedTreeNode<>(numbers[middle], aParent);

        n.left = minimalDoublyLinkedTree(numbers, lower, middle - 1, n);
        n.right = minimalDoublyLinkedTree(numbers, middle + 1, upper, n);

        return n;
    }
}
