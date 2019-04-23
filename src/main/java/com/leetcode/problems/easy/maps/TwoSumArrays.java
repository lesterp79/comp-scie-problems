/*
 * TwoSum.java
 *
 * Copyright (c) 2000-2018 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.leetcode.problems.easy.maps;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 */
public class TwoSumArrays {

    public static void main(String[] args) {

        int[] results = twoSumHashMapOnePass(new int[]{-2, 4, -6, 5, 14, 7, 6, 0}, 5);

        for (int index : results) {
            System.out.println("index = " + index);
        }
    }

    public static int[] twoSumBruteForce(int[] nums, int target) {
        int i = 0;
        int j = 0;
        boolean found = false;
        while (i < nums.length) {
            j = 0;
            while (j < nums.length) {
                if (i != j) {
                    if (nums[i] + nums[j] == target) {
                        found = true;
                        break;
                    }
                }
                j++;
            }
            if (found) {
                break;
            }
            i++;
        }

        return new int[]{i, j};
    }

    public static int[] twoSumHashMapOnePass(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> complMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];

            // get the complement
            int compl = target - num;

            // get the entry for the number from the map
            Integer numberIndex = complMap.get(num);

            // if the complement is not the number itself
            if (compl != num) {
                // if there's an existing entry for this number
                if (numberIndex != null) {
                    // with an index < 0
                    if (numberIndex < 0) { // since there's exactly one solution, we can ignore numbers that occur more than once
                        // and number != complement
                        // this is it
                        result = new int[]{complMap.get(compl), i};
                    }
                } else { // no entry for this number. build the entry for this number and for its complement
                    complMap.put(num, i);
                    complMap.put(compl, -1);

                }
            } else { // if the complement is the number itself
                // no entry for this number. build the entry for this number, but don't worry about the complement
                if (numberIndex == null) {
                    complMap.put(num, i);
                } else {  // this number appears twice and sums up to target
                    result = new int[]{numberIndex, i};
                }

                // we don't have to do nothing else with the complement
            }
        }
        return result;
    }
}