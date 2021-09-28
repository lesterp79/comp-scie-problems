package com.java_coding_problems_book.functional.decorator_pattern.imperative;

public class Cream extends CakeDecorator {

    public Cream(Cake cake) {
        super(cake);
    }

    @Override
    public String decorate() {
        return super.decorate() + decorateCream();
    }

    private String decorateCream() {
        return "with Cream ";
    }
}