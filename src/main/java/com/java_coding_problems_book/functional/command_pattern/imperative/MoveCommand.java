package com.java_coding_problems_book.functional.command_pattern.imperative;


public class MoveCommand implements Command {

    private final IODevice action;

    public MoveCommand(IODevice action) {
        this.action = action;
    }

    @Override
    public void execute() {
        action.move();
    }
}