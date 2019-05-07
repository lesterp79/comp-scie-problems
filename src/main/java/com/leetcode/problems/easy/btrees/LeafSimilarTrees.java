/*
 * LeafSimilarSequence.java
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
 * Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence. Two
 * binary trees are considered leaf-similar if their leaf value sequence is the same.
 * <p>
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 */
public class LeafSimilarTrees {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode node = new TreeNode(2);
        node.right = new TreeNode(5);
        node.left = new TreeNode(4);
        root1.left = node;
        node = new TreeNode(3);
        node.right = new TreeNode(8);
        root1.right = node;

        TreeNode root2 = new TreeNode(1);
        node = new TreeNode(2);
        node.right = new TreeNode(5);
        node.left = new TreeNode(7);
        node.left.left = new TreeNode(4);
        root2.left = node;
        node = new TreeNode(3);
        node.right = new TreeNode(8);
        node.right.right = new TreeNode(8);
        root2.right = node;

        System.out.println(new LeafSimilarTrees().leafSimilar(root1, root2));

    }


    Queue<Integer> sequence = new LinkedList<>();

    boolean leafSimilar = true;

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null){
            return true;
        }

        produce(root1);

        consume(root2);

        return leafSimilar && sequence.isEmpty();

    }

    private void produce(TreeNode root) {
        if (root == null) {
            return;
        }
        produce(root.left);

        produce(root.right);

        if (root.left == null && root.right == null) {
            sequence.add(root.val);
        }
    }

    private void consume(TreeNode root) {

        if (!leafSimilar || root == null) {
            return;
        }

        consume(root.left);

        if (root.left == null && root.right == null) {
            Integer next = sequence.poll();
            if (next == null || root.val != next) {
                leafSimilar = false;
                return;
            }
        }
        consume(root.right);
    }



}
