/*
 * UnivaluedBinaryTree.java
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
import java.util.LinkedList;
import java.util.Queue;

/**
 * A binary tree is univalued if every node in the tree has the same value.
 * <p>
 * Return true if and only if the given tree is univalued.
 */
public class UnivaluedBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(1);
        node.left = new TreeNode(1);
        node.left.left = new TreeNode(2);
        root.left = node;
        node = new TreeNode(1);
        node.right = new TreeNode(1);
        root.right = node;

        System.out.println(new UnivaluedBinaryTree().isUnivalTree(root));

    }

    int uniVal = -1;

    public boolean isUnivalTree(TreeNode root) {
        uniVal = root.val;
        return isUnivalDynamic(root);
    }

    private boolean isUnival(TreeNode root) {
        if (root == null) {
            return true;
        }
        return root.val == uniVal && isUnival(root.left) && isUnival(root.right);

    }

    private boolean isUnivalDynamic(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        boolean univalTree = true;

        while (!queue.isEmpty() && univalTree) {
            TreeNode node = queue.poll();
            univalTree = node.val == uniVal && checkUnival(node.left) && checkUnival(node.right);

            if (univalTree && node.left != null) {
                queue.add(node.left);
            }

            if (univalTree && node.right != null) {
                queue.add(node.right);
            }
        }

        return univalTree;

    }

    boolean checkUnival(TreeNode aTreeNode) {
        boolean unival = true;
        if (aTreeNode != null) {
            unival =  aTreeNode.val == uniVal;
        }
        return unival;
    }

}
