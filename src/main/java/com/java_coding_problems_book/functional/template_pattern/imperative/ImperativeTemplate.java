package com.java_coding_problems_book.functional.template_pattern.imperative;

public class ImperativeTemplate {
    public static void main(String[] args) {
        Pizza veggiePizza = new VeggiePizza();
        veggiePizza.makePizza();

        Pizza pepPizza = new PepperoniPizza();
        pepPizza.makePizza();
    }
}
