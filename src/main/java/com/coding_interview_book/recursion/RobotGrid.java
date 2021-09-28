package com.coding_interview_book.recursion;

import java.awt.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class RobotGrid {

    public static void main(String[] args) {

        /* 0 - robot, # - maze, X - target
 (m, n) +           +
        |0| | | | | |
        |0|0| | | | |
        |#|0|0|0|0| |
        |#|#|#|#|0| |
        | | | | |0| |
        | | | | |0|X|
        +           + (0, 0)
        */

        // we store the path in a LinkedHashSet
        Set<Point> path = new LinkedHashSet<>();

        // we define the maze
        boolean[][] maze  = new boolean[6][6];
        maze[2][0]=true;
        maze[3][0]=true;
        maze[3][1]=true;
        maze[3][2]=true;
        maze[3][3]=true;

        boolean[][] visited  = new boolean[6][6];

        // we compute and display the path
        RobotGrid.computePath(5, 5, maze, path, visited);

        path.stream().forEach(System.out::println);
    }
    public static boolean computePath(int m, int n, boolean[][] maze, Set<Point> path, boolean[][] visited) {
        if (m < 0 || n < 0 || maze[m][n] || visited[m][n]) {
            return false;
        }
        visited[m][n] = true;
        if (m == 0 && n == 0 || computePath(m, n - 1, maze, path, visited) || computePath(m - 1, n, maze, path, visited)) {
            path.add(new Point(n, m));
            return true;
        } else {
            return false;
        }

    }
}
