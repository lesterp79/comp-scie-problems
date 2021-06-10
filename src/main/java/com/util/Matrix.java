package com.util;

public class Matrix {
    public static void printMatrix(int[][] m) {
        System.out.print("{ ");
        for (int i = 0; i < m.length; i++) {
            System.out.print("{ ");
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j]);
                if (j != m[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print(" }");
            if (i != m.length - 1) {
                System.out.print(", ");
            }

        }
        System.out.print(" }");
    }
}
