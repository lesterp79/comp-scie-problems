package com.coding_problems_book.arrays;

import static com.util.Matrix.printMatrix;

public class RotateMatrix {

    public static void main(String[] args) {
        int[][] m = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        rotateMatrixRings(m);
        printMatrix(m);
    }

    static void rotateMatrixTranspose(int[][] m) {
        if (m != null && m.length > 1) {
            for (int j = 0; j < m.length; j++) {
                for (int i = 0; i < m[j].length/2; i++) {
                    swap(m, i, j, m.length - 1 - i, j);
                }
            }
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[i].length - 1 - i; j++) {
                    swap(m, i, j, m.length - 1 - j, m[i].length - 1 - i);
                }
            }
        }
    }

    static void rotateMatrixRings(int[][] m) {
        if (m != null && m.length > 1) {
            for (int i = 0; i < m.length/2; i++) {
                for (int j = i; j < m[j].length - 1 - i; j++) {
                    var aux = m[j][i];
                    m[j][i] =  m[i][m[j].length - 1 - j];
                    m[i][m[j].length - 1 - j] = m[m.length - 1 - j][m.length - 1 - i];
                    m[m.length - 1 - j][m.length - 1 - i] = m[m.length - 1 - i][j];
                    m[m.length - 1 - i][j] = aux;
                }
            }
        }
    }

    private static void swap(int[][] m, int i1, int j1, int i2, int j2) {
        int aux = m[i1][j1];
        m[i1][j1] = m[i2][j2];
        m[i2][j2] = aux;
    }

}
