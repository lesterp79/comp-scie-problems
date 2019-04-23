/*
 * RansomNote.java
 *
 * Copyright (c) 2000-2019 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.leetcode.problems.easy.maps;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that
 * will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class RansomNote {

    public static void main(String[] args) {
        System.out.println(new RansomNote().canConstruct("jbagb", "accdbgbggj"));

    }
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine == null || ransomNote == null) {
            return false;
        }

        // build the map
        Map<Character, Integer> magazineLetters = new HashMap<>();

        char[] magChars = magazine.toCharArray();

        for (char magChar : magChars) {
            Integer noLetters = magazineLetters.get(magChar);
            if (noLetters == null) {
                magazineLetters.put(magChar, 1);
            } else {
                magazineLetters.put(magChar, ++noLetters);
            }
        }

        char[] noteChars = ransomNote.toCharArray();

        boolean canBeBuilt = true;

        for (int i = 0; i < ransomNote.length(); i++) {
            char noteLetter = noteChars[i];
            Integer noLetters = magazineLetters.get(noteLetter);

            if (noLetters == null) {
                canBeBuilt = false;
                break;
            } else {
                noLetters = noLetters - 1;
                if (noLetters == 0) {
                    magazineLetters.remove(noteLetter);
                } else {
                    magazineLetters.put(noteLetter, noLetters);
                }
            }
        }
        return canBeBuilt;
    }
}
