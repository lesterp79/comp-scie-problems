package com.coding_interview_book.linked_lists;

import static com.coding_interview_book.linked_lists.Reverse.reverse;


public class Sum {

    public static void main(String[] args) {

        Node head1 = reverse(new Node(1, new Node(9, new Node(8, new Node(7, null)))));
        Node head2 = reverse(new Node(9, new Node(9, new Node(8, null))));

        Node head = reverse(sumLists(head1, head2, 0));


        while (head != null) {
            System.out.println(head.val);
            head = head.next;

        }
    }

    static Node sumLists(Node head1, Node head2, int carry) {

        if (head1 == null && head2 == null && carry == 0) {
            return null;
        }
        int value = carry;

        if (head1 != null) {
            value +=head1.val;
        }

        if (head2 != null) {
            value += head2.val;
        }

        Node rest = sumLists(head1 == null ? null : head1.next, head2 == null ? null : head2.next, value / 10);

        return new Node(value % 10, rest);
    }
}