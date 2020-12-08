/*
 * RemovePrimesLinkedList.java
 *
 * Copyright (c) 2000-2019 MotionPoint Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * MotionPoint Corp. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with MotionPoint.
 */
package com.interviews.microsoft;


public class SieveOfEratosthenes {

    public static void main(String[] args) {
        SieveOfEratosthenes.sieve(100);
    }

    static void sieve(int n) {

        boolean[] primes = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            primes[i] = true;
        }

        for (int p = 2; p * p <= n; p++) {
            if (primes[p]) {
                for (int j = p * p; j <= n; j += p)
                    primes[j] = false;
            }
        }

        // Print all prime numbers
        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
