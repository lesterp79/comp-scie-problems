/*
 * SubSetSum.java
 *
 * Copyright (c) 2000-2019 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.other.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * Subset sum problem is to find subset of elements that are selected from a given set whose sum adds up to a given number K. We are
 * considering the set contains non-negative values. It is assumed that the input set is unique (no duplicates are presented).
 */
public class SubSetSum {

    public static void main(String[] args) {

        Deque<Integer> path = new ArrayDeque();

        if (new SubSetSum().subsetSum(new int[]{7, 2, 3, 4, 5}, 15, path)) {
            for (Integer integer:
                 path) {
                System.out.println(integer + " ");
            }
        }
    }

    boolean subsetSum(int[] set, int k, Deque<Integer> path) {
        int[] subset = new int[set.length];

        return findSum(set, subset, new ArrayDeque<>(), 0, k);
    }

    boolean findSum(int[] set, int[] subset,  Deque<Integer> path, int pathSum, int k) {

        for (int i = 0; i < set.length; i++) {
            if (subset[i] == 0) {
                int sum = pathSum + set[i];
                if (sum == k) {
                    path.push(set[i]);
                    return true;
                } else if (sum < k) {
                    subset[i] = 1;
                    path.push(set[i]);
                    if (findSum(set, Arrays.copyOf(subset, subset.length), path, sum, k)) {
                        return true;
                    }
                    // backtrack
                    path.pop();
                } else {
                    subset[i] = 1;
                }
            }
        }
        return false;
    }
}
