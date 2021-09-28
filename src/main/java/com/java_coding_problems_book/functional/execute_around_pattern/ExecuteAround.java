package com.java_coding_problems_book.functional.execute_around_pattern;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.function.Function;

public class ExecuteAround {

    public static void main(String[] args) throws IOException {
        var sum = read(ExecuteAround::sumAll);
        var first = read(ExecuteAround::getFirst);
    }

    private static double getFirst(Scanner scanner) {
        if (scanner.hasNextDouble()) {
            return scanner.nextDouble();
        }

        return Double.NaN;
    }

    private static double sumAll(Scanner scanner) {
        double sum = 0.0d;
        while (scanner.hasNextDouble()) {

            sum += scanner.nextDouble();
        }

        return sum;
    }


    public static double read(Function<Scanner, Double> snf)
            throws IOException {

        try (Scanner scanner = new Scanner(
                Path.of("doubles.txt"), StandardCharsets.UTF_8)) {

            return snf.apply(scanner);
        }
    }
}

