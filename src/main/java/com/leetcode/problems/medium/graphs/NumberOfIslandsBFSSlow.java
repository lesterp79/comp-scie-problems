/*
 * NumberOfIslands.java
 *
 * Copyright (c) 2000-2019 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.leetcode.problems.medium.graphs;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed
 * by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * Input: 11110 11010 11000 00000
 * <p>
 * Output: 1 Example 2:
 * <p>
 * Input: 11000 11000 00100 00011
 * <p>
 * Output: 3
 */
public class NumberOfIslandsBFSSlow {

    public static void main(String[] args) {
        char[][] grid = new char[4][];
        grid[0] = new char[]{'1', '1', '0', '0', '0'};
        grid[1] = new char[]{'1', '1', '0', '0', '0'};
        grid[2] = new char[]{'0', '0', '0', '0', '0'};
        grid[3] = new char[]{'0', '0', '0', '0', '0'};

        System.out.println(new NumberOfIslandsBFSSlow().numIslands(grid));
    }

    static int[] dx = new int[]{0, -1, 0, 1};
    static int[] dy = new int[]{1, 0, -1, 0};



    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = 'x';
                    findIsland(i, j, grid);
                    numIslands++;
                }
            }
        }

        return numIslands;
    }

//    void findIsland(int i, int j, char[][] grid) {
//
//        for (int k = 0; k < dx.length; k++) {
//            if (i + dx[k] >= 0 && i + dx[k] < grid.length & j + dy[k] >= 0 && j + dy[k] < grid[i + dx[k]].length
//                            && grid[i + dx[k]][j + dy[k]] == '1') {
//                grid[i + dx[k]][j + dy[k]] = 'x';
//                findIsland(i + dx[k], j + dy[k], grid);
//            }
//        }
//    }

    void findIsland(int i, int j, char[][] grid) {

        if (i + 1 < grid.length && grid[i + 1][j] == '1'){
            grid[i + 1][j] = 'x';
            findIsland(i + 1, j, grid);
        }

        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            grid[i - 1][j] = 'x';
            findIsland(i - 1, j, grid);
        }

        if (j + 1 < grid[0].length && grid[i][j + 1] == '1') {
            grid[i][j + 1] = 'x';
            findIsland(i , j + 1, grid);
        }

        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            grid[i][j - 1] = 'x';
            findIsland( i, j - 1, grid);
        }
    }
}


