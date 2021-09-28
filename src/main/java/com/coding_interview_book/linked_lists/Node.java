package com.coding_interview_book.linked_lists;

class Node {
    Node next;
    int val;

    public Node(int val, Node next) {
        this.next = next;
        this.val = val;
    }

    public Node(int val) {
        this(val, null);
    }

    static void print(Node node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}

