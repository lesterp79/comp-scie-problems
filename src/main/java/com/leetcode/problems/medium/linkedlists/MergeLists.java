package com.leetcode.problems.medium.linkedlists;

public class MergeLists {

    public static void main(String[] args) {
        var list1 = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, null)))))));
        var list2 = new ListNode(1000000, new ListNode(1000001, new ListNode(1000002, new ListNode(1000003, new ListNode(1000004, null)))));
        print(mergeInBetween(list1, 2, 5, list2));


    }
    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode tail2 = list2;
        while (tail2.next != null) {
            tail2 = tail2.next;
        }

        ListNode athNode = list1;
        int i = 0;
        while (i < a - 1) {
            athNode = athNode.next;
            i++;
        }
        ListNode bthNode = list1;

        int j = 0;
        while (j < b) {
            bthNode = bthNode.next;
            j++;
        }

        athNode.next = list2;
        tail2.next = bthNode.next;

        return list1;

    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static void print(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}