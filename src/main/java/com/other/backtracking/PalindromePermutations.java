/*
 * PalindromePermutations.java
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

public class PalindromePermutations {

    public static void main(String[] args) {
        PalindromePermutations palindromePermutations = new PalindromePermutations();

        palindromePermutations.palindromePermutations("aabbcadad");
        for (String s   :
                        palindromePermutations.palindromes) {
            System.out.println("\"" + s + "\"" );
        }
    }

    List<String> palindromes = new ArrayList<>();
    boolean odd;

    /**
     * Given a string, we need all possible palindromes that can be generated using letters of that string.
     *
     * Examples:
     *
     * Input:  str = "aabcb"
     * Output: abcba bacab
     *
     * nput:  str = "aabbcadad"
     * Output: aabdcdbaa aadbcbdaa abadcdaba
     *         abdacadba adabcbada adbacabda
     *         baadcdaab badacadab bdaacaadb
     *         daabcbaad dabacabad dbaacaabd
     */
    void palindromePermutations(String str) {
        permutePalindromeOther(str, "");
    }

    void permutePalindrome(String str, String path) {
        if (str.length() == 0) {
            palindromes.add(path);
        }
        if (path.length() < str.length()) {
            for (int i = 0; i < str.length(); i++) {
                String rest = str.substring(0, i) + str.substring(i + 1);
                permutePalindrome(rest, path + str.charAt(i));
                }
            } else { // we still don't know if we have a palindrome, continue generating the current path
                int i = 0;
                while (i < str.length() && matchesCorresponding(i, str, path)) {
                    String rest = str.substring(0, i) + str.substring(i + 1);
                    permutePalindrome(rest, path + str.charAt(i));
                    i++;
                }
            }
    }

    void permutePalindromeOther(String str, String path) {
        if (str.length() == 0) {
            palindromes.add(path);
        }

        boolean[] notUnique = new boolean[26];
        for (int i = 0; i < str.length(); i++) {
            final char charAt = str.charAt(i);
            if (!notUnique[charAt - 'a']) {
                notUnique[charAt - 'a'] = true;
                String rest = str.substring(0, i) + str.substring(i + 1);
                if (path.length() < str.length()) {
                    permutePalindromeOther(rest, path + str.charAt(i));
                } else {
                    if (matchesCorresponding(i, str, path)) {
                        permutePalindromeOther(rest, path + str.charAt(i));
                    }
                }
            }
        }
    }

    boolean matchesCorresponding(int i, String str, String path) {
        return str.charAt(i) == path.charAt(str.length() - 1);
    }
}
