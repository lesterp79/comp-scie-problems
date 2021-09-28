package com.java_coding_problems_book.functional.observer_pattern.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class FireStation implements FireStationRegister {

    public static void main(String[] args) {
        FireStation fireStation = new FireStation();

        fireStation.registerFireStation(address -> {
            if (address.contains("Brookhaven")) {
                System.out.println(
                        "Brookhaven fire station will go to this fire");
            }
        });
        fireStation.registerFireStation(address -> {
            if (address.contains("Decatur")) {
                System.out.println(
                        "Brookhaven fire station will go to this fire");
            }
        });

        fireStation.registerFireStation( address -> {
            if (address.contains("Vinings")) {
            System.out.println(
                    "Vinings fire station will go to this fire");
        }});

        fireStation.notifyFireStations(
                "Fire alert: WestHaven At Vinings 5901 Suffex Green Ln Atlanta");
    }

    List<Consumer<String>> fos = new ArrayList<>();

    @Override
    public void registerFireStation(Consumer<String> fo) {
        fos.add(fo);
    }

    @Override
    public void notifyFireStations(String address) {
        for (Consumer<String> fo : fos) {
            fo.accept(address);
        }
    }
    
    
}
