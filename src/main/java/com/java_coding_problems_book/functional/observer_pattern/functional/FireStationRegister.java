package com.java_coding_problems_book.functional.observer_pattern.functional;

import java.util.function.Consumer;

public interface FireStationRegister {
    void registerFireStation(Consumer<String> fo);
    void notifyFireStations(String address);
}