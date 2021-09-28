package com.java_coding_problems_book.functional.template_pattern.functional;

import java.util.function.Supplier;

public class FunctionalPizza {

    public FunctionalPizza(Supplier<String> makeToppings) {
        this.makeToppings = makeToppings;
    }

    private Supplier<String> makeToppings;

    public void makePizza() {
        System.out.println("Prepare dough");
        System.out.println(makeToppings.get());
        System.out.println("Bake Pizza");
    }
}
