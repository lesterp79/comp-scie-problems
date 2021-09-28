package com.java_coding_problems_book.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] a = {7, 7, 2, 4, 1, 6, 8, 3, 5};
        sort(a);
        Arrays.stream(a).forEach(System.out::println);
    }

    public static void sort(int[] a) {
        if (a != null && a.length > 1) {
            for (int i = 1; i < a.length; i++) {
                var current = a[i];
                var j = i - 1;
                while (j >= 0 && a[j] > current) {
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = current;
            }
        }
    }
}
