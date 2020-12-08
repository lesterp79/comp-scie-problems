/*
 * MergeIntervals.java
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = { { 3, 4 }, { 4, 6 }, { 4, 10 }, { 4, 18 } };
        int l = merge(intervals);
        for (int i = 0; i < l; i++) {
            System.out.println(intervals[i][0] + ", " + intervals[i][1]);
        }
    }

    public static int merge(int[][] intervals) {

        if (intervals == null || intervals.length <= 1) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int i = 0;
        for (int j = 1; j < intervals.length; j++) {
            int[] interval = intervals[j];
            if (intervals[i][1] < interval[0]) {
                if (++i < intervals.length) {
                    intervals[++i] = interval;
                }
            } else {
                intervals[i][1] = Math.max(intervals[i][1], interval[1]);
            }
        }

        return i + 1;

    }
}