package com.coding_problems_book.bit_manipulation;

public class IntegerBitDivision {


    public static void main(String[] args) {
        System.out.println(divideNoRemainder(-23, 77));

    }
    static long divideNoRemainder(long q, long p) {
        if (p == 0) {
            throw new ArithmeticException("Division by zero");
        }

        long sign = q / p > 0 ? 1 : -1;

        q = Math.abs(q);
        p = Math.abs(p);


        int INTEGER_MSB = 31;
        long quotient = 0;
        long total = 0;
        for (int i = INTEGER_MSB; i >= 0; i--) {
            long half = total + (p << i);
            if (half <= q) {
                total = total + (p << i);
                quotient = quotient | p << i;
            }
        }

        return sign * quotient;

    }
}
