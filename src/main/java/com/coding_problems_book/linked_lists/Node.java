package com.coding_problems_book.linked_lists;

class Node {
    Node next;
    int val;

    public Node(int val, Node next) {
        this.next = next;
        this.val = val;
    }

    static void print(Node node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}

