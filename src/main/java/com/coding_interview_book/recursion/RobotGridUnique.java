package com.coding_interview_book.recursion;


import java.awt.*;
import java.util.Stack;


public class RobotGridUnique {
    public static void main(String[] args) {

        // we define the maze
        boolean[][] maze  = new boolean[3][3];
        maze[0][1] = true;


        computePath(2, 2, maze, new Stack<>());


    }
    public static void computePath(int x, int y, boolean[][] maze, Stack<Point> path) {
        if (x < 0 || y < 0 || maze[x][y]) {
            return;
        }

        Point point = new Point(x, y);

        if (x == 0 && y == 0) {
            path.add(point);
            System.out.println("================================================================");
            path.stream().forEach(System.out::println);
            path.pop();
            return;
        }
        path.add(point);

        computePath(x - 1, y, maze, path);

        computePath(x, y - 1, maze, path);

        path.pop();
    }
}

