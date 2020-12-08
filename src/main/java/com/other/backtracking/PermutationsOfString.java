/*
 * PermutationsOfString.java
 *
 * Copyright (c) 2000-2019 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.other.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string str, the task is to print all the permutations of str. A permutation is an arrangement of all or part of a set
 * of objects, with regard to the order of the arrangement. For instance, the words ‘bat’ and ‘tab’ represents two distinct
 * permutation (or arrangements) of a similar three letter word.
 *
 * Examples:
 *
 * Input: str = “cd”
 * Output: cd dc
 *
 * Input: str = “abb”
 * Output: abb abb bab bba bab bba
 */
public class PermutationsOfString {

    List<String> permutations = new ArrayList<>();

    public static void main(String[] args) {
        final PermutationsOfString permutationsOfString = new PermutationsOfString();
        permutationsOfString.permuteStringUnique("geek", "");

        for (String s   :
                        permutationsOfString.permutations) {
            System.out.println("\"" + s + "\"" );
        }

    }


    void permuteString(String str, String path) {
        // end of path, add permutation
        if (str.length() == 0) {
            permutations.add(path);
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            String sub = str.substring(0, i) +
                            str.substring(i + 1);

            permuteString(sub, path + str.charAt(i));
        }
    }

    void permuteStringUnique(String str, String path) {
        // end of path, add permutation
        if (str.length() == 0) {
            permutations.add(path);
            return;
        }

        boolean[] notUnique = new boolean[26];

        for (int i = 0; i < str.length(); i++) {

            final char charAt = str.charAt(i);

            if (!notUnique[charAt - 'a']) {
                notUnique[charAt - 'a'] = true;
                String sub = str.substring(0, i) + str.substring(i + 1);
                permuteStringUnique(sub, path + charAt);
            } else {
                continue;
            }
        }
    }
}
