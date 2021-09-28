package com.coding_interview_book.arrays;

import java.util.Arrays;

public class ArrayFromPermutation {

    public static void main(String[] args) {
        Arrays.stream(new ArrayFromPermutation().buildArray(new int[]{
                0, 2, 1, 5, 3, 4})).forEach(System.out::println);

    }


    public int[] buildArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        for (int i = 0; i < nums.length; i++) {
            int idx = nums[i] % nums.length;
            int val = nums[idx] % nums.length;
            nums[i] += val * nums.length;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] /= nums.length;
        }

        return nums;
    }

}
