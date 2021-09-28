package com.java_coding_problems_book.functional.decorator_pattern.imperative;

public class BaseCake implements Cake {

    @Override
    public String decorate() {
        return "Base cake ";
    }
}