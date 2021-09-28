package com.java_coding_problems_book.functional.command_pattern.functional;


import com.java_coding_problems_book.functional.command_pattern.imperative.Command;

import java.util.ArrayList;
import java.util.List;

public class Sequence {

    private final List<Runnable> commands = new ArrayList<>();

    public void recordSequence(Runnable cmd) {
        commands.add(cmd);
    }

    public void runSequence() {
        for (Runnable c : commands) {
            c.run();
        }
    }

    public void clearSequence() {
        commands.clear();
    }
}