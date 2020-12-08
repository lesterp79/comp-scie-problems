package com.coding_problems_book.recursion;

import java.util.Date;

public class NCoins {

    public static void main(String[] args) {
        System.out.println(nCoinsRecursive(5000));
    }

    static int nCoinsRecursive(int n) {
        int[] coins = new int[]{25, 10, 5, 1};
        int[][] cache = new int[n + 1][coins.length];
        long before = System.currentTimeMillis();
        int result = nCoinsR(n, 0, coins, cache);
        System.out.println(System.currentTimeMillis() - before);
        return result;
    }


    static int nCoinsR(int n, int index, int[] coins, int[][] cache) {
        if (n == 0 || index == coins.length - 1) {
            return 1;
        }

        int result = 0;
        int numberOfCoins = n / coins[index];
        for (int i = 0; i <= numberOfCoins; i++) {
            if (cache[n - (i * coins[index])][index + 1] == 0) {
                cache[n - (i * coins[index])][index + 1] = nCoinsR(n - (i * coins[index]), index + 1, coins, cache);
            }
            result += cache[n - (i * coins[index])][index + 1];
        }

        return result;
    }
}
