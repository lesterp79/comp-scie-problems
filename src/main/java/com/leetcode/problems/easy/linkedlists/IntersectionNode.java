package com.leetcode.problems.easy.linkedlists;

import javax.swing.text.html.Option;
import java.util.Optional;

public class IntersectionNode {

    ListNode result = null;
    public static void main(String[] args) {
        ListNode intersect = new ListNode(8, new ListNode(4, new ListNode(5)));

        ListNode headA = new ListNode(4, new ListNode(1,intersect));

        ListNode headB = new ListNode(5, new ListNode(6, new ListNode(1, intersect)));

        getIntersectionNode(headA, headB).ifPresentOrElse(n -> System.out.println(n.val), () -> System.out.println("No Intersection"));
    }
    public static Optional<ListNode> getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a != null ? a.next : headB;
            b = b != null ? b.next : headA;
        }

        return Optional.ofNullable(a);


    }
}


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}