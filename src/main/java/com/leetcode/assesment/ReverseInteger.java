package com.leetcode.assesment;

import java.util.ArrayDeque;



public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(Integer.MAX_VALUE));
    }

    public int reverse(int x) {

        boolean neg = x < 0;

        if (neg) {
            x = x * -1;
        }

        int reverse = 0;



        while (x > 0) {
            try {
                reverse = Math.addExact(Math.multiplyExact(reverse, 10), x % 10);
                x /= 10;
            } catch (ArithmeticException e) {
                return 0;
            }
        }
        return reverse * (neg ? -1 : 1);

    }
}

