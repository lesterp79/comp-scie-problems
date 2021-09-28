/*
 * InOrderSuccessor.java
 *
 * Copyright (c) 2000-2018 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.coding_interview_book.graphs_trees;

import com.util.BTreePrinter;
import com.util.DoublyLinkedTreeNode;
import com.util.BTreeNode;

/**
 * Successor: Write an algorithm to find the "next" node (i .e., in-order successor) of a given node in a
 * binary search tree. You may assume that each node has a link to its parent.
 * Hints: #79, #91
 */
public class InOrderSuccessor {

    public static void main(String[] args) {

        int[] listNumbers = new int[]{1, 2, 4, 5, 6, 7, 8, 9, 10, 11};

        DoublyLinkedTreeNode root = MinimalTree.minimalDoublyLinkedTree(listNumbers, 0, listNumbers.length - 1, null);

        BTreePrinter.printNode(root);

        DoublyLinkedTreeNode nodeNumber11 = root.getRight().getRight().getRight().getRight();

        final Integer inOrderSuccessor = getInOrderSuccessor(nodeNumber11);

        System.out.println("inOrderSuccessor = " + ((inOrderSuccessor == null) ? "No successor found" : inOrderSuccessor));

    }


    private static Integer getInOrderSuccessor(DoublyLinkedTreeNode<Integer> aNode) {

        // by definition, we'll say that a null node's has no successor
        if (aNode == null) {
            return null;
        }

        // if we have a right subtree, the in-order successor will be the MINIMUM node from the right subtree
        if (aNode.hasRightChild()) {
            return getMinimumValue(aNode.right);
        }

        // if we don't have a right subtree, we check our parent node

        // Since we NEVER GO LEFT, UNLESS we are looking for the minimum in our RIGHT subtree (previous branch, AND we are a LEFT
        // child, the only possibility is that we are starting our search for a successor IN THIS VERY NODE. In that case,
        // it can't be other that our parent.

        if (aNode.isLeftChild()) {
            return aNode.getParent().val;
        }

        // if we are here, we do NOT have a right subtree, and we are NOT a left child. The only two remaining possibilities are:

        //1: we are a RIGHT child. In this case, note that we are starting our search in the MAX NODE of our current SUBTREE, since
        // there is NO MORE nodes to our RIGHT. Therefore, our successor MUST be the ROOT of our subtree, and we find it by traversing
        // the tree BACKWARDS, using the parent, until we find a node that is NOT a right child. Then its parent's value will be
        // the successor(AS LONG AS WE ARE NOT IN THE ABSOLUTE MAXIMUM OF THE WHOLE TREE STRUCTURE, i.e., we are searching on the
        // RIGHT PART OF THE TREE, in which case there is no successor)

        if (aNode.isRightChild()) {
            return getRootForRelativeMaximum(aNode.getParent());
        }

        //2: If we have NO RIGHT SUBTREE AND we are NOT a left or a child, then we are the root, or the ABSOLUTE MAXIMUM AND THE ROOT,
        // since the only possible nodes will be to our left

        // There's no successor for the THE ABSOLUTE MAXIMUM
        return null;
    }

    private static Integer getRootForRelativeMaximum(DoublyLinkedTreeNode<Integer> aNode) {
        // if we get to the root (no parent), never finding a node that is NOT a right child, then we are looking for the successor
        // of THE ABSOLUTE MAXIMUM.
        if (aNode.getParent() == null) {
            // There's no successor for the THE ABSOLUTE MAXIMUM
            return null;
        }

        // otherwise, as long as we are a right child, we keep looking for the first node that is a left child, which parent's node
        // value is  guaranteed to be the immediate successor of relative maximum for its left subtree.
        if (aNode.isRightChild()) {
            return getRootForRelativeMaximum(aNode.getParent());
        }

        // we found the successor for the relative maximum
        return aNode.getParent().val;
    }

    /**
     * Gets the minimum value from a BST, but recursively traversing the BST to the left. Once we have no more left to go to, the
     * current node's value will be the minimum.
     *
     * @param aRoot the root of from a BST to search for
     *
     * @return the minimum value of from a BST
     */
    private static Integer getMinimumValue(BTreeNode<Integer> aRoot) {
        if (aRoot.hasLeftChild()) {
            return getMinimumValue(aRoot.left);
        }

        return aRoot.val;
    }


}
