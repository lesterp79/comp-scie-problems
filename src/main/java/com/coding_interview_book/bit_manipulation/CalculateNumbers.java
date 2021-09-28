package com.coding_interview_book.bit_manipulation;

public class CalculateNumbers {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(calculate(3, 4)));

    }
    static int calculate(int i, int j) {
        return (~0 << i) & ((1 << (j + 1)) - 1);
    }
}
