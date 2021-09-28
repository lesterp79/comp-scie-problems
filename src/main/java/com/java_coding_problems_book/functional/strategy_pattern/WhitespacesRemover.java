package com.java_coding_problems_book.functional.strategy_pattern;
public class WhitespacesRemover implements RemoveStrategy {
    @Override
    public String execute(String s) {
        return s.replaceAll("\\s", "");
    }
}