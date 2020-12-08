/*
 * RottingOranges.java
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

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * In a given grid, each cell can have one of three values:
 *
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1
 * instead.
 */

public class RottingOranges {

    public static void main(String[] args) {
        int[][] grid = new int[3][];
        grid[0] = new int[] {2, 1, 1};
        grid[1] = new int[] {0, 1, 1};
        grid[2] = new int[] {1, 0, 1};

        System.out.println(new RottingOranges().orangesRotting(grid));

    }

    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};

    int numGoodApples = 0;



    public int orangesRotting(int[][] grid) {

        Queue<Integer> queue = new ArrayDeque<>();
        int il = grid.length;

        for (int i = 0; i < il; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(j * 10 + i);
                } else if (grid[i][j] == 1) {
                    numGoodApples++;
                }
            }
        }

        int depth = 0;
        while (!queue.isEmpty() && numGoodApples > 0) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int code = queue.remove();
                queueAdjacentOranges(code % 10, code / 10, grid, queue);
            }
            depth++;
        }

        return numGoodApples > 0 ? -1 : depth;
    }

    void queueAdjacentOranges(int i, int j, int[][] grid, Queue<Integer> queue) {
        for (int d = 0; d < dx.length; d++) {
            if (i + dy[d] < grid.length && i + dy[d] >= 0 && j + dx[d] < grid[0].length && j + dx[d] >= 0
                            && grid[i + dy[d]][j + dx[d]] == 1 && numGoodApples > 0) {
                grid[i + dy[d]][j + dx[d]] = 2;
                numGoodApples--;
                queue.offer((j + dx[d]) * 10 + i + dy[d]);
            }
        }
    }

}

