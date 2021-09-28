package com.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {

    // the adjacency list is represented as a map
    public final Map<T, List<T>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    // adding a new edge between two elements
    public boolean addEdge(T from, T to) {

        if (from == null || to == null) {
            return false;
        }

        List<T> adjacents = adjacencyList.get(from);

        // we add an element that has no edges until now, therefore
        // we have to add the element and create its empty list of adjacents
        if (adjacents == null) {

            List list = new ArrayList<>();
            list.add(to);

            adjacencyList.put(from, list);
        } else {
            // we add an edge to an existing element
            adjacents.add(to);
        }

        return true;
    }
}
