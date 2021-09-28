package com.java_coding_problems_book.functional.observer_pattern.imperative;

import java.util.ArrayList;
import java.util.List;

public class FireStation implements FireStationRegister{

    public static void main(String[] args) {
        FireStation fireStation = new FireStation();
        fireStation.registerFireStation(new BrookhavenFireStation());
        fireStation.registerFireStation(new DecaturFireStation());
        fireStation.registerFireStation(new ViningsFireStation());
    }

    List<FireObserver> fos = new ArrayList<>();

    @Override
    public void registerFireStation(FireObserver fo) {
        fos.add(fo);
    }

    @Override
    public void notifyFireStations(String address) {
        for (FireObserver fo : fos) {
            fo.fire("");
        }
    }
}
