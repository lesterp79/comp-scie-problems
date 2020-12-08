package com.coding_problems_book.linked_lists;

import java.util.ArrayDeque;

public class Palindromes {

    public static void main(String[] args) {
        System.out.println(isPalindrome(new Node(1, null)));

    }
    static boolean isPalindrome(Node head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }

        Node slow = head;
        Node fast = head;

        var stack = new ArrayDeque<Integer>();

        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.val != stack.pop()) {
                return false;
            }
            slow = slow.next;
        }

        return true;

    }
}


