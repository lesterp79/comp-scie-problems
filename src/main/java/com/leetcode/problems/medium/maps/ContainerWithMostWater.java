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
package com.leetcode.problems.medium.maps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[] {8, 5, 2, 4, 14, 8, 14, 8, 2, 3, 2, 2, 5}));
    }

    public static int maxArea(int[] height) {

        List<ContainerWall> containerWallList = new ArrayList<>();

        for (int i = 0; i < height.length; i++) {
            containerWallList.add(new ContainerWall(height[i], i));
        }

        // sort first O(n log n)
        Collections.sort(containerWallList);

        int maxArea = 0;


        // use "vertical" sweep to determine the "container" with the greater area
        for (int i = 0; i < height.length ; i++) {

            int thisHeight = containerWallList.get(i).height;

            int curHeight = thisHeight;


            int beginContainer = i;

            int endContainer = i;

            // process the containers of this height
            while (i < height.length - 1 && thisHeight == curHeight ) {
                endContainer = containerWallList.get(++i).pos;
            }

            int thisContainerSize =  endContainer - beginContainer;

            int thisHeightArea = thisHeight * thisContainerSize;

            if (thisHeightArea > maxArea) {
                maxArea = thisHeightArea;
            }
        }

        return maxArea;
    }
}

class ContainerWall implements Comparable<ContainerWall>{

    public ContainerWall(int height, int pos) {
        this.height = height;
        this.pos = pos;
    }

    int height;
    int pos;

    @Override
    public int compareTo(ContainerWall o) {

        int heightWise = o.height - this.height;

        if (heightWise != 0) {
            return heightWise;
        }

        return o.pos - this.pos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ContainerWall that = (ContainerWall) o;

        if (height != that.height)
            return false;
        return pos == that.pos;
    }

    @Override
    public int hashCode() {
        int result = height;
        result = 31 * result + pos;
        return result;
    }
}
