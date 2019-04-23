/*
 * CheckBinarySearchTree.java
 *
 * Copyright (c) 2000-2018 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.book.problems.trees;

import com.util.BTreeNode;
import com.util.BTreePrinter;

/**
 * Validate BST: Implement a function to check if a binary tree is a binary search tree. Hints: #35, #57, #86, # 773, # 728
 */
public class CheckBinarySearchTree {

    public static int minValue = Integer.MIN_VALUE;

    public static void main(String[] args) {

        int[] listNumbers = new int[]{1, 2, 4, 5, 6, 7, 8, 9, 10, 11};

        BTreeNode root = MinimalTree.minimalTree(listNumbers, 0, listNumbers.length - 1);

        BTreePrinter.printNode(root);

        System.out.println(checkBinarySearchTree(root));
    }

    /**
     * Given a root, if we do an in-order-traversal, the BST will be traversed in order, and if we keep track of the minimum
     * element, every node that we visit then must be greater than or equal than the minimum.
     *
     * @param aNode the root of this subtree
     *
     * @return if the tree starting at this toot is a BST
     */
    private static boolean checkBinarySearchTree(BTreeNode<Integer> aNode) {

        // a null node does not alter the minimum and does not break the condition for BST. We just return true.
        if (aNode == null) {
            return true;
        }

        // left subtree needs to be a BST
        boolean isLeftBST = checkBinarySearchTree(aNode.left);

        // if the left subtree is not a BST, we can immediately return false
        if (!isLeftBST) {
            return false;
        }

        // otherwise, this node's value needs to be greater than of equals to the current min value (updated while traversing left
        // subtree)
        if (aNode.val < minValue) {
            return false;
        }

        // set the new min value
        minValue = aNode.val;

        // right subtree needs to be a BST
        boolean isRightBST = checkBinarySearchTree(aNode.right);

        // if the right subtree is not a BST, we can immediately return false
        if (!isRightBST) {
            return false;
        }


        //the tree that has this node as its root is a BST
        return true;
    }
}
