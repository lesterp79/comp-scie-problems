package com.coding_interview_book.recursion;

import com.util.Matrix;

import java.util.Arrays;

public class KnightsTour {
    static int[][] moves = new int[][]{{-2, -1}, {-1, -2}, {2, -1}, {1, -2}, {-2, 1}, {-1, 2}, {2, 1}, {1, 2}};

    public static void main(String[] args) {
        int[][] m = new int[8][8];
        for (int i = 0; i < m.length; i++) {
            Arrays.fill(m[i], -1);
        }

        tour(0, 0, 0, m);
    }

    private static boolean tour(int i, int j,int count,  int[][] m) {
        if (count == m.length * m[i].length - 1) {
            m[i][j] = count;
            printSolution(m);
            System.out.println("=============================================================");
            m[i][j] = -1;
            return true;
        } else {
            m[i][j] = count;
            int k = 0;
            boolean done = false;
            while (k < moves.length && !done) {
                int nextI = i + moves[k][0];
                int nextJ = j + moves[k][1];
                if (inBounds(nextI, nextJ, m)) {
                    done
                            = tour(nextI, nextJ,count + 1, m);
                }
                k++;
            }
            m[i][j] = -1;
            return done;
        }


    }

    private static void printSolution(int[][] m) {
        Matrix.printMatrix(m);
    }

    private static boolean inBounds(int i, int j, int[][] m) {
        return i >= 0 && i < m.length && j >= 0 && j < m[i].length && m[i][j] < 0;
    }
}
