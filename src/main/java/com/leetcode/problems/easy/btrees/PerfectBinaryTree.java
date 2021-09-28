/*
 * IsPerfectBinaryTree.java
 *
 * Copyright (c) 2000-2019 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.leetcode.problems.easy.btrees;

import com.coding_interview_book.graphs_trees.MinimalTree;
import com.util.BTreeNode;
import com.util.BTreePrinter;

public class PerfectBinaryTree {

    public static void main(String[] args) {
        int[] listNumbers = new int[]{1, 2, 4, 3, 6, 7, -8, 9, -10, 10, 8, 9, 0, 2, 0};

        BTreeNode root = MinimalTree.minimalTree(listNumbers, 0, listNumbers.length - 1);

        BTreePrinter.printNode(root);

        System.out.println(new PerfectBinaryTree().isPerfect(root) != -1);
    }

    public int isPerfect(BTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftPerfectHeight = isPerfect(root.left);

        if (leftPerfectHeight == -1) {
            return -1;
        }

        int rightPerfectHeight = isPerfect(root.right);

        if (rightPerfectHeight == -1) {
            return -1;
        }

        if (leftPerfectHeight != rightPerfectHeight) {
            return -1;
        }

        return leftPerfectHeight + 1;

    }
}
