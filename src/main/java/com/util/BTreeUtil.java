package com.util;

import java.util.LinkedList;
import java.util.Queue;

public class BTreeUtil {

    public static <T extends Comparable<T>> boolean insertBST(T element, BTreeNode<T> root) {

        if (element == null) {
            return false;
        }

        insert(root, element);

        return true;
    }

    private static <T extends Comparable<T>> BTreeNode<T> insert(BTreeNode<T> current, T element) {

        if (current == null) {
            return new BTreeNode<T>(element);
        }

        if (element.compareTo(current.val) < 0) {
            current.left = insert(current.left, element);
        } else {
            current.right = insert(current.right, element);
        }

        return current;
    }
    // insert a node into the tree via Breadth-First Search (BFS)
    public static <T extends Comparable<T>> boolean insertBFS(T element, BTreeNode<T> root) {

        if (element == null) {
            return false;
        }

        insertBFS(root, element);

        return true;
    }

    // insert via Breadth-first Search (BFS) algorithm
    private static <T extends Comparable<T>> void insertBFS(BTreeNode<T> node, T element) {

        Queue<BTreeNode<T>> queue = new LinkedList<>();

        queue.add(node);

        while (!queue.isEmpty()) {
            node = queue.peek();
            queue.poll();

            if (node.left == null) {
                node.left = new BTreeNode<>(element);
                break;
            } else {
                queue.add(node.left);
            }

            if (node.right == null) {
                node.right = new BTreeNode<>(element);
                break;
            } else {
                queue.add(node.right);
            }
        }
    }
}
