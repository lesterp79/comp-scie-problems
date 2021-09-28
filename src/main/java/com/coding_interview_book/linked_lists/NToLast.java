package com.coding_interview_book.linked_lists;

import java.util.Optional;

public class NToLast {
    public static void main(String[] args) {
        var head = new Node(2, new Node(1, new Node(5, new Node(9, new Node(8, new Node(3, new Node(7, null)))))));
        nthToLast(head, 8).ifPresentOrElse(n -> System.out.println(n.val), () -> System.out.println("Not Found"));

    }

    private static Optional<Node> nthToLast(Node head, int n) {
        int i = n - 1;
        Node p2 = head;
        while (p2 != null && i > 0) {
            p2 = p2.next;
            i--;
        }

        if (p2 == null) {
            return Optional.empty();
        } else {
            Node p1 = head;
            while (p2.next != null) {
                p1 = p1.next;
                p2 = p2.next;
            }
            return Optional.of(p1);
        }
    }
}