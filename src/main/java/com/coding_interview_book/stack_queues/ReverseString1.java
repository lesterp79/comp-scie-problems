package com.coding_interview_book.stack_queues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReverseString1 {
    public static void main(String[] args) {
        System.out.println(reverseString("Henlo"));
    }

    public static String reverseString(String s) {

        if (s == null || s.length() <= 1) {
            return s;
        } else {
            Deque<Character> stack = new ArrayDeque<>();
            IntStream.range(0, s.length()).mapToObj(s::charAt).forEach(stack::push);

            Stream<Character> characterStream = IntStream.range(0, stack.size()).mapToObj(i -> stack.pop());
            Stream<String> stringStream = characterStream.map(String::valueOf);
            String results = stringStream.collect(Collectors.joining());
            return results;
        }
    }
}
