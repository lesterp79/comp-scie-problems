/*
 * ContainerWithMostWater.java
 *
 * Copyright (c) 2000-2018 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.leetcode.problems.medium.arrays;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = new int[] {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {

        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;

        while (i < j) {
            maxArea = Math.max(maxArea, Math.min(height[j], height[i]) * Math.abs(j - i));
            if (height[i] <= height[j]) {
                i++;
            } else if (height[j] < height[i]){
                j--;
            }
        }

        return maxArea;
    }

}
