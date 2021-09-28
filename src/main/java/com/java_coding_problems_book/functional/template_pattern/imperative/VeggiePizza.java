package com.java_coding_problems_book.functional.template_pattern.imperative;

public class VeggiePizza extends Pizza{
    @Override
    protected void prepareToppings() {
        System.out.println("Add veggies");
    }
}
