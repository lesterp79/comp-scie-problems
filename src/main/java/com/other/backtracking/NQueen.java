/*
 * NQueen.java
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
 * <p>The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other.  For
 * example, following is a solution for 4 Queen problem.</p>
 *
 *               { 0,  1,  0,  0}
 *               { 0,  0,  0,  1}
 *               { 1,  0,  0,  0}
 *               { 0,  0,  1,  0}
 *  </pre>
 *
 *  Start in the leftmost column
 * 2) If all queens are placed
 *     return true
 * 3) Try all rows in the current column.
 *    Do following for every tried row.
 *     a) If the queen can be placed safely in this row
 *        then mark this [row, column] as part of the
 *        solution and recursively check if placing
 *        queen here leads to a solution.
 *     b) If placing the queen in [row, column] leads to
 *        a solution then return true.
 *     c) If placing queen doesn't lead to a solution then
 *        unmark this [row, column] (Backtrack) and go to
 *        step (a) to try other rows.
 * 3) If all rows have been tried and nothing worked,
 *    return false to trigger backtracking.</pre>
 */
public class NQueen {
    public static void main(String[] args) {
        final int[][] board = new int[4][4];

        if ( solveForNQueens(4, board)) {
            printSolution(board);
        }
    }

    public static boolean solveForNQueens(int n, int[][] board) {
        if (n == 0) { // all queens are placed, we found a solution
            return true;
        }

        for (int col = 0; col < board.length; col++) {
            for (int row = 0; row < board[0].length; row++) {
                if (isSafe(col, row, board)) { // if safe square
                    // place queen here
                    board[col][row] = 1;
                    // try to solve for n - 1 queens, now that we placed this queen here
                    if (solveForNQueens(n - 1, board)) { // we found a solution using this configuration, we can return
                        return true;
                    } else { // this configuration was not good, remove queen n (backtrack) and keep trying to place it elsewhere
                        board[col][row] = 0;
                    }

                }
            }
        }

        return false;
    }

    /**
     *
     * @param col
     * @param row
     * @param board
     * @return
     */
    static boolean isSafe(int col, int row, int[][] board) {
        return isInBounds(col, row, board) && board[col][row] == 0 && !threatensQueen(col, row, board);
    }

    private static boolean isInBounds(int col, int row, int[][] board) {
        return col >= 0 && col < board.length && row >= 0 && row < board[0].length;
    }


    private static boolean threatensQueen(final int aCol, final int aRow, int[][] aBoard) {

        int xMove[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int yMove[] = {-1, 0, -1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            int col = aCol + xMove[i];
            int row = aRow + yMove[i];
            int j = 1;
            while (isInBounds(col, row, aBoard)) {
                if (aBoard[col][row] == 1) {
                    return true;
                }
                j++;
                col = xMove[i] * j;
                row = yMove[i] * j;
            }
        }
        return false;
    }

    static void printSolution(int sol[][]) {
        for (int x = 0; x < sol.length; x++) {
            for (int y = 0; y < sol[0].length; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }

}
