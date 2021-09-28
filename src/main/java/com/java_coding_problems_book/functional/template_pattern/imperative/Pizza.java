package com.java_coding_problems_book.functional.template_pattern.imperative;

public abstract class Pizza {
    public void makePizza() {
        System.out.println("Prepare dough");
        prepareToppings();
        System.out.println("Bake Pizza");
    }

    protected abstract void prepareToppings();
}
