package com.coding_problems_book.stack_queues;

import java.util.ArrayDeque;
import java.util.Arrays;

public class StockSpan {

    public static void main(String[] args) {
        int[] spans = getStockSpans(new int[]{55, 34, 22, 23, 27, 88, 70, 42, 51, 100});

        Arrays.stream(spans).forEach(System.out::println);
    }

    static int[] getStockSpansBruteForce(int[] prices) {

        if (prices == null) {
            return null;
        }
        var results = new int[prices.length];

        if (prices.length > 0) {
            var stack = new ArrayDeque<Integer>();
            var aux = new ArrayDeque<Integer>();

            for (int i = 0; i < prices.length; i++) {
                int span = 1;
                while (!stack.isEmpty() && prices[i] >= stack.peek()) {
                    aux.push(stack.pop());
                    span++;
                }

                while (!aux.isEmpty()) {
                    stack.push(aux.pop());
                }
                stack.push(prices[i]);
                results[i] = span;
            }

        }

        return results;
    }

    static int[] getStockSpans(int[] prices) {

        if (prices == null) {
            return null;
        }
        var results = new int[prices.length];
        var stack = new ArrayDeque<Integer>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] >= prices[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                results[i] = i + 1;
            } else {
                results[i] = i - stack.peek();
            }
            stack.push(i);
        }
        return results;

    }
}
