/*
 * TwoSumFour.java
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

import com.coding_interview_book.graphs_trees.MinimalTree;
import com.util.BTreeNode;
import com.util.BTreePrinter;

/**
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is
 * equal to the given target.
 */
public class TwoSumBST {
    public static void main(String[] args) {
        int[] listNumbers = new int[]{1, 2, 4, 5, 6, 7, 8, 9, 10, 11};

        BTreeNode<Integer> root = MinimalTree.minimalTree(listNumbers, 0, listNumbers.length - 1);

        System.out.println("Origin BST");

        BTreePrinter.printNode(root);

        boolean found =  findTarget(root, 9);

        System.out.println("found = " + found);
    }

    public static boolean findTarget(BTreeNode<Integer> root, int k) {
        return false;
    }
}
