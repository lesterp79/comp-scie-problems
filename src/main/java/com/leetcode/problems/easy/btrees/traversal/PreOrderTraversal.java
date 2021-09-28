/*
 * PreOrderTraversal.java
 *
 * Copyright (c) 2000-2019 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.leetcode.problems.easy.btrees.traversal;

import com.coding_interview_book.graphs_trees.MinimalTree;
import com.util.BTreeNode;
import com.util.BTreePrinter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,2,3]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class PreOrderTraversal {

    public static void main(String[] args) {
        int[] listNumbers = new int[]{1, 2, 4, 5, 6, 7, 8, 9, 10, 11};

        BTreeNode root = MinimalTree.minimalTree(listNumbers, 0, listNumbers.length - 1);

        BTreePrinter.printNode(root);

        System.out.println(new PreOrderTraversal().preOrderTraversalIterative(root));


    }

    public List<Integer> preOrderTraversalRecursive(BTreeNode<Integer> root) {
        List<Integer> preOrderList = new ArrayList<>();
        preOrder(preOrderList, root);
        return preOrderList;
    }

    private void preOrder(List<Integer> preOrderList, BTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        preOrderList.add(root.val);
        preOrder(preOrderList, root.left);
        preOrder(preOrderList, root.right);
    }

    public List<Integer> preOrderTraversalIterative(BTreeNode<Integer> root) {

        List<Integer> preOrderList = new ArrayList<>();

        Stack<BTreeNode> stack = new Stack<>();

        BTreeNode<Integer> current;

        stack.push(root);

        while (!stack.isEmpty()) {
            current = stack.pop();
            preOrderList.add(current.val);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return preOrderList;
    }
}

