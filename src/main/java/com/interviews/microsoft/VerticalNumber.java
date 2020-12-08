/*
 * VerticalNumber.java
 *
 * Copyright (c) 2000-2019 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.interviews.microsoft;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Print a number vertically with each digit on its own line, without converting to a string.
 * eg. 12345 becomes:
 * 1
 * 2
 * 3
 * 4
 * 5
 */
public class VerticalNumber {

    public static void main(String[] args) {
        printVertically(12345);
    }
    static void printVertically(int n) {
        Deque<Integer> stack = new ArrayDeque<>();

        int div = n;

        while (div > 0) {
            int rest = div % 10;
            stack.push(rest > 0 ? rest : 0);
            div /= 10;
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + "\r");
        }
    }
}
