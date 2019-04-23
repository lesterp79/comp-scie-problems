/*
 * PathSum.java
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

import com.util.TreeNode;

/**
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {

    private boolean hasPath = false;
    private int total = 0;

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        total = sum;

        hasPath(root, 0);

        return hasPath;

    }

    private void hasPath(TreeNode root, int pathTotal) {
        if (root == null || hasPath) {
            return;
        }

        int rootTotal = pathTotal + root.val;

        if (root.left == null && root.right == null) {
            hasPath = rootTotal == total;
            return;
        }

        hasPath(root.left, rootTotal);
        hasPath(root.right, rootTotal);
    }
}
