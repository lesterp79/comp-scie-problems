package com.coding_interview_book.graphs_trees;

import com.util.Graph;

import java.util.ArrayDeque;
import java.util.HashSet;

public class IsGraph {

    public static void main(String[] args) {

        var graph = new Graph<String>();

        // directed graph
        graph.addEdge("A", "C");
        graph.addEdge("C", "B");
        graph.addEdge("C", "E");
        graph.addEdge("B", "E");
        graph.addEdge("D", "A");
        graph.addEdge("D", "B");

        boolean isPathAE = isPath(graph, "A", "E");
        System.out.println("Is path from A to E: " + isPathAE);

        boolean isPathEA = isPath(graph, "E", "A");
        System.out.println("Is path from E to A: " + isPathEA);

        boolean isPathCD = isPath(graph, "C", "D");
        System.out.println("Is path from C to D: " + isPathCD);

        boolean isPathDC = isPath(graph, "D", "C");
        System.out.println("Is path from D to C: " + isPathDC);

        boolean isPathDE = isPath(graph, "D", "E");
        System.out.println("Is path from D to E: " + isPathDE);

        boolean isPathED = isPath(graph, "E", "D");
        System.out.println("Is path from E to D: " + isPathED);
    }

    private static <T> boolean isPath(Graph<T> graph, T from, T to) {

        var queue = new ArrayDeque<T>();
        var visited = new HashSet<T>();

        queue.add(from);
        visited.add(from);

        var found = false;

        while (!queue.isEmpty() && !found) {
            T current = queue.poll();
            if (to.equals(current)) {
                found = true;
            } else {
                var adjList = graph.adjacencyList.get(current);
                if (adjList != null) {
                    for (T adj : adjList) {
                        if (!visited.contains(adj)) {
                            queue.add(adj);
                            visited.add(adj);
                        }
                    }
                }
            }
        }

        return found;
    }
}


