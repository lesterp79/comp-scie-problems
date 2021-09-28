/*
 * MagicIndex.java
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
 * Magic Index: A magic index in an array A [0 ... n -1] is defined to be an index such that A[i] = i. Given a sorted array of
 * distinct integers, write a method to find a magic index, if one exists, in array A.
 * <p>
 * FOLLOW UP What if the values are not distinct?
 */
public class MagicIndex {

    public static void main(String[] args) {
        System.out.println(findMagicIndexWithDuplicates(new int[]{0, 0, 1, 1, 1, 1, 8, 9, 10, 10, 11}, 0, 10));

    }

    static int findMagicIndexBruteN(int[] array) {
        if (array == null) {
            return -1;
        }

        int i = 0;
        while (i < array.length && array[i] < i) {
            i++;
        }

        return i < array.length ? (array[i] == i ? i : -1) : -1;
    }

    static int findMagicIndexLogN(int[] array, int start, int end) {
        if (end < start) {
            return -1;
        }
        int middle = (end + start) / 2;
        if (array[middle] == middle) {
            return middle;
        } else if (array[middle] > middle) {
            return findMagicIndexLogN(array, start, middle - 1);
        } else {
            return findMagicIndexLogN(array, middle +1 , end);
        }
    }

    static int findMagicIndexWithDuplicates(int[] array, int start, int end) {
        if (end < start) {
            return -1;
        }
        int midIndex = (start + end) / 2;
        if (array[midIndex] == midIndex) {
            return midIndex;
        }

        int leftIndex = Math.min(midIndex - 1, array[midIndex]);
        int left = findMagicIndexWithDuplicates(array, start, leftIndex);

        if (left >= 0) {
            return left;
        }

        int rightIndex = Math.max(midIndex + 1 , array[midIndex]);
        int right = findMagicIndexWithDuplicates(array, rightIndex, end);
        return right;

    }
}

