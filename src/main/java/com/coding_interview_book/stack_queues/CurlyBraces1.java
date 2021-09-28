package com.coding_interview_book.stack_queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class CurlyBraces1 {
    public static void main(String[] args) {
        System.out.println(matchingPairsRecursive("((()))()"));
    }

    public static boolean matchingPairsRecursive(String s) {
        if (s == null || s.length() == 0 || s.length() % 2 > 0) {
            return false;
        } else {
            return matchingPairs(0, s.length() / 2, s.length() / 2, s);
        }
    }

    public static boolean matchingPairs(int idx, int left, int right, String s) {
        if (left == 0 && right == 0) {
            return true;
        } else if (left < 0 || left > right) {
            return false;
        } else if (s.charAt(idx) == '(') {
                return matchingPairs(idx + 1, left - 1, right, s);
        } else {
            return matchingPairs(idx + 1, left, right - 1, s);

        }

    }

    public static boolean matchingPairsIter(String s) {
        if (s == null || s.length() == 0 || s.length() % 2 > 0) {
            return false;
        } else {

            int i = 0;
            int left = s.length() / 2;
            int right = left;

            while (i < s.length() && left >= 0 && right >= left) {
                if (s.charAt(i) == '(') {
                    left--;
                } else {
                    right--;
                }
                i++;
            }

            return left == 0 && right == 0;
        }
    }

    public static boolean matchingPairsStack(String s) {
        if (s == null || s.length() == 0 || s.length() % 2 > 0) {
            return false;
        } else {
            Deque<Character> stack = new ArrayDeque<>();

            int i = 0;
            boolean valid = true;
            while (i < s.length() && valid) {
                if (s.charAt(i) == '(') {
                    stack.push(s.charAt(i));
                } else {
                    if (stack.isEmpty()) {
                        valid = false;
                    } else {
                        stack.pop();
                    }
                }
                i++;
            }

            return valid && stack.isEmpty();
        }
    }
}
