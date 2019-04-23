/*
 * TotalHammingDistance.java
 *
 * Copyright (c) 2000-2018 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.leetcode.problems.medium.bits;

public class TotalHammingDistance {

    public static void main(String[] args) {

        int[] nums = new int[] { 4, 14, 2 };

        System.out.println(totalHammingDistance(nums));
    }

    public static int totalHammingDistance(int[] nums) {


        BitColumn[] bitColumnArray = createBitColumnArray();

        populateBitColumnsTotals(nums, bitColumnArray);

        int totalDistance = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < bitColumnArray.length; j++) {
                if ((bitColumnArray[j].mask & nums[i]) > 0) {
                    totalDistance = totalDistance + bitColumnArray[j].totalZeroes;
                } else {
                    totalDistance = totalDistance + bitColumnArray[j].totalOnes;
                }
            }
        }

        return totalDistance/2;
    }

    static void populateBitColumnsTotals(int[] nums, BitColumn[] bitColumnArray) {
        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < bitColumnArray.length; j++) {
                if ((bitColumnArray[j].mask & nums[i]) > 0) {
                    bitColumnArray[j].totalOnes++;
                } else {
                    bitColumnArray[j].totalZeroes++;
                }
            }
        }
    }

    static BitColumn[] createBitColumnArray() {

        BitColumn[] bitColumnArray = new BitColumn[32];

        BitColumn bitColumn0 = new BitColumn(0);

        bitColumnArray[0] = bitColumn0;

        int mask = 1;

        for (int i = 1; i < 32; i++) {

            System.out.println(mask);

            BitColumn bitColumn = new BitColumn(mask);

            bitColumnArray[i] = bitColumn;

            mask = mask << 1;
        }

        return bitColumnArray;
    }
}

class BitColumn {

    BitColumn(int aMask) {
        this.mask = aMask;
    }
    int mask;
    int totalZeroes;
    int totalOnes;
}