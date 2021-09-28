package com.coding_interview_book.graphs_trees;

import com.util.BTreeNode;
import com.util.BTreeUtil;

public class BSTSuccessor {
    public static void main(String[] args) {
    /*
              70
            /    \
          50      75
         /  \    /  \
        40  55  72  77
       /   /  \
      35  54   60
              /
             58
              \
              59
    */
        var root = new BTreeNode<>(70);
        BTreeUtil.insertBST(50, root);
        BTreeUtil.insertBST(75, root);
        BTreeUtil.insertBST(40, root);
        BTreeUtil.insertBST(55, root);
        BTreeUtil.insertBST(72, root);
        BTreeUtil.insertBST(77, root);
        BTreeUtil.insertBST(35, root);
        BTreeUtil.insertBST(54, root);
        BTreeUtil.insertBST(60, root);
        BTreeUtil.insertBST(58, root);
        BTreeUtil.insertBST(59, root);

        var succ = new BSTSuccessor();
//        System.out.println(succ.findSuccessorInOrder(root, 61));
//        System.out.println(succ.successor != null ? succ.successor : "No successor");


        succ = new BSTSuccessor();
        System.out.println(succ.findSuccessorPreOrder(root, 59));
        System.out.println(succ.successor != null ? succ.successor : "No successor");

    }

    Integer successor;

    private boolean findSuccessorInOrder(BTreeNode<Integer> root, int value) {
        if (root == null) {
            return false;
        }

        if (root.val == value) {
            if (root.hasRightChild()) {
                var tmp = root.right;
                while (tmp.left != null) {
                    tmp = tmp.left;
                }
                successor = tmp.val;
            }
            return true;
        } else if (root.val < value) {
            return findSuccessorInOrder(root.right, value);
        } else {
            successor = root.val;
            return findSuccessorInOrder(root.left, value);

        }
    }

    private boolean findSuccessorPreOrder(BTreeNode<Integer> root, int value) {
        if (root == null) {
            return false;
        }
        if (root.val == value) {
            if (root.hasLeftChild()) {
                successor = root.left.val;
            } else if (root.hasRightChild()) {
                successor = root.right.val;
            }
            return true;

        } else if (root.val > value) {
            if (root.hasRightChild()) {
                successor = root.right.val;
            }
            return findSuccessorPreOrder(root.left, value);
        } else {
            return findSuccessorPreOrder(root.right, value);
        }
    }

}