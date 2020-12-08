/*
 * KnightTour.java
 *
 * Copyright (c) 2000-2019 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.other.backtracking;

/**
 * The knight is placed on the first block of an empty board and, moving according to the rules of chess, must visit each square
 * exactly once. Given a board of 8x8, return all possible tours.
 */
public class KnightTour {

    public static void main(String[] args) {
        new KnightTour().knightTours();
    }

    /**
     * If all squares are visited
     *     print the solution
     * Else
     *    a) Add one of the next moves to solution vector and recursively
     *    check if this move leads to a solution. (A Knight can make maximum
     *    eight moves. We choose one of the 8 moves in this step).
     *    b) If the move chosen in the above step doesn't lead to a solution
     *    then remove this move from the solution vector and try other
     *    alternative moves.
     *    c) If none of the alternatives work then return false (Returning false
     *    will remove the previously added item in recursion and if false is
     *    returned by the initial call of recursion then "no solution exists" )
     * @return
     */
    boolean knightTours() {

        int sol[][] = new int[8][8];

        for (int x = 0; x < sol.length; x++) {
            for (int y = 0; y < sol[0].length; y++) {
                sol[x][y] = -1;
            }

        }

        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

        // since the Knight is initially at the first block
        sol[0][0] = 0;

        // start from 0,0 and explore all tours
        if (!isKnightTour(0, 0, 1, sol, xMove, yMove)) {
            System.out.println("Solution does not exist");
            return false;
        } else
            printSolution(sol);

        return true;

    }

    boolean isKnightTour(int x, int y, int i,
                    int sol[][], int xMove[],
                    int yMove[]) {

        int next_x, next_y;

        if (i == sol.length * sol[0].length)
            return true;

        // Try all next moves from the current coordinate x, y
        for (int k = 0; k < 8; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if (isSafe(next_x, next_y, sol)) {
                sol[next_x][next_y] = i;
                if (isKnightTour(next_x, next_y, i + 1,
                                sol, xMove, yMove))
                    return true;
                else
                    sol[next_x][next_y] = -1;// backtracking
            }
        }

        return false;
    }

    static boolean isSafe(int x, int y, int sol[][]) {
        return (x >= 0 && x < sol.length && y >= 0 &&
                        y < sol[0].length && sol[x][y] == -1);
    }

    static void printSolution(int sol[][]) {
        for (int x = 0; x < sol.length; x++) {
            for (int y = 0; y < sol[0].length; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }
}
