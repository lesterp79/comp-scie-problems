/*
 * CandyCrush.java
 *
 * Copyright (c) 2000-2019 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.leetcode.problems.medium.linkedlists;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * Given a 1-d array candy crush, return the shortest array after removing all the continuous same numbers (the repeating number >=
 * 3) input: 1-d array [1, 3, 3, 3, 2, 2, 2, 3, 1] return: [1, 1] Time complexity should be better than O(n^2)
 */
public class CandyCrush {

    public static void main(String[] args) {
        final int[] x = new CandyCrush().candyCrush(new int[]{1, 3, 3, 3, 2, 2, 2, 3, 1});

        for (int i : x) {
            System.out.println(i);
        }
    }

    public int[] candyCrush(int[] arr) {
        if (arr == null || arr.length < 3) {
            return arr;
        }

        Deque<Integer> stack = new ArrayDeque<>(arr.length);

        for (int i = 0, j = 1; j < arr.length;) {
            if (arr[i] != arr[j]) {
                stack.push(arr[i]);
                i++;
                j++;
            } else {
                if (!stack.isEmpty()) {
                    int previous = stack.peek();
                    if (previous == arr[j]) {
                        stack.pop();
                        while (previous == arr[i]) {
                            i++;
                            j++;
                        }
                    } else {
                        stack.push(arr[i]);
                        i++;
                        j++;
                    }
                } else {
                    stack.push(arr[i]);
                    i++;
                    j++;
                }
            }
        }

        return stack.stream().mapToInt(i -> i).toArray();
    }
}
