package com.java_coding_problems_book.functional.command_pattern.functional;


import com.java_coding_problems_book.functional.command_pattern.imperative.IODevice;

public class HardDisk implements IODevice {

    public static void main(String[] args) {
        HardDisk hd = new HardDisk();
        Sequence sequence = new Sequence();
        sequence.recordSequence(hd::copy);
        sequence.recordSequence(hd::delete);
        sequence.recordSequence(hd::move);
        sequence.recordSequence(hd::delete);
        sequence.runSequence();
    }
    @Override
    public void copy() {
        System.out.println("Copying ...");
    }

    @Override
    public void delete() {
        System.out.println("Deleting ...");
    }

    @Override
    public void move() {
        System.out.println("Moving ...");
    }
}