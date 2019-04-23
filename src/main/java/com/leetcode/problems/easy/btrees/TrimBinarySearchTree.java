/*
 * TrimBinarySearchTree.java
 *
 * Copyright (c) 2000-2018 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.leetcode.problems.easy.btrees;

import com.book.problems.trees.MinimalTree;
import com.util.BTreeNode;
import com.util.BTreePrinter;

/**
 * Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in
 * [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary
 * search tree.
 */
public class TrimBinarySearchTree {
    public static void main(String[] args) {
        int[] listNumbers = new int[]{1, 2, 4, 5, 6, 7, 8, 9, 10, 11};

        BTreeNode<Integer> root = MinimalTree.minimalTree(listNumbers, 0, listNumbers.length - 1);

        System.out.println("Origin BST");

        BTreePrinter.printNode(root);

        BTreeNode<Integer> newRoot = trimBST(root, 3, 9);

        System.out.println("Trimmed BST");

        BTreePrinter.printNode(newRoot);


    }

    public static BTreeNode<Integer> trimBST(BTreeNode<Integer> root, int L, int R) {
        if (root == null) {
            return null;
        }

        if (root.val < L) {
            return trimBST(root.right, L, R);
        }

        if (root.val > R) {
            return trimBST(root.left, L, R);
        }

        root.left = trimBST(root.left, L, R);

        root.right = trimBST(root.right, L, R);

        return root;
    }
}
