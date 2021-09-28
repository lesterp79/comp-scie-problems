package com.leetcode.assesment;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class KthLargest {

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3,new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));   // return 4
        System.out.println(kthLargest.add(5));   // return 5
        System.out.println(kthLargest.add(10));  // return 5

        System.out.println(kthLargest.add(9));   // return 8
        System.out.println(kthLargest.add(4));   // return 8
    }

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        for (int x : nums) {
            minHeap.add(x);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
    }

    public int add(int val) {
        if (val > minHeap.peek()) {
            minHeap.add(val);
            minHeap.remove();
        }

        return minHeap.peek();
    }
}
