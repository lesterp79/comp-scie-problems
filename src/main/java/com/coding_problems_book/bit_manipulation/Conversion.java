package com.coding_problems_book.bit_manipulation;

import java.util.stream.IntStream;

public class Conversion {
    public static void main(String[] args) {
        System.out.println(bitsToConvert(608443816, 1196695432));
    }
    static int bitsToConvert(int q, int p) {
//        return IntStream.range(0, 32).map(i -> (q >> i & 1) ^ (p >> i & 1)).sum();

        int xor = q ^ p;
        int count = 0;
        while (xor > 0) {
            count = xor & 1;
            xor >>= 1;
        }
        return count;
    }
}
