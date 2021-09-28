package com.coding_interview_book.strings;

import java.util.ArrayList;
import java.util.List;

public class SurrogatePairs {
    public static void main(String[] args) {
        var list = extract(String.valueOf(new char[]{'a', '\uD83D', '\uDC95', 'b', '\uD83D', '\uDE0D'}));

        for (int i = 0; i < list.size(); i++) {
            char[] chars = Character.toChars(list.get(i));
            System.out.println(chars.length);
            System.out.println(chars);
        }
    }

    public static List<Integer> extract(String str) {
        var results = new ArrayList<Integer>();
        int i = 0;
        while (i < str.length()) {
            // get the code point at i
            int cp = str.codePointAt(i);
            if (Character.charCount(cp) == 2) { // if this codepoint is represented by two chars, its a surrogate pair
                results.add(cp); //get the pair
                //results.add(str.codePointAt(++i));
                i++;
            }
            i++;
        }

        //results.forEach(System.out::println);

        return results;
    }
}
