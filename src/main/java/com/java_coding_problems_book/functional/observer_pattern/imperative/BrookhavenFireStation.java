package com.java_coding_problems_book.functional.observer_pattern.imperative;

public class BrookhavenFireStation implements FireObserver {

    @Override
    public void fire(String address) {
        if (address.contains("Brookhaven")) {
            System.out.println(
                    "Brookhaven fire station will go to this fire");
        }
    }
}
