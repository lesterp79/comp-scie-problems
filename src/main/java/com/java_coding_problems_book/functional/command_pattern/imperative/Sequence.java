package com.java_coding_problems_book.functional.command_pattern.imperative;


import java.util.ArrayList;
import java.util.List;

public class Sequence {

    private final List<Command> commands = new ArrayList<>();

    public void recordSequence(Command cmd) {
        commands.add(cmd);
    }

    public void runSequence() {
        for (Command c : commands) {
            c.execute();
        }
    }

    public void clearSequence() {
        commands.clear();
    }
}