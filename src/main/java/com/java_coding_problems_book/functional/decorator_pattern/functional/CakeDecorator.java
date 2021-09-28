package com.java_coding_problems_book.functional.decorator_pattern.functional;

import java.util.function.Function;
import java.util.stream.Stream;

public class CakeDecorator {

    public static void main(String[] args) {
        CakeDecorator nutsAndCream = new CakeDecorator(
                (Cake c) -> c.decorate(" with Nuts"),
                (Cake c) -> c.decorate(" with Cream"));

        Cake cake = nutsAndCream.decorate(new Cake("Base cake"));

// Base cake with Nuts with Cream
        System.out.println(cake.getDecorations());
    }

    private Function<Cake, Cake> decorator;

    public CakeDecorator(Function<Cake, Cake>... decorations) {
        reduceDecorations(decorations);
    }

    public Cake decorate(Cake cake) {
        return decorator.apply(cake);
    }

    private void reduceDecorations(
            Function<Cake, Cake>... decorations) {

        decorator = Stream.of(decorations)
                          .reduce(Function.identity(), Function::andThen);
    }
}