/*
 * HammingDistance.java
 *
 * Copyright (c) 2000-2018 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.leetcode.problems.easy.bits;

public class HammingDistance {
    public static void main(String[] args) {

        System.out.println(hammingDistance(488, 214));
    }

    public static int hammingDistance(int x, int y) {

        int dist = 0;

        if (x == y) {
            return 0;
        }

        int mask = 0;

        dist = getDistance(x, y, dist, mask);

        mask = (int) Math.pow(2, 30);

        for (int i = 30; i >= 0; i--) {

            System.out.println("mask = " + mask);

            dist = getDistance(x, y, dist, mask);

            mask = mask >> 1;

        }

        return dist;
    }

    static int getDistance(int x, int y, int dist, int mask) {

        if ((mask & x) != (mask & y))   {
            dist = dist + 1;
        }
        return dist;
    }
}
