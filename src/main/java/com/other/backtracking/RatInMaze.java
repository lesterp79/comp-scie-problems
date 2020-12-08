/*
 * RatInMaze.java
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
 * A Maze is given as N*N binary matrix of blocks where source block is the upper left most block i.e., maze[0][0] and destination
 * block is lower rightmost block i.e., maze[N-1][N-1]. A rat starts from source and has to reach the destination. The rat can move
 * only in two directions: forward and down. In the maze matrix, 0 means the block is a dead end and 1 means the block can be used
 * in the path from source to destination.
 */
public class RatInMaze {

    public static void main(String[] args) {
        final int[][] maze = new int[3][];

        maze[0] = new int[]{1, 1, 1, 1, 1, 1};
        maze[1] = new int[]{1, 0, 0, 0, 1, 1};
        maze[2] = new int[]{1, 0, 0, 0, 1, 1};

        int sol[][] = new int[maze.length][maze[0].length];

        // prepare the solution matrix
        for (int x = 0; x < sol.length; x++) {
            for (int y = 0; y < sol[0].length; y++) {
                sol[x][y] = 0;
            }
        }

        if (new RatInMaze().solveMaze(maze, sol)) {
            printSolution(sol);
        } else {
            System.out.println("No solution");
        }

    }

    boolean solveMaze(int maze[][], int[][] sol) {

        return solveMaze(0, 0, sol, maze);
    }

    boolean solveMaze(int x, int y, int sol[][], int maze[][]) {

        // arrived at destination
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            sol[x][y] = 1;
            return true;
        }

        // try to move forward
        if (isSafe(x, y, maze)) {
            sol[x][y] = 1;
            if (solveMaze(x + 1, y, sol, maze)) {
                return true;
            }

            if (solveMaze( x, y + 1, sol, maze)) {
                return true;
            }
            // backtrack
            sol[x][y] = 0;
            return false;
        }

        return false;
    }

    static boolean isSafe(int x, int y, int[][] maze) {
        return (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 1);
    }

    static void printSolution(int sol[][]) {
        for (int x = 0; x < sol.length; x++) {
            for (int y = 0; y < sol[0].length; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }
}
