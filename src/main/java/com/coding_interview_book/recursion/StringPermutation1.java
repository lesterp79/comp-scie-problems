package com.coding_interview_book.recursion;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class StringPermutation1 {

    static List<String> perms = new ArrayList<>();

    public static void main(String[] args) {
        permute("abca");
    }

    private static void permute(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            map.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }
        permute(0, s.length(), new StringBuilder(), map);

        perms.forEach(System.out::println);
    }

    private static String transform(AtomicInteger count, String s) {
        return count.incrementAndGet() + "- " + s;
    }


    private static void permute(int idx, int length, StringBuilder sb, Map<Character, Integer> map) {
        if (idx >= length) {
            perms.add(sb.toString());
        } else {
            for (Map.Entry<Character, Integer> e : map.entrySet()) {
                if (e.getValue() > 0) {
                    sb.append(e.getKey());
                    e.setValue(e.getValue() - 1);
                    permute(idx + 1, length, sb, map);
                    sb.deleteCharAt(sb.length() - 1);
                    e.setValue(e.getValue() + 1);
                }
            }
        }
    }
}
