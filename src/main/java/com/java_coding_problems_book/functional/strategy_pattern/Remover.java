package com.java_coding_problems_book.functional.strategy_pattern;

import java.util.function.Function;

public final class Remover {
    public static void main(String[] args) {
        System.out.println(remove("This is a test ", s -> s.replaceAll("\\s", "")));
    }

    private Remover() {
        throw new AssertionError("Cannot be instantiated");
    }

//    public static String remove(String s, RemoveStrategy strategy) {
//        return strategy.execute(s);
//    }

    public static String remove(String s, Function<String,String> removerFn) {
        return removerFn.apply(s);
    }
}