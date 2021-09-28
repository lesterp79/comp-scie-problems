package com.java_coding_problems_book.functional.factory_pattern;


import java.util.Map;

public class FruitFactory {
    public static void main(String[] args) {
        TriFunction<String, Integer, String, Fruit> f = FruitFactory.newInstance(Gac.class);
        System.out.println("Got Function ref");
        System.out.println(f.apply("t", 1, "v"));



    }
    static Map<String, TriFunction<String, Integer, String, Fruit>> maps = Map.of("Gac",
            Gac::new);


//            , "Cantaloupe", Cantaloupe::new
//            , "Hemi", Hemi::new);

    public static TriFunction<String, Integer, String, Fruit> newInstance(Class<?> clazz) {
        return maps.get(clazz.getSimpleName());
    }
}