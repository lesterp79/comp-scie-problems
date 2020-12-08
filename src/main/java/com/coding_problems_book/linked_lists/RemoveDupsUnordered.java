package com.coding_problems_book.linked_lists;

import java.util.HashSet;

public class RemoveDupsUnordered {

    public static void main(String[] args) {
        var head = new Node(1, new Node(1, null));
        removeDups(head);
        var node = head;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    static void removeDups(Node head) {
        if (head != null) {
            var previous = head;
            var node = head.next;

            var dups = new HashSet<Integer>();
            dups.add(head.val);

            while (node != null) {
                if (!dups.add(node.val)) {
                    previous.next = node.next;
                } else {
                    previous = node;
                }
                node = node.next;
            }
        }
    }
}

