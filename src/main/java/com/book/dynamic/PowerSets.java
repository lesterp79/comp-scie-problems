/*
 * PowerSets.java
 *
 * Copyright (c) 2000-2019 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.book.dynamic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Power Set: Write a method to return all subsets of a set.
 */
public class PowerSets {

    public static void main(String[] args) {
        final List<List<Integer>> subsetsIterative = new PowerSets()
                        .getSubsetsBinary(Arrays.stream(new int[]{1, 2, 3, 4}).boxed().collect(toList()));

        for (List<Integer> subset : subsetsIterative) {
            System.out.print("{");
            for (int i = 0; i < subset.size(); i++) {
                Integer elem = subset.get(i);
                System.out.print((i > 0 ? ", " : "") + elem);
            }
            System.out.print("}, ");
        }
    }

    ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allSubsets;
        if (set.size() == index) {
            allSubsets = new ArrayList<>();
            allSubsets.add(new ArrayList<>());
        } else {
            // gets the previously generated subsets (i.e for {1, 2, 3}, calling from index element with index 1 will return {2,
            // 3} {2}, {3}, {})
            allSubsets = getSubsets(set, index + 1);
            // gets the element with current index (i.e. 1)
            int item = set.get(index);

            // this will hold the subsets generated from the current elements
            ArrayList<ArrayList<Integer>> mySubsets = new ArrayList<>();

            // // from each previously generated subset, generate a new one by adding the current element
            for (ArrayList<Integer> subset : allSubsets) {
                ArrayList<Integer> newSubset = new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(item);
                // collect all the subsets generated from the current element
                mySubsets.add(newSubset);
            }

            allSubsets.addAll(mySubsets);
        }

        return allSubsets;
    }

    List<List<Integer>> getSubsetsIterative(List<Integer> set) {

        if (set == null) {
            return null;
        }

        List<List<Integer>> allSubsets = new ArrayList<>();

        Deque<List<Integer>> queue = new ArrayDeque<>();

        // start with the empty set
        queue.push(new ArrayList<>());

        int elemIndex = set.size() - 1;

        while (elemIndex >= 0) {
            int item = set.get(elemIndex);
            int noSubsetsInQueue = queue.size();
            for (int i = 0; i < noSubsetsInQueue; i++) {
                List<Integer> subSet = queue.remove();
                List<Integer> newSubSet = new ArrayList<>();
                newSubSet.addAll(subSet);
                newSubSet.add(item);
                queue.add(newSubSet);
                queue.add(subSet);
            }

            elemIndex--;
        }

        while (!queue.isEmpty()) {
            allSubsets.add(queue.poll());
        }

        return allSubsets;
    }

    List<List<Integer>> getSubsetsBinary(List<Integer> set) {
        List<List<Integer>> allsubsets = new ArrayList<>();
        int max = 1 << set.size(); /* Compute 2An */
        for (int k = 0; k < max; k++) {
            List<Integer> subset = convertIntToSet(k, set);
            allsubsets.add(subset);
        }
        return allsubsets;
    }

    List<Integer> convertIntToSet(int x, List<Integer> set) {
        List<Integer> subset = new ArrayList<Integer>();
        int index = 0;
        for (int k = x; k > 0; k >>= 1) {
            if ((k & 1) == 1) {
                subset.add(set.get(index));
            }
            index++;
        }
        return subset;
    }
}