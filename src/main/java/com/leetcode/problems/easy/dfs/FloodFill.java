/*
 * FloodFill.java
 *
 * Copyright (c) 2000-2019 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.leetcode.problems.easy.dfs;

public class FloodFill {

    public static void main(String[] args) {
        int[][] image = {{0, 0, 0}, {0, 1, 1}};
        final int[][] x = new FloodFill().floodFill(image, 1, 1, 1);
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[0].length; j++) {
                System.out.println(x[i][j] + ", ");
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if (image[sr][sr] == newColor) {
            return image;
        }
        flood(image, sr, sc, newColor);
        return image;
    }

    public void flood(int[][] image, int sr, int sc, int newColor) {

        // get current color
        int color = image[sr][sc];

        //flood
        image[sr][sc] = newColor;

        // propagate
        if (isWithingBounds(image, sr + 1, sc) && image[sr + 1][sc] == color) {
            floodFill(image, sr + 1, sc, newColor);

        }
        if (isWithingBounds(image, sr - 1, sc) && image[sr - 1][sc] == color) {
            floodFill(image, sr - 1, sc, newColor);

        }
        if (isWithingBounds(image, sr, sc - 1) && image[sr][sc - 1] == color) {
            floodFill(image, sr, sc - 1, newColor);

        }
        if (isWithingBounds(image, sr, sc + 1) && image[sr][sc + 1] == color) {
            floodFill(image, sr, sc + 1, newColor);

        }
    }

    private boolean isWithingBounds(int[][] image, int sr, int sc) {
        return sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length;
    }
}

