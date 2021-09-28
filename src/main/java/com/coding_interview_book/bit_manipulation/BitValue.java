package com.coding_interview_book.bit_manipulation;

public class BitValue {
    public static void main(String[] args) {
//        System.out.println(getBitValue(6, 1));
//        System.out.println(setBitValue(97, 5, 0));
        System.out.println(clearBitsToK(-1025088563, 4));

    }

    private static int getBitValue(int n, int k) {
        return (n & 1 << k) > 0 ? 1: 0;
    }

    private static int setBitValue(int n, int k, int value) {
        if (value == 1) {
            return n | 1 << k;
        } else {
            return n & ~(1 << k);
        }
    }

    private static int clearBitsToK(int n, int k) {
        int msd = -1;
        for (int i = 0; i < 32; i++) {
            if ((n >>> i & 1) > 0) {
                msd = i;
            }
        }
        if (msd < 0) {
            return 0;
        }
        for (int i = 0; i < k; i++) {
            if (msd - i >= 0) {
                n = n & ~(1 << msd - i);
            } else {
                break;
            }
        }
        return n;
    }
}
