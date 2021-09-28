package com.java_coding_problems_book.functional.command_pattern.imperative;

public class HardDisk implements IODevice {

    public static void main(String[] args) {
        HardDisk hd = new HardDisk();
        Sequence sequence = new Sequence();
        sequence.recordSequence(new CopyCommand(hd));
        sequence.recordSequence(new DeleteCommand(hd));
        sequence.recordSequence(new MoveCommand(hd));
        sequence.recordSequence(new DeleteCommand(hd));
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