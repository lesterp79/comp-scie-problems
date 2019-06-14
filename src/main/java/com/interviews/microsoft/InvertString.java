/*
 * InverString.java
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

/**
 * Recursively reverse a string.
 */
public class InvertString {

    public static void main(String[] args) {
        System.out.println(new InvertString().invert(("abcdefgh")));
    }

    String invert(String aString) {
        if (aString == null | aString.length() <= 1) {
            return aString;
        }

        char[] result = aString.toCharArray();

        invert(result, 0, result.length - 1);

        return new String(result);

    }

    void invert(char[] arr, int left, int right) {

        if (left > right) {
            return;
        }

        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        invert(arr, left + 1, right - 1);
    }
}
