/*
 * DigPow.java
 *
 * Copyright (c) 2000-2019 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.codewarrior.problems;

public class DigPow {
    public static long digPow(int n, int p) {

        int sum = 0;

        char[] number = Integer.toString(n).toCharArray();

        for (int i = 0, exp = p; i < number.length; i++, exp++) {
            int digit = Integer.parseInt(String.valueOf(number[i]));
            sum += Math.pow(digit, exp);
        }

        int k = sum / n;

        return (sum % n) == 0 ? k : -1;
    }
}