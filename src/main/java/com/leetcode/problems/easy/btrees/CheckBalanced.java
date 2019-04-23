/*
 * CheckBalanced.java
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
 * Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
 * this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
 * node never differ by more than one.
 */
public class CheckBalanced {

    public static void main(String[] args) {

        int[] listNumbers = new int[]{1, 2, 4, 5, 6, 7, 8, 9, 10, 11};

        BTreeNode root = MinimalTree.minimalTree(listNumbers, 0, listNumbers.length - 1);

        BTreePrinter.printNode(root);

        BTreeNode newRoot = new BTreeNode(22);

        newRoot.right = root;

        boolean isTreeBalanced = isTreeBalanced(newRoot) > 0;

        System.out.println("isTreeBalanced = " + isTreeBalanced);


    }

    static int isTreeBalanced(BTreeNode aNode) {

        System.out.println("Processing Node = [" + aNode + "]...");

        // if this is a null node, this is a balanced subtree with a height of zero (0)
        if (aNode == null) {
            System.out.println("Node = [" + aNode + "] is a balanced subtree with a height of zero (0)");
            return 0;
        }

        // get the height of the left subtree
        int hLeft = isTreeBalanced(aNode.left);

        System.out.println("The size of the left subtree for Node = [" + aNode + "] is: " + hLeft);

        // if the left subtree is unbalanced, then there's nothing more to check, and we just return -1
        if (hLeft == -1) {
            System.out.println("The size of the left subtree for Node = [" + aNode + "] is unbalanced!");
            return -1;
        }

        // get the height of the left subtree
        int hRight = isTreeBalanced(aNode.right);

        System.out.println("The size of the right subtree for Node = [" + aNode + "] is: " + hRight);

        // if the right subtree is unbalanced, then there's nothing more to check, and we just return -1
        if (hRight == -1) {
            System.out.println("The size of the right subtree for Node = [" + aNode + "] is unbalanced!");
            return -1;
        }

        // at this point, we know that the subtrees are not unbalanced in themselves

        // next step is to calculate the difference between the depths of the subtrees
        int depthDiff = Math.abs(hLeft - hRight);

        System.out.println("The abs vaule of the difference between the depths of the subtrees for Node = [" + aNode + "] is: " + depthDiff);


        // if the absolute value of the difference is greater than one, this subtree is unbalanced
        if (depthDiff > 1) {
            System.out.println("The subtree with root Node = [" + aNode + "] is unbalanced bc the abs vaule of the difference between "
                            + "the depths of the subtrees is: " + depthDiff);
            return -1;
        }

        int height = (hRight > hLeft ? hRight : hLeft) + 1;

        // this tree is not unbalanced. return its height, which is the greatest of the two subtrees plus 1
        System.out.println("The subtree with root Node = [" + aNode + "] has a height of : " + height);

        return height;
    }

}
