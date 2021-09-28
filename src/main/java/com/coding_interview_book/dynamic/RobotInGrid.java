/*
 * RobotInGrid.java
 *
 * Copyright (c) 2000-2019 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.coding_interview_book.dynamic;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Robot in a Grid: Imagine a robot sitting on the upper left corner of grid with r rows and c columns. The robot can only move in
 * two directions, right and down, but certain cells are "off limits" such that the robot cannot step on them. Design an algorithm
 * to find a path for the robot from the top left to the bottom right.
 */
public class RobotInGrid {

    public static void main(String[] args) {
        boolean[] row1 = {false, true, true, true};
        boolean[] row2 = {true, true, true, true};
        boolean[] row3 = {true, true, true, true};
        boolean[] row4 = {true, true, true, true};

        boolean[][] maze = new boolean[4][];
        maze[0] = row1;
        maze[1] = row2;
        maze[2] = row3;
        maze[3] = row4;

        ArrayList<Point> path = new RobotInGrid().getPath(maze);

        for (Point point : path) {
            System.out.println("point = " + point);
        }

    }

    ArrayList<Point> getPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) {
            return new ArrayList<>();
        }
        Set<Point> failedPoints = new HashSet<>();
        ArrayList<Point> path = new ArrayList<>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
            return path;
        }

        return null;
    }

    boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, Set<Point> failedPoints) {

        if (col < 0 || row < 0 || !maze[row][col]) {
            return false;
        }

        Point point = new Point(row, col);

        /* If we've already visited this cell, return. */
        if (failedPoints.contains(point)) {
            return false;
        }

        boolean isAtOrigin = row == 0 && col == 0;


        /* If there's a path from the start to here, add my location. */
        if (isAtOrigin || getPath(maze, row, col - 1, path, failedPoints) || getPath(maze, row - 1, col, path, failedPoints)) {
            path.add(point);
            return true;
        }

        failedPoints.add(point); //cache result
        return false;
    }

}
