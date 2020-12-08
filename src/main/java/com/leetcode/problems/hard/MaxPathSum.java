/*
 * MaxPathSum.java
 *
 * Copyright (c) 2000-2019 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.leetcode.problems.hard;

public class MaxPathSum {

    class Solution {
        int maxSum = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            if(root == null){
                return maxSum;
            }
            maxPath(root);
            return maxSum;
        }

        public int maxPath(TreeNode root) {
            if(root == null){
                return 0;
            }
            int leftMax = Math.max(0, maxPath(root.left));

            int rightMax = Math.max(0, maxPath(root.right));


            maxSum =  Math.max(maxSum, leftMax + rightMax + root.val);

            return Math.max(leftMax, rightMax) + root.val;
        }
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
