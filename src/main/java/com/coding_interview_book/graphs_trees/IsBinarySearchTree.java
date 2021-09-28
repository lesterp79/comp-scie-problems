package com.coding_interview_book.graphs_trees;

import com.util.BTreeNode;
import com.util.BTreeUtil;

public class IsBinarySearchTree {

    public static void main(String[] args) {


            /*
              40
            /    \
           30     49
          /  \   /  \
         20  35 45   52
            /  \
           34  37
              /
             36
    */


        var root = new BTreeNode<>(40);
        BTreeUtil.insertBST(30, root);
        BTreeUtil.insertBST(49, root);
        BTreeUtil.insertBST(20, root);
        BTreeUtil.insertBST(35, root);
        BTreeUtil.insertBST(45, root);
        BTreeUtil.insertBST(52, root);
        BTreeUtil.insertBST(34, root);
        BTreeUtil.insertBST(37, root);
        BTreeUtil.insertBST(36, root);

        System.out.println(isBST(root, null, null));


        /*    P:
              40
            /    \
          30      50
         /  \    /  \
        20   90  70 80
       /
      6
        */
        root = new BTreeNode<>(40);
        BTreeUtil.insertBFS(30, root);
        BTreeUtil.insertBFS(50, root);
        BTreeUtil.insertBFS(20, root);
        BTreeUtil.insertBFS(90, root);
        BTreeUtil.insertBFS(70, root);
        BTreeUtil.insertBFS(80, root);
        BTreeUtil.insertBFS(6, root);

        System.out.println(isBST(root, null, null));

              /*
              40

    */
        root = new BTreeNode<>(40);

        System.out.println(isBST(root, null, null));

    }


    public static <T extends Comparable<T>> boolean isBST(BTreeNode<T> root, T min, T max) {
        if (root == null) {
            return true;
        } else {

            if ((min != null && root.val.compareTo(min) <= 0) || (max != null && root.val.compareTo(max) > 0)) {
                return false;
            }


            return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);


        }
    }
}
