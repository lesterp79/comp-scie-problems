/*
 * MaximalSquare.java
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

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int maxSquareSide = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    int squareSide = 1;
                    boolean growing = true;
                    while (i + squareSide < rows && j + squareSide < cols && growing) {
                        int k = i;
                        while (k < i + squareSide && growing) {
                            if (matrix[k][j + squareSide] == '0') {
                                growing = false;
                            }
                            k++;
                        }
                        k = j;
                        while (k < j + squareSide && growing) {
                            if (matrix[i + squareSide][k] == '0') {
                                growing = false;
                            }
                            k++;
                        }
                        if (growing) {
                            squareSide++;
                        }
                    }

                    maxSquareSide = Math.max(maxSquareSide, squareSide);
                }
            }
        }

        return maxSquareSide * maxSquareSide;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
                        { '1', '0', '0', '1', '0' } };

        System.out.println(maximalSquareDP(matrix));

    }

    public static int maximalSquareDP(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = Integer.parseInt(String.valueOf(matrix[i][0]));
        }

        for (int j = 0; j < matrix[0].length; j++) {
            dp[0][j] = Integer.parseInt(String.valueOf(matrix[0][j]));
        }

        int maxSquare = 0;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),
                                    dp[i - 1][j - 1]) + 1;
                    maxSquare = Math.max(maxSquare, dp[i][j]);
                }
            }
        }
        return maxSquare;
    }
}

