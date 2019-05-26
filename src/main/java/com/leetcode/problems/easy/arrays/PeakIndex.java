/*
 * PeakIndex.java
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

public class PeakIndex {
    public static void main(String[] args) {
        System.out.println(new PeakIndex().peakIndexInMountainArray(new int[]{0, 1, 3, 5, 4}));

    }

    public int peakIndexInMountainArray(int[] A) {
        int lo = 0;
        int hi = A.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (A[mid] < A[mid + 1]) { // peak index is after mid.
                lo = mid + 1;
            } else if (A[mid - 1] > A[mid]) { // peak index is before mid.
                hi = mid;
            } else { // peak index is mid.
                return mid;
            }
        }
        return -1; // no peak.
    }
}
