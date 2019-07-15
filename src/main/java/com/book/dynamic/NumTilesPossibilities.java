/*
 * NumTilesPossibilities.java
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

/**
 * You have a set of tiles, where each tile has one letter tiles[i] printed on it.  Return the number of possible non-empty
 * sequences of letters you can make.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "AAB" Output: 8 Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
 * 1 <= tiles.length <= 7
 * tiles consists of uppercase English letters.
 */
public class NumTilesPossibilities {

    public static void main(String[] args) {
        System.out.println(new NumTilesPossibilities().numTilePossibilities("AAB"));
    }

    public int numTilePossibilities(String tiles) {
        int[] count = new int[26];
        for (char c : tiles.toCharArray()) count[c - 'A']++;
        return dfs(count);
    }

    int dfs(int[] arr) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) continue;
            sum++;
            arr[i]--;
            sum += dfs(arr);
            arr[i]++;
        }
        return sum;
    }
}
