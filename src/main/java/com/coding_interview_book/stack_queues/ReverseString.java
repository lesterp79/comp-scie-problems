package com.coding_interview_book.stack_queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseString("Hello"));
    }

    private static String reverseString(String s) {
        if (s == null || s.length() < 2) {
            return s;
        } else {
            Deque<Character> stack = new ArrayDeque<>();
            s.chars().mapToObj(c -> (char) c).forEach(stack::push);
//            var stack = s.chars().mapToObj(c -> (char) c).collect(Collectors.toCollection(ArrayDeque::new));
            return IntStream.range(0, stack.size())
                            .map(i -> stack.pop())
                            .mapToObj(c -> (char) c)
                            .map(String::valueOf).collect(Collectors.joining());
        }
    }

}
