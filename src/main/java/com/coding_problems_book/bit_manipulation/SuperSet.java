package com.coding_problems_book.bit_manipulation;

import java.util.HashSet;
import java.util.Set;

public class SuperSet {

    public static void main(String[] args) {
        System.out.println(superSetRecursive(new String[]{"a", "b", "c", "d"}, 0));
    }
    static Set<Set<String>> superSet(String[] arr) {
        Set<Set<String>> superSet = new HashSet<>();

        var superSetSize = 1 << arr.length;

        for (int i = 0; i < superSetSize; i++) {
            var subSet = new HashSet<String>();
            for (int j = 0; j < arr.length; j++) {
                if (((i >> j) & 1) == 1) {
                    subSet.add(arr[j]);
                }
            }
            superSet.add(subSet);
        }
        return superSet;
    }

    static Set<Set<String>> superSetRecursive(String[] arr, int index) {

        if (index >= arr.length) {
            HashSet<Set<String>> superSets = new HashSet<>();
            superSets.add(new HashSet<>());
            return superSets;
        }

        Set<Set<String>> superSet = superSetRecursive(arr, index + 1);

        Set<Set<String>> moreSubsets = new HashSet<>();
        for (Set<String> subset : superSet) {
            var newSubset = new HashSet<>(subset);
            newSubset.add(arr[index]);
            moreSubsets.add(newSubset);
        }
        superSet.addAll(moreSubsets);
        return superSet;
    }
}
