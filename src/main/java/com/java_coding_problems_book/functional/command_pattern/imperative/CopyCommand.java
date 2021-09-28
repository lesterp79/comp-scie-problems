package com.java_coding_problems_book.functional.command_pattern.imperative;


public class CopyCommand implements Command {

    private final IODevice action;

    public CopyCommand(IODevice action) {
        this.action = action;
    }

    @Override
    public void execute() {
        action.copy();
    }
}