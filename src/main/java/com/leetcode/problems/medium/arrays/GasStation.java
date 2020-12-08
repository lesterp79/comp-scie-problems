package com.leetcode.problems.medium.arrays;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int i = 0;
        boolean found = false;
        int len = gas.length;

        while (i < len && !found) {
            int tank = 0;
            boolean outOfGas = false;
            int j = 0;

            while (j < len && !outOfGas) {
                int next = (i + j) % len;
                tank += gas[next] - cost[next];
                outOfGas = tank < 0;
                j++;
            }

            if (!outOfGas) {
                found = true;
            } else {
                i++;
            }
        }

        return found ? i : -1;
    }
}
