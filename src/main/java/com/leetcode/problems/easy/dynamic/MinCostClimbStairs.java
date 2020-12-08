/*
 * MinCostClimbStairs.java
 *
 * Copyright (c) 2000-2019 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.leetcode.problems.easy.dynamic;

/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * <p>
 * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and
 * you can either start from the step with index 0, or the step with index 1.
 * <p>
 * Example 1: Input: cost = [10, 15, 20] Output: 15 Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 * Example 2: Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1] Output: 6 Explanation: Cheapest is start on cost[0], and only step
 * on 1s, skipping cost[3]. Note: cost will have a length in the range [2, 1000]. Every cost[i] will be an integer in the range [0,
 * 999].
 */
public class MinCostClimbStairs {

    public static void main(String[] args) {
        System.out.println(new MinCostClimbStairs().minCostRecursive(new int[]{10, 15, 20}));
    }

    int minCostRecursive(int[] cost) {
        return minCostRecursive(cost, 0);
    }
    int minCostRecursive(int[] cost, int index)
    {
        // Base case
        if( index >= cost.length) // We have reached the top
        {
            return 0;
        }
        else
        {
            int cost1 = minCostRecursive(cost,index + 1); // choice 1
            int cost2 = minCostRecursive(cost,index + 2); // choice 2
            return cost[index] + Math.min(cost1, cost2);
        }
    }
}
