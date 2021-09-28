package com.leetcode.assesment;

import java.util.*;

class PickOne {

    private Map<Integer, List<Integer>> map = new HashMap<>();

    public PickOne(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            List<Integer> t = map.computeIfAbsent(nums[i], k -> new ArrayList<>());
            t.add(i);
        }
    }

    public int pick(int target) {
        List<Integer> t = map.get(target);
        Random random = new Random();
        return t.get(random.nextInt(t.size()));

    }

    public static void main(String[] args) {
        PickOne solution = new PickOne(new int[] {1, 2, 3, 3, 3});
        System.out.println(solution.pick(3)); // It should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
        System.out.println(solution.pick(1)); // It should return 0. Since in the array only nums[0] is equal to 1.
        System.out.println(solution.pick(3)); // It should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
    }
}
