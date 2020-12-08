/*
 * fibonicciMemo.java
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

public class FibonacciMemo
{
    final int MAX = 100;
    final int NIL = -1;

    int lookup[] = new int[MAX];

    /* Function to initialize NIL values in lookup table */
    void init() {
        for (int i = 0; i < MAX; i++) {
            lookup[i] = NIL;
        }
    }

    /* function for nth Fibonacci number */
    int fib(int n)
    {
        if (lookup[n] == NIL) {
            if (n <= 1){
                lookup[n] = n;
            }
            else {
                lookup[n] = fib(n-1) + fib(n-2);
            }
        }
        return lookup[n];
    }

    public static void main(String[] args)
    {
        FibonacciMemo f = new FibonacciMemo();
        int n = 40;
        f.init();
        System.out.println("Fibonacci number is" + " " + f.fib(n));
    }
}