/*
 * InOrderTraversal.java
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

import com.leetcode.problems.easy.btrees.MaximumBinaryTree;
import com.util.BTreeNode;
import com.util.BTreePrinter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
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
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */

public class InOrderTraversal {

    public static void main(String[]args){
        int[] listNumbers = new int[]{3, 20, 4, 9, 11, 5, 8, 7, 2, -1};

        BTreePrinter.printNode(new MaximumBinaryTree().constructMaximumBinaryTree(listNumbers));

        System.out.println(new InOrderTraversal().inOrderTraversal(new MaximumBinaryTree().constructMaximumBinaryTree(listNumbers)));
    }

    public List<Integer> inOrderTraversal(BTreeNode<Integer> root) {

        List<Integer> inOrderList = new ArrayList<>();

        Stack<BTreeNode<Integer>> stack = new Stack<>();

        BTreeNode<Integer> current = root;


        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            inOrderList.add(current.val);

            current = current.right;

        }

        return inOrderList;
    }
}
