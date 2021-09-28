package com.coding_interview_book.recursion;

public class TowerOfHanoi {
    public static void main(String[] args) {
        moveDisks(4, 'A','C', 'B');
    }
    public static void moveDisks(int n, char origin, char target, char intermediate) {
        if (n == 1) {
            System.out.printf("Move disk: %d from: %c to: %c%n", n, origin, target);
        } else {
            moveDisks(n - 1, origin, intermediate, target);
            System.out.printf("Move disk: %d from: %c to: %c%n", n, origin, target);
            moveDisks(n - 1, intermediate, target, origin);
        }
    }
}