/*
 * SquaresOfSortedArray.java
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
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted
 * non-decreasing order.
 *
 *
 *
 * Example 1:
 *
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Example 2:
 *
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 *
 * Note:
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A is sorted in non-decreasing order.
 */
public class SquaresOfSortedArray {

    public static void main(String[] args) {
        final int[] a = {-7,-3,2,3,11};
        int[] b = new SquaresOfSortedArray().sortedSquares(a);
        for (int e : b) {
            System.out.println("e = " + e);
        }
    }

    public int[] sortedSquares(int[] A) {

        if (A == null) {
            return null;
        }

        int[] B = new int[A.length];

        int j = A.length - 1;
        int i = 0;
        int k = B.length - 1;

        while (i <= j) {
            if (Math.abs(A[i]) <= Math.abs(A[j])) {
                B[k--] = A[j] * A[j];
                j--;
            } else {
                B[k--] = A[i] * A[i];
                i++;
            }
        }

        return B;

    }

    public int[] sortedSquaresStreams(int[] A) {

        List<Integer> list = Arrays.stream(A).boxed().map(a -> (int) Math.pow(a, 2)).sorted().collect(Collectors.toList());

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
