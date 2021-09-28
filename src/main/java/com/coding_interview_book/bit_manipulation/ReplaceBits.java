package com.coding_interview_book.bit_manipulation;

public class ReplaceBits {

    public static void main(String[] args) {
        System.out.println(replaceBits(731566066, 616, 2, 3));

    }
    static int replaceBits(int q, int p, int i, int j) {

        if (j < i) {
            return q;
        }
        int maskOne;
        int maskZero;

        for (int k = j; k >= i; k--) {
            maskOne = 1 << k;
            maskZero = ~ maskOne;
            if ((p & maskOne) > 0) {
                q |= maskOne;
            } else {
                q &= maskZero;
            }
        }
        return q;
    }
}
