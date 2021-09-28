package com.leetcode.assesment;

public class IsOneBitCharacter {

    public static void main(String[] args) {
        var bits = new int[]{0,0,0,0,1,1,0};
        System.out.println(new IsOneBitCharacter().isOneBitCharacter(bits));
    }
    public boolean isOneBitCharacter(int[] bits) {
        return isOneBitCharacter(bits, 0);
    }

    private boolean isOneBitCharacter(int[] bits, int i) {
        if (i >= bits.length) {
            return false;
        } else if (i == bits.length - 1) {
            return bits[i] == 0;
        } else {
            if (bits[i] == 0) {
                return isOneBitCharacter(bits, i + 1);
            } else {
                return isOneBitCharacter(bits, i + 2);
            }
        }


    }
}
