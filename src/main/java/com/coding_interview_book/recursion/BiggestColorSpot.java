package com.coding_interview_book.recursion;

import java.util.Random;

public class BiggestColorSpot {

    public static void main(String[] args) {

        int cols = 5;
        int rows = 5;
        int colors = 3; // a spot can have the colors 1, 2 or 3

        Random rnd = new Random();

        int[][] a = new int[rows][cols];

        // add random colors
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                a[i][j] = rnd.nextInt(colors);
            }
        }

        // show the surface on screen
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }

        BiggestColorSpot spots = new BiggestColorSpot();
        spots.determineBiggestColorSpot(a);
        System.out.println("spots.biggestColorSpot = " + spots.biggestColorSpot);
        System.out.println("spots.biggestColor = " + spots.biggestColor);
    }

    int biggestColorSpot = 0;
    private int currentColorSpot;
    int biggestColor;
    private int[][] adj = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    void determineBiggestColorSpot(int[][] a) {
        if (a == null || a.length < 1) {
            return;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] > 0) {
                    currentColorSpot = 0;
                    computeColorSpot(i, j, a, a[i][j]);
                    if (currentColorSpot > biggestColorSpot) {
                        biggestColorSpot = currentColorSpot;
                        biggestColor = -a[i][j];
                    }
                }
            }
        }
    }
    private void computeColorSpot(int i, int j, int a[][], int color) {
        currentColorSpot++;
        a[i][j] = -a[i][j];

        for (int[] delta : adj) {

            int x = i + delta[0];
            int y = j + delta[1];

            if (inBounds(x, a.length)
                    && inBounds(y, a[i].length)
                    && isSameColor(x, y, a, color)) {
                computeColorSpot(x, y, a, color);
            }
        }

//        if (i > 1 && a[i - 1][j] == color) {
//            computeColorSpot(i - 1, j, a, color);
//        }
//
//        if ((i + 1) < a.length && a[i + 1][j] == color) {
//            computeColorSpot(i + 1, j, a, color);
//        }
//
//        if (j > 1 && a[i][j - 1] == color) {
//            computeColorSpot(i, j - 1, a, color);
//        }
//
//        if ((j + 1) < a[i].length && a[i][j + 1] == color) {
//            computeColorSpot(i, j + 1, a, color);
//        }
    }

    private boolean inBounds(int x, int upper) {
        return x >= 0 && x < upper;
    }

    private boolean  isSameColor(int i, int j, int[][] a, int color) {
        return a[i][j] == color;
    }
}


