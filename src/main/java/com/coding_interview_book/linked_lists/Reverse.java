package com.coding_interview_book.linked_lists;

public class Reverse {

    public static void main(String[] args) {
        Node head = new Node(1, new Node(9, new Node(8, new Node(7, null))));

        reverse(head);
        var node = newHead;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }
    static Node newHead;

    static Node reverse(Node head) {
        if (head != null) {
            reverse(null, head);
        }
        return newHead;
    }

    static void reverse(Node parent, Node node) {
        if (node.next == null) {
            newHead = node;
            node.next = parent;
        } else {
            reverse(node, node.next);
            node.next = parent;
        }
    }
}
