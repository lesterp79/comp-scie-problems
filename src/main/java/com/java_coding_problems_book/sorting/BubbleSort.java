package com.java_coding_problems_book.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {7, 7, 2, 4, 1, 6, 8, 3, 5};


//        bubbleSort(a);
        Arrays.sort(a);

        reverseSorted(a);

        Arrays.stream(a).forEach(System.out::println);


    }

    private static void reverseSorted(int[] a) {
        if (a != null || a.length > 1) {
            int head = 0;
            int tail = a.length - 1;
            for (int i = 0; head < tail; i++, head++, tail--) {
                int temp = a[head];
                a[head] = a[tail];
                a[tail] = temp;
            }
        }
    }

    public static void bubbleSort(int[] a) {
        if (a != null && a.length > 1) {
            int lastSwap = a.length;
            while (lastSwap > 0) {
                int swap = 0;
                for (int i = 1; i < lastSwap; i++) {
                    if (a[i - 1] > a[i]) {
                        swap = i;
                        int temp = a[i - 1];
                        a[i - 1] = a[i];
                        a[i] = temp;
                    }
                }
                lastSwap = swap;

            }
        }
    }
}
