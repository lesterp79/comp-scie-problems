package com.leetcode.problems.easy.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KidsWithMoreCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().orElseThrow(RuntimeException::new);
        return Arrays.stream(candies).mapToObj(i -> i + extraCandies >= max).collect(Collectors.toList());

    }
}
