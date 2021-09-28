package com.coding_interview_book.recursion;

import com.util.Matrix;

import java.util.ArrayList;
import java.util.List;

public class FiveTowers {
    public static void main(String[] args) {
        build(0, new int[5][5], new int[5]);
        solutions.forEach(i -> {
            Matrix.printMatrix(i);
            System.out.println();
        });
    }

    static List<int[][]> solutions = new ArrayList<>();

    static void build(int i, int[][] m, int[] cols) {
        if (i == m.length) {
            solutions.add(Matrix.deepCopy(m));
        } else {
            for (int j = 0; j < m[i].length; j++) {
                if (canBuild(i, j, m, cols)) {
                    m[i][j] = 1;
                    cols[j] = 1;
                    build(i + 1, m, cols);
                    m[i][j] = 0;
                    cols[j] = 0;
                }
            }
        }


    }


    private static boolean canBuild(int i, int j, int[][] m, int[] cols) {

        if (cols[j] == 1) {
            return false;
        }

        if (i > 0) {
            //check upper left
            if (j > 0 && m[i - 1][j - 1] == 1) {
                return false;
            }

            //check upper right
            if (j < m[i].length - 1 && m[i - 1][j + 1] == 1) {
                return false;
            }
        }

        return true;

    }
}
