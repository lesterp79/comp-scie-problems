package com.coding_interview_book.recursion;

public class MagicIndex2 {
;
    public static void main(String[] args) {
        int[] array = new int[]{-1, -1, 1, 4, 5, 6, 7, 8, 9};
        System.out.println(findMagicIndex(0, array.length - 1, array));

    }

    private static int findMagicIndex(int beg, int end, int[] a) {
        if (beg > end) {
            return -1;
        }
        int i = (beg + end) / 2;

        // we found a magic index, but we have to keep looking left
        if (a[i] == i) {
            int left = findMagicIndex(beg, i - 1, a);
            // we found a lesser magic index, we return it
            // we didnt found lesser, return this
            return left >= 0 ? left : i;
        } else { // this is not a magic number, we have to search left and right, but left first
            int left = findMagicIndex(beg, i - 1, a);
            return left >= 0 ? left : findMagicIndex(i + 1, end, a);

        }
    }


}
