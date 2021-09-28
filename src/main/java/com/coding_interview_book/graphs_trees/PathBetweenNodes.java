package com.coding_interview_book.graphs_trees;

import com.util.Vertex;

import java.util.*;

public class PathBetweenNodes {


    public static boolean existPathBtwNodes(Vertex from, Vertex to) {
        if (from == to) {
            return true;
        }

        Set<Vertex> visited = new HashSet<>();
        Deque<Vertex> queue = new ArrayDeque<>();

        queue.add(from);

        while (!queue.isEmpty()) {
            Vertex curr = queue.poll();
            if (curr == to) {
                return true;
            }
            visited.add(curr);
            for (Vertex v : curr.neighbors) {
                if (!visited.contains(v)) {
                    queue.offer(v);
                }
            }
        }

        return false;




    }
}
