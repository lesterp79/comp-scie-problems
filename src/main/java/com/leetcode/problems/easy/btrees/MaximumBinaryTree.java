/*
 * MaximumBinaryTree.java
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

import com.util.BTreeNode;
import com.util.BTreePrinter;

/**
 * Definition for a binary tree node.
 * public class BTreeNode {
 *     int val;
 *     BTreeNode left;
 *     BTreeNode right;
 *     BTreeNode(int x) { val = x; }
 * }
 */

/**
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 * <p>
 * The root is the maximum number in the array. The left subtree is the maximum tree constructed from left part subarray divided by
 * the maximum number. The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum tree by the given array and output the root node of this tree.
 * <p>
 * Example 1: Input: [3,2,1,6,0,5] Output: return the tree root node representing the following tree:
 * <p>
 * 6 /   \ 3     5 \    / 2  0 \ 1 Note: The size of the given array will be in the range [1,1000].
 */
public class MaximumBinaryTree {

    public static void main(String[] args) {

        int[] listNumbers = new int[]{3, 20, 4, 9, 11, 5, 8, 7, 2, -1};

        BTreePrinter.printNode(new MaximumBinaryTree().constructMaximumBinaryTree(listNumbers));

    }
    public BTreeNode<Integer> constructMaximumBinaryTree(int[] nums) {
        if (nums == null) {
            return null;
        }

        BTreeNode<Integer> root = getMaxTree(nums, 0, nums.length - 1);

        return root;
    }

    public BTreeNode getMaxTree(int[] nums, int i, int j) {

        if (i > j) {
            return null;
        }

        int maxIdx = max(nums, i, j);
        BTreeNode root = new BTreeNode(nums[maxIdx]);
        root.left = getMaxTree(nums, i, maxIdx - 1);
        root.right = getMaxTree(nums, maxIdx + 1, j);

        return root;
    }

    private int max(int[] aNums, int i, int j) {
        int max = Integer.MIN_VALUE;
        int maxIdx = i;
        for (int k = i; k <= j; k++) {
            if (aNums[k] > max) {
                max = aNums[k];
                maxIdx = k;
            }
        }

        return maxIdx;
    }
}
