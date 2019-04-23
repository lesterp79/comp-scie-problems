/*
 * ToLowerCase.java
 *
 * Copyright (c) 2000-2019 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.leetcode.problems.easy.arrays;

/**
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 */
public class ToLowerCase {
    public static void main(String[] args) {
        System.out.println(new ToLowerCase().toLowerCase("hello"));
    }
    public String toLowerCase(String str) {
        if (str == null) {
            return null;
        }
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            c += 32;
            if (c >= 97 && c <= 122) {
                chars[i] = c;
            }
        }

        return new String(chars);
    }
}
