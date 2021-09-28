package com.coding_interview_book.puzzles;

import java.awt.color.CMMException;
import java.util.Map;
import java.util.TreeMap;

public class RomanNumber {
    public static void main(String[] args) {
        System.out.println(romanNumber(19151));
    }

    public static String romanNumber(int n) {
        TreeMap<Integer, String> mappings  = new TreeMap<>();
        mappings.put(0, "");
        mappings.put(1, "I");
        mappings.put(4, "IV");
        mappings.put(5, "V");
        mappings.put(9, "IX");
        mappings.put(10, "X");
        mappings.put(40, "XL");
        mappings.put(50, "L");
        mappings.put(90, "XC");
        mappings.put(100, "C");
        mappings.put(400, "CD");
        mappings.put(500, "D");
        mappings.put(900, "CM");
        mappings.put(1000, "M");

        return romanNumber(n, 10, mappings);
    }

    public static String romanNumber(int n, int digit, TreeMap<Integer, String> mapping) {
        if (n == 0) {
            return "";
        } else {
            int key = n % (digit);
            String previous = romanNumber(n - key, digit * 10, mapping);
            if (mapping.containsKey(key)) {
                return previous + mapping.get(key);
            } else {
                var lowerEntry = mapping.lowerEntry(key);
                return previous + lowerEntry.getValue() + romanNumber( key - lowerEntry.getKey(), digit, mapping);
            }
        }
        }
    }
