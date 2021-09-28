package com.util;

public class Matrix {
    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%4d", matrix[row][col]);
            }
            System.out.println();
        }
    }

    public static int[][] deepCopy(int[][] matrix) {
        return java.util.Arrays.stream(matrix).map(int[]::clone).toArray($ -> matrix.clone());
    }
}
