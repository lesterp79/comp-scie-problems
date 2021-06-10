package com.coding_problems_book.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExtractIntegers {

    public static void main(String[] args) {
        var integers = extractIntegers("cv dd 4 k 2321 2 11 k4k2 66 4d");
        integers.forEach(System.out::println);
    }

    public static List<Integer> extractIntegers(String str) {
        var results = new ArrayList<Integer>();
        if (str != null && str.length() > 0) {
            int multi = 1; // multiplier
            int acc = 0; // accumulator

            for (int i = str.length() - 1; i >= 0; i--) {
                if (Character.isDigit(str.charAt(i))) {
                    acc += multi * Character.digit(str.charAt(i), 10); // accumulate digit with corresponding order

                    multi *= 10; // increment digit order
                } else if (acc > 0) { // end of digit sequence
                    results.add(acc);
                    acc = 0;
                    multi = 1;
                }
            }

            if (acc > 0) {
                results.add(acc);
            }
        }
        Collections.reverse(results);
        return results;
    }
}
