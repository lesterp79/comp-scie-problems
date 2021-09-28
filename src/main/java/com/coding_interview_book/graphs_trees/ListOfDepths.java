/*
 * ListOfDepths.java
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

import com.util.BTreeNode;
import com.util.BTreePrinter;
import com.util.Node;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
 * at each depth (e.g., if you have a tree with depth 0, you'll have 0 linked lists).
 * Hints: #107, #123, #735
 */
public class ListOfDepths {

    static Node<Node<BTreeNode<Integer>>> depths;

    static Map<Integer, Node<BTreeNode<Integer>>> depthsTailMap = new HashMap<>();

    static Map<Integer, Node<BTreeNode<Integer>>> depthsRootMap = new HashMap<>();

    public static void main(String[] args) {

        int[] listNumbers = new int[]{1, 2, 4, 5, 6, 7, 8, 9, 10};

        BTreeNode root = MinimalTree.minimalTree(listNumbers, 0, listNumbers.length - 1);

        BTreePrinter.printNode(root);

        createMapOfDepths(root, 0);

        createListOfDepths();

        Node<Node<BTreeNode<Integer>>> depth = depths;

        int i = 0;
        while (depth != null) {
            System.out.println("Level: " + i++);
            Node<BTreeNode<Integer>> node = depth.data;
            while (node != null) {
                System.out.println(node);
                node = node.next;
            }
            depth = depth.next;
        }

        System.out.println("Done");

    }

    private static void createListOfDepths() {
        Collection<Node<BTreeNode<Integer>>> depthsRoots = depthsRootMap.values();

        Node<Node<BTreeNode<Integer>>> aDepthList = depths;

        for (Node<BTreeNode<Integer>> depthsRoot: depthsRoots) {
            if (aDepthList == null) {
                aDepthList = new Node<>(depthsRoot);
                depths = aDepthList;
                continue;
            }
            aDepthList.next = new Node<>(depthsRoot);
            aDepthList = aDepthList.next;
        }
    }

    static void createMapOfDepths(BTreeNode<Integer> treeNode, int depth) {

        if (treeNode == null) {
            return;
        }

        addToListOfDepthsOrderOneWithMap(treeNode, depth);
        createMapOfDepths(treeNode.left, depth + 1);
        createMapOfDepths(treeNode.right, depth + 1);

    }


    private static void addToListOfDepthsOrderN(BTreeNode<Integer> aTreeNode, int aDepth) {

        Node<BTreeNode<Integer>> thisNode = new Node<>(aTreeNode);

        if (aDepth == 0) {
            depths = new Node<>(thisNode);
            return;
        }

        // find my list of depths
        Node<Node<BTreeNode<Integer>>> myDepthsRoot = depths;

        int depth = 0;
        while (depth < aDepth - 1) {
            myDepthsRoot = myDepthsRoot.next;
            depth++;
        }

        if (myDepthsRoot.next == null) {
            myDepthsRoot.next = new Node<>(thisNode);
            return;
        }

        Node<BTreeNode<Integer>> myNodeTail = myDepthsRoot.next.data;

        while (myNodeTail.next != null) {
            myNodeTail = myNodeTail.next;
        }

        myNodeTail.next = thisNode;

    }

    private static void addToListOfDepthsOrderOneWithMap(BTreeNode<Integer> aTreeNode, int aDepth) {

        System.out.println("Processing aTreeNode = [" + aTreeNode + "], aDepth = [" + aDepth + "]");

        Node<BTreeNode<Integer>> thisNode = new Node<>(aTreeNode);

        // find my list of depths
        Node<BTreeNode<Integer>> myDepthTail = depthsTailMap.get(aDepth);

        if (myDepthTail == null) {
            System.out.println("Inserting aTreeNode = [" + aTreeNode + "] as ROOT at Depth = [" + aDepth + "]");

            depthsRootMap.put(aDepth, thisNode);
            depthsTailMap.put(aDepth, thisNode);
            return;
        }

        System.out.println("Inserting tree node = [" + thisNode.data + "] after tree node tail = [" + myDepthTail.data + "] at Depth = ["
                        + aDepth + "]");

        myDepthTail.next = thisNode;

        depthsTailMap.put(aDepth, thisNode);

    }

}
