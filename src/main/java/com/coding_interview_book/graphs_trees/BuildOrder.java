/*
 * BuildOrder.java
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

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of projects, where the second
 * project is dependent on the first project). All of a project's dependencies must be built before the project is. Find a build
 * order that will allow the projects to be built. If there is no valid build order, return an error. EXAMPLE Input: projects: a, b,
 * c, d, e, f dependencies: (a, d), (f, b), (b, d), (f, a), (d, c) Output: f, e, a, b, d, c Hints: #26, #47, #60, #85, # 125, # 733
 * 4.8
 */
public class BuildOrder {

    public static void main(String[] args) {
        int m = 0;
        int n = 0;

    }

    void test(int n) {
        if (n < 5) {
            System.out.println(n);
        } else {
            for (int i = 0; i < n; i++) {
                System.out.println(i);
            }
        }
    }

    /* Find a correct build order . */
    Project[] findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    Project[] orderProjects(ArrayList<Project> aNodes) {

        if (aNodes == null) {
            return null;
        }

        Project[] buildOrder = new Project[aNodes.size()];

        return buildOrder;

    }

    Graph buildGraph(String[] aProjects, String[][] aDependencies) {
        // if there's no projects in the list, return an empty graph
        Graph graph = new Graph();
        if (aProjects == null) {
            return graph;
        }

        for (String projectName : aProjects) {
            graph.getOrCreateNode(projectName);
        }

        // if there's any project in the dependencies list that was not present in the original list of project, it will be created
        for (String[] dependency : aDependencies) {
            graph.addEdge(dependency[0], dependency[1]);
        }

        return graph;
    }



}

class Graph {
    private ArrayList<Project> nodes = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>();

    public Project getOrCreateNode(String name) {
        if (!map.containsKey(name)) {
            Project node = new Project(name);
            nodes.add(node);
            map.put(name, node);
        }

        return map.get(name);
    }

    public void addEdge(String startName, String endName) {
        Project start = getOrCreateNode(startName);
        Project end = getOrCreateNode(endName);
        start.addNeighbor(end);
    }

    public ArrayList<Project> getNodes() {
        return nodes;
    }
}

class Project {
    private ArrayList<Project> children = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>();
    private String name;
    private int dependencies = 0;

    public Project(String n) {
        name = n;
    }

    public void addNeighbor(Project node) {
        if (!map.containsKey(node.getName())) {
            children.add(node);
            map.put(node.getName(), node);
            node.incrementDependencies();
        }
    }

    public void incrementDependencies() {
        dependencies++;
    }

    public void decrementDependencies() {
        dependencies--;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Project> getChildren() {
        return children;
    }

    public int getNumberDependencies() {
        return dependencies;
    }
}