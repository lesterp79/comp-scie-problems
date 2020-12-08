/*
 * SearchInRotatedSortedArray.java
 *
 * Copyright (c) 2000-2018 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.leetcode.problems.medium.arrays;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        return search(0, nums.length - 1, nums, target);
    }

    int search(int start, int end, int[] nums, int target) {
        if (start > end) {
            return -1;
        }

        int middle = (start + end) / 2;

        if (target == nums[middle]) {
            return middle;
        }

        // if this half is sorted
        if (nums[middle] < nums[end]) {
            if (target > nums[middle] && target <= nums[end]) {
                // if it contains target, discard other half
                return search(middle + 1, end, nums, target);
            } else {
                // otherwise discard this half
                return search(start, middle - 1, nums, target);
            }
        } else {
            if (target < nums[middle] && target >= nums[start]) {
                // if it contains target, discard other half
                return search(start, middle - 1, nums, target);
            } else {
                // otherwise discard this half
                return search(middle + 1, end, nums, target);
            }
        }

    }
}
