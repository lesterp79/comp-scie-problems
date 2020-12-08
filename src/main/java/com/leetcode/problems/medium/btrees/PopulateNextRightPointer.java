/*
 * NextPointer.java
 *
 * Copyright (c) 2000-2019 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.leetcode.problems.medium.btrees;

/**
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree
 * has the following definition:
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to
 * NULL.
 *
 * Initially, all next pointers are set to NULL.
 */
public class PopulateNextRightPointer {


    public TreeNode connect(TreeNode root) {

        if (root == null) {
            return null;
        }
        connectTree(root);
        return root;
    }

    private void connectTree(TreeNode root) {
        if (root.left == null) {
            return;
        }

        root.left.next = root.right;

        if (root.next != null) {
            root.right.next= root.next.left;
        }

        connectTree(root.left);
        connectTree(root.right);

    }

}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;
    public TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return "{" + val + ", left:" + left + ", right:" + right + ", next:" + next + '}';
    }
}
