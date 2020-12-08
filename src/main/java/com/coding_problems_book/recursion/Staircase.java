package com.coding_problems_book.recursion;

public class Staircase {
    int countForSteps(int n) {
        if (n < 3) {
            return n;
        } else if (n == 3) {
            return 4;
        } else {
            return countForSteps(n - 3) + countForSteps(n - 2) + countForSteps(n - 1);
        }
    }
}
