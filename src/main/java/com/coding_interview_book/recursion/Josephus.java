package com.coding_interview_book.recursion;

import java.util.ArrayDeque;

public class Josephus {
    public static void main(String[] args) {
        System.out.println(josephusIter(2, 7));

    }

    public static int josephusIter(int n, int k) {

        if (n < 1) {
            return -1;
        } else if (n == 1) {
            return 1;
        } else {
            var stack = new ArrayDeque<Integer>();

            for (int i = 1; i <= n; i++) {
                stack.add(i);
            }

            while (stack.size() > 1) {
                for (int i = 1; i <= k; i++) {
                    var condemned = stack.pop();
                    if (i != k) {
                        stack.add(condemned);
                    } else {
                        break;
                    }
                }
            }
            return stack.poll();
        }

    }

    public static int josephusRec(int n, int k) {
        if (n == 1) {
            return 1;
        }
        return (josephusRec(n - 1, k) + k - 1) % n + 1;
    }
}
