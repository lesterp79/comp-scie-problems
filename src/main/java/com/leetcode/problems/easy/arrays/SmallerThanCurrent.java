package com.leetcode.problems.easy.arrays;

import java.util.*;

public class SmallerThanCurrent {

    public static void main(String[] args) {
        final int[] a = {7,7,7,7};
        Arrays.stream(smallerNumbersThanCurrent(a)).forEach(System.out::println);

    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {

        Map<Integer, List<Integer>> idxMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list =  idxMap.computeIfAbsent(nums[i], k -> new ArrayList<>());
            list.add(i);
        }
        Arrays.sort(nums);
        int[] results = new int[nums.length];
        results[0] = 0;
        for (int i = 1, j = 0; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                j = i;
            }
            List<Integer> list = idxMap.get(nums[i]);
            if (list != null) {
                for (int idx : list) {
                    results[idx] = j;
                }
                idxMap.remove(nums[i]);
            }
        }

        return results;
    }
}
