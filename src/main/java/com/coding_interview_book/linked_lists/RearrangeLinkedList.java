package com.coding_interview_book.linked_lists;

public class RearrangeLinkedList {
    public static void main(String[] args) {
        var head = new Node(1,  new Node(5,  new Node(4,  new Node(3,  new Node(2,  new Node(7, null))))));
        head = rearrange(head, 3);
        Node.print(head);
    }

    private static Node rearrange(Node head, int n) {
        if (head.next == null) {
            return head;
        }
        Node before_List = new Node(0);
        Node after_list = new Node(0);

        Node before = before_List;
        Node after = after_list;

        while (head != null) {
            if (head.val < n) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        before.next = after_list.next;
        after.next = null;

        return before_List.next;
    }
}
