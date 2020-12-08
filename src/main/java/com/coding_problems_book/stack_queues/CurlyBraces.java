package com.coding_problems_book.stack_queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;

public class CurlyBraces {
    public static void main(String[] args) {
        System.out.println(verifyStack("{{[[]]{{{}}}}}"));
    }
    static boolean verify(String s) {
        int i = 0;
        int count = 0;
        while (count >= 0 && i < s.length()) {
            if (s.charAt(i) == '{') {
                count++;
            } else if (s.charAt(i) == '}') {
                count--;
            }
            i++;
        }

        return count == 0;
    }


    static boolean verifyStack(String s) {
        HashMap<Character, Character> closing = new HashMap<>();
        closing.put('}', '{');
        closing.put(')', '(');
        closing.put(']', '[');

        HashSet<Character> opening = new HashSet<>();
        opening.add('{');
        opening.add('(');
        opening.add('[');

        Deque<Character> stack = new ArrayDeque<>();

        int i = 0;
        boolean failed = false;
        while (!failed && i < s.length()) {
            char c = s.charAt(i);
            if (closing.containsKey(c)) {
                if (stack.isEmpty()) {
                    failed = true;
                } else {
                    failed = stack.pop() != closing.get(c);
                }
            } else if (opening.contains(c)) {
                stack.push(c);
                failed = stack.size() * 2 > s.length();
            }
            i++;
        }

        return stack.isEmpty() && !failed;
    }
}
