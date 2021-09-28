package com.coding_interview_book.graphs_trees;

import com.util.BTreeNode;
import com.util.BTreeUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class ListPerBinaryTreeLevel {

    public static void main(String[] args) {

        // [[40], [47, 45], [11, 13, 44, 88], [3, 1]]
    /*
              --40--
            /        \
          -47-       -45-
         /    \     /    \
        11     13  44    88
       /  \
      3    1
    */


        var root = new BTreeNode<>(40);
       BTreeUtil.insertBFS(47, root);
       BTreeUtil.insertBFS(45, root);
       BTreeUtil.insertBFS(11, root);
       BTreeUtil.insertBFS(13, root);
       BTreeUtil.insertBFS(44, root);
       BTreeUtil.insertBFS(88, root);
       BTreeUtil.insertBFS(3, root);
       BTreeUtil.insertBFS(1, root);

        System.out.println(fetchAllLevels(root));
    }
    public static <T extends Comparable<T>> List<List<T>> fetchAllLevels(BTreeNode<T> root) {
        ArrayList<List<T>> allLevels = new ArrayList<>();
        var level = 0;
        var queue = new ArrayDeque<BTreeNode<T>>();
        queue.add(root);

        while (!queue.isEmpty()) {
            var levelSize = queue.size();
            var levelList = new ArrayList<T>();
            for (int i = 0; i < levelSize; i++) {
                var current = queue.poll();
                levelList.add(current.val);
                if (current.hasRightChild()) {
                    queue.add(current.right);
                }
                if (current.hasLeftChild()) {
                    queue.add(current.left);
                }
            }
            allLevels.add(levelList);
            level++;
        }

        return allLevels;
    }
}
