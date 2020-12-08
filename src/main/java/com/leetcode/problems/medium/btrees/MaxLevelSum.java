/*
 * MaxLevelSum.java
 *
 * Copyright (c) 2000-2019 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.leetcode.problems.medium.btrees;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 *
 * Return the smallest level X such that the sum of all the values of nodes at level X is maximal.
 */
public class MaxLevelSum {


    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // do a bfs and accumulate sum by level
        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        int max = 0;
        int maxLevel = 1;
        int level = 0;
        while (!queue.isEmpty()) {
            // get number of nodes in level
            int count = queue.size();
            int sum = 0;
            level++;
            // process level and sum
            for (int i = 0; i < count; i++) {
                TreeNode curr = queue.poll();
                sum += curr.val;
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            // finish processing level
            if (sum > max) {
                max = sum;
                maxLevel = level;
            }
        }

        return maxLevel;
    }
}
