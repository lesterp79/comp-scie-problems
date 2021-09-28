package com.coding_interview_book.graphs_trees;

import com.util.BTreeNode;
import com.util.BTreeUtil;

public class BalancedBST {

    public static void main(String[] args) {


    /*  not balanced at root
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
        BTreeUtil.insertBST(36, root); // if you comment this line the tree is balanced

        System.out.println("Balanced? " + isBalanced(root));

    }

    private static <T> boolean isBalanced(BTreeNode<T> root) {
        if (root == null) {
            return true;
        }

        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static <T> int getHeight(BTreeNode<T> root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}


