/*
 * MaxSum.java
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

public class MaxSum {

    public static void main(String[] args) {
        int[] listNumbers = new int[]{1, 2, 4, 3, 6, 7, -8, 9, -10, 10};

        BTreeNode root = MinimalTree.minimalTree(listNumbers, 0, listNumbers.length - 1);

        BTreePrinter.printNode(root);

        System.out.println(maxSum(root));

    }


        private static int maxSum = Integer.MIN_VALUE;

        static int maxSum(BTreeNode<Integer> root) {
            maxSum(root, 0);
            return maxSum;
        }

        static void maxSum(BTreeNode<Integer> root, int pathSum) {
            if (root == null) {
                return;
            }

            int sum = pathSum + root.val;

            if (root.left == null && root.right == null) {
                if (sum > maxSum) {
                    maxSum = sum;
                }
                return;
            }

            maxSum(root.left, sum);
            maxSum(root.right, sum);
        }
}
