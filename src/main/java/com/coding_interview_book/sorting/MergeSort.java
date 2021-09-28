/*
 * MergeSort.java
 *
 * Copyright (c) 2000-2018 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.coding_interview_book.sorting;

public class MergeSort {

    public static void main(String[] args) {
        int[] toSort = new int[]{38, 27, 43, 3, 9, 82, 10};

        mergeSort(toSort);

        for (int elem : toSort) {
            System.out.println("elem = " + elem);
        }
    }

    /**
     * Sorts (in a natural order) an array of integers by performing the initial call to the {@link #mergeSort(int[], int[], int,
     * int)} method, passing an empty array the same size as the #array to sort as the #helper, 0 as #low and #array.length - 1 as
     * #high. When this method finishes, the given #array will be sorted.
     *
     * @param array the array to sort
     */
    static void mergeSort(int[] array) {
        if (array == null) {
            return;
        }
        mergeSort(array, new int[array.length], 0, array.length - 1);
    }

    /**
     * Given the whole array, but considering only the sub-array delimited by low and high, keep dividing the sub-array in two
     * halves and calling itself recursively, until low >= high (which means you either have a one-element array or an empty array,
     * at which point you can stop and consider those sub arrays as sorted). After you merge-sort both halves, you can consider them
     * sorted and you can merge them together by calling {@link #merge(int[], int[], int, int, int)}
     *
     * @param array the whole array that needs to be sorted
     * @param helper the helper array to use as a buffer to help with the merging of the two sorted sub-arrays
     * @param low the position for the lower boundary of the sub-array to sort on this call
     * @param high the position for the upper boundary of the sub-array to sort on this call
     */
    static void mergeSort(int[] array, int[] helper, int low, int high) {
        // We only need to keep recurring until we get to our BASE CASE: low >= high.
        // low = high: we have a ONE-ELEMENT array OR
        // low > high: we have an EMPTY array
        // in BOTH cases, the sub-array defined by low and high are considered SORTED and we are DONE
        if (low < high) {
            // divide the array into two halves: one from position low to middle and the other position middle + 1 to high
            int middle = (low + high) / 2;
            // recursive call for the first half from position low to middle
            mergeSort(array, helper, low, middle);
            // recursive call for the second half from position middle + 1 to high
            mergeSort(array, helper, middle + 1, high);
            // once we are here, we ASSUME, using INDUCTION that BOTH HALVES ARE SORTED
            // now we MERGE both halves and as a result the given array is sorted
            merge(array, helper, low, middle, high); //Merge them
        }
    }

    /**
     * Merges the two (already sorted) sub-arrays delimited by the positions low, middle and high, using the helper array as a
     * buffer.
     *
     * @param array the whole array that needs to be sorted
     * @param helper the helper array to use as a buffer to help with the merging of the two sorted sub-arrays
     * @param low the position for the lower boundary of the first sub-array (first half) to merge on this call
     * @param middle the position for the upper boundary of the first sub-array (first half) to merge on this call
     * @param high the position for the upper boundary of the second sub-array (second half) to merge on this call
     */
    static void merge(int[] array, int[] helper, int low, int middle, int high) {
        // Copy both halves (from position low to high) into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }
        // variable to iterate through the first sub-array (first half). Starts at position low and can go up to middle
        int idxFirstHalf = low;
        // variable to iterate through the second sub-array (second half). Starts at position middle + 1 and can go up to high
        int idxSecHalf = middle + 1;
        // variable to iterate through the helper array that contains BOTH halves. Starts at position low and can go up to high
        int currIdx = low;
        // we iterate until either we get to the end of the first sub-array or the end of the second sub-array
        while (idxFirstHalf <= middle && idxSecHalf <= high) {
            // if the element on the first half of the helper array is smaller or equal, then we copy that element into the
            // original array and move to the next element on the first half of the helper array
            if (helper[idxFirstHalf] <= helper[idxSecHalf]) {
                array[currIdx] = helper[idxFirstHalf];
                idxFirstHalf++;
            } else {
                // if the element on the second half of the helper array is smaller, then we copy that element into the
                // original array and move to the next element on the second half of the helper array
                array[currIdx] = helper[idxSecHalf];
                idxSecHalf++;
            }
            // move to the next element on the original array
            currIdx++;
        }
        //if there's any remaining elements in the first half of the helper array (idxFirstHalf <= middle),
        // then copy the rest of the left side of the array into the target array
        // notice that, since the helper array already contains the sorted elements of the second array (we copied them over at the
        // start) nothing else needs to happen if there's any remaining elements in the second half (idxSecHalf <= high)
        int remaining = middle - idxFirstHalf;
        for (int i = 0; i <= remaining; i++) {
            array[currIdx + i] = helper[idxFirstHalf + i];
        }
    }
}
