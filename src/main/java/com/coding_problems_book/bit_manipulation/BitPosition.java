package com.coding_problems_book.bit_manipulation;

import java.util.stream.IntStream;

public class BitPosition {
    public static void main(String[] args) {
        System.out.println(bitPos(1 << 31));
    }

    static int bitPos(int n) {
        return IntStream.range(0, 32).filter(i -> ((n >> i) & 1) > 0).findFirst().orElse(-1);
    }

}
