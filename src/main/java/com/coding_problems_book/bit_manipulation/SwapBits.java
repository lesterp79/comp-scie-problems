package com.coding_problems_book.bit_manipulation;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SwapBits {
    public static void main(String[] args) {
        System.out.println(swap(2640));
    }

    static int swap(int n) {

//        int oddToEven;
//        int evenToOdd;

//        return IntStream.range(0, 32).map(i -> i % 2 == 0 ? n >> 1 & (1 << i) : n << 1 & (1 << i)).sum();


        int mask = IntStream.range(0, 32).filter(i -> i % 2 == 0).map(i -> 1 << i).sum();
        return (mask & (n >> 1)) | (~mask & (n << 1));
    }
}
