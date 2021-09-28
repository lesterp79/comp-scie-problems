package com.coding_interview_book.arrays;

import com.util.MinHeap;

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[][] arrays = new int[][] { { 3, 4, 5 }, { 20, 22, 24 }, { 50 }, { -1, 15 } };
        int[] result = mergeSorted(arrays);
        Arrays.stream(result).forEach(System.out::println);
    }

    public static int[] mergeSorted(int[][] arrs) {
        if (arrs == null || arrs.length == 0) {
            return new int[0];
        } else {
            var resLen = 0;
            for (int i = 0; i < arrs.length; i++) {
                resLen += arrs[i] == null ? 0 : arrs[i].length;
            }
            int[] results = new int[resLen];

            MinHeap[] minHeap = new MinHeap[arrs.length];

            // add in the heap first element from each array
            for (int i = 0; i < arrs.length; i++) {
                minHeap[i] = new MinHeap(arrs[i] == null || arrs[i].length < 1 ? Integer.MAX_VALUE : arrs[i][0], i, 0);
            }

            Arrays.sort(minHeap);

            for (int i = 0; i < resLen; i++) {
                MinHeap.heapify(minHeap, 0, arrs.length);
                results[i] = minHeap[0].data;
                minHeap[0].currentIndex++;
                if (minHeap[0].currentIndex >= arrs[minHeap[0].heapIndex].length) {
                    minHeap[0].data = Integer.MAX_VALUE;
                } else {
                    minHeap[0].data = arrs[minHeap[0].heapIndex][minHeap[0].currentIndex];

                }
            }

            return results;
        }


    }



}
