package com.coding_interview_book.linked_lists;

public class MergeSorted {

    public static void main(String[] args) {
        Node head1 = new Node(1, null);
        Node head2 = new Node(4, null);

        Node head = mergeSorted(head1, head2);

        Node.print(head);

    }

    static Node mergeSorted(Node node1, Node node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }

        Node more;
        if (node1.val < node2.val) {
            more = mergeSorted(node1.next, node2);
        } else {
            more = mergeSorted(node1, node2.next);
        }

        return new Node(Math.min(node1.val, node2.val), more);

    }

}
