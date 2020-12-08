package com.coding_problems_book.bit_manipulation;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class BitRotation {
    public static void main(String[] args) {
        System.out.println(rotate(423099897, 10, true));
    }

    static int rotate(int n, int k, boolean left) {
        k %= 32;
        if (left) {
            return n << k | n >> (32 - k);
        } else {
            return n >> k | n << (32 - k);
        }
    }
}
