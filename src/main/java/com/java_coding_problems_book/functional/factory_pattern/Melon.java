package com.java_coding_problems_book.functional.factory_pattern;
public class Melon implements Fruit{
    public Melon(String type, int weight, String origin) {
        this.type = type;
        this.weight = weight;
        this.origin = origin;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    public String getOrigin() {
        return origin;
    }

    private final String type;
    private final int weight;
    private final String origin;



    @Override
    public String toString() {
        return "Melon{" +
                "type='" + type + '\'' +
                ", weight=" + weight +
                ", origin='" + origin + '\'' +
                '}';
    }

    // getters, toString(), and so on omitted for brevity
}

