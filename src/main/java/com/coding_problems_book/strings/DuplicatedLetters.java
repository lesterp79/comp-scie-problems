package com.coding_problems_book.strings;

import java.util.ArrayList;

// Find duplicated lowercase letters (a-z) in a char array in O(n) time and O(1) space
public class DuplicatedLetters {
    public static void main(String[] args) {

        var letters = new char[26];
        for (int i = 0; i < NUMBER_OF_LETTERS_ALPHABET; i++) {
            letters[i] = (char) (i + 'a');
        }

        letters[0] = 'b';
        letters[5] = 'w';


        char[] dups = duplicatedLetters(letters);

        for (int i = 0, dupsLength = dups.length; i < dupsLength; i++) {
            char dup = dups[i];
            System.out.print(dup + (i < dupsLength - 1 ? ", " : ""));

        }
        System.out.println();
    }

    final static int NUMBER_OF_LETTERS_ALPHABET = 26;

    public static char[] duplicatedLetters(char[] letters) {
        var duplicates = new ArrayList<Character>();

        if (letters != null && letters.length > 1) {
            for (int i = 0; i < letters.length; i++) {
                letters[(letters[i] - 'a') % 26] += 26;
            }

            for (int i = 0; i < letters.length; i++) {
                if ((letters[i] - 'a') / 26 > 1) {
                    duplicates.add((char) (i + 'a'));
                }
            }

        }
        return getChars(duplicates);
    }

    private static char[] getChars(ArrayList<Character> duplicates) {
        var tmp = duplicates.stream().mapToInt(c -> c).toArray();
        return new String(tmp, 0, tmp.length).toCharArray();
    }
}
