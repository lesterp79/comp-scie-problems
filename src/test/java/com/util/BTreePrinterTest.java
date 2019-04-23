package com.util;

public class BTreePrinterTest {

    private static BTreeNode<Integer> test1() {
        BTreeNode<Integer> root = new BTreeNode<Integer>(2);
        BTreeNode<Integer> n11 = new BTreeNode<Integer>(7);
        BTreeNode<Integer> n12 = new BTreeNode<Integer>(5);
        BTreeNode<Integer> n21 = new BTreeNode<Integer>(2);
        BTreeNode<Integer> n22 = new BTreeNode<Integer>(6);
        BTreeNode<Integer> n23 = new BTreeNode<Integer>(3);
        BTreeNode<Integer> n24 = new BTreeNode<Integer>(6);
        BTreeNode<Integer> n31 = new BTreeNode<Integer>(5);
        BTreeNode<Integer> n32 = new BTreeNode<Integer>(8);
        BTreeNode<Integer> n33 = new BTreeNode<Integer>(4);
        BTreeNode<Integer> n34 = new BTreeNode<Integer>(5);
        BTreeNode<Integer> n35 = new BTreeNode<Integer>(8);
        BTreeNode<Integer> n36 = new BTreeNode<Integer>(4);
        BTreeNode<Integer> n37 = new BTreeNode<Integer>(5);
        BTreeNode<Integer> n38 = new BTreeNode<Integer>(8);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;
        n12.left = n23;
        n12.right = n24;

        n21.left = n31;
        n21.right = n32;
        n22.left = n33;
        n22.right = n34;
        n23.left = n35;
        n23.right = n36;
        n24.left = n37;
        n24.right = n38;

        return root;
    }

    private static BTreeNode<Integer> test2() {
        BTreeNode<Integer> root = new BTreeNode<Integer>(2);
        BTreeNode<Integer> n11 = new BTreeNode<Integer>(7);
        BTreeNode<Integer> n12 = new BTreeNode<Integer>(5);
        BTreeNode<Integer> n21 = new BTreeNode<Integer>(2);
        BTreeNode<Integer> n22 = new BTreeNode<Integer>(6);
        BTreeNode<Integer> n23 = new BTreeNode<Integer>(9);
        BTreeNode<Integer> n31 = new BTreeNode<Integer>(5);
        BTreeNode<Integer> n32 = new BTreeNode<Integer>(8);
        BTreeNode<Integer> n33 = new BTreeNode<Integer>(4);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;

        n12.right = n23;
        n22.left = n31;
        n22.right = n32;

        n23.left = n33;

        return root;
    }

    public static void main(String[] args) {

        BTreePrinter.printNode(test1());
        BTreePrinter.printNode(test2());

    }
}