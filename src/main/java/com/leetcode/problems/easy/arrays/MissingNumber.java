/*
 * MissingNumber.java
 *
 * Copyright (c) 2000-2019 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.leetcode.problems.easy.arrays;

import java.util.Arrays;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *  *
 *  * Example 1:
 *  *
 *  * Input: [3,0,1]
 *  * Output: 2
 *  * Example 2:
 *  *
 *  * Input: [9,6,4,2,3,5,7,0,1]
 *  * Output: 8
 *
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(new MissingNumber().missingNumberGaussFormula(new int[]{0,1,3,4,5}));
    }

    /**
     * Using Gauss Formula. Runtime O(n). Spatial O(1)
     * @param nums
     * @return
     */
    public int missingNumberGaussFormula(int[] nums) {

        if (nums == null) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

        }

        return ((nums.length * (nums.length + 1)) / 2) - sum;
    }

    /**
     * Using a sorting algorithm. Runtime O(nlog n). Spatial O(1)
     * @param nums
     * @return
     */
    public int missingNumberUsingSorting(int[] nums) {
        if (nums == null) {
            return 0;
        }

        Arrays.sort(nums);

        if (nums[0] != 0) {
            return 0;
        }

        int missing = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                missing = i;
                break;
            }
        }

        return missing;
    }
}
