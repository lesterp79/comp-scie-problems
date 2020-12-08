package com.coding_problems_book.linked_lists;

import static com.coding_problems_book.linked_lists.Reverse.reverse;

public class SwapAdjacent {

    public static void main(String[] args) {
        Node head = swapAdjacent(new Node(1, null));

        while (head != null) {
            System.out.println(head.val);
            head = head.next;

        }
    }
   static Node swapAdjacent(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node more = swapAdjacent(node.next.next);
        Node nextNode = node.next;
        nextNode.next = node;
        node.next = more;
        return nextNode;
    }


}
