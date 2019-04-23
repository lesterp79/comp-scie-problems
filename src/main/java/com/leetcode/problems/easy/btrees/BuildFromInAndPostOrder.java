/*
 * BuildFromInAndPostOrder.java
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
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 *
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class BuildFromInAndPostOrder {

    public static void main(String[] args) {
        new BuildFromInAndPostOrder().buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
    }

    private int idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) return null;
        if (inorder.length == 0) return null;
        idx = postorder.length-1;
        TreeNode root = build(inorder, postorder, 0, idx);
        return root;
    }

    private TreeNode build(int[] inorder, int[] postorder, int start, int end) {
        if (start>end) return null;
        TreeNode node = new TreeNode(postorder[idx--]);
        if (start==end) return node;

        int index = findIdx(inorder, node.val, end);
        node.right = build(inorder, postorder, index+1, end);
        node.left = build(inorder, postorder, start, index-1);
        return node;
    }

    private int findIdx(int[] inorder, int val, int end) {
        for (int i=end; i>=0; i--) {
            if (inorder[i]==val) return i;
        }
        return 0;
    }
}
