package com.leetcode.problems.easy.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.stream;

public class MinIndexSum {
    public static void main(String[] args) {
        var list1 = new String[]{"Shogun","Tapioca Express","Burger King","KFC"};
        var list2 = new String[]{"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};
        stream(findRestaurant(list1, list2)).forEach(System.out::println);

    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        var map = IntStream.range(0, list1.length)
                           .boxed()
                           .collect(Collectors.toMap(i -> list1[i], Function.identity()));

        int minSum = Integer.MAX_VALUE;


        var results = new ArrayList<String>();

        for (int i = 0; i < list2.length; i++) {
            String restaurant = list2[i];
            if (map.containsKey(restaurant)) {
                var sum = i + map.get(restaurant);
                if (sum < minSum) {
                    results.clear();
                    results.add(restaurant);
                    minSum = sum;
                } else if (sum == minSum) {
                    results.add(restaurant);
                }
            }
        }

        return results.toArray(new String[0]);
    }
}
