/*
 * RelativeSortArray.java
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
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 * <p>
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear
 * in arr2 should be placed at the end of arr1 in ascending order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6] Output: [2,2,2,1,4,3,3,9,6,7,19]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * arr1.length, arr2.length <= 1000 0 <= arr1[i], arr2[i] <= 1000 Each arr2[i] is distinct. Each arr2[i] is in arr1.
 */
public class RelativeSortArray {

    public static void main(String[] args) {
        int[] sorted = new RelativeSortArray().relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6});

        for (int i = 0; i < sorted.length; i++) {
            System.out.println(sorted[i]);
        }
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] counter = new int[1000];

        for (int i = 0; i < arr1.length; i++) {
            counter[arr1[i]]++;
        }

        int j = 0;
        for (int i = 0; i < arr2.length; i++) {
            int p = counter[arr2[i]];
            for (int k = 0; k < p;  k++) {
                arr1[j++] = arr2[i];
                counter[arr2[i]]--;
            }
        }

        for (int i = 0; i < 1000; i++) {
            if (counter[i] > 0) {
                int p = counter[i];
                for (int k = 0; k < p; k++) {
                    arr1[j++] = i;
                }
            }
        }

        return arr1;
    }
}
