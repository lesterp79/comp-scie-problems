/*
 * BuildFromInAndPreOrder.java
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
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 *
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class BuildFromInAndPreOrder {

    int idx = 0;

    public static void main(String[] args) {
        new BuildFromInAndPreOrder().buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length != preorder.length) return null;
        if (inorder.length == 0) return null;
        idx = 0;
        return build(preorder, inorder, idx, preorder.length - 1);

    }

    private TreeNode build(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[idx++]);

        if (start == end) {
            return root;
        }

        int index = findIdx(inorder, root.val, end);

        root.left = build(preorder, inorder, start, index - 1);
        root.right = build(preorder, inorder, index + 1, end);

        return root;

    }

    private int findIdx(int[] inorder, int val, int end) {
        for (int i=end; i>=0; i--) {
            if (inorder[i]==val) return i;
        }
        return 0;
    }


}
