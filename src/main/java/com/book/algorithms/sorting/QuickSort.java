/*
 * QuickSort.java
 *
 * Copyright (c) 2000-2018 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.book.algorithms.sorting;

public class QuickSort {
    public static void main(String[] args) {
        int[] toSort = new int[]{38, 27, 43, 3, 9, 82, 10};

        quickSort(toSort, 0, toSort.length-1);

        for (int elem : toSort) {
            System.out.println("elem = " + elem);
        }
    }

    private static void quickSort(int[] array, int left, int right) {
        int index = partitionSimple(array, left, right);
        if (left < index - 1) { // sort left half
            quickSort(array, left, index - 1);
        }
        if (index < right) { // then sort right half
            quickSort(array, index, right);
        }

    }

    static int partitionSimple(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2]; // pick the pivot point
        while (left <= right) {
                // Find element on left that should be on right
                while (arr[left] < pivot) {
                    left++;
                }
                // Find element on right that should be on left
                while (arr[right] > pivot) {
                    right--;
                }

            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    static int partitionLast(int[] arr, int low, int high) {

        int pivot = arr[high]; // pick the pivot as the right

        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);

        return high;
    }

    private static void swap(int[] arr, int left, int right) {
        int aux = arr[left];
        arr[left] = arr[right];
        arr[right] = aux;
    }
}
