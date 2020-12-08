/*
 * FibonacciTab.java
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

public class FibonacciTab
{
    int fib(int n) {
        int f[] = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }

    public static void main(String[] args)
    {
        FibonacciTab f = new FibonacciTab();
        int n = 40;
        System.out.println("Fibonacci number is" + " " + f.fib(n));
    }
}