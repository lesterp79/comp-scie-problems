package com.coding_interview_book.graphs_trees;

import com.util.BTreeNode;
import com.util.BTreeUtil;

public class SubTree {

    public static void main(String[] args) {
  /*    P:                     Q:
              40                     30
            /    \                  /  \
          30      10               20   90
         /  \    /  \             /
        20   90  70 80           6
       /
      6
        */

        var p = new BTreeNode<>(40);

         BTreeUtil.insertBFS(30, p);
         BTreeUtil.insertBFS(10, p);
         BTreeUtil.insertBFS(20, p);
         BTreeUtil.insertBFS(90, p);
         BTreeUtil.insertBFS(70, p);
         BTreeUtil.insertBFS(80, p);
         BTreeUtil.insertBFS(6, p);

        var q = new BTreeNode<>(30);

        BTreeUtil.insertBFS(20, q);
        BTreeUtil.insertBFS(90, q);
        BTreeUtil.insertBFS(6, q);

        System.out.println("'p' subtree of 'q' ? " + isSubTree(p, q));
        System.out.println("'q' subtree of 'p' ? " + isSubTree(q, p));
    }
    public static <T> boolean isSubTree(BTreeNode<T> p, BTreeNode<T> q) {
        if (p == null || q == null) {
            return false;
        }

        if (verify(p, q)) {
            return true;
        } else {
            return isSubTree(p.left, q) || isSubTree(p.right, q);
        }
    }

    private static <T> boolean verify(BTreeNode<T> p, BTreeNode<T> q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            return (p.val == q.val) && verify(p.left, q.left) && verify(p.right, q.right);
        }
    }
}
