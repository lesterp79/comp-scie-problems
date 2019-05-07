/*
 * PopulateNextRightPointerII.java
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
 * Given a binary tree
 * <p>
 * struct Node { int val; Node *left; Node *right; Node *next; } Populate each next pointer to point to its next right node. If
 * there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 */
public class PopulateNextRightPointerII {

    public static void main(String[] args) {

        new PopulateNextRightPointerII().run();

    }

    public void run() {
        TreeNode root = new TreeNode(1);
        TreeNode node = new TreeNode(2);
        node.right = new TreeNode(5);
        node.left = new TreeNode(4);
        node.left.left = new TreeNode(7);
        root.left = node;
        node = new TreeNode(3);
        node.right = new TreeNode(8);
        root.right = node;

        System.out.println("root = " + root);

        connect(root);

        System.out.println("root = " + root);
    }

    public TreeNode connect(TreeNode root) {
        if (root == null) {
            return null;
        }
        connectTree(root);
        return root;
    }

    private void connectTree(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            System.out.println("Connecting " + root.left.val + " ->  " + root.right.val);
        }

        if (root.next != null) {
            TreeNode toConnect = root.right != null ? root.right : root.left;
            TreeNode next = root.next.left != null ? root.next.left : root.next.right;
            toConnect.next = next;
            if (next != null) {
                System.out.println("Connecting " + toConnect.val + " -> " + next.val);

            }

        }
        connectTree(root.left);
        connectTree(root.right);
    }

    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode next;

        public TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "{" + val + ", left:" + left + ", right:" + right + ", next:" + next + '}';
        }
    }
}
