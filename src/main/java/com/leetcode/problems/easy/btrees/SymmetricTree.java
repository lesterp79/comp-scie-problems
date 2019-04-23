/*
 * SymmetricTree.java
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
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * <p>
 * 1 /   \ /      \ 2         2 /  \      /  \ 3   4     4    3 /\  / \   / \  / \ 5 6  7 8  8  7  6  5 But the following
 * [1,2,2,null,3,null,3] is not: 1 / \ 2   2 \   \ 3    3 Note: Bonus points if you could solve it both recursively and
 * iteratively.
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);

    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val & isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

}
