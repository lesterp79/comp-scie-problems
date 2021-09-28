package com.coding_interview_book.maps;

import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NutsAndBolts {
    public static void main(String[] args) {
        var res = findNutsAndBolts(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, new int[]{8, 1, 3, 2, 5, 6, 7, 4});
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.println(res[i][j] +( j != res.length - 1 ? ", " : ""));
            }
            System.out.println();
        }
    }

    private static int[][] findNutsAndBolts(int[] nuts, int[] bolts) {
        var map = IntStream.range(0, nuts.length).boxed().parallel()
                           .collect(Collectors.toMap(i -> nuts[i], i -> i, (a, b) -> b, HashMap::new));

        int[][] result = new int[nuts.length][bolts.length];
        IntStream.range(0, bolts.length).forEach(j -> {
            var i = map.get(bolts[j]);
            result[i][j] = bolts[j];
        });
        return result;
    }
}
