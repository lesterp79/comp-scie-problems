/*
 * RecursiveMultiply.java
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

/**
 * Recursive Multiply: Write a recursive function to multiply two positive integers without using the * operator (or / operator).
 * You can use addition, subtraction, and bit shifting, but you should minimize the number of those operations
 */
public class RecursiveMultiply {

    public static void main(String[] args) {
        System.out.println(new RecursiveMultiply().minProductOptimized(17, 23));
    }

    int minProduct(int a, int b) {
        int bigger = a < b ? b : a;
        int smaller = a < b ? a : b;

        return minProductHelper(smaller, bigger);
    }

    int minProductHelper(int smaller, int bigger) {
        if (smaller == 0) { // 0 x bigger = 0
            return 0;
        } else if (smaller == 1) { // 1 x bigger = bigger
            return bigger;
        }

        // compute half. if uneven, compute the other half, if even. double it
        int s = smaller >> 1;
        int side1 = minProductHelper(s, bigger);
        int side2 = side1;

        if (smaller % 2 == 1) {
            side2 = minProductHelper(smaller - s, bigger);
        }

        return side1 + side2;
    }

    int minProductCached(int a, int b) {
        int bigger = a < b ? b : a;
        int smaller = a < b ? a : b;

        return minProductHelperCached(smaller, bigger, new int[smaller + 1]);
    }

    int minProductHelperCached(int smaller, int bigger, int[] memo) {
        if (smaller == 0) { // 0 x bigger = 0
            return 0;
        } else if (smaller == 1) { // 1 x bigger = bigger
            return bigger;
        } else if (memo[smaller] > 0) {
            return memo[smaller];
        }

        // compute half. if uneven, compute the other half, if even. double it
        int s = smaller >> 1;
        int side1 = minProductHelperCached(s, bigger, memo);
        int side2 = side1;

        if (smaller % 2 == 1) {
            side2 = minProductHelperCached(smaller - s, bigger, memo);
        }

        // sum and cache
        memo[smaller] =  side1 + side2;

        return memo[smaller];
    }

    int minProductOptimized(int a, int b) {
        int bigger = a < b ? b : a;
        int smaller = a < b ? a : b;

        return minProductHelperCached(smaller, bigger, new int[smaller + 1]);
    }

    int minProductHelperOptimized(int smaller, int bigger) {
        if (smaller == 0) { // 0 x bigger = 0
            return 0;
        } else if (smaller == 1) { // 1 x bigger = bigger
            return bigger;
        }

        // compute half. if uneven, compute the other half, if even. double it
        int s = smaller >> 1;
        int halProd = minProductHelperOptimized(s, bigger);

        if (smaller % 2 == 0) {
            return halProd + halProd;
        } else {
            return halProd + halProd + bigger;
        }
    }
}
