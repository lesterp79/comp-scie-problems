/*
 * TripleStep.java
 *
 * Copyright (c) 2000-2019 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.coding_interview_book.dynamic;

import java.util.Arrays;

/**
 * Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time. Implement a
 * method to count how many possible ways the child can run up the stairs.
 */
public class TripleStep {

    public static void main(String[] args) {
        int n = 4;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        System.out.println(countSteps(n, new int[n]));
    }

    static int countSteps(int n, int[] memo) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            if (memo[n] > -1) {
                memo[n] = countSteps(n - 1, memo) + countSteps(n - 2, memo) + countSteps(n - 3, memo);
            }
            return memo[n];
        }
    }
}
