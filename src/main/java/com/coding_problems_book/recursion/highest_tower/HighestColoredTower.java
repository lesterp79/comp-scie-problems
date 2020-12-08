package com.coding_problems_book.recursion.highest_tower;

import java.util.*;

public class HighestColoredTower {

    public static void main(String[] args) {
        Box b1 = new Box(10, 5, 2);
        Box b2 = new Box(10, 7, 1);
        Box b3 = new Box(10, 3, 1);
        Box b4 = new Box(14, 10, 3);
        Box b5 = new Box(5, 2, 1);
        Box b6 = new Box(7, 5, 3);
        Box b7 = new Box(2, 8, 1);

        List<Box> boxes = Arrays.asList(b1, b2, b3, b4, b5, b6, b7);

//        int highest1 = Tower.build(boxes);
        int highest2 = buildViaMemoization(boxes);

//        System.out.println("\nThe highest tower of colored boxes has a high of (plain recursion): " + highest1);
        System.out.println("\nThe highest tower of colored boxes has a high of (Memoization): " + highest2);
    }

    public static int buildViaMemoization(List<Box> boxes) {

        var memo = new int[boxes.size()];
        Arrays.fill(memo, -1);

        boxes.sort((o1, o2) -> o2.getHeight() - o1.getHeight());

        int highest = 0;
        for (int i = 0; i < boxes.size(); i++) {
            highest = Math.max(highest, build(boxes, i, memo));
        }
        return highest;
    }

    public static int build(List<Box> boxes, int base, int[] memo) {

        if (memo[base] > 0) {
            return memo[base];
        }

        int highest = 0;
        for (int i = base + 1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeNext(boxes.get(base))) {
                int height = build(boxes, i, memo);
                highest = Math.max(highest, height);
            }
        }

        highest += boxes.get(base).getHeight();
        memo[base] = highest;

        return memo[base];
    }
}