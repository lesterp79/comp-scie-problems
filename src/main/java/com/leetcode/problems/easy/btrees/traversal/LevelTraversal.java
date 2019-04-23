/*
 * LevelTraversal.java
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
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class LevelTraversal {

    public static void main(String[] args) {
        int[] listNumbers = new int[]{3, 20, 4, 9, 11, 5, 8, 7, 2, -1};

        BTreePrinter.printNode(new MaximumBinaryTree().constructMaximumBinaryTree(listNumbers));

        System.out.println(new LevelTraversal().levelOrder(new MaximumBinaryTree().constructMaximumBinaryTree(listNumbers)));
    }
    public List<Integer> levelOrder(BTreeNode<Integer> root) {

        List<Integer> levelOrderList = new ArrayList<>();

        if (root == null) {
            return levelOrderList;
        }

        Queue<BTreeNode<Integer>> queue = new LinkedList<>();

        BTreeNode<Integer> node = root;

        queue.add(node);

        while (!queue.isEmpty()) {
            node = queue.poll();

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }

            levelOrderList.add(node.val);
        }

        return levelOrderList;
    }
}
