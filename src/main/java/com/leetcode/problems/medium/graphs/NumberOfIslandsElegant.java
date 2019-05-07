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
 * The algorithm works as follow:
 * <p>
 * Scan each cell in the grid. If the cell value is '1' explore that island. Mark the explored island cells with 'x'. Once finished
 * exploring that island, increment islands counter. The arrays dx[], dy[] store the possible moves from the current cell. Two land
 * cells ['1'] are considered from the same island if they are horizontally or vertically adjacent (possible moves
 * (-1,0),(0,1),(0,-1),(1,0)). Two '1' diagonally adjacent are not considered from the same island.
 */
public class NumberOfIslandsElegant {

    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    explore(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    public static void explore(char[][] grid, int i, int j) {
        grid[i][j] = 'x';
        for (int d = 0; d < dx.length; d++) {
            if (i + dy[d] < grid.length && i + dy[d] >= 0 && j + dx[d] < grid[0].length && j + dx[d] >= 0
                            && grid[i + dy[d]][j + dx[d]] == '1') {
                explore(grid, i + dy[d], j + dx[d]);
            }
        }
    }
}
