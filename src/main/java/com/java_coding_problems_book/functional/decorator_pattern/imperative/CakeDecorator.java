package com.java_coding_problems_book.functional.decorator_pattern.imperative;

public class CakeDecorator implements Cake {
    public static void main(String[] args) {
        Cake cake = new Nuts(new Cream(new BaseCake()));

// Base cake with Cream with Nuts
        System.out.println(cake.decorate());
    }

    private final Cake cake;

    public CakeDecorator(Cake cake) {
        this.cake = cake;
    }

    @Override
    public String decorate() {
        return cake.decorate();
    }
}