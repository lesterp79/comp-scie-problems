/*
 * Insert.java
 *
 * Copyright (c) 2000-2019 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.coding_interview_book.bit_manipulation;

/**
 * Insertion: You are given two 32-bit numbers, Nand M, and two bit positions, i and
 * j. Write a method to insert Minto N such that M starts at bit j and ends at bit i. You
 * can assume that the bits j through i have enough space to fit all of M. That is, if
 * M = 10011, you can assume that there are at least 5 bits between j and i. You would not, for
 * example, have j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2.
 * EXAMPLE
 * Input: N 10011, i 2, j 6
 * Output: N 10001001100
 * Hints: # 137, #169, #215
 */
public class Insert {
    public static void main(String[] args) {
        int n = 0b10010010100;
        int m = 0b10011;
        System.out.println(Integer.toBinaryString(updateBits(n, m, 7, 10)));

    }
    static int updateBits(int n, int m, int i, int j) {
        int maskI = (1 << i) - 1;
        System.out.println("Integer.toBinaryString(maskI) = " + Integer.toBinaryString(maskI));
        int maskJ = (-1 << (j + 1));
        System.out.println("Integer.toBinaryString(maskJ) = " + Integer.toBinaryString(maskJ));
        int mask = maskI | maskJ;
        System.out.println("Integer.toBinaryString(mask) = " + Integer.toBinaryString(mask));
        int cleared = n & mask;
        System.out.println("Integer.toBinaryString(cleared) = " + Integer.toBinaryString(cleared));
        return cleared | m << i;
    }
}
