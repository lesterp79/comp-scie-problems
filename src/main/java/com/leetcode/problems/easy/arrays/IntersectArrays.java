/*
 * IntersectArrays.java
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class IntersectArrays {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1};
        int[] arr2 = new int[]{1, 2};

        int[] results = new IntersectArrays().intersectionBinarySearch(arr1, arr2);

        for (int result: results) {
            System.out.println("result = " + result);
        }

    }

    public int[] intersectionTwoPointers(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            result[k++] = num;
        }
        return result;
    }

    public int[] intersectionBinarySearch(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return nums2;
        } else if (nums2 == null || nums2.length == 0) {
            return nums1;
        }

        int [] outerArr;
        int [] innerArr;

        if (nums1.length < nums2.length) {
            outerArr = nums1;
            innerArr = nums2;
        } else {
            outerArr = nums2;
            innerArr = nums1;
        }

        Set<Integer> intersectSet = new HashSet<>();

        Arrays.sort(innerArr);

        for (int target : outerArr) {
            if (binarySearch(innerArr, target)) {
                intersectSet.add(target);
            }
        }

        int[] results = new int[intersectSet.size()];

        Iterator<Integer> it = intersectSet.iterator();

        int i = 0;
        while (it.hasNext()) {
            results[i++] = it.next();
        }

        return results;
    }

    private boolean binarySearch(int[] aInnerArr, int aTarget) {
        int start = 0;
        int end = aInnerArr.length;

        while (start < end) {
            int middle = (start + end) / 2;

            if (aInnerArr[middle] < aTarget) {
                start = middle + 1;
            } else if (aInnerArr[middle] > aTarget){
                end = middle;
            } else {
                return true;
            }
        }

        return false;
    }
}
