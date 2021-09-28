package com.java_coding_problems_book.functional.strategy_pattern;

public class NumberRemover implements RemoveStrategy {
    @Override
    public String execute(String s) {
        return s.replaceAll("\\d", "");
    }
}