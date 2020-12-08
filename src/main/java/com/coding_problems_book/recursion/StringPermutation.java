package com.coding_problems_book.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringPermutation {

    public static void main(String[] args) {
        var results = permuteString("abc");
        results.stream().forEach(System.out::println);

    }

    static List<String> permuteString(String s) {
        if (s == null) {
            return null;
        }
        return permute(s);
    }

    static List<String> permute(String s) {
        List<String> perms = new ArrayList<>();
        if (s.length() == 1) {
            perms.add(s);
        } else {
            for (int i = 0; i < s.length(); i++) {
                var otherPerms = permute(s.substring(0, i) + s.substring(i + 1));
                final var c = s.charAt(i);
                perms.addAll(otherPerms.stream().map(p -> c + p).collect(Collectors.toList()));
            }
        }
        return perms;
    }

}
