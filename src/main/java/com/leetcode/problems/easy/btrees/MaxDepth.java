/*
 * MaxDepth.java
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
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given binary tree [3,9,20,null,null,15,7],
 * <p>
 * 3 / \ 9  20 /  \ 15   7 return its depth = 3.
 */
public class MaxDepth {

    int maxDepth = 0;

    public int maxDepthTopDown(TreeNode root) {

        if (root == null) {
            return maxDepth;
        }

        maxDepthTopDown(0, root);

        return maxDepth;

    }

    private void maxDepthTopDown(int depth, TreeNode root) {
        if (root == null) {
            return;
        }

        depth += 1;

        if (root.left == null && root.right == null) {
            maxDepth = Math.max(depth, maxDepth);
        }

        maxDepthTopDown(depth, root.left);
        maxDepthTopDown(depth, root.right);
    }

    public int maxDepthBottomUp(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepthBottomUp(root.left), maxDepthBottomUp(root.right)) + 1;
    }
}




