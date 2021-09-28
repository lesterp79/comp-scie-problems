package com.coding_interview_book.linked_lists;

import java.util.HashSet;
import java.util.Set;

public class RemoveDupsUnordered1 {
    public static void main(String[] args) {
        var head = new Node(1,  new Node(1,  new Node(2,  new Node(2, null))));
        removeDups(head);
        Node p = head;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

    private static void removeDups(Node head) {
        if (head != null && head.next != null) {
            Node p = head;
            Set<Integer> dups = new HashSet<>();
            dups.add(head.val);
            while (p.next != null) {
                if (dups.contains(p.next.val)) {
                    p.next = p.next.next;
                } else {
                    dups.add(p.next.val);
                    p = p.next;
                }
            }
        }
    }
}
