package com.java_coding_problems_book.functional.observer_pattern.imperative;

public interface FireStationRegister {
    void registerFireStation(FireObserver fo);
    void notifyFireStations(String address);
}