package com.java_coding_problems_book.functional.template_pattern.functional;

public class FunctionalTemplate {
    public static void main(String[] args) {
        //make veggies Pizza
        var veggiesPizza = new FunctionalPizza(() -> "Add veggie toppings");
        var pepPizza = new FunctionalPizza(() -> "Add pepperoni toppings");

        pepPizza.makePizza();

    }

}
