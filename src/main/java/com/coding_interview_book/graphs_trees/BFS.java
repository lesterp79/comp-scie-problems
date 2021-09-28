/*
 * BFS.java
 *
 * Copyright (c) 2000-2018 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.coding_interview_book.graphs_trees;

import com.util.Vertex;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class BFS {

    void bfs(Vertex vertex) {

        HashMap<Vertex, Integer> levels = new HashMap<>() ;
        levels.put(vertex, 0);

        HashMap<Vertex, Vertex> parents = new HashMap<>() ;
        parents.put(vertex, null);

        Deque<Vertex> frontier = new ArrayDeque<>();
        frontier.add(vertex);

        int i = 1;

        while (!frontier.isEmpty()) {
            int frontierSize = frontier.size();
            for (int j = 0; j < frontierSize; j++) {
                Vertex v = frontier.remove();
                for (Vertex u : v.neighbors) {
                    if (!levels.containsKey(u)) {
                        levels.put(u, i);
                        frontier.add(u);
                        parents.put(v, u);
                    }
                }
            }
            i++;
        }
    }
}
