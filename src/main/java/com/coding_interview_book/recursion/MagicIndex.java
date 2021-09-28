package com.coding_interview_book.recursion;

public class MagicIndex {


    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 4, 4, 5, 7, 8, 8, 11, 12, 12, 12, 13, 13, 20, 21, 21};
        System.out.println(find(arr));
    }

    public static int find(int[] arr) {
        return find(0, arr.length - 1, arr);
    }

    public static int find(int start, int end, int[] arr) {
        if (start > end) {
            return -1;
        }

        int middle = (start + end) / 2;

        int result = find(start, middle - 1, arr);

        if (result >= 0) {
            return result;
        } else if (arr[middle] == middle) {
            return middle;
        } else {
            return find(middle + 1, end, arr);
        }
    }
}
