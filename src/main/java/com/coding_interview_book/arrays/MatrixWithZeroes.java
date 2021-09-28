package com.coding_interview_book.arrays;

import java.util.Arrays;

import static com.util.Matrix.printMatrix;

public class MatrixWithZeroes {
    public static void main(String[] args) {
        int[][] m = {{1, 0, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {0, 14, 15, 16}};
        printMatrix(m);
        System.out.println();
        matrixWithZeroes(m);
        printMatrix(m);
    }

    public static void matrixWithZeroes(int[][] m) {
        if (m != null && m.length > 0 && m[0].length > 0) {
            boolean anyZeroInFirstRow = anyZeroInRowOrCol(m, true);
            boolean anyZeroInFirstCol = anyZeroInRowOrCol(m, false);


            for (int i = 1; i < m.length; i++) {
                for (int j = 1; j < m[i].length; j++) {
                    if (m[i][j] == 0) {
                        m[i][0] = 0;
                        m[0][j] = 0;
                    }
                }
            }

            for (int i = 1; i < m.length; i++) {
                if (m[i][0] == 0) {
                    for (int j = 1; j < m[0].length; j++) {
                        m[i][j] = 0;
                    }
                }
            }

            for (int j = 1; j < m[0].length; j++) {
                if (m[0][j] == 0) {
                    for (int i = 1; i < m.length; i++) {
                        m[i][j] = 0;
                    }
                }

            }

            if (anyZeroInFirstRow) {
                Arrays.fill(m[0], 0);
            }

            if (anyZeroInFirstCol) {
                for (int i = 0; i < m.length; i++) {
                    m[i][0] = 0;
                }
            }

        }
    }


    private static boolean anyZeroInRowOrCol(int[][] m, boolean isRows) {
        boolean anyZeroInFirstColOrRow = false;
        int i = 0;
        int length = isRows ? m.length : m[0].length;
        while (i < length && !anyZeroInFirstColOrRow) {
            anyZeroInFirstColOrRow = (isRows ? m[0][i] : m[i][0]) == 0;
            i++;
        }

        return anyZeroInFirstColOrRow;
    }

}
