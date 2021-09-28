package com.coding_interview_book.recursion;

public class NCoins2 {

    public static void main(String[] args) {
        System.out.println("Count (plain recursion): " + NCoins2.nCoinsRecursive(25));
    }
    static int nCoinsRecursive(int n) {
        int[] coins = {25, 10, 5, 1};
        return nCoinsRecursive(n, coins, 0, new int[n + 1][coins.length]);
    }

    static int nCoinsRecursive(int n, int[] coins, int position , int[][] cache) {
        if (cache[n][position] != 0) {
            return cache[n][position];
        } else {
            if (position == coins.length - 1) {
                return 1;
            } else {
                int i = 0;
                int count = 0;
                while (i * coins[position] <= n) {
                    int remain = n - (i * coins[position]);
                    count += nCoinsRecursive(remain, coins, position + 1, cache);
                    i++;
                }
                cache[n][position] = count;
                return count;
            }
        }
    }
}
