package com.coding_interview_book.bit_manipulation;

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
