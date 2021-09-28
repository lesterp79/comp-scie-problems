package com.java_coding_problems_book.functional.loan_pattern;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.function.Function;

public class Formula {

    public static void main(String[] args) throws IOException {
        double xPlusYMinusZ = Formula.compute((formula) -> formula.add().add().minus().result());
        double xMinusYMultiplySqrtZ = Formula.compute((sc)
                -> sc.add().minus().multiplyWithSqrt().result());
    }

    private double result;

    private Formula() {
        result = 0.0;
        System.out.println("Open scanner");
    }

    public static double compute(Function<Formula, Double> f) throws IOException {

        Formula formula = new Formula();
        double result;

        try {
            result = f.apply(formula);
        } finally {
            formula.close();
        }

        return result;
    }

    private void close() {
        System.out.println("Closing scanner");
        result = 0.0;
    }

    public Formula add() {
        System.out.println("Add");

        return this;
    }

    public Formula minus() {
        System.out.println("Minus");


        return this;
    }

    public Formula multiplyWithSqrt() {
        System.out.println("Sqrt");

        return this;
    }

    public double result() {
        return result;
    }
}
